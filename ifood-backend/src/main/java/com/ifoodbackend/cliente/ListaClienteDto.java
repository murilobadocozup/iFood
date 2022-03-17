package com.ifoodbackend.cliente;

import java.util.List;
import java.util.stream.Collectors;

public class ListaClienteDto {

    private Long id;
    private String cpf;

    public ListaClienteDto(Cliente cliente) {
        this.id = cliente.getId();
        this.cpf = cliente.getCpf();
    }

    public Long getId() {
        return id;
    }
    public String getCpf() {
        return cpf;
    }

    public static List<ListaClienteDto> converter(List<Cliente> lista) {
        return lista.stream().map(ListaClienteDto::new).collect(Collectors.toList());
    }
}
