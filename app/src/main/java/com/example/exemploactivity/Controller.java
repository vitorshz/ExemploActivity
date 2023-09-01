package com.example.exemploactivity;

import com.example.exemploactivity.modelo.Aluno;
import com.example.exemploactivity.modelo.Professor;

import java.util.ArrayList;

public class Controller {

    private static Controller instancia;
    private static ArrayList<Aluno> listaAlunos;
    private static ArrayList<Professor> listaProfs;
    public static Controller getInstance(){
        if(instancia == null)
            return instancia = new Controller();
        else
            return instancia;
    };
    private Controller(){
        listaAlunos = new ArrayList<>();

        listaProfs = new ArrayList<>();
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
}
