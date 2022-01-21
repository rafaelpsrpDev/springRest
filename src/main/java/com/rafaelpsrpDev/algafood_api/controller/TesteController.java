package com.rafaelpsrpDev.algafood_api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelpsrpDev.algafood_api.domain.model.Cozinha;
import com.rafaelpsrpDev.algafood_api.domain.model.Restaurante;
import com.rafaelpsrpDev.algafood_api.domain.repository.CozinhaRepository;
import com.rafaelpsrpDev.algafood_api.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@GetMapping("cozinhas/por-nome")
	public List<Cozinha> buscarPorNome(@RequestParam("nome") String nome){
		return cozinhaRepository.findTodasByNomeContaining(nome);
	}
	
	@GetMapping("cozinhas/unico-por-nome")
	public Optional<Cozinha> buscarNome(@RequestParam("nome") String nome){
		return cozinhaRepository.findByNome(nome);
	}
	
	
	@GetMapping("restaurante/por-taxa-frete")
	public List<Restaurante> restaurantesPorTaxaFrete(@RequestParam("taxaInicial") BigDecimal taxaInicial, @RequestParam("taxaFinal") BigDecimal taxaFinal){
		return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
	
	}
}
