package com.rafaelpsrpDev.algafood_api.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rafaelpsrpDev.algafood_api.domain.exception.EntidadeNaoEncontradaException;
import com.rafaelpsrpDev.algafood_api.domain.model.Cidade;
import com.rafaelpsrpDev.algafood_api.domain.model.Estado;
import com.rafaelpsrpDev.algafood_api.domain.repository.CidadeRepository;
import com.rafaelpsrpDev.algafood_api.domain.repository.EstadoRepository;

@Service 
public class CadastroCidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public void excluir(Long cidadeId) {
		try {
			cidadeRepository.deleteById(cidadeId);
		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format(
					"Não existe uma cidade com codigo %d", cidadeId));
		
		}
	}
	
	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Optional<Estado> estado = estadoRepository.findById(estadoId);
		
		if(estado.isPresent()) {
			throw new EntidadeNaoEncontradaException(
					String.format(
						"Não existe cadastro de estado com codigo %d", estadoId));
		
		}
		
		cidade.setEstado(estado.get());
		
		return cidadeRepository.save(cidade);
	}

	
	
}
