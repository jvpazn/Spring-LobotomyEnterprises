package com.JMR.LobotomyEnterprises.DAO;

import com.JMR.LobotomyEnterprises.model.Funcionario;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import java.util.*;

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

        jdbcClient.sql(sql).param("nome", funcionario.getNome()).param("senha", funcionario.getSenha()).param("dataDeNascimento", funcionario.getDataDeNascimento()).param("cpf", funcionario.getCPF()).param("emailPessoal", funcionario.getEmailPessoal()).param("emailEmpresarial", funcionario.getEmailEmpresarial()).param("nivelFormacao", funcionario.getNivelFormacao()).param("horasSemanais", funcionario.getHorasSemanais()).param("salario", funcionario.getSalario()).param("matricula", funcionario.getMatricula()).param("setorId", funcionario.getSetorId()).param("cargoId", funcionario.getCargoId()).update();

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

    public List<Funcionario> findAll() {
        return jdbcClient.sql("SELECT * FROM funcionario").query(Funcionario.class).list();
    }

public List<Funcionario> findByFilters(
        String nome,
        String cpf,
        Long setorId,
        Long cargoId,
        Double salarioMin,
        Double salarioMax
) {
    StringBuilder sql = new StringBuilder("SELECT * FROM funcionario WHERE 1=1 ");
    Map<String, Object> params = new HashMap<>();

    if (nome != null && !nome.isBlank()) {
        sql.append(" AND nome LIKE :nome ");
        params.put("nome", "%" + nome + "%");
    }

    if (cpf != null && !cpf.isBlank()) {
        sql.append(" AND cpf = :cpf ");
        params.put("cpf", cpf);
    }

    if (setorId != null) {
        sql.append(" AND setor_id = :setorId ");
        params.put("setorId", setorId);
    }

    if (cargoId != null) {
        sql.append(" AND cargo_id = :cargoId ");
        params.put("cargoId", cargoId);
    }

    return jdbcClient.sql(sql.toString()).params(params).query(Funcionario.class).list();
}

    public int update(Long id, Funcionario funcionario) {
        String sql = """
            UPDATE funcionario
            SET nome = :nome,
                senha = :senha,
                dataDeNascimento = :dataDeNascimento,
                cpf = :cpf,
                emailPessoal = :emailPessoal,
                emailEmpresarial = :emailEmpresarial,
                nivelFormacao = :nivelFormacao,
                horasSemanais = :horasSemanais,
                salario = :salario,
                matricula = :matricula,
                setor_id = :setorId,
                cargo_id = :cargoId
            WHERE id = :id
        """;

            return jdbcClient.sql(sql).param("nome", funcionario.getNome()).param("senha", funcionario.getSenha()).param("dataDeNascimento", funcionario.getDataDeNascimento()).param("cpf", funcionario.getCPF()).param("emailPessoal", funcionario.getEmailPessoal()).param("emailEmpresarial", funcionario.getEmailEmpresarial()).param("nivelFormacao", funcionario.getNivelFormacao()).param("horasSemanais", funcionario.getHorasSemanais()).param("salario", funcionario.getSalario()).param("matricula", funcionario.getMatricula()).param("setorId", funcionario.getSetorId()).param("cargoId", funcionario.getCargoId()).param("id", id).update();
    }

    public int delete(Long id) {
        return jdbcClient.sql("DELETE FROM funcionario WHERE id = :id").param("id", id).update();
    }

}