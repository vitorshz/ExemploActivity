package com.example.exemploactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemploactivity.modelo.Aluno;

import org.w3c.dom.Text;

public class CadastroAlunoActivity extends AppCompatActivity {
    private EditText edRaAluno;
    private EditText edNomeAluno;
    private EditText edCpf;
    private EditText edDataNasc;
    private TextView tvAlunosCadastrados;

    private Button btSalvar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

        edRaAluno = findViewById(R.id.edRaAluno);
        edNomeAluno = findViewById(R.id.edNomeAluno);
        edCpf = findViewById(R.id.edCpf);
        edDataNasc = findViewById(R.id.edDataNasc);
        btSalvar = findViewById(R.id.btSalvar);
        tvAlunosCadastrados = findViewById(R.id.tvAlunosCadastrados);

        atualizarListaAlunos();

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarAluno();
            }
        });
    }

    private void salvarAluno() {

        if(edRaAluno.getText().toString().isEmpty()){
            edRaAluno.setError("Informe o RA do Aluno");
            return;
        }
        if(edNomeAluno.getText().toString().isEmpty()){
            edNomeAluno.setError("Informe o Nome do Aluno");
            return;
        }
        if(edCpf.getText().toString().isEmpty()){
            edCpf.setError("Informe o CPF do Aluno");
            return;
        }
        if(edDataNasc.getText().toString().isEmpty()){
            edDataNasc.setError("Informe a Data de nascimento do Aluno");
            return;
        }
        Aluno aluno = new Aluno();
        aluno.setRa(Integer.parseInt(edRaAluno.getText().toString()));
        aluno.setNome(edNomeAluno.getText().toString());
        aluno.setCpf(edCpf.getText().toString());
        aluno.setDtNasc(edDataNasc.getText().toString());

        Controller.getInstance().salvarAluno(aluno);
        Toast.makeText(CadastroAlunoActivity.this, "Aluno cadastrado com sucesso!!", Toast.LENGTH_LONG).show();
        this.finish();

    }
    private void atualizarListaAlunos(){
        String texto = "";
        for (Aluno aluno: Controller.getInstance().retornarAlunos()){
            texto += "RA "+aluno.getRa()+" Nome "+aluno.getNome()+" Cpf "+aluno.getCpf()+" Dt.Nasc. "+aluno.getDtNasc()+"\n";
        }
        tvAlunosCadastrados.setText(texto);
    }

}