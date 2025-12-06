package com.JMR.LobotomyEnterprises.DAO;

import com.JMR.LobotomyEnterprises.model.Setor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public class SetorDAO {

    private final JdbcClient jdbcClient;

    public SetorDAO(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public Setor create(Setor setor) {
        String sql = """
            INSERT INTO setor (nome, id_setor)
            VALUES (:nome, :idSetor)
        """;

        jdbcClient.sql(sql).param("nome", setor.getNome()).param("idSetor", setor.getId_Setor()).update();

        Long id = jdbcClient.sql("SELECT LAST_INSERT_ID()").query(Long.class).single();
        setor.setId(id);
        return setor;
    }

    public Optional<Setor> findById(Long id) {
        return jdbcClient.sql("SELECT * FROM setor WHERE id = :id").param("id", id).query(Setor.class).optional();
    }

    public Optional<Setor> findByIdSetor(String idSetor) {
        return jdbcClient.sql("SELECT * FROM setor WHERE id_setor = :idSetor").param("idSetor", idSetor).query(Setor.class).optional();
    }

public java.util.List<Setor> findAll() {
    return jdbcClient.sql("SELECT * FROM setor").query(Setor.class).list();
}
public List<Setor> findByFilters(
            String nome,
            String idSetor
    ) {
        StringBuilder sql = new StringBuilder("SELECT * FROM setor WHERE 1=1 ");
        Map<String, Object> params = new HashMap<>();

        if (nome != null && !nome.isBlank()) {
            sql.append(" AND nome LIKE :nome ");
            params.put("nome", "%" + nome + "%");
        }

        if (idSetor != null && !idSetor.isBlank()) {
            sql.append(" AND id_setor = :idSetor ");
            params.put("idSetor", idSetor);
        }

        return jdbcClient.sql(sql.toString()).params(params).query(Setor.class).list();
    }

    public int update(Long id, Setor setor) {
    String sql = """
        UPDATE setor
        SET nome = :nome, id_setor = :idSetor
        WHERE id = :id
    """;

    return jdbcClient.sql(sql).param("nome", setor.getNome()).param("idSetor", setor.getId_Setor()).param("id", id).update();
}

    public int delete(Long id) {
        return jdbcClient.sql("DELETE FROM setor WHERE id = :id").param("id", id).update();
    }
}
