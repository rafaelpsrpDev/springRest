package com.rafaelpsrpDev.algafood_api.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelpsrpDev.algafood_api.domain.model.FormaPagamento;
import com.rafaelpsrpDev.algafood_api.domain.repository.FormaPagamentoRepository;

@Repository
public class FormaPagamentoRepositoryImplementary {
	
	/*
	@PersistenceContext
	private EntityManager manager;
	
	
	public List<FormaPagamento> todas() {
		
		TypedQuery<FormaPagamento> query = manager.createQuery("from FormaPagamento", FormaPagamento.class);
		
		return query.getResultList();
	}

	@Override
	public FormaPagamento porId(Long id) {
		return manager.find(FormaPagamento.class, id);
	}
	
	@Transactional
	@Override
	public FormaPagamento adicionar(FormaPagamento formaPagamento) {
		
		return manager.merge(formaPagamento);
	}
	
	@Transactional
	@Override
	public void remover(FormaPagamento formaPagamento) {
		
		formaPagamento = porId(formaPagamento.getId());
		manager.remove(formaPagamento);
		
	}
	*/
	
}
