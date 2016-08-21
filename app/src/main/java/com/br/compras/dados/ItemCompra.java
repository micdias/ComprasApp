package com.br.compras.dados;

/**
 * Created by Michel on 25/03/16.
 */
public class ItemCompra {

    private long id;
    private String item;
    private Double valor;
    private Setor setor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }


    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }


    @Override
    public String toString() {
        return getItem();
    }
}
