package com.androidclass.ufg.listviewsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.androidclass.ufg.listviewsample.model.Time;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lista = findViewById(R.id.listaEquipes);

        final ArrayList<Time> equipes = getEquipes();

        //ArrayAdapter<Time> adaptador = new ArrayAdapter<Time>(this,android.R.layout.simple_list_item_1,equipes);
        AdapterTimesPersonalizado adaptador = new AdapterTimesPersonalizado(equipes, this);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Log.i("TAG", "usuário clicou no item:" + lista.getItemAtPosition(position).toString());
                //Toast.makeText(getApplicationContext(),"Você clicou em: "+ equipes.get(position).toString(),Toast.LENGTH_LONG).show();
                abreDetalhes(equipes.get(position), equipes);
            }
        });
    }

    private void abreDetalhes(Time time, ArrayList<Time> times) {
        Intent it = new Intent(this, TimeDetalhesActivity.class);
        it.putExtra("TIME_SELECIONADO", time);
        it.putExtra("TIMES", times);
        startActivity(it);
    }

    private ArrayList<Time> getEquipes() {
        ArrayList<Time> equipes = new ArrayList<>();

        equipes.add(new Time("Atlético Clube Goianiense", R.drawable.atletico_go));
        equipes.add(new Time("Vila Nova", R.drawable.vila_nova));
        equipes.add(new Time("Goiás", R.drawable.goias));
        equipes.add(new Time("Goiânia", R.drawable.goiania));
        equipes.add(new Time("Itumbiara", R.drawable.itumbiaraec));
        equipes.add(new Time("Aparecidense", R.drawable.aparecidense));
        equipes.add(new Time("Anapolina", R.drawable.anapolina));
        equipes.add(new Time("CRAC", R.drawable.crac));
        equipes.add(new Time("Novo Horizonte", R.drawable.novo_horizonte));

        return equipes;
    }


}
