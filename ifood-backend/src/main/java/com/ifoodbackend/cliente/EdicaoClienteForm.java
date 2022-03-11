package com.ifoodbackend.cliente;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class EdicaoClienteForm {

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    private String telefone;

    @NotNull
    private LocalDate dataNascimento;

    @NotBlank
    private String imagem;

    public EdicaoClienteForm(@NotBlank @CPF String cpf,
                               @NotBlank String telefone,
                               @NotNull LocalDate dataNascimento,
                               @NotBlank String imagem) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.imagem = imagem;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getImagem() {
        return imagem;
    }
}
