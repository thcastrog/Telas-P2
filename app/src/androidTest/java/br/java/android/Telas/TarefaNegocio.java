package br.java.android.Telas;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.thayna.telas.TarefasOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thayn on 10/12/2016.
 */

public class TarefaNegocio {

    public static long criarTarefa(Tarefa tarefa, Context contexto) {

        TarefasOpenHelper openHelper = new TarefasOpenHelper(contexto);
        SQLiteDatabase bancoDados = openHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("tarefa", tarefa.getTarefa());
        valores.put("descricao", tarefa.getDescricao());
        valores.put("concluida", tarefa.isConcluida());
        long id = bancoDados.insert("tarefas", null, valores);

        bancoDados.close();

        return id;
    }

    public static void buscarTarefa(long id, Context contexto) {
        TarefasOpenHelper openHelper = new TarefasOpenHelper(contexto);
        SQLiteDatabase bancoDados = openHelper.getReadableDatabase();

        Cursor c = bancoDados.query("tarefas", new String[]{"_id", "tarefa", "descricao", "concluida"}, "_id =" + id, null, null, null, null);
    }

    Tarefa t = null;
    c.moveToFirst(); //Va para o começo do resultado
    while(!c.isAfterLast())


    {
        t = new Tarefa();
        AbstractCursor c;
        t.setId(c.getInt(0));
        t.setTarefa(c.getString(1));
        t.setDescricao(c.getString(2));
        t.setConcluida(Boolean.getBoolean(c.getString(3)));

        c.moveToNext();
    }

    c.close();
    bancoDados.close();
    return t;


    public static int apagarTarefa(long idParam, Context contexto) {
        TarefasOpenHelper openHelper = new TarefasOpenHelper(contexto);
        SQLiteDatabase bancoDados = openHelper.getReadableDatabase();

        int linhas = bancoDados.delete("tarefas", " _id" + idParam, null);
        bancoDados.close();
        return linhas;
    }

    public static int atualizarTarefa(Tarefa tarefa, Context contexto) {
        TarefasOpenHelper openHelper = new TarefasOpenHelper(contexto);
        SQLiteDatabase bancoDados = openHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(" _id", tarefa.getId());
        valores.put("tarefa", tarefa.getTarefa());
        valores.put("descricao", tarefa.getDescricao());
        valores.put("concluida", tarefa.isConcluida());

        int linhas = bancoDados.update("tarefas", valores, " _id" + tarefa.getId(), null);
        bancoDados.close();
        return linhas;
    }

    public static List<Tarefa> listaTarefas(Context contexto) {
        TarefasOpenHelper openHelper = new TarefasOpenHelper(contexto);
        SQLiteDatabase bancoDados = openHelper.getReadableDatabase();
        List<Tarefa> tarefas = new ArrayList<Tarefa>();

        Cursor c = bancoDados.query("tarefas", new String[]{"id", "tarefa", "descricao", "concluida"}, null, null, null, null, null);
        Tarefa t = null;
        c.moveToFirst(); //Va para o começo do resultado
        while (!c.isAfterLast())

        {
            t = new Tarefa();
            t.setId(c.getInt(0));
            t.setTarefa(c.getString(1));
            t.setDescricao(c.getString(2));
            t.setConcluida(Boolean.getBoolean(c.getString(3)));
            tarefas.add(t);
            c.moveToNext();
        }
        c.close();
        bancoDados.close();
        return tarefas;
    }
}


