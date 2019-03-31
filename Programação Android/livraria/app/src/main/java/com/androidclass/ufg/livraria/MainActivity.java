package com.androidclass.ufg.livraria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.androidclass.ufg.livraria.model.Livro;
import com.androidclass.ufg.livraria.model.LivroListAdapter;
import com.github.javafaker.Book;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    DBAccess db;
    Button btnCadastrar;

    LivroListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBAccess(getApplicationContext());

        populateInitialDB();

        carregarListView();

        btnCadastrar = (Button) findViewById(R.id.btn_cadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // criar a intent
                Intent i = new Intent(getApplicationContext(), CadastrarNovoActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarListView();
    }

    private void carregarListView() {
        final RecyclerView lista = findViewById(R.id.listaLivros);
        final ArrayList<Livro> livros = db.getAll();

        adapter = new LivroListAdapter(livros);
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setAdapter(adapter);
    }

    private void populateInitialDB() {
//        Faker faker = new Faker();
//        Random random = new Random();
//
//        for (int i = 0; i < 50; i++){
//            Book book = faker.book();
//            double preco = Double.parseDouble(String.format("%.2f", random.nextDouble() * 100)) ;
//            Livro livro = new Livro(i, book.title(), book.author(), book.publisher(), preco);
//            db.insertBook(livro);
//        }
    }
}
