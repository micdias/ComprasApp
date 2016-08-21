package com.br.compras.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.br.compras.Enum.Cor;
import com.br.compras.R;

import com.br.compras.dados.Setor;
import com.br.compras.dao.SetorDAO;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Michel on 12/04/16.
 */
public class CadastroSetorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_setor);

        List<Cor> listCores = Arrays.asList(Cor.values());

        Spinner spinnerSetor = (Spinner) findViewById(R.id.spinnerCores);
        ArrayAdapter<Cor> dataAdapter = new ArrayAdapter<Cor>(this, android.R.layout.simple_spinner_dropdown_item, listCores);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSetor.setAdapter(dataAdapter);


        spinnerSetor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinnerSetor = (Spinner) findViewById(R.id.spinnerCores);

                Cor corSelecionada = (Cor) spinnerSetor.getSelectedItem();
                spinnerSetor.setBackgroundColor(Color.parseColor(corSelecionada.getRGB()));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        Button botaoSalvar =  (Button) findViewById(R.id.btnSalvar);
        Toast.makeText(CadastroSetorActivity.this,"BEM VINDO",Toast.LENGTH_LONG).show();
        botaoSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                TextView categoriaView =  (TextView) findViewById(R.id.editTextCategoria);
                Spinner spinnerSetor = (Spinner) findViewById(R.id.spinnerCores);

                Cor corSelecionada = (Cor) spinnerSetor.getSelectedItem();
                spinnerSetor.setBackgroundColor(Color.parseColor(corSelecionada.getRGB()));

                Setor setor = new Setor(categoriaView.getText().toString(),corSelecionada);
                SetorDAO setorDAO = SetorDAO.getInstance(CadastroSetorActivity.this);

                if(setorDAO.gravar(setor)){
                    Toast.makeText(CadastroSetorActivity.this, "cadastro com sucesso"+ categoriaView.getText(),Toast.LENGTH_SHORT).show();

                }else
                {
                    Toast.makeText(CadastroSetorActivity.this, "erro no cadastro"+ categoriaView.getText(),Toast.LENGTH_SHORT).show();
                }

                //setorDAO.fecharConexao();

                //voltando para tela inicial
                Intent ir = new Intent(CadastroSetorActivity.this, ListaSetorActivity.class);
                startActivity(ir);
                finish();
            }
        });

    }


}
