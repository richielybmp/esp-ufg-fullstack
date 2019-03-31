package com.androidclass.ufg.livraria;

/**
 * Created by Alunoinf_2 on 09/02/2019.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBMannager extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "livros";
    public static final String ID = "_id";
    public static final String TITULO = "titulo";
    public static final String AUTOR = "autor";
    public static final String EDITORA = "editora";
    public static final String PRECO = "preco";
    private static final int VERSAO = 1;

    public DBMannager(Context context) {
        super(context, NOME_BANCO, null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LIVROS_TABLE = "CREATE TABLE "
                + TABELA + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + TITULO + " TEXT,"
                + AUTOR + " TEXT,"
                + EDITORA + " TEXT,"
                + PRECO + " REAL )";
        db.execSQL(CREATE_LIVROS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
