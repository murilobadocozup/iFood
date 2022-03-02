package com.ifoodbackend.endereco;

import com.ifoodbackend.cliente.Cliente;

import javax.validation.constraints.NotBlank;

public class CadastroEnderecoForm {

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

    public CadastroEnderecoForm(@NotBlank String rua, @NotBlank String numero, @NotBlank String cidade,
                    @NotBlank String estado, @NotBlank String cep, String complemento, String referencia) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.complemento = complemento;
        this.referencia = referencia;
    }

    public Endereco converter(Cliente cliente) {
        Endereco endereco = new Endereco(cliente,rua,numero,cidade,estado,cep);

        if (complemento != null) {
            endereco.setComplemento(complemento);
        }
        if (referencia != null) {
            endereco.setReferencia(referencia);
        }

        return endereco;
    }
}
