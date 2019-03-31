package com.androidclass.ufg.livraria;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.androidclass.ufg.livraria.model.Livro;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alunoinf_2 on 09/02/2019.
 */

public class DBAccess {

    private SQLiteDatabase db;

    private DBMannager dbMannager;

    public DBAccess(Context context){
        dbMannager = new DBMannager(context);
    }

    public void dropDB(){
        dbMannager.onUpgrade(db, 0, 0);
    }

    public String insertBook(Livro livro){
        ContentValues valores;
        long resultado;

        db = dbMannager.getWritableDatabase();

        valores = new ContentValues();
        //valores.put(DBMannager.ID, livro.getId());
        valores.put(DBMannager.TITULO, livro.getTitulo());
        valores.put(DBMannager.AUTOR, livro.getAutor());
        valores.put(DBMannager.EDITORA, livro.getEditora());
        valores.put(DBMannager.PRECO, livro.getPreco());

        resultado = db.insert(DBMannager.TABELA, null, valores);

        db.close();

        if (resultado == -1){
            return "Erro ao tentar inserir registro";
        }
        else{
            return "Registro inserido com sucesso.";
        }
    }

    public Livro selectBook(int id) {
        db = dbMannager.getReadableDatabase();

        Cursor cursor = db.query(DBMannager.TABELA, new String[] {
                        DBMannager.ID, DBMannager.TITULO, DBMannager.AUTOR, DBMannager.EDITORA, DBMannager.PRECO },
                DBMannager.ID + "=?",
                new String[] { String.valueOf(id) },
                null,
                null,
                null,
                null);
        Livro livro = null;
        if (cursor != null) {
            cursor.moveToFirst();
            livro = new Livro();
            livro.setId(Integer.parseInt(cursor.getString(0)));
            livro.setTitulo(cursor.getString(1));
            livro.setAutor(cursor.getString(2));
            livro.setEditora(cursor.getString(3));
            livro.setPreco(cursor.getDouble(4));
            return livro;
        } else{
            throw new RuntimeException("ID não encontrado!");
        }
    }

    public ArrayList<Livro> getAll() {
        ArrayList<Livro> livros = new ArrayList<Livro>();

        String selectQuery = "SELECT * FROM " + DBMannager.TABELA;

        db = dbMannager.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,
                null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                Livro livro = new Livro();

                livro.setId(Integer.parseInt(cursor.getString(0)));
                livro.setTitulo(cursor.getString(1));
                livro.setAutor(cursor.getString(2));
                livro.setEditora(cursor.getString(3));
                livro.setPreco(cursor.getDouble(4));

                livros.add(livro);
            } while (cursor.moveToNext());
        }
        db.close();
        return livros;
    }

    public int updateBook(Livro livro) {
        db = dbMannager.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBMannager.TITULO, livro.getTitulo());
        values.put(DBMannager.AUTOR, livro.getAutor());
        values.put(DBMannager.EDITORA, livro.getAutor());
        values.put(DBMannager.PRECO, livro.getPreco());

        // updating row
        return db.update(DBMannager.TABELA, values,
                DBMannager.ID + " = ?",
                new String[] { String.valueOf(livro.getId()) });
    }

    public void deleteBook(int id) {
        db = dbMannager.getWritableDatabase();
        db.delete(DBMannager.TABELA, DBMannager.ID + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }

    public void deleteAllBooks() {
        db = dbMannager.getWritableDatabase();
        db.execSQL("DELETE FROM " + DBMannager.TABELA, null);
        db.close();
    }
}
