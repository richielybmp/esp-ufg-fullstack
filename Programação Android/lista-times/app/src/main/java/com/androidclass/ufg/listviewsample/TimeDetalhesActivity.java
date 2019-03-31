package com.androidclass.ufg.listviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.androidclass.ufg.listviewsample.model.Time;

import java.util.ArrayList;

public class TimeDetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_detalhes);

        TextView tvTime = findViewById(R.id.tvTime);

        Time time = (Time) getIntent().getSerializableExtra("TIME_SELECIONADO");
        ArrayList<Time> times = (ArrayList)getIntent().getSerializableExtra("TIMES");
        System.out.println("Times: "+ time.getNome());
        System.out.println("Times: "+ times.get(0).getNome());

        Log.d("TIME 0", times.get(0).getNome());
        Log.d("TIME_SELECIONADO", time.getNome());

        tvTime.setText(time.toString());

    }
}
