package com.br.compras.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;


import com.br.compras.Enum.Cor;
import com.br.compras.R;
import com.br.compras.dados.Setor;
import com.br.compras.dao.SetorDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaSetorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_setor);

        SetorDAO setorDAO = SetorDAO.getInstance(this);
        List<Setor> listSetor = setorDAO.listSetor();




        int layout = android.R.layout.simple_list_item_1;
        ArrayAdapter<Object> adapter = new ArrayAdapter<Object>(this,layout,listSetor.toArray());


        ListView listCategoria = (ListView) findViewById(R.id.listCategoria);
        listCategoria.setAdapter(adapter);



    }

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

    @Override
    protected void onResume() {
        super.onResume();

        SetorDAO setorDAO =  SetorDAO.getInstance(ListaSetorActivity.this);
        setorDAO.listSetor();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        SetorDAO setorDAO =  SetorDAO.getInstance(ListaSetorActivity.this);
        setorDAO.listSetor();
    }
}
