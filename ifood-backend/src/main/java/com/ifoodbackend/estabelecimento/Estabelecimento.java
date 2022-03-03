package com.ifoodbackend.estabelecimento;

import com.ifoodbackend.item.CadastroItemForm;
import com.ifoodbackend.item.Item;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @CNPJ
    @Column(nullable = false)
    private String cnpj;

    @NotBlank
    @Column(nullable = false)
    private String telefone;

    @NotBlank
    @Email
    @Column(nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String endereco;

    @NotNull
    @Column(nullable = false)
    private LocalTime horaAbertura;

    @NotNull
    @Column(nullable = false)
    private LocalTime horaFechamento;

    @NotNull
    @Column(nullable = false)
    private BigDecimal taxaDeEntrega;

    @NotBlank
    @Column(nullable = false)
    private String imagem;

    @OneToMany(mappedBy = "estabelecimento", cascade = CascadeType.PERSIST)
    private Set<Item> itens = new HashSet<>();

    public Estabelecimento(@NotBlank @CNPJ String cnpj,
                           @NotBlank String telefone,
                           @NotBlank @Email String email,
                           @NotBlank String endereco,
                           @NotNull LocalTime horaAbertura,
                           @NotNull LocalTime horaFechamento,
                           @NotNull BigDecimal taxaDeEntrega,
                           @NotBlank String imagem,
                           Set<CadastroItemForm> itens) {
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
        this.taxaDeEntrega = taxaDeEntrega;
        this.imagem = imagem;
        this.itens = itens.stream().map(item -> item.converter(this)).collect(Collectors.toSet());
    }

    public Estabelecimento() {

    }
}
