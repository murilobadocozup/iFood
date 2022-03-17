package com.ifoodbackend.cliente;

import com.ifoodbackend.endereco.EdicaoEnderecoForm;
import com.ifoodbackend.endereco.Endereco;
import com.ifoodbackend.endereco.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid CadastroClienteForm clienteForm) {
        Cliente cliente = clienteForm.converter();
        clienteRepository.save(cliente);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid EdicaoClienteForm clienteForm) {
        Optional<Cliente> buscaCliente = clienteRepository.findById(id);

        if (!buscaCliente.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }

        Cliente cliente = buscaCliente.get();
        cliente.setCpf(clienteForm.getCpf());
        cliente.setTelefone(clienteForm.getTelefone());
        cliente.setDataNascimento(clienteForm.getDataNascimento());
        cliente.setImagem(clienteForm.getImagem());

        clienteRepository.save(cliente);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idCliente}/enderecos/{idEndereco}")
    public ResponseEntity<?> atualizarEndereco(@PathVariable Long idCliente, @PathVariable Long idEndereco, @RequestBody @Valid EdicaoEnderecoForm enderecoForm) {
        Optional<Cliente> buscaCliente = clienteRepository.findById(idCliente);
        Optional<Endereco> buscaEndereco = enderecoRepository.findById(idEndereco);

        if (!buscaCliente.isPresent() || !buscaEndereco.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }

        if (buscaEndereco.get().getCliente() != buscaCliente.get()) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("");
        }

        Endereco endereco = buscaEndereco.get();
        endereco.setRua(enderecoForm.getRua());
        endereco.setNumero(enderecoForm.getNumero());
        endereco.setCidade(enderecoForm.getCidade());
        endereco.setEstado(enderecoForm.getEstado());
        endereco.setCep(enderecoForm.getCep());
        endereco.setComplemento(enderecoForm.getComplemento());
        endereco.setReferencia(enderecoForm.getReferencia());

        enderecoRepository.save(endereco);

        return ResponseEntity.ok().build();
    }
}
