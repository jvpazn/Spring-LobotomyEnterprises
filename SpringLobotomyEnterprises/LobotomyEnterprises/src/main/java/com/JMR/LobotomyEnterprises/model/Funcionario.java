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
    private Setor setor;
    private Cargo cargo;

    public Funcionario() {}

    public Funcionario(
            String nome,
            String senha,
            String dataDeNascimento,
            String CPF,
            String emailPessoal,
            String emailEmpresarial,
            String nivelFormacao,
            int horasSemanais,
            int salario,
            String matricula,
            Setor setor,
            Cargo cargo
    ) {
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
        this.setor = setor;
        this.cargo = cargo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getDataDeNascimento() { return dataDeNascimento; }
    public void setDataDeNascimento(String dataDeNascimento) { this.dataDeNascimento = dataDeNascimento; }

    public String getCPF() { return CPF; }
    public void setCPF(String CPF) { this.CPF = CPF; }

    public String getEmailPessoal() { return emailPessoal; }
    public void setEmailPessoal(String emailPessoal) { this.emailPessoal = emailPessoal; }

    public String getEmailEmpresarial() { return emailEmpresarial; }
    public void setEmailEmpresarial(String emailEmpresarial) { this.emailEmpresarial = emailEmpresarial; }

    public String getNivelFormacao() { return nivelFormacao; }
    public void setNivelFormacao(String nivelFormacao) { this.nivelFormacao = nivelFormacao; }

    public int getHorasSemanais() { return horasSemanais; }
    public void setHorasSemanais(int horasSemanais) { this.horasSemanais = horasSemanais; }

    public int getSalario() { return salario; }
    public void setSalario(int salario) { this.salario = salario; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public Setor getSetor() { return setor; }
    public void setSetor(Setor setor) { this.setor = setor; }

    public Cargo getCargo() { return cargo; }
    public void setCargo(Cargo cargo) { this.cargo = cargo; }


    public void dadosPublicos() {
        System.out.println("Nome: " + nome);
        System.out.println("Setor em que trabalha: " + (setor != null ? setor.getNome() : "Não definido"));
        System.out.println("Nível de Formação: " + nivelFormacao);
        System.out.println("Cargo: " + (cargo != null ? cargo.getTitulo() : "Não definido"));
    }
}
