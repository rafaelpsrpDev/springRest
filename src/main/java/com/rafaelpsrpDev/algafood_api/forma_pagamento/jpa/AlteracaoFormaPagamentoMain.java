package com.rafaelpsrpDev.algafood_api.forma_pagamento.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.rafaelpsrpDev.algafood_api.AlgafoodApiApplication;
import com.rafaelpsrpDev.algafood_api.domain.model.FormaPagamento;
import com.rafaelpsrpDev.algafood_api.domain.repository.FormaPagamentoRepository;

public class AlteracaoFormaPagamentoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);
		
		FormaPagamento formaPagamento = new FormaPagamento();
		formaPagamento.setId(2L);
		formaPagamento.setDescricao("LittleCard");
		
		formaPagamentoRepository.adicionar(formaPagamento);

	}

}
