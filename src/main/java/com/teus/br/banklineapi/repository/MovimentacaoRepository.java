package com.teus.br.banklineapi.repository;

import com.teus.br.banklineapi.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {

}
