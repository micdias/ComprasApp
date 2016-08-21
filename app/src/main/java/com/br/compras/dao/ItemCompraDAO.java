package com.br.compras.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Switch;

import com.br.compras.Enum.Cor;
import com.br.compras.dados.ItemCompra;
import com.br.compras.dados.Setor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Michel on 19/07/16.
 */
public class ItemCompraDAO extends DataBaseHelper{


    private static final String TABLE_NAME = "ITEM_COMPRA";
    public static final String SCRIPT_CREATE = "CREATE TABLE "+TABLE_NAME +"(id PRIMARY KEY, " +
                                                "descricao TEXT NOT NULL, " +
                                                "valor numeric NULL," +
                                                "setor numeric NOT NULL );";

    public static final String SCRIPT_DELETE = "DROP TABLE IF EXISTS "+ TABLE_NAME + ";";


    private static ItemCompraDAO instance;

    private ItemCompraDAO(Context context)
    {
      init(context);
    }

    public static ItemCompraDAO getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new ItemCompraDAO(context);
        }

        return instance;
    }

    public List<ItemCompra> listItemCompra()
    {
        List<ItemCompra> listItemCompra =  new ArrayList<ItemCompra>();

        String[] colunas = {"id","descricao","valor"};
        Cursor cursor =  obterConexao().query(TABLE_NAME, colunas, null, null, null, null, null);
        ItemCompra itemCompra = null;
        while(cursor.moveToNext()) {
            itemCompra = new ItemCompra();
            itemCompra.setId(cursor.getInt(0));
            itemCompra.setItem(cursor.getString(1));
            itemCompra.setValor(cursor.getDouble(2));

            listItemCompra.add(itemCompra);
        }
        fecharConexao();
        return listItemCompra;
    }


    public List<ItemCompra> obterItemCompraPorSetor()
    {
        List<ItemCompra> listItemCompra =  new ArrayList<ItemCompra>();

        String[] colunas = {"id","descricao","valor","setor"};
        Cursor cursor =  obterConexao().query(TABLE_NAME, colunas, null, null, null, null, null);
        ItemCompra itemCompra = null;
        while(cursor.moveToNext()) {
            itemCompra = new ItemCompra();
            itemCompra.setId(cursor.getInt(0));
            itemCompra.setItem(cursor.getString(1));
            itemCompra.setValor(cursor.getDouble(2));
            itemCompra.setSetor(obterSetor(cursor.getInt(3)));

            listItemCompra.add(itemCompra);
        }
        fecharConexao();
        return listItemCompra;
    }

    Map<Integer,Setor> mapSetor = new HashMap<>();
    private Setor obterSetor(Integer codigoSetor)
    {
        Setor setor = null;
        if(mapSetor.containsKey(codigoSetor))
        {
            setor = mapSetor.get(codigoSetor);

        }else
        {
           setor = obterSetorData(codigoSetor);
        }
        return setor;

    }

    //TODO melhorar isso nao esta certo acessar outra tabela
    private Setor obterSetorData(Integer codigoSetor)
    {
        Setor setor = new Setor();

        String[] colunas = {"id","descricao","cor"};
        String selecaoClausula = " id=?";
        String[] selecaoArgumentos = {String.valueOf(codigoSetor)};
        Cursor cursor =  obterConexao().query("setor", colunas, selecaoClausula, selecaoArgumentos, null, null, null);


        if(cursor.moveToNext()) {
            setor.setId(cursor.getInt(0));
            setor.setDescricaoSetor(cursor.getString(1));

            setor.setCor(Cor.valueOf(cursor.getString(2)));
        }
        fecharConexao();
        return setor;
    }


}
