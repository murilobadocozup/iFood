package com.ifoodbackend.estabelecimento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
