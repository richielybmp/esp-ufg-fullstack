package com.androidclass.ufg.ecommerceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        ImageView imagemDetalhe = findViewById(R.id.produto_imagem_detalhe);
        TextView tvDetalhe = findViewById(R.id.produto_detalhe);
        TextView tvCores = findViewById(R.id.produto_cor);
        TextView tvPreco = findViewById(R.id.produto_preco);
        Button btnAcompanhar = findViewById(R.id.button);

        final Produto produto = (Produto) getIntent().getSerializableExtra("PRODUTO");

        imagemDetalhe.setImageResource(produto.getImageID());
        tvDetalhe.setText(produto.getDescricao());
        tvCores.setText(produto.getCor());
        tvPreco.setText(produto.getPreco());

        btnAcompanhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Acompanhando o protudo " + produto.getNome(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
