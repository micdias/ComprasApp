package com.br.compras.dados;

import com.br.compras.Enum.Cor;

/**
 * Created by Michel on 06/05/16.
 */
public class Setor {
    private String descricaoSetor;
    private Cor cor;
    private Integer id;

    public Setor(String descricaoSetor,Cor cor)
    {
        this.descricaoSetor = descricaoSetor;
        this.cor = cor;
    }

    public Setor()
    {}


    public String getDescricaoSetor() {
        return descricaoSetor;
    }

    public void setDescricaoSetor(String descricaoSetor) {
        this.descricaoSetor = descricaoSetor;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getDescricaoSetor() + " " + getCor();
    }
}
