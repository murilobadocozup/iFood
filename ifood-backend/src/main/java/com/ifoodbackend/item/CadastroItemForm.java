package com.ifoodbackend.item;

import com.ifoodbackend.estabelecimento.Estabelecimento;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class CadastroItemForm {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotNull
    private Boolean ativo;

    @NotNull @PositiveOrZero
    private BigDecimal preco;

    private String imagem;

    public CadastroItemForm(@NotBlank String nome,
                            @NotBlank String descricao,
                            @NotNull Boolean ativo,
                            @NotNull @PositiveOrZero BigDecimal preco,
                            String imagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.ativo = ativo;
        this.preco = preco;
        this.imagem = imagem;
    }

    public Item converter(Estabelecimento estabelecimento) {
        Item item = new Item(estabelecimento,nome,descricao,ativo,preco,imagem);

        if (imagem != null) {
            item.setImagem(imagem);
        }

        return item;
    }
}
