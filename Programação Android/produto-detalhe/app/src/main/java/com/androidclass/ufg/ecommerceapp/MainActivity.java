package com.androidclass.ufg.ecommerceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final ListView lista = findViewById(R.id.listaProdutos);
        final RecyclerView lista = findViewById(R.id.listaProdutos);
        final ArrayList<Produto> produtos = getEquipes();

        //ProdutosListAdapter adapter = new ProdutosListAdapter(this, produtos);
        // RecylcerView
        ProdutosListAdapter adapter = new ProdutosListAdapter(produtos);
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setAdapter(adapter);
    }

    private ArrayList<Produto> getEquipes() {
        ArrayList<Produto> equipes = new ArrayList<>();

        equipes.add(new Produto("Atlético Clube Goianiense", "O mais querido do Centro-Oeste", "Vermelho e Preto", 15, 1024, 2999.90, R.drawable.atletico_go));
        equipes.add(new Produto("Goiás", "Verdão ô ô", "Verde e Branco", 34, 1024, 1999.90, R.drawable.goias));
        equipes.add(new Produto("Vila Nova", "Colorado do Universitário", "Vermelho e Branco", 25, 1024, 29.90, R.drawable.vila_nova));
        equipes.add(new Produto("Crac", "Leão de Catalão", "Azul e Branco", 1, 1024, 9.90, R.drawable.crac));

        return equipes;
    }
}
