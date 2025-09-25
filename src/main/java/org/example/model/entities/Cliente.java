package org.example.model.entities;

import java.util.Date;

public class Cliente {

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String sexo;
    private java.sql.Date dt_nascimento;

    public Cliente() {
    }

    public Cliente(int id, String nome, String cpf, String email, String sexo, Date dt_nascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.sexo = sexo;
        this.dt_nascimento = (java.sql.Date) dt_nascimento;
    }

    public Cliente(String nome, String cpf, String email, String sexo, Date dt_nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.sexo = sexo;
        this.dt_nascimento = (java.sql.Date) dt_nascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public java.sql.Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = (java.sql.Date) dt_nascimento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", sexo='" + sexo + '\'' +
                ", dt_nascimento=" + dt_nascimento +
                '}';
    }
}
