package com.rafaelpsrpDev.algafood_api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rafaelpsrpDev.algafood_api.domain.exception.EntidadeEmUsoException;
import com.rafaelpsrpDev.algafood_api.domain.exception.EntidadeNaoEncontradaException;
import com.rafaelpsrpDev.algafood_api.domain.model.Estado;
import com.rafaelpsrpDev.algafood_api.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	

	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
	}
	
	public void excluir(Long estadoId) {
		try {
			estadoRepository.deleteById(estadoId);
		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format(
					"Não existe um cadastro de estado com codigo %d", estadoId));
		
		}catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("Estado de codigo %d "
					+ "não pode ser removida, pois está em uso", estadoId));
		}	
		
	}
}
