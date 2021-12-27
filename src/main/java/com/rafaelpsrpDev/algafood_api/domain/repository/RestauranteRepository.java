package com.rafaelpsrpDev.algafood_api.domain.repository;

import java.util.List;

import com.rafaelpsrpDev.algafood_api.domain.model.Restaurante;

public interface RestauranteRepository {
	
	List<Restaurante> todas();
	Restaurante porId(Long id);
	Restaurante adicionar(Restaurante restaurante);
	void remover(Long id);
}
