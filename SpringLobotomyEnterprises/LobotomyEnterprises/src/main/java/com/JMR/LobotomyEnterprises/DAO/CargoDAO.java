package com.JMR.LobotomyEnterprises.DAO;

import com.JMR.LobotomyEnterprises.model.Cargo;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public class CargoDAO {

    private final JdbcClient jdbcClient;

    public CargoDAO(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

public Cargo create(Cargo cargo) {

    String sql = """
        INSERT INTO cargo (titulo, descricao, nivelSalarialMinimo, requisitos)
        VALUES (:titulo, :descricao, :nivelSalarialMinimo, :requisitos)
    """;

    jdbcClient.sql(sql)
            .param("titulo", cargo.getTitulo()).param("descricao", cargo.getDescricao()).param("nivelSalarialMinimo", cargo.getNivelSalarialMinimo()).param("requisitos", cargo.getRequisitos()).update();

    Long id = jdbcClient.sql("SELECT LAST_INSERT_ID()").query(Long.class).single();

    cargo.setId(id);
    return cargo;
}
    public Optional<Cargo> findById(Long id) {
        return jdbcClient.sql("SELECT * FROM cargo WHERE id = :id").param("id", id).query(Cargo.class).optional();
    }

public List<Cargo> findAll() {
        return jdbcClient.sql("SELECT * FROM cargo").query(Cargo.class).list();
    }

    public List<Cargo> findByFilters(
            String titulo,
            String descricao,
            Integer nivelMinimo,
            String requisitos
    ) {
        StringBuilder sql = new StringBuilder("SELECT * FROM cargo WHERE 1=1 ");
        Map<String, Object> params = new HashMap<>();

        if (titulo != null && !titulo.isBlank()) {
            sql.append(" AND titulo LIKE :titulo ");
            params.put("titulo", "%" + titulo + "%");
        }

        return jdbcClient.sql(sql.toString()).params(params).query(Cargo.class).list();
    }

    public int update(Long id, Cargo cargo) {
        String sql = """
            UPDATE cargo
            SET titulo = :titulo, descricao = :descricao, nivelSalarialMinimo = :nivelSalarialMinimo, requisitos = :requisitos
            WHERE id = :id
        """;

        return jdbcClient.sql(sql).param("titulo", cargo.getTitulo()).param("descricao", cargo.getDescricao()).param("nivelSalarialMinimo", cargo.getNivelSalarialMinimo()).param("requisitos", cargo.getRequisitos()).param("id", id).update();
    }

    public int delete(Long id) {
        return jdbcClient.sql("DELETE FROM cargo WHERE id = :id").param("id", id).update();
    }

}
