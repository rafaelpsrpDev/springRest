package com.rafaelpsrpDev.algafood_api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rafaelpsrpDev.algafood_api.domain.exception.EntidadeEmUsoException;
import com.rafaelpsrpDev.algafood_api.domain.exception.EntidadeNaoEncontradaException;
import com.rafaelpsrpDev.algafood_api.domain.model.Cozinha;
import com.rafaelpsrpDev.algafood_api.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}
	
	public void excluir(Long cozinhaId) {
		try {
			cozinhaRepository.deleteById(cozinhaId);
		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format(
					"Não existe uma cozinha com codigo %d", cozinhaId));
		
		}catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format("Cozinho de codigo %d "
					+ "não pode ser removida, pois está em uso", cozinhaId));
		}	
	}
}
