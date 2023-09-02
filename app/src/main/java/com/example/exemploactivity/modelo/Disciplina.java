package com.example.exemploactivity.modelo;

public class Disciplina {
    int codDisciplina;
    String descricao;
    Double cargaHoraria;
    Professor professor;

    public Disciplina() {
    }

    public Disciplina(int codDisciplina, String descricao, Double cargaHoraria, Professor professor) {
        this.codDisciplina = codDisciplina;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

    public int getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(int codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
