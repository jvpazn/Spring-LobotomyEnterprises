package com.JMR.LobotomyEnterprises.model;

public class Setor {
    private Long id;
    private String nome;
    private String id_Setor;


    public Setor(String nome, String id_Setor) {
        this.nome = nome;
        this.id_Setor = id_Setor;
    }


    public Setor() {
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

    public String getId_Setor() {
        return this.id_Setor;
    }

    public void setId_Setor(String id_Setor) {
        this.id_Setor = id_Setor;
    }
    

}
