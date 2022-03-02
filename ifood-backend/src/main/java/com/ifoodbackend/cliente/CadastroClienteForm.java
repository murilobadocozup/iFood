package com.ifoodbackend.cliente;

import com.ifoodbackend.endereco.CadastroEnderecoForm;
import com.ifoodbackend.validadores.ValorUnico;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class CadastroClienteForm {

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    private String telefone;

    @NotBlank
    @Email
    @ValorUnico(domainClass = Cliente.class, fieldName = "email")
    private String email;

    @Valid
    private Set<CadastroEnderecoForm> enderecos = new HashSet<>();

    @NotNull
    private LocalDate dataNascimento;

    @NotBlank
    private String imagem;

    public CadastroClienteForm(@NotBlank @CPF String cpf,
                               @NotBlank String telefone,
                               @NotBlank @Email String email,
                               @Valid Set<CadastroEnderecoForm> enderecos,
                               @NotNull LocalDate dataNascimento,
                               @NotBlank String imagem) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.enderecos.addAll(enderecos);
        this.dataNascimento = dataNascimento;
        this.imagem = imagem;
    }

    public Cliente converter() {
        return new Cliente(cpf,telefone,email,dataNascimento,enderecos,imagem);
    }
}
