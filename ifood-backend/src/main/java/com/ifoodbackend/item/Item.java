package com.ifoodbackend.item;

import com.ifoodbackend.estabelecimento.Estabelecimento;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Estabelecimento estabelecimento;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotNull
    private Boolean ativo;

    @NotNull @PositiveOrZero
    private BigDecimal preco;

    private String imagem;

    public Item(Estabelecimento estabelecimento, String nome, String descricao, Boolean ativo, BigDecimal preco, String imagem) {
        this.estabelecimento = estabelecimento;
        this.nome = nome;
        this.descricao = descricao;
        this.ativo = ativo;
        this.preco = preco;
        this.imagem = imagem;
    }

    public Item() {
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
