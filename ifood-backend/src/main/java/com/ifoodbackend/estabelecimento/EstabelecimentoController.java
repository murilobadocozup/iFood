package com.ifoodbackend.estabelecimento;

import com.ifoodbackend.cliente.Cliente;
import com.ifoodbackend.cliente.EdicaoClienteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/estabelecimentos")
public class EstabelecimentoController {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid CadastroEstabelecimentoForm estabelecimentoForm) {
        Estabelecimento estabelecimento = estabelecimentoForm.converter();
        estabelecimentoRepository.save(estabelecimento);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid EdicaoEstabelecimentoForm estabelecimentoForm) {
        Optional<Estabelecimento> buscaEstabelecimento = estabelecimentoRepository.findById(id);

        if (!buscaEstabelecimento.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }

        Estabelecimento estabelecimento = buscaEstabelecimento.get();
        estabelecimento.setCnpj(estabelecimentoForm.getCnpj());
        estabelecimento.setTelefone(estabelecimentoForm.getTelefone());
        estabelecimento.setEndereco(estabelecimentoForm.getEndereco());
        estabelecimento.setHoraAbertura(estabelecimentoForm.getHoraAbertura());
        estabelecimento.setHoraFechamento(estabelecimentoForm.getHoraFechamento());
        estabelecimento.setTaxaDeEntrega(estabelecimentoForm.getTaxaDeEntrega());
        estabelecimento.setImagem(estabelecimentoForm.getImagem());

        estabelecimentoRepository.save(estabelecimento);

        return ResponseEntity.ok().build();
    }
}
