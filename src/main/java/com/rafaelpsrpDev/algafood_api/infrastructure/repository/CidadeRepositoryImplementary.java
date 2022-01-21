package com.rafaelpsrpDev.algafood_api.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelpsrpDev.algafood_api.domain.model.Cidade;
import com.rafaelpsrpDev.algafood_api.domain.repository.CidadeRepository;

@Repository
public class CidadeRepositoryImplementary {
	/*	
	@PersistenceContext
	private EntityManager manager;

	
	@Override
	public List<Cidade> todas() {
		
		TypedQuery<Cidade> query = manager.createQuery("from Cidade", Cidade.class);
		return query.getResultList();
	}

	@Override
	public Cidade porId(Long id) {
		return manager.find(Cidade.class, id);
	}
	
	@Transactional
	@Override
	public Cidade adicionar(Cidade cidade) {
		return manager.merge(cidade);
	}
	
	@Transactional
	@Override
	public void remover(Long cidadeId) {
		Cidade cidade = porId(cidadeId);

		if(cidade == null) {
			throw new EmptyResultDataAccessException(1);
		}else {			
			manager.remove(cidade);
		}
		
	}*/
	
}
