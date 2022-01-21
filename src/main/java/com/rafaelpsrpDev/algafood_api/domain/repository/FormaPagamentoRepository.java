package com.rafaelpsrpDev.algafood_api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelpsrpDev.algafood_api.domain.model.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
	
	/*
	List<FormaPagamento> todas();
	FormaPagamento porId(Long id);
	FormaPagamento adicionar(FormaPagamento formaPagamento);
	void remover(FormaPagamento formaPagamento);
	*/

}
