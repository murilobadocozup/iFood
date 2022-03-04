package com.ifoodbackend.pedido;

import com.ifoodbackend.cliente.Cliente;
import com.ifoodbackend.estabelecimento.Estabelecimento;
import com.ifoodbackend.item.Item;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Estabelecimento estabelecimento;

    @NotNull
    @ManyToOne
    private Cliente cliente;

    @NotBlank
    private String status;

    @ManyToMany
    @JoinTable(name = "pedido_item")
    private List<Item> itens = new ArrayList<>();

    @NotNull
    private BigDecimal valorPedido;

    @NotNull
    private BigDecimal taxaDeEntrega;

    @NotNull
    private LocalDateTime dataPedido;

    public Pedido(@NotNull Estabelecimento estabelecimento,
                  @NotNull Cliente cliente,
                  @NotBlank String status,
                  List<Item> itens,
                  @NotNull BigDecimal valorPedido,
                  @NotNull BigDecimal taxaDeEntrega) {
        this.estabelecimento = estabelecimento;
        this.cliente = cliente;
        this.status = status;
        this.itens.addAll(itens);
        this.valorPedido = valorPedido;
        this.taxaDeEntrega = taxaDeEntrega;
        this.dataPedido = LocalDateTime.now();
    }

    public Pedido() {
    }
}
