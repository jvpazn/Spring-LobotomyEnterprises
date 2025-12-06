package com.JMR.LobotomyEnterprises.DAO;

import com.JMR.LobotomyEnterprises.model.Cargo;
import java.util.Optional;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;


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
}
