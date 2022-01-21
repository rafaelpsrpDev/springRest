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

import com.rafaelpsrpDev.algafood_api.domain.exception.EntidadeEmUsoException;
import com.rafaelpsrpDev.algafood_api.domain.exception.EntidadeNaoEncontradaException;
//import com.rafaelpsrpDev.algafood_api.domain.model.Cozinha;
import com.rafaelpsrpDev.algafood_api.domain.model.Estado;
import com.rafaelpsrpDev.algafood_api.domain.repository.EstadoRepository;
import com.rafaelpsrpDev.algafood_api.domain.service.CadastroEstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CadastroEstadoService cadastroEstadoService;
	
	
	@GetMapping
	public List<Estado> listar(){
		return estadoRepository.findAll();
	}
	
	@GetMapping("/{estadoId}")
	public ResponseEntity<Estado> buscar(@PathVariable("estadoId") Long id) {
		Optional<Estado> estado = estadoRepository.findById(id);
		
		if(estado.isPresent()) {
			return ResponseEntity.ok(estado.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Estado adicionar(@RequestBody Estado estado) {
		return cadastroEstadoService.salvar(estado);
	}
	
	@PutMapping("/{estadoId}")
	public ResponseEntity<Estado> atualizar(@PathVariable("estadoId") Long id, @RequestBody Estado estado){
		Optional<Estado> estadoAtual = estadoRepository.findById(id);
		
		if(estadoAtual.isPresent()) {
			
			BeanUtils.copyProperties(estado, estadoAtual.get(), "id");
			
			Estado estadoNovo = cadastroEstadoService.salvar(estadoAtual.get());
			return ResponseEntity.ok(estadoNovo);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/{estadoId}")
	public ResponseEntity<Estado> remover(@PathVariable("estadoId") Long id){
		try {
			cadastroEstadoService.excluir(id);
			return ResponseEntity.noContent().build();
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
