package com.br.compras.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.br.compras.R;
import com.br.compras.activity.CadastroSetorActivity;
import com.br.compras.dados.ItemCompra;
import com.br.compras.dao.ItemCompraDAO;


public class ListaComprasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_compra);



        List<ItemCompra> listItemCompra = new ArrayList<>();


        ItemCompraDAO itemCompraDAO =  ItemCompraDAO.getInstance(this);


        listItemCompra = itemCompraDAO.obterItemCompraPorSetor();


        int layout = android.R.layout.simple_list_item_1;
        ArrayAdapter<Object> adapter = new ArrayAdapter<Object>(this,layout,listItemCompra.toArray());


        ListView listCategoria = (ListView) findViewById(R.id.listItemCompras);
        listCategoria.setAdapter(adapter);



    }
//MENU PRINCIPAL
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater =  getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Integer itemClicado = item.getItemId();

        if(itemClicado == R.id.idMenuNovaCategoria)
        {
            Intent ir = new Intent(this, CadastroSetorActivity.class);
            startActivity(ir);

        }else if(itemClicado == R.id.idMenuListaCompras)
        {
            Intent ir = new Intent(this, ListaComprasActivity.class);
            startActivity(ir);
        }else if(itemClicado == R.id.idMenuCadastroCompras)
        {
            Intent ir = new Intent(this, CadastroItemCompraActivity.class);
            startActivity(ir);
        }


        return super.onOptionsItemSelected(item);
    }


}
