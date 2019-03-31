package com.androidclass.ufg.firebasesample.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TextView;

import com.androidclass.ufg.firebasesample.MainActivity;
import com.androidclass.ufg.firebasesample.R;

import java.util.ArrayList;

/**
 * Created by Alunoinf_2 on 23/02/2019.
 */


public class LivrosListAdapter extends RecyclerView.Adapter<LivrosListAdapter.ViewHolder> {

    private final ArrayList<Livro> livros;
    private int pos = 0;

    public LivrosListAdapter(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from( viewGroup.getContext()).inflate(R.layout.item_livro, viewGroup, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(livros.get(i));
        viewHolder.itemView.setBackgroundColor(pos == i ? Color.LTGRAY : Color.TRANSPARENT);
    }

    @Override
    public int getItemCount() {
        return livros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titulo;
        TextView autor;
        TextView editora;
        TextView preco;

        Context viewContext;

        public ViewHolder(@NonNull View rowView) {
            super(rowView);
            viewContext = rowView.getContext();
            this.titulo = (TextView) rowView.findViewById(R.id.livro_nome);
            this.autor = (TextView) rowView.findViewById(R.id.livro_autor);
            this.editora = (TextView) rowView.findViewById(R.id.livro_editora);
            this.preco = (TextView) rowView.findViewById(R.id.livro_preco);

            rowView.setOnClickListener(this);
        }

        public void bind(Livro livro){
            titulo.setText(livro.getTitulo());
            autor.setText(livro.getAutor());
            editora.setText(livro.getEditora());
            preco.setText(String.valueOf(livro.getPreco()));
        }

        public void bindForm(Livro livro){
            ((MainActivity) viewContext).etTitulo.setText(livro.getTitulo());
            ((MainActivity) viewContext).etAutor.setText(livro.getAutor());
            ((MainActivity) viewContext).etEditora.setText(livro.getEditora());
            ((MainActivity) viewContext).etPreco.setText(Double.toString(livro.getPreco()));
        }

        public void onClick(View v) {
            if (getAdapterPosition() == RecyclerView.NO_POSITION) return;
            Livro livro = livros.get(getAdapterPosition());
            bindForm( livro);
            ((MainActivity) viewContext).livroSelecionado = livro;
            ((MainActivity) viewContext).setMenuIconVisibility(true);

            // Updating old as well as new positions
            notifyItemChanged(pos);
            pos = getAdapterPosition();
            notifyItemChanged(pos);

        }
    }
}