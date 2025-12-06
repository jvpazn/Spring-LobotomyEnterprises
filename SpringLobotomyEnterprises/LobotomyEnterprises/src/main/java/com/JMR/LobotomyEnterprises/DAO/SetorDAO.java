package com.JMR.LobotomyEnterprises.DAO;

import com.JMR.LobotomyEnterprises.model.Setor;
import java.util.Optional;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

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
}
