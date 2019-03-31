package com.androidclass.ufg.listviewsample.model;

import java.io.Serializable;

/**
 * Created by Alunoinf_2 on 01/02/2019.
 */

public class Time implements Serializable {

    private String nome;
    private int id;

    public Time(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return getNome();
    }
}