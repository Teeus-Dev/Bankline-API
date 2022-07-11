package com.teus.br.banklineapi.service;

import com.teus.br.banklineapi.dto.NovaMovimentacao;
import com.teus.br.banklineapi.model.Correntista;
import com.teus.br.banklineapi.model.Movimentacao;
import com.teus.br.banklineapi.model.MovimentacaoTipo;
import com.teus.br.banklineapi.repository.CorrentistaRepository;
import com.teus.br.banklineapi.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private CorrentistaRepository correntistaRepository;
    public void save(NovaMovimentacao novaMovimentacao) {
        Movimentacao movimentacao = new Movimentacao();

        Double valor = novaMovimentacao.getTipo()== MovimentacaoTipo.RECEITA ?
                novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;

        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setValor(valor);

        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
        if(correntista != null) {
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }
        repository.save(movimentacao);
    }
}
