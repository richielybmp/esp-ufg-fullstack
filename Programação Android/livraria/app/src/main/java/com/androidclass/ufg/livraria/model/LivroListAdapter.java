package com.androidclass.ufg.livraria.model;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidclass.ufg.livraria.DetailsActivity;
import com.androidclass.ufg.livraria.R;

import java.util.ArrayList;

/**
 * Created by Alunoinf_2 on 09/02/2019.
 */

public class LivroListAdapter extends RecyclerView.Adapter<LivroListAdapter.ViewHolder> {

    private final ArrayList<Livro> livros;

    public LivroListAdapter(ArrayList<Livro> livros) {
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

        public ViewHolder(@NonNull View rowView) {
            super(rowView);

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

        @Override
        public void onClick(View v) {
            Livro livro = livros.get(getAdapterPosition());
            Context context = v.getContext();
            Intent it = new Intent(context, DetailsActivity.class);
            it.putExtra("LIVRO", livro);
            context.startActivity(it);
        }
    }
}
