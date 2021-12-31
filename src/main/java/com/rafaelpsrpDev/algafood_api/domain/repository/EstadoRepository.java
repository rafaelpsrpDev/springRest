package com.rafaelpsrpDev.algafood_api.domain.repository;

import java.util.List;

import com.rafaelpsrpDev.algafood_api.domain.model.Estado;

public interface EstadoRepository {
	
	List<Estado> todas();
	Estado porId(Long id);
	Estado adicionar(Estado estado);
	void remover(Long estadoId);
}
