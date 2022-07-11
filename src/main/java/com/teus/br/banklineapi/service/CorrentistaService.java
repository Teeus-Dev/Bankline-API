package com.teus.br.banklineapi.service;

import com.teus.br.banklineapi.dto.NovoCorrentista;
import com.teus.br.banklineapi.model.Conta;
import com.teus.br.banklineapi.model.Correntista;
import com.teus.br.banklineapi.controller.CorrentistaController;
import com.teus.br.banklineapi.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CorrentistaService {

    @Autowired
    private CorrentistaRepository repository;

    public void save(NovoCorrentista novoCorrentista) {
        Correntista correntista = new Correntista();
        correntista.setCpf(novoCorrentista.getCpf());
        correntista.setNome(novoCorrentista.getNome());

        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());

        correntista.setConta(conta);
        repository.save(correntista);


    }
}
