package com.br.compras.Enum;

/**
 * Created by Michel on 13/07/16.
 */
public enum Cor {

    AMARELO("Amarelo", "#FFFF00"),
    AZUL("Azul",	"#8470FF"),
    VERDE("Verde",	"#00FF00"),
    VERMELHO("Vermelho",	"#FF0000");


    private String descricao;
    private String RGB;

    private Cor(String descricao,String RGB)
    {
        this.descricao = descricao;
        this.RGB = RGB;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getRGB() {
        return RGB;
    }
}
