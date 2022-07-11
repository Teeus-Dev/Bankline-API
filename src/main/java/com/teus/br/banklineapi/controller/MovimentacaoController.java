package com.teus.br.banklineapi.controller;


import com.teus.br.banklineapi.dto.NovaMovimentacao;
import com.teus.br.banklineapi.dto.NovoCorrentista;
import com.teus.br.banklineapi.model.Correntista;
import com.teus.br.banklineapi.model.Movimentacao;
import com.teus.br.banklineapi.repository.CorrentistaRepository;
import com.teus.br.banklineapi.repository.MovimentacaoRepository;
import com.teus.br.banklineapi.service.CorrentistaService;
import com.teus.br.banklineapi.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacao movimentacao) {

        service.save(movimentacao);
    }
}
