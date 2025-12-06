package com.JMR.LobotomyEnterprises.DAO;

import com.JMR.LobotomyEnterprises.model.Funcionario;
import java.util.Optional;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class FuncionarioDAO {

    private final JdbcClient jdbcClient;

    public FuncionarioDAO(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public Funcionario create(Funcionario funcionario) {

        String sql = """
            INSERT INTO funcionario (
                nome, senha, dataDeNascimento, cpf, emailPessoal,
                emailEmpresarial, nivelFormacao, horasSemanais, salario,
                matricula, setor_id, cargo_id
            ) VALUES (
                :nome, :senha, :dataDeNascimento, :cpf, :emailPessoal,
                :emailEmpresarial, :nivelFormacao, :horasSemanais, :salario,
                :matricula, :setorId, :cargoId
            )
        """;

        jdbcClient.sql(sql).param("nome", funcionario.getNome()).param("senha", funcionario.getSenha()).param("dataDeNascimento", funcionario.getDataDeNascimento()).param("cpf", funcionario.getCPF()).param("emailPessoal", funcionario.getEmailPessoal()).param("emailEmpresarial", funcionario.getEmailEmpresarial()).param("nivelFormacao", funcionario.getNivelFormacao()).param("horasSemanais", funcionario.getHorasSemanais()).param("salario", funcionario.getSalario()).param("matricula", funcionario.getMatricula()).param("setorId", funcionario.getSetor() != null ? funcionario.getSetor().getId() : null).param("cargoId", funcionario.getCargo() != null ? funcionario.getCargo().getId() : null).update();

        Long id = jdbcClient.sql("SELECT LAST_INSERT_ID()").query(Long.class).single();

        funcionario.setId(id);
        return funcionario;
    }

    public Optional<Funcionario> findById(Long id) {
        return jdbcClient.sql("SELECT * FROM funcionario WHERE id = :id")
                .param("id", id)
                .query(Funcionario.class)
                .optional();
    }
}
