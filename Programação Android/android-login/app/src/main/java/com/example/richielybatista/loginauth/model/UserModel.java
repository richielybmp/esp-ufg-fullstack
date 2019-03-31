package com.example.richielybatista.loginauth.model;

import java.io.Serializable;

public class UserModel implements Serializable {
    private String nome;
    private String token;
    private String photourl;

    public UserModel() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }
}
