package com.androidclass.ufg.livraria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidclass.ufg.livraria.model.Livro;

public class CadastrarNovoActivity extends AppCompatActivity {

    Button btnCadastrarNovo;
    EditText titulo;
    EditText autor;
    EditText editora;
    EditText preco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_livro);

        btnCadastrarNovo = (Button) findViewById(R.id.btn_novo);
        titulo = (EditText) findViewById(R.id.novo_livro_nome);
        autor = (EditText) findViewById(R.id.novo_livro_autor);
        editora = (EditText) findViewById(R.id.novo_livro_editora);
        preco = (EditText) findViewById(R.id.novo_livro_preco);

        btnCadastrarNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar(v);
            }
        });

        Boolean ehEdicao = (Boolean) getIntent().getBooleanExtra("EDICAO", false);
        Livro livro = (Livro)getIntent().getSerializableExtra("LIVRO");
    }

    private void validar(View v) {
        Boolean inconsistente = false;

        if (titulo.getText().length() <= 0){
            titulo.setError("Informe um nome");
            inconsistente = true;
        }
        if (autor.getText().length() <= 0){
            autor.setError("Informe um nome");
            inconsistente = true;
        }
        if (editora.getText().length() <= 0){
            editora.setError("Informe um nome");
            inconsistente = true;
        }
        if (preco.getText().length() <= 0){
            preco.setError("Informe um nome");
            inconsistente = true;
        }

        if (inconsistente){
            Toast.makeText(this, "Não foi possível criar um novo registro", Toast.LENGTH_SHORT).show();
        }
        else{
            DBAccess db = new DBAccess(getApplicationContext());
            db.insertBook(new Livro(titulo.getText().toString(), autor.getText().toString(), editora.getText().toString(), Double.parseDouble(preco.getText().toString())));
            finish();
        }
    }
}
