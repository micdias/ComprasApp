package com.br.compras.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Michel on 19/07/16.
 */
public class DataBaseConfig extends SQLiteOpenHelper {

    private static final String nameDataBase = "ComprasDB.db";
    private static final int versaoDataBase = 1;

    private static DataBaseConfig instance = null;

    private DataBaseConfig(Context context)
    {
        super(context, nameDataBase, null, versaoDataBase);
    }

    public static DataBaseConfig getInstance(Context context) {
        if(instance == null)
            instance = new DataBaseConfig(context);

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ItemCompraDAO.SCRIPT_CREATE);
        db.execSQL(SetorDAO.SCRIPT_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ItemCompraDAO.SCRIPT_DELETE);
        db.execSQL(SetorDAO.SCRIPT_DELETE);

        onCreate(db);
    }
}
