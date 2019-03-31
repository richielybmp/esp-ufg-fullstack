package com.androidclass.ufg.firebasesample.model;

import java.io.Serializable;

/**
 * Created by Alunoinf_2 on 23/02/2019.
 */


public class Livro implements Serializable {
    private String id;
    private String titulo;
    private String autor;
    private String editora;
    private double preco;

    public Livro(String titulo, String autor, String editora, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.preco = preco;

    }

    public Livro() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                ", preco=" + preco +
                '}';
    }
}
