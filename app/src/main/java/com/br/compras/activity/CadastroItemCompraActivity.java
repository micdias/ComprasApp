package com.br.compras.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.br.compras.R;
import com.br.compras.dados.Setor;
import com.br.compras.dao.SetorDAO;

import java.util.List;

/**
 * Created by Michel on 20/07/16.
 */
public class CadastroItemCompraActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_itemcompra);


        Spinner spinnerSetor = (Spinner) findViewById(R.id.spinnerSetorItemCompra);
        ArrayAdapter<Setor> dataAdapter = new ArrayAdapter<Setor>(this, android.R.layout.simple_spinner_dropdown_item, listSetor());
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSetor.setAdapter(dataAdapter);

        Button botaoSalvarItemCompra = (Button) findViewById(R.id.btnCadastraItemCompra);
        botaoSalvarItemCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView descricaoItemCompra = (TextView) findViewById(R.id.textDescricaoItemCompra);
                Spinner spinnerSetor = (Spinner) findViewById(R.id.spinnerSetorItemCompra);
                Setor setor = (Setor) spinnerSetor.getSelectedItem();


            }

        });
    }

    private List<Setor> listSetor()
    {
        SetorDAO setorDAO = SetorDAO.getInstance(this);
        return setorDAO.listSetor();

    }


}
