package com.androidclass.ufg.livraria;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidclass.ufg.livraria.model.Livro;

public class DetailsActivity extends AppCompatActivity implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener  {

    private TextView tvTitulo;
    private TextView tvAutor;
    private TextView tvEditora;
    private TextView tvPreco;
    private Button btnExcluir;
    private Button btnEditar;

    private Livro livro;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        livro = (Livro) getIntent().getSerializableExtra("LIVRO");

        tvTitulo = findViewById(R.id.detail_titulo);
        tvTitulo.setText(livro.getTitulo());

        tvAutor = findViewById(R.id.detail_autor);
        tvAutor.setText(livro.getAutor());

        tvEditora = findViewById(R.id.detail_editora);
        tvEditora.setText(livro.getEditora());

        tvPreco = findViewById(R.id.detail_preco);
        tvPreco.setText(String.valueOf(livro.getPreco()));

        btnExcluir = (Button) findViewById(R.id.btn_excluir);

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertBuilder(DetailsActivity.this, null, "Excluir", "Deseja realmente excluir esse registro?", "Sim", "Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == DialogInterface.BUTTON_POSITIVE) {
                            Intent i = new Intent(getApplicationContext(), CadastrarNovoActivity.class);
                            i.putExtra("LIVRO", livro);
                            i.putExtra("EDICAO", true);
                            startActivity(i);
                            //finish();
                        }
                    }
                }, DetailsActivity.this);
            }
        });

        btnEditar = (Button) findViewById(R.id.btn_editar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertBuilder(DetailsActivity.this, null, "Editar", "Deseja realmente editar esse registro?", "Sim", "Não", DetailsActivity.this, DetailsActivity.this);
            }
        });
    }

    public static void showAlertBuilder(Activity activity, @Nullable View view, CharSequence titleMessage,
                                        CharSequence message, CharSequence positiveButtonMessage, CharSequence cancelButtonMessage, DialogInterface.OnClickListener clickListener, DialogInterface.OnCancelListener cancelListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        if (!(titleMessage.length() == 0))
            builder.setTitle(titleMessage);
        if (!(message.length() == 0))
            builder.setMessage(message);
        if (view != null)
            builder.setView(view);

        builder.setPositiveButton(positiveButtonMessage, clickListener);
        builder.setNegativeButton(cancelButtonMessage, clickListener);
        builder.setOnCancelListener(cancelListener);
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onCancel(DialogInterface dialog) {
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE) {
            DBAccess db = new DBAccess(getApplicationContext());
            db.deleteBook(livro.getId());
            Toast.makeText(this, "Registro excluído com sucesso", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
