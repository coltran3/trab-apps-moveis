package com.example.aula5mobile.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;

public class DisciplinaDAO extends SQLiteOpenHelper {
    private static final String DATABASE = "BancoDisciplinas";
    private static final int VERSAO = 1;

    public DisciplinaDAO(Context context) {
        super(context, DATABASE, null, VERSAO);

    }

    public void onCreate(SQLiteDatabase db) {
        String ddl ="CREATE TABLE Disciplina (id INTEGER PRIMARY KEY," + " nome TEXT UNIQUE NOT NULL);";
        db.execSQL(ddl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int velha, int nova) {
        String ddl ="DROP TABLE IF EXISTS Disciplina";
        db.execSQL(ddl);
        onCreate(db);
    }

    public void salvar(DisciplinaValue disciplinaValue) {

        ContentValues values = new ContentValues();

        values.put("nome", disciplinaValue.getNome());
                getWritableDatabase().insert("Disciplina", null, values );
    }

    public List getLista(){
        List<DisciplinaValue> disciplinas = new LinkedList<DisciplinaValue>();
        String query = "SELECT  * FROM " + "Disciplina order by nome";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        DisciplinaValue disciplina = null;

        if (cursor.moveToFirst()) {
            do {
                disciplina = new DisciplinaValue();
                disciplina.setId(Long.parseLong(cursor.getString(0)));
                disciplina.setNome(cursor.getString(1));
                disciplinas.add(disciplina);

            } while (cursor.moveToNext());
        }
        return disciplinas;
    }

    public void deletar(DisciplinaValue disciplinaValue) {
        String[] args = { disciplinaValue.getId().toString() };
        getWritableDatabase().delete("Disciplina", "id=?", args);
    }

    public void alterar(DisciplinaValue disciplinaValue) {
        ContentValues values = new ContentValues();
        values.put("nome", disciplinaValue.getNome());
        getWritableDatabase().update("Disciplina", values, "id=?", new String[]{disciplinaValue.getId().toString()});
    }
}

