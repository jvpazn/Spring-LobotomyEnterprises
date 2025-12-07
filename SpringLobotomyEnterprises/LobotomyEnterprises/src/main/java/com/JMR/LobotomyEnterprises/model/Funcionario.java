package com.JMR.LobotomyEnterprises.model;

public class Funcionario {

    private Long id;
    private String nome;
    private String senha;
    private String dataDeNascimento;
    private String CPF;
    private String emailPessoal;

    private String emailEmpresarial;
    private String nivelFormacao;
    private int horasSemanais;
    private int salario;
    private String matricula;
    private Long setorId; 
    private Long cargoId; 


    public Funcionario() {}


    public Funcionario(Long id, String nome, String senha, String dataDeNascimento, String CPF, String emailPessoal, String emailEmpresarial, String nivelFormacao, int horasSemanais, int salario, String matricula, Long setorId, Long cargoId) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.dataDeNascimento = dataDeNascimento;
        this.CPF = CPF;
        this.emailPessoal = emailPessoal;
        this.emailEmpresarial = emailEmpresarial;
        this.nivelFormacao = nivelFormacao;
        this.horasSemanais = horasSemanais;
        this.salario = salario;
        this.matricula = matricula;
        this.setorId = setorId;
        this.cargoId = cargoId;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataDeNascimento() {
        return this.dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCPF() {
        return this.CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmailPessoal() {
        return this.emailPessoal;
    }

    public void setEmailPessoal(String emailPessoal) {
        this.emailPessoal = emailPessoal;
    }

    public String getEmailEmpresarial() {
        return this.emailEmpresarial;
    }

    public void setEmailEmpresarial(String emailEmpresarial) {
        this.emailEmpresarial = emailEmpresarial;
    }

    public String getNivelFormacao() {
        return this.nivelFormacao;
    }

    public void setNivelFormacao(String nivelFormacao) {
        this.nivelFormacao = nivelFormacao;
    }

    public int getHorasSemanais() {
        return this.horasSemanais;
    }

    public void setHorasSemanais(int horasSemanais) {
        this.horasSemanais = horasSemanais;
    }

    public int getSalario() {
        return this.salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Long getSetorId() {
        return this.setorId;
    }

    public void setSetorId(Long setorId) {
        this.setorId = setorId;
    }

    public Long getCargoId() {
        return this.cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }
}