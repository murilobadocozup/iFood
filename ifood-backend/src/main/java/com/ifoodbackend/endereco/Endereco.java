package com.ifoodbackend.endereco;

import com.ifoodbackend.cliente.Cliente;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @NotBlank
    private String rua;

    @NotBlank
    private String numero;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @NotBlank
    private String cep;

    private String complemento;

    private String referencia;

    public Endereco(Cliente cliente, @NotBlank String rua, @NotBlank String numero,
                    @NotBlank String cidade, @NotBlank String estado, @NotBlank String cep) {
        this.cliente = cliente;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public Endereco() {

    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
