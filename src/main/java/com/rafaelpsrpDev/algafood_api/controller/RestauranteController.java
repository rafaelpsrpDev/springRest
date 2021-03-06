package com.rafaelpsrpDev.algafood_api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rafaelpsrpDev.algafood_api.domain.exception.EntidadeNaoEncontradaException;
import com.rafaelpsrpDev.algafood_api.domain.model.Restaurante;
import com.rafaelpsrpDev.algafood_api.domain.repository.RestauranteRepository;
import com.rafaelpsrpDev.algafood_api.domain.service.CadastroRestauranteService;

import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CadastroRestauranteService cadastroRestauranteService;
	
	@GetMapping
	public List<Restaurante> listar(){
		return restauranteRepository.findAll();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> buscar(@PathVariable("restauranteId") Long id){
		Optional<Restaurante> restaurante = restauranteRepository.findById(id);
		
		if(restaurante.isPresent()) {
			return ResponseEntity.ok(restaurante.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante){
		try {			
			restaurante = cadastroRestauranteService.salvar(restaurante);
			return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);  
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{restauranteId}")
	public ResponseEntity<?> atualizar(@PathVariable("restauranteId") Long id, @RequestBody Restaurante restaurante){
		try {
			Optional<Restaurante> restauranteAtual = restauranteRepository.findById(id);
			if(restauranteAtual.isPresent()) {
				
				BeanUtils.copyProperties(restaurante, restauranteAtual.get(), "id");
				Restaurante restauranteNovo = cadastroRestauranteService.salvar(restauranteAtual.get());
				
				return ResponseEntity.ok(restauranteNovo);
			}
			
			return ResponseEntity.notFound().build();
		}catch(EntidadeNaoEncontradaException e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PatchMapping("/{restauranteId}")
	public ResponseEntity<?> atualizarParcial(@PathVariable("restauranteId") Long id, @RequestBody Map<String, Object> campos){
		Optional<Restaurante> restauranteAtual = restauranteRepository.findById(id);
		
		if(!restauranteAtual.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		this.merge(campos, restauranteAtual.get());
		
		return this.atualizar(id, restauranteAtual.get());
	}

	private void merge(Map<String, Object> campos, Restaurante restauranteDestino) {
		ObjectMapper objectMapper = new ObjectMapper();
		Restaurante restauranteOrigem = objectMapper.convertValue(campos, Restaurante.class);

		campos.forEach((nomePropriedade, valorPropriedade) -> {
			Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade); 
			field.setAccessible(true);
			
			Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);
			
			System.out.println(nomePropriedade + " = " + valorPropriedade + " = " + novoValor); 
			
			ReflectionUtils.setField(field, restauranteDestino, novoValor);
		});
	}
	
	@DeleteMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> remover(@PathVariable("restauranteId") Long id){
		try {
			cadastroRestauranteService.excluir(id);
			return ResponseEntity.noContent().build();
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
