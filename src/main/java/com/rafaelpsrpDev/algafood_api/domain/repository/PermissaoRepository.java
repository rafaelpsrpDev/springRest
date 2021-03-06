package com.rafaelpsrpDev.algafood_api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelpsrpDev.algafood_api.domain.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long>{
	/*
	List<Permissao> todas();
	Permissao porId(Long id);
	Permissao adicionar(Permissao permissao);
	void remover(Permissao permissao);
	*/
}
