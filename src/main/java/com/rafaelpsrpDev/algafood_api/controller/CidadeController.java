package com.rafaelpsrpDev.algafood_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelpsrpDev.algafood_api.domain.exception.EntidadeNaoEncontradaException;
import com.rafaelpsrpDev.algafood_api.domain.model.Cidade;
import com.rafaelpsrpDev.algafood_api.domain.repository.CidadeRepository;
import com.rafaelpsrpDev.algafood_api.domain.service.CadastroCidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private CadastroCidadeService cadastroCidadeService;
	
	@GetMapping
	public List<Cidade> listar(){
		return cidadeRepository.todas();
	}
	
	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody Cidade cidade) {
		try {
			 cidade = cadastroCidadeService.salvar(cidade);
			return ResponseEntity.status(HttpStatus.CREATED).body(cidade);
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/{cidadeId}")
	public ResponseEntity<Cidade> buscar(@PathVariable("cidadeId") Long cidadeId){
		Cidade cidade = cidadeRepository.porId(cidadeId);
		
		if(cidade != null) {
			return ResponseEntity.ok(cidade);
		}else {		
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{cidadeId}")
	public ResponseEntity<Cidade> atualizar()
}
