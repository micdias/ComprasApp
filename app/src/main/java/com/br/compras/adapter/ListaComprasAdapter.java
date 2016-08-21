package com.br.compras.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.br.compras.R;
import com.br.compras.dados.ItemCompra;

import java.util.List;

/**
 * Created by Michel on 25/03/16.
 */
public class ListaComprasAdapter extends BaseAdapter{


    private final List<ItemCompra> listCompra;
    private final Activity activity;

    public ListaComprasAdapter( List<ItemCompra> listCompra, Activity activity) {
        this.listCompra = listCompra;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listCompra.size();
    }

    @Override
    public Object getItem(int position) {
        return listCompra.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listCompra.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ItemCompra itemCompra = listCompra.get(position);
        ViewHolder holder;

        if(convertView == null)
        {
            convertView = LayoutInflater.from(activity.getApplicationContext()).inflate(R.layout.item_compra_layout, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.descricao.setText(itemCompra.getItem());
        holder.valor.setText(itemCompra.getValor().toString());

        return convertView;
    }

    class ViewHolder
    {
        TextView descricao;
        TextView valor;

        public ViewHolder(View view)
        {
            descricao = (TextView) view.findViewById(R.id.descricaoCompra);
            valor = (TextView) view.findViewById(R.id.valorCompra);
        }

    }
}

