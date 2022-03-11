package com.ifoodbackend.estabelecimento;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalTime;

public class EdicaoEstabelecimentoForm {

    @NotBlank
    @CNPJ
    private String cnpj;

    @NotBlank
    private String telefone;

    @NotBlank
    private String endereco;

    @NotNull
    private LocalTime horaAbertura;

    @NotNull
    private LocalTime horaFechamento;

    @NotNull
    private BigDecimal taxaDeEntrega;

    @NotBlank
    private String imagem;

    public EdicaoEstabelecimentoForm(@NotBlank @CNPJ String cnpj,
                                       @NotBlank String telefone,
                                       @NotBlank String endereco,
                                       @NotNull LocalTime horaAbertura,
                                       @NotNull LocalTime horaFechamento,
                                       @NotNull BigDecimal taxaDeEntrega,
                                       @NotBlank String imagem) {
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.endereco = endereco;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
        this.taxaDeEntrega = taxaDeEntrega;
        this.imagem = imagem;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public LocalTime getHoraAbertura() {
        return horaAbertura;
    }

    public LocalTime getHoraFechamento() {
        return horaFechamento;
    }

    public BigDecimal getTaxaDeEntrega() {
        return taxaDeEntrega;
    }

    public String getImagem() {
        return imagem;
    }
}
