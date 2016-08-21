package com.br.compras.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.br.compras.Enum.Cor;
import com.br.compras.dados.Setor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michel on 06/05/16.
 */
public class SetorDAO extends DataBaseHelper{

    private static final String TABLE_NAME = "SETOR";
    public static final String SCRIPT_CREATE = "CREATE TABLE "+TABLE_NAME+" (id PRIMARY KEY, " +
                                                "descricao TEXT NOT NULL, " +
                                                "cor TEXT NOT NULL )";

    public static final String SCRIPT_DELETE = "DROP TABLE IF EXISTS "+ TABLE_NAME + ";";

    private static SetorDAO instance;

    private SetorDAO(Context context)
    {
        init(context);
    }

    public static SetorDAO getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new SetorDAO(context);
        }

        return instance;
    }

    public boolean gravar(Setor setor)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put("descricao",setor.getDescricaoSetor());
        contentValues.put("cor", setor.getCor().getRGB());


        obterConexao().insert(TABLE_NAME,null,contentValues);

        fecharConexao();
        return true;
    }


    public List<Setor> listSetor()
    {
        List<Setor> listSetor = new ArrayList<Setor>();

        String[] colunas = {"id","descricao","cor"};
        Cursor cursor =  obterConexao().query(TABLE_NAME, colunas, null, null, null, null, null);
        Setor setor = null;
       while(cursor.moveToNext()) {
           setor = new Setor();
           setor.setId(cursor.getInt(0));
           setor.setDescricaoSetor(cursor.getString(1));
           try {
               String temp = cursor.getString(2);
               setor.setCor(Cor.valueOf(temp));
           }catch (Exception e){
               e.getMessage();
           }

           listSetor.add(setor);
       }
        fecharConexao();

        return listSetor;
    }

    public Setor obterSetor(Integer codigoSetor)
    {
        Setor setor = new Setor();

        String[] colunas = {"id","descricao","cor"};
        String selecaoClausula = " id=?";
        String[] selecaoArgumentos = {String.valueOf(codigoSetor)};
        Cursor cursor =  obterConexao().query(TABLE_NAME, colunas, selecaoClausula, selecaoArgumentos, null, null, null);


        if(cursor.moveToNext()) {
            setor.setId(cursor.getInt(0));
            setor.setDescricaoSetor(cursor.getString(1));
            setor.setCor(Cor.valueOf(cursor.getString(2)));
         }

        fecharConexao();

        return setor;
    }



}
