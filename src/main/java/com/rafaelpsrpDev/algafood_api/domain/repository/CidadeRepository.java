package com.rafaelpsrpDev.algafood_api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelpsrpDev.algafood_api.domain.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	/*
	List<Cidade> todas();
	Cidade porId(Long id);
	Cidade adicionar(Cidade cidade);
	void remover(Long id);
*/
}
