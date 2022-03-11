package com.ifoodbackend.cliente;

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
}
