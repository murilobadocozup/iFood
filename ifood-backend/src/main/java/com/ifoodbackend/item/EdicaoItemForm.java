package com.ifoodbackend.item;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class EdicaoItemForm {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotNull
    private Boolean ativo;

    @NotNull @PositiveOrZero
    private BigDecimal preco;

    private String imagem;

    public EdicaoItemForm(@NotBlank String nome,
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

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getImagem() {
        return imagem;
    }
}
