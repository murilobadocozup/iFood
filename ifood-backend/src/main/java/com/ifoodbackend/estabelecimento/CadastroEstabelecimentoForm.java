package com.ifoodbackend.estabelecimento;

import com.ifoodbackend.item.CadastroItemForm;
import com.ifoodbackend.validadores.ValorUnico;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class CadastroEstabelecimentoForm {

    @NotBlank
    @CNPJ
    private String cnpj;

    @NotBlank
    private String telefone;

    @NotBlank
    @Email
    @ValorUnico(domainClass = Estabelecimento.class, fieldName = "email")
    private String email;

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

    @Valid
    private Set<CadastroItemForm> itens = new HashSet<>();

    public CadastroEstabelecimentoForm(@NotBlank @CNPJ String cnpj,
                                       @NotBlank String telefone,
                                       @NotBlank @Email String email,
                                       @NotBlank String endereco,
                                       @NotNull LocalTime horaAbertura,
                                       @NotNull LocalTime horaFechamento,
                                       @NotNull BigDecimal taxaDeEntrega,
                                       @NotBlank String imagem,
                                       @Valid Set<CadastroItemForm> itens) {
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
        this.taxaDeEntrega = taxaDeEntrega;
        this.imagem = imagem;
        this.itens.addAll(itens);
    }

    public Estabelecimento converter() {
        return new Estabelecimento(cnpj,telefone,email,endereco,
                horaAbertura, horaFechamento,taxaDeEntrega,imagem,itens);
    }
}
