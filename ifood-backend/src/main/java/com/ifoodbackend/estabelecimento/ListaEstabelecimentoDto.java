package com.ifoodbackend.estabelecimento;

import java.util.List;
import java.util.stream.Collectors;

public class ListaEstabelecimentoDto {

    private Long id;
    private String cnpj;

    public ListaEstabelecimentoDto(Estabelecimento estabelecimento) {
        this.id = estabelecimento.getId();
        this.cnpj = estabelecimento.getCnpj();
    }

    public Long getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public static List<ListaEstabelecimentoDto> converter(List<Estabelecimento> lista) {
        return lista.stream().map(ListaEstabelecimentoDto::new).collect(Collectors.toList());
    }
}
