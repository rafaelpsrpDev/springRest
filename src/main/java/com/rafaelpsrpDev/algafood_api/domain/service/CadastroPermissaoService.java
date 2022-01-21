package com.rafaelpsrpDev.algafood_api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rafaelpsrpDev.algafood_api.domain.exception.EntidadeNaoEncontradaException;
import com.rafaelpsrpDev.algafood_api.domain.model.Permissao;
import com.rafaelpsrpDev.algafood_api.domain.repository.PermissaoRepository;

@Service
public class CadastroPermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;
	
	
	public Permissao salvar(Permissao permissao) {
		return permissaoRepository.save(permissao);
	}
	
	public void excluir(Long id) {
		try {
			permissaoRepository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(String.format(
					"Não existe uma permissao com codigo %d", id));
		}
	}
}
