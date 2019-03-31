package com.example.richielybatista.loginauth.session;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.richielybatista.loginauth.LoginActivity;

import java.util.Date;
import java.util.HashMap;

public class SessionManager {
    public static final String FOLDER = "KEY_SESSION";
    public static final String LOGADO = "KEY_LOGADO";
    public static final String PROPERTY_NOME = "KEY_NOME";
    public static final String PROPERTY_TOKEN = "KEY_TOKEN";
    public static final String PROPERTY_FOTO = "KEY_FOTO";
    public static final String PROPERTY_LOGINTIMESTAMP= "KEY_LOGIN_TIMESTAMP";

    private static SharedPreferences preferences;
    private final Context contexto;
    private final SharedPreferences.Editor editor;

    public SessionManager(Context contexto){
        this.contexto = contexto;
        preferences = getPreferences();
        editor = preferences.edit();
    }

    public void saveLoginSession(String nome, String token, String foto){
        this.editor.putBoolean(LOGADO, true);
        this.editor.putString(PROPERTY_NOME, nome);
        this.editor.putString(PROPERTY_TOKEN, token);
        this.editor.putString(PROPERTY_FOTO, foto);
        this.editor.putLong(PROPERTY_LOGINTIMESTAMP, new Date().getTime());

        this.editor.apply();
    }

    public HashMap<String, String> getSessionData(){
        HashMap<String, String> info = new HashMap<String, String>();

        info.put(PROPERTY_NOME, this.preferences.getString(PROPERTY_NOME, null));
        info.put(PROPERTY_TOKEN, this.preferences.getString(PROPERTY_TOKEN, null));
        info.put(PROPERTY_FOTO, this.preferences.getString(PROPERTY_FOTO, null));

        return info;
    }

    public void logOut() {
        this.editor.remove(LOGADO);
        this.editor.remove(PROPERTY_NOME);
        this.editor.remove(PROPERTY_TOKEN);
        this.editor.remove(PROPERTY_FOTO);
        this.editor.remove(PROPERTY_LOGINTIMESTAMP);

        this.editor.clear();
        this.editor.commit();

        Intent i = new Intent(this.contexto, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        this.contexto.startActivity(i);
    }

    public void checkLogin(){
        if(!isLoggedIn()){
            Intent i = new Intent(this.contexto, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            contexto.startActivity(i);
        }
    }

    private SharedPreferences getPreferences(){
        return this.contexto.getSharedPreferences(FOLDER, Context.MODE_PRIVATE);
    }

    private boolean isLoggedIn(){
        return preferences.getBoolean(LOGADO, false);
    }
}
