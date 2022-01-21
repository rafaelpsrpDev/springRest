package com.rafaelpsrpDev.algafood_api.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelpsrpDev.algafood_api.domain.exception.EntidadeNaoEncontradaException;
import com.rafaelpsrpDev.algafood_api.domain.model.Cozinha;
import com.rafaelpsrpDev.algafood_api.domain.model.Restaurante;
import com.rafaelpsrpDev.algafood_api.domain.repository.RestauranteRepository;

@Repository
public class RestauranteRepositoryImplementary {
	/*
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> todas() {
		
		TypedQuery<Restaurante> query = manager.createQuery("from Restaurante", Restaurante.class);
		
		return query.getResultList();	
	}

	@Override
	public Restaurante porId(Long id) {
		return manager.find(Restaurante.class, id);
	}
	
	@Transactional
	@Override
	public Restaurante adicionar(Restaurante restaurante) {
		return manager.merge(restaurante);
	}
	
	@Transactional
	@Override
	public void remover(Long restauranteId) {
		Restaurante restaurante = porId(restauranteId);
		
		if(restaurante == null) {
			throw new EntidadeNaoEncontradaException("Não existe");
		}else {			
			manager.remove(restaurante);
		}
	}
*/
}
