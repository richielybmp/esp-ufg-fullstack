package com.androidclass.ufg.listviewsample;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidclass.ufg.listviewsample.model.Time;

import java.util.ArrayList;

/**
 * Created by Alunoinf_2 on 02/02/2019.
 */

public class AdapterTimesPersonalizado extends BaseAdapter {

    private final ArrayList<Time> times;
    private final Activity activity;

    public AdapterTimesPersonalizado(ArrayList<Time> times, Activity act) {
        this.times = times;
        this.activity = act;
    }

    @Override
    public int getCount() {
        return times.size();
    }

    @Override
    public Object getItem(int position) {
        return times.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.item_times_layout, parent, false);
        Time time = times.get(position);

        ImageView iv = view.findViewById(R.id.lista_times_personalizada_imagem);
        TextView tv = view.findViewById(R.id.lista_times_personalizada_nome);

        iv.setImageResource(time.getId());

        tv.setText(time.getNome());

        return view;
    }
}
