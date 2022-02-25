package com.ifoodbackend.cliente;

import com.ifoodbackend.validadores.ValorUnico;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @CPF
    @Column(nullable = false)
    private String cpf;

    @NotBlank
    @Column(nullable = false)
    private String telefone;

    @NotNull
    @Column(nullable = false)
    private LocalDate dataNascimento;

    @NotBlank
    @Email
    @Column(nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String endereco;

    @NotBlank
    @Column(nullable = false)
    private String imagem;

    public Cliente(@NotBlank @CPF String cpf,
                   @NotBlank String telefone,
                   @NotBlank @Email String email,
                   @NotBlank String endereco,
                   @NotNull LocalDate dataNascimento,
                   @NotBlank String imagem) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.imagem = imagem;
    }

    public Cliente() {

    }
}
