package com.androidclass.ufg.ecommerceapp;

import java.io.Serializable;

/**
 * Created by Alunoinf_2 on 02/02/2019.
 */

public class Produto implements Serializable {

    private String nome;

    private String descricao;

    private String cor;

    private int qtd_estoque;

    private int mem_size;

    private double preco;

    private int imageID;

    public Produto(String nome, String descricao, String cor, int qtd_estoque, int mem_size, double preco, int imageID) {
        this.nome = nome;
        this.descricao = descricao;
        this.cor = cor;
        this.qtd_estoque = qtd_estoque;
        this.mem_size = mem_size;
        this.preco = preco;
        this.imageID = imageID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public int getMem_size() {
        return mem_size;
    }

    public void setMem_size(int mem_size) {
        this.mem_size = mem_size;
    }

    public String getPreco() {
        return "R$" + String.valueOf(this.preco);
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
