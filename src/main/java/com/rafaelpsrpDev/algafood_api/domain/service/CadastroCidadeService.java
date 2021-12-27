package com.rafaelpsrpDev.algafood_api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
			cidadeRepository.remover(cidadeId);
		}catch (DataIntegrityViolationException e) {
			throw new EntidadeNaoEncontradaException(String.format(
					"Não existe um cadastro de cidade com codigo %d", cidadeId));
		
		}
	}
	
	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.porId(estadoId);
		
		if(estado == null) {
			throw new EntidadeNaoEncontradaException(
					String.format(
						"Não existe cadastro de estado com codigo %d", estadoId));
		
		}
		
		cidade.setEstado(estado);
		
		return cidadeRepository.adicionar(cidade);
	}
	
	
}
