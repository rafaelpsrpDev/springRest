package com.rafaelpsrpDev.algafood_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelpsrpDev.algafood_api.domain.exception.EntidadeNaoEncontradaException;
import com.rafaelpsrpDev.algafood_api.domain.model.Permissao;
import com.rafaelpsrpDev.algafood_api.domain.repository.PermissaoRepository;
import com.rafaelpsrpDev.algafood_api.domain.service.CadastroPermissaoService;

@RestController
@RequestMapping(value = "/permissao")
public class PermissaoController {
	
	
	@Autowired
	private CadastroPermissaoService cadastroPermissaoService;
	
	@Autowired
	private PermissaoRepository permissaoRepository;
	
	
	@GetMapping
	public List<Permissao> listar(){
		return permissaoRepository.findAll();
	}
	
	@GetMapping("/{permissaoId}")
	public ResponseEntity<Permissao> buscar(@PathVariable("permissaoId") Long id){
		Optional<Permissao> permissao = permissaoRepository.findById(id);
		if(permissao.isPresent()) {
			return ResponseEntity.ok(permissao.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Permissao permissao(@RequestBody Permissao permissao) {
		return cadastroPermissaoService.salvar(permissao);
	}
	
	@PutMapping("/{permissaoId}")
	public ResponseEntity<Permissao> atualizar(@PathVariable("permissaoId") Long id, @RequestBody Permissao permissao){
		Optional<Permissao> permissaoAtual = permissaoRepository.findById(id);
		if(permissaoAtual.isPresent()) {	
			BeanUtils.copyProperties(permissao, permissaoAtual.get(), "id");
			
			Permissao permissaoNova = cadastroPermissaoService.salvar(permissaoAtual.get());
			return ResponseEntity.ok(permissaoNova);
		}else {
			return ResponseEntity.notFound().build();
		}	
	}
	
	@DeleteMapping("/{permissaoId}")
	public ResponseEntity<Permissao> remover(@PathVariable("permissaoId") Long id){
		try {
			cadastroPermissaoService.excluir(id);
			return ResponseEntity.noContent().build();
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
