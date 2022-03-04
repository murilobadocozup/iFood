package com.ifoodbackend.pedido;

import com.ifoodbackend.cliente.ClienteRepository;
import com.ifoodbackend.estabelecimento.EstabelecimentoRepository;
import com.ifoodbackend.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid CadastroPedidoForm pedidoForm) {
        Pedido pedido = pedidoForm.converter(clienteRepository,estabelecimentoRepository,itemRepository);
        pedidoRepository.save(pedido);
        return ResponseEntity.ok().build();
    }



}
