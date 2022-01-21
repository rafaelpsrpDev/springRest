package com.rafaelpsrpDev.algafood_api.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelpsrpDev.algafood_api.domain.model.Cozinha;
import com.rafaelpsrpDev.algafood_api.domain.model.Estado;
import com.rafaelpsrpDev.algafood_api.domain.repository.EstadoRepository;

@Repository
public class EstadoRepositoryImplementary  {
/*
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Estado> todas() {

		TypedQuery<Estado> query = manager.createQuery("from Estado", Estado.class);
		return query.getResultList();
	}

	@Override
	public Estado porId(Long id) {
		return manager.find(Estado.class, id);
	}
	
	
	@Transactional
	@Override
	public Estado adicionar(Estado estado) {
		return manager.merge(estado);
	}
	
	@Transactional
	@Override
	public void remover(Long estadoId) {
		Estado estado = porId(estadoId);
		
		if(estado == null) {
			throw new EmptyResultDataAccessException(1);
		}else {			
			manager.remove(estado);
		}
		
	}
	*/
}
