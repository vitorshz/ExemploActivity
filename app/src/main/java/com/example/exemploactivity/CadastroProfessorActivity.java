package com.example.exemploactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemploactivity.modelo.Aluno;
import com.example.exemploactivity.modelo.Professor;

public class    CadastroProfessorActivity extends AppCompatActivity {
    private EditText edMatriculaProf;
    private EditText edNomeProf;
    private EditText edCpfProf;
    private EditText edDataNascProf;
    private EditText edAdmissão;
    private Button btSalvar;
    private TextView tvProfsCadastrados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_professor);

        edMatriculaProf = findViewById(R.id.edMatriculaProf);
        edNomeProf = findViewById(R.id.edNomeProf);
        edCpfProf = findViewById(R.id.edCpfProf);
        edDataNascProf = findViewById(R.id.edDataNascProf);
        edAdmissão = findViewById(R.id.edAdmissão);
        btSalvar = findViewById(R.id.btSalvar);
        tvProfsCadastrados = findViewById(R.id.tvProfsCadastrados);

        atualizarListaProfs();
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarProfessor();
            }
        });
    }
        private void salvarProfessor(){
            if(edMatriculaProf.getText().toString().isEmpty()){
                edMatriculaProf.setError("Informe a Matrícula do Professor");
                return;
            }
            if(edNomeProf.getText().toString().isEmpty()){
                edNomeProf.setError("Informe o Nome do Professor");
                return;
            }
            if(edCpfProf.getText().toString().isEmpty()){
                edCpfProf.setError("Informe o CPF do Professor");
                return;
            }
            if(edDataNascProf.getText().toString().isEmpty()){
                edDataNascProf.setError("Informe a Data de nascimento do Professor");
                return;
            }
            if(edAdmissão.getText().toString().isEmpty()){
                edAdmissão.setError("Informe a Data de Admissão do Professor");
                return;
            }

            Professor prof = new Professor();
            prof.setMatricula(Integer.parseInt(edMatriculaProf.getText().toString()));
            prof.setNome(edNomeProf.getText().toString());
            prof.setCpf(edCpfProf.getText().toString());
            prof.setDtNasc(edDataNascProf.getText().toString());
            prof.setDtAdmissao(edAdmissão.getText().toString());

            Controller.getInstance().salvarProf(prof);
            Toast.makeText(CadastroProfessorActivity.this, "Professor cadastrado com sucesso!", Toast.LENGTH_LONG).show();
            this.finish();
        }
    private void atualizarListaProfs(){
        String texto = "";
        for (Professor prof: Controller.getInstance().retornarProfs()){
            texto += "RA "+prof.getMatricula()+" Nome "+prof.getNome()+" Cpf "+prof.getCpf()+" Dt.Nasc. "+prof.getDtNasc()+
                    " Dt.admissao. "+prof.getDtAdmissao()+
                    "--------------------------------------------"+"\n";
        }
        tvProfsCadastrados.setText(texto);
    }

}