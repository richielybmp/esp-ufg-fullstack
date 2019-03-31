package com.androidclass.ufg.ecommerceapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alunoinf_2 on 02/02/2019.
 */

public class ProdutosListAdapter extends RecyclerView.Adapter<ProdutosListAdapter.ViewHolder> {

    private final ArrayList<Produto> produtos;

    public ProdutosListAdapter(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from( viewGroup.getContext()).inflate(R.layout.item_produto, viewGroup, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(produtos.get(i));
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nome;
        TextView estoque;
        TextView preco;
        ImageView imagem;

        public ViewHolder(@NonNull View rowView) {
            super(rowView);

            this.nome = (TextView) rowView.findViewById(R.id.produto_nome);
            this.estoque = (TextView) rowView.findViewById(R.id.produto_estoque);
            this.preco = (TextView) rowView.findViewById(R.id.produto_preco);
            this.imagem = (ImageView) rowView.findViewById(R.id.produto_imagem);

            rowView.setOnClickListener(this);
        }

        public void bind(Produto produto){
            nome.setText(produto.getNome());
            estoque.setText( String.valueOf(produto.getQtd_estoque()));
            preco.setText(produto.getPreco());
            imagem.setImageResource(produto.getImageID());
        }

        @Override
        public void onClick(View v) {
            Produto p = produtos.get(getAdapterPosition());
            Context context = v.getContext();
            Intent it = new Intent(context, DetalhesActivity.class);
            it.putExtra("PRODUTO", p);
            context.startActivity(it);
        }
    }

}

//public class ProdutosListAdapter extends ArrayAdapter<Produto> {
//
//    private final ArrayList<Produto> produtos;
//    private final Context context;
//
//    public ProdutosListAdapter(Context context, ArrayList<Produto> elementos){
//        super(context , R.layout.item_produto, elementos);
//        this.context = context;
//        this.produtos = elementos;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent){
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View rowView = inflater.inflate(R.layout.item_produto,parent,false);
//
//        TextView nome = (TextView) rowView.findViewById(R.id.produto_nome);
//        TextView estoque = (TextView) rowView.findViewById(R.id.produto_estoque);
//        TextView preco = (TextView) rowView.findViewById(R.id.produto_preco);
//        ImageView imagem = (ImageView) rowView.findViewById(R.id.produto_imagem);
//
//        nome.setText(produtos.get(position).getNome());
//        estoque.setText( String.valueOf(produtos.get(position).getQtd_estoque()));
//        preco.setText(produtos.get(position).getPreco());
//        imagem.setImageResource(produtos.get(position).getImageID());
//        return rowView;
//    }
//}
