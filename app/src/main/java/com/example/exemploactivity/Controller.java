package com.example.exemploactivity;

import com.example.exemploactivity.modelo.Aluno;
import com.example.exemploactivity.modelo.Disciplina;
import com.example.exemploactivity.modelo.Professor;
import com.example.exemploactivity.modelo.Turma;

import java.util.ArrayList;

public class Controller {

    private static Controller instancia;
    private static ArrayList<Aluno> listaAlunos;
    public static ArrayList<Professor> listaProfs;
    private static ArrayList<Disciplina> listaDisciplinas;
    private static ArrayList<Turma> listaTurmas;


    public static Controller getInstance(){
        if(instancia == null)
            return instancia = new Controller();
        else
            return instancia;
    };
    private Controller(){
        listaAlunos = new ArrayList<>();
        listaProfs = new ArrayList<>();
        listaDisciplinas = new ArrayList<>();
        listaTurmas = new ArrayList<>();
    }
    public void salvarAluno(Aluno aluno){
        listaAlunos.add(aluno);

    }
    public ArrayList<Aluno> retornarAlunos() {
        return listaAlunos;
    }

    public void salvarProf(Professor prof){
        listaProfs.add(prof);
    }
    public ArrayList<Professor> retornarProfs(){
        return listaProfs;
    }

    public void salvarDisciplinas(Disciplina disciplina){
        listaDisciplinas.add(disciplina);
    }
    public ArrayList<Disciplina> retornarDisciplinas(){
        return listaDisciplinas;
    }

    public void salvarTurmas(Turma turma){listaTurmas.add(turma);}
    public ArrayList<Turma> retornarTurmas(){return listaTurmas;}



}
