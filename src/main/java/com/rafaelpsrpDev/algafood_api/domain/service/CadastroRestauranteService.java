package com.rafaelpsrpDev.algafood_api.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.rafaelpsrpDev.algafood_api.domain.exception.EntidadeNaoEncontradaException;
import com.rafaelpsrpDev.algafood_api.domain.model.Cozinha;
import com.rafaelpsrpDev.algafood_api.domain.model.Restaurante;
import com.rafaelpsrpDev.algafood_api.domain.repository.CozinhaRepository;
import com.rafaelpsrpDev.algafood_api.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public void excluir(Long restauranteId) {
		try {
			restauranteRepository.deleteById(restauranteId);
		}catch (DataIntegrityViolationException e) {
			throw new EntidadeNaoEncontradaException(String.format(
					"Não existe um cadastro de restaurante com codigo %d", restauranteId));
		
		}

	}
	
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de cozinha com codigo %d", cozinhaId)));
		
		
		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.save(restaurante);
	}
}
