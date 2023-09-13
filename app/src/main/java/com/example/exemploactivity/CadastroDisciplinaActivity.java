package com.example.exemploactivity;

import static com.example.exemploactivity.Controller.listaProfs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemploactivity.modelo.Disciplina;
import com.example.exemploactivity.modelo.Professor;

import java.util.ArrayList;

public class CadastroDisciplinaActivity extends AppCompatActivity {
    private TextView tvListaDisciplina;
    private TextView tvErroProfessor;
    private EditText edDescDisciplina;
    private EditText edCargaHoraria;
    private Spinner spProfessor;
    private Button btSalvar;
    private int posicaoSelecionada = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_disciplina);

        tvListaDisciplina = findViewById(R.id.tvListaDisciplina);
        tvErroProfessor= findViewById(R.id.tvErroProfessor);
        edCargaHoraria= findViewById(R.id.edCargaHoraria);
        edDescDisciplina = findViewById(R.id.edDescDisciplina);
        spProfessor= findViewById(R.id.spProfessor);
        btSalvar= findViewById(R.id.btSalvar);
        spProfessor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posicao, long l) {
                if (posicao> 0){
                    posicaoSelecionada = posicao;
                    tvErroProfessor.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarDisciplina();
            }
        });
        carregaProfessores();
        atualizaListaDisciplinas();
    }

    private void salvarDisciplina() {
        double cargaHoraria;
        if(edDescDisciplina.getText().toString().isEmpty()){
            edDescDisciplina.setError("A descrição da disciplina deve ser informada!!");
            edDescDisciplina.requestFocus();
            return;
        }
        if (edCargaHoraria.getText().toString().isEmpty()){
            edCargaHoraria.setError("A carga horária deve ser infomrada!!");
            edCargaHoraria.requestFocus();
            return;
        }else{
            cargaHoraria = Double.parseDouble(edCargaHoraria.getText().toString());
            if (cargaHoraria<= 0 ){
                edCargaHoraria.setError("A carga horaria deve ser maior que zero!!");
                edCargaHoraria.requestFocus();
                return;
            }
        }
        if (posicaoSelecionada<=0 ){
            tvErroProfessor.setVisibility(View.VISIBLE);
            return;
        }
        Professor prof = listaProfs.get(posicaoSelecionada - 1);
        Disciplina disciplina = new Disciplina();
        disciplina.setDescricao(edDescDisciplina.getText().toString());
        disciplina.setCargaHoraria(cargaHoraria);
        disciplina.setProfessor(prof);

        Controller.getInstance().salvarDisciplinas(disciplina);
        Toast.makeText(this, "Disciplina salva com sucesso!!", Toast.LENGTH_LONG).show();

    }

    private void carregaProfessores() {
        listaProfs = Controller.getInstance().retornarProfs();
        String[]vetProfes = new String[listaProfs.size() + 1];
        vetProfes[0] = "Selecione o Professor:";
        for (int i = 0; i < listaProfs.size(); i++) {
            Professor prof = listaProfs.get(i);
            vetProfes[i+1] = prof.getMatricula()+" - "+prof.getNome();
        }
        ArrayAdapter adapter = new ArrayAdapter(CadastroDisciplinaActivity.this,
                android.R.layout.simple_dropdown_item_1line, vetProfes);
        spProfessor.setAdapter(adapter);

    }
    private void atualizaListaDisciplinas(){
        ArrayList<Disciplina> lista = Controller.getInstance().retornarDisciplinas();
        String texto = "";
        for (Disciplina dis: lista) {
            texto += dis.getDescricao()+"\n"+
                    "Carga Hr: " + dis.getCargaHoraria()+"\n"+
                    "Professor: " + dis.getProfessor() + "\n"+
                    "---------------------------------------------\n";
        }
        tvListaDisciplina.setText(texto);
    }

}