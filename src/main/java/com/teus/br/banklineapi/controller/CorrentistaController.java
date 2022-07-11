package com.teus.br.banklineapi.controller;


import java.util.List;

import com.teus.br.banklineapi.dto.NovoCorrentista;
import com.teus.br.banklineapi.model.Correntista;
import com.teus.br.banklineapi.repository.CorrentistaRepository;
import com.teus.br.banklineapi.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
    @Autowired
    private CorrentistaRepository repository;

    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovoCorrentista correntista) {
        service.save(correntista);
    }
}
