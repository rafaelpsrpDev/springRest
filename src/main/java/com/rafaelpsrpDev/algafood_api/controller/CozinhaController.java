package com.rafaelpsrpDev.algafood_api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rafaelpsrpDev.algafood_api.controller.model.CozinhasXmlWrapper;
import com.rafaelpsrpDev.algafood_api.domain.model.Cozinha;
import com.rafaelpsrpDev.algafood_api.domain.repository.CozinhaRepository;
import com.rafaelpsrpDev.algafood_api.domain.service.CadastroCozinhaService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private CadastroCozinhaService cadastroCozinhaService;
	
	
	@GetMapping
	public List<Cozinha> listar(){
		return cozinhaRepository.todas();
	}
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhasXmlWrapper listarXML(){
		return new CozinhasXmlWrapper(cozinhaRepository.todas());
	}
	
	@ResponseStatus(HttpStatus.OK)	
	//produces dentro do getmapping especificar o tipo de retorno xml, json
	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id) {
		
		//return cozinhaRepository.porId(id);
		Cozinha cozinha = cozinhaRepository.porId(id);

		if(cozinha != null) {	
			return ResponseEntity.ok(cozinha);
		}else {			
			return ResponseEntity.notFound().build();
		}
		
		//HttpHeaders headers = new HttpHeaders();
		//headers.add
		
  		//return ResponseEntity.status(HttpStatus.OK).body(cozinha);
		//return ResponseEntity.ok(cozinha);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return cadastroCozinhaService.salvar(cozinha);
	}
	
	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable("cozinhaId") Long id, @RequestBody Cozinha cozinha){
		Cozinha cozinhaAtual = cozinhaRepository.porId(id);
		
		if(cozinhaAtual != null) {
			
			BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
			
			cozinhaRepository.adicionar(cozinhaAtual);
			return ResponseEntity.ok(cozinhaAtual);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> remover(@PathVariable("cozinhaId") Long id){
		try {			
			Cozinha cozinha = cozinhaRepository.porId(id);
			
			if(cozinha != null) {			
				cozinhaRepository.remover(cozinha);
				
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.notFound().build();
			
		}catch (DataIntegrityViolationException e) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	} 
}
