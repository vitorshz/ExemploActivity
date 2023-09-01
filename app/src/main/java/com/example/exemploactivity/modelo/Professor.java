package com.example.exemploactivity.modelo;

public class Professor {
    private int matricula;
    private String nome;
    private String cpf;
    private String DtNasc;
    private String DtAdmissao;

    public Professor() {
    }

    public Professor(int matricula, String nome, String cpf, String dtNasc, String dtAdmissao) {

        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        DtNasc = dtNasc;
        DtAdmissao = dtAdmissao;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
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

    public String getDtNasc() {
        return DtNasc;
    }

    public void setDtNasc(String dtNasc) {
        DtNasc = dtNasc;
    }

    public String getDtAdmissao() {
        return DtAdmissao;
    }

    public void setDtAdmissao(String dtAdmissao) {
        DtAdmissao = dtAdmissao;
    }
}
