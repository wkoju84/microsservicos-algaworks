package com.william.avaliacao.api;

import com.william.avaliacao.domain.AvaliacaoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoController(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @GetMapping
    public List<AvaliacaoModel> buscarPorProduto (@RequestParam Long produtoId){

        return avaliacaoRepository.getAll()
                .stream()
                .filter(avaliacao -> avaliacao.getProdutoId().equals(produtoId))
                .map(AvaliacaoModel::of)
                .collect(Collectors.toList());
    }

}
