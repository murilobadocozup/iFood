package com.ifoodbackend.pedido;

import com.ifoodbackend.cliente.Cliente;
import com.ifoodbackend.cliente.ClienteRepository;
import com.ifoodbackend.estabelecimento.Estabelecimento;
import com.ifoodbackend.estabelecimento.EstabelecimentoRepository;
import com.ifoodbackend.item.Item;
import com.ifoodbackend.item.ItemRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class CadastroPedidoForm {

    @NotNull
    private Long estabelecimentoId;

    @NotNull
    private Long clienteId;

    @NotBlank
    private String status;

    private List<Long> itensId = new ArrayList<>();

    @NotNull
    private BigDecimal valorPedido;

    @NotNull
    private BigDecimal taxaDeEntrega;

    public CadastroPedidoForm(@NotNull Long estabelecimentoId,
                              @NotNull Long clienteId,
                              @NotBlank String status,
                              List<Long> itensId,
                              @NotNull BigDecimal valorPedido,
                              @NotNull BigDecimal taxaDeEntrega) {
        this.estabelecimentoId = estabelecimentoId;
        this.clienteId = clienteId;
        this.status = status;
        this.itensId.addAll(itensId);
        this.valorPedido = valorPedido;
        this.taxaDeEntrega = taxaDeEntrega;
    }

    public Pedido converter(ClienteRepository clienteRepo, EstabelecimentoRepository estabelecimentoRepo, ItemRepository itemRepo) {
        Optional<Cliente> buscaCliente = clienteRepo.findById(clienteId);
        Optional<Estabelecimento> buscaEstabelecimento = estabelecimentoRepo.findById(estabelecimentoId);

        Cliente cliente = buscaCliente.get();
        Estabelecimento estabelecimento = buscaEstabelecimento.get();

        List<Item> itens = itemRepo.findAllById(itensId);

        Pedido pedido = new Pedido(estabelecimento,cliente,status,itens,valorPedido,taxaDeEntrega);

        return pedido;
    }
}
