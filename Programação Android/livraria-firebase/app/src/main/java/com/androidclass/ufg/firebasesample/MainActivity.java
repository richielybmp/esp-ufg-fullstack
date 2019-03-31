package com.androidclass.ufg.firebasesample;

import android.content.ClipData;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidclass.ufg.firebasesample.model.Livro;
import com.androidclass.ufg.firebasesample.model.LivrosListAdapter;
import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    public EditText etTitulo;
    public EditText etAutor;
    public EditText etEditora;
    public EditText etPreco;

    public MenuItem itemAdd, itemDelete, itemReturn, itemSave;

    RecyclerView rVlista;

    private ArrayList<Livro> listaLivros = new ArrayList<Livro>();
    LivrosListAdapter arrayAdapterLivros;

    public Livro livroSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitulo = findViewById(R.id.novo_livro_nome);
        etAutor = findViewById(R.id.novo_livro_autor);
        etEditora = findViewById(R.id.novo_livro_editora);
        etPreco = findViewById(R.id.novo_livro_preco);

        rVlista = findViewById(R.id.listaLivros);

        inicializarFirebase();
        //populateInitialDB();
        listarLivros();
    }

    private void populateInitialDB() {
        Faker faker = new Faker();
        Random random = new Random();

        for (int i = 0; i < 50; i++){
            Book book = faker.book();
            double preco = Double.parseDouble(String.format("%.2f", random.nextDouble() * 100)) ;
            Livro livro = new Livro(book.title(), book.author(), book.publisher(), preco);
            livro.setId(UUID.randomUUID().toString());
            databaseReference.child("Livro").child(livro.getId()).setValue(livro);
        }
    }

    private void listarLivros() {
        databaseReference.child("Livro").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaLivros.clear();
                for(DataSnapshot objSnapshot: dataSnapshot.getChildren()){
                    Livro livro = objSnapshot.getValue(Livro.class);
                    listaLivros.add(livro);
                }

                arrayAdapterLivros = new LivrosListAdapter(listaLivros);
                rVlista.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rVlista.setAdapter(arrayAdapterLivros);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);

        itemAdd = menu.findItem(R.id.btnAdd);
        itemDelete = menu.findItem(R.id.btnDelete);
        itemReturn = menu.findItem(R.id.btnBack);
        itemSave = menu.findItem(R.id.btnEdit);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        String nome = etTitulo.getText().toString();
        String editora = etEditora.getText().toString();
        String autor = etAutor.getText().toString();
        String preco = etPreco.getText().toString();

        switch (item.getItemId()){
            case R.id.btnAdd: {
                if (nome.equals("") || editora.equals("") || autor.equals("") || preco.equals("")) {
                    valida();
                } else {
                    Livro livro = new Livro();
                    livro.setId(UUID.randomUUID().toString());
                    livro.setTitulo(nome);
                    livro.setAutor(autor);
                    livro.setEditora(editora);
                    livro.setPreco(Double.parseDouble(preco));

                    databaseReference.child("Livro").child(livro.getId()).setValue(livro);
                    Toast.makeText(this,"Adiciondo",Toast.LENGTH_LONG).show();
                    limparcampos();
                }

                break;
            }
            case R.id.btnDelete:{
                Livro livro = new Livro();
                livro.setId(livroSelecionado.getId());
                databaseReference.child("Livro").child(livro.getId()).removeValue();
                Toast.makeText(this,"Registro Excluído",Toast.LENGTH_LONG).show();
                limparcampos();
                setMenuIconVisibility(false);
                break;
            }
            case R.id.btnEdit:{

                Livro livro = new Livro ();
                livro.setId(livroSelecionado.getId());
                livro.setTitulo(nome);
                livro.setAutor(autor);
                livro.setEditora(editora);
                livro.setPreco(Double.parseDouble(preco));

                databaseReference.child("Livro").child(livro.getId()).setValue(livro);
                Toast.makeText(this,"Alterado",Toast.LENGTH_LONG).show();
                limparcampos();
                setMenuIconVisibility(false);
                break;
            }
            case R.id.btnBack:{

                limparcampos();
                setMenuIconVisibility(false);

                break;
            }

            default:break;
        }
        return true;
    }

    private void limparcampos() {
        etTitulo.setText("");
        etAutor.setText("");
        etEditora.setText("");
        etPreco.setText("");
    }

    private void valida() {
        String nome = etTitulo.getText().toString();
        String editora = etEditora.getText().toString();
        String autor = etAutor.getText().toString();
        String preco = etPreco.getText().toString();

        if(nome.equals("")){
            this.etTitulo.setError("Campo Requerido");
        }
        if(editora.equals("")){
            this.etEditora.setError("Campo Requerido");
        }
        if(autor.equals("")){
            this.etAutor.setError("Campo Requerido");
        }
        if(preco.equals("")){
            this.etPreco.setError("Campo Requerido");
        }
    }

    public void setMenuIconVisibility(Boolean ehEdicao) {
        itemAdd.setVisible(!ehEdicao);
        itemDelete.setVisible(ehEdicao);
        itemReturn.setVisible(ehEdicao);
        itemSave.setVisible(ehEdicao);
    }
}
