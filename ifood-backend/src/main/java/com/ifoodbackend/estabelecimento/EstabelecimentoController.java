package com.ifoodbackend.estabelecimento;

import com.ifoodbackend.item.EdicaoItemForm;
import com.ifoodbackend.item.Item;
import com.ifoodbackend.item.ItemRepository;
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

    @Autowired
    private ItemRepository itemRepository;

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

    @PutMapping("/{idEstabelecimento}/itens/{idItem}")
    public ResponseEntity<?> atualizarItem(@PathVariable Long idEstabelecimento, @PathVariable Long idItem, @RequestBody @Valid EdicaoItemForm itemForm) {
        Optional<Estabelecimento> buscaEstabelecimento = estabelecimentoRepository.findById(idEstabelecimento);
        Optional<Item> buscaItem = itemRepository.findById(idItem);

        if (!buscaEstabelecimento.isPresent() || !buscaItem.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }

        if (buscaItem.get().getEstabelecimento() != buscaEstabelecimento.get()) {
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("");
        }

        Item item = buscaItem.get();
        item.setNome(itemForm.getNome());
        item.setDescricao(itemForm.getDescricao());
        item.setAtivo(itemForm.getAtivo());
        item.setPreco(itemForm.getPreco());
        item.setImagem(itemForm.getImagem());

        itemRepository.save(item);

        return ResponseEntity.ok().build();
    }
}
