package com.ifoodbackend.cliente;

import com.ifoodbackend.endereco.CadastroEnderecoForm;
import com.ifoodbackend.endereco.Endereco;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST)
    private Set<Endereco> enderecos = new HashSet<>();

    @NotBlank
    @Column(nullable = false)
    private String imagem;

    public Cliente(@NotBlank @CPF String cpf,
                   @NotBlank String telefone,
                   @NotBlank @Email String email,
                   @NotNull LocalDate dataNascimento,
                   Set<CadastroEnderecoForm> enderecos,
                   @NotBlank String imagem) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.enderecos = enderecos.stream().map(endereco -> endereco.converter(this)).collect(Collectors.toSet());
        this.dataNascimento = dataNascimento;
        this.imagem = imagem;
    }

    public Cliente() {

    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
