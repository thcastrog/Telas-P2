package com.thayna.telas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by thayn on 10/12/2016.
 */

public class TarefasOpenHelper extends SQLiteOpenHelper {

    private static final String NOME_DO_BANCO = "TarefasBancoDados";
    private static final int VERSAO_BANCO = 1;

    private Context contexto;

    public TarefasOpenHelper(Context context) {
        super(context, NOME_DO_BANCO, null, VERSAO_BANCO);
        this.contexto = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE tarefas" +
                "(_id integer PRIMARY KEY" +
                " AUTOINCREMENT, " +
                "tarefa text, " +
                " descricao text, " +
                " concluida boolean)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
