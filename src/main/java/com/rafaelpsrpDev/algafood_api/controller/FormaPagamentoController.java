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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelpsrpDev.algafood_api.domain.exception.EntidadeNaoEncontradaException;
import com.rafaelpsrpDev.algafood_api.domain.model.FormaPagamento;
import com.rafaelpsrpDev.algafood_api.domain.repository.FormaPagamentoRepository;
import com.rafaelpsrpDev.algafood_api.domain.service.CadastroFormaPagamentoService;


@RestController
@RequestMapping(value = "/forma-pagamento")
public class FormaPagamentoController {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@Autowired
	private CadastroFormaPagamentoService cadastroFormaPagamentoService;
	
	@GetMapping
	public List<FormaPagamento> listar(){
		return formaPagamentoRepository.findAll();
	}
	
	@GetMapping("/{formaPagamentoId}")
	public ResponseEntity<FormaPagamento> buscar(@PathVariable("formaPagamentoId") Long Id){
		Optional<FormaPagamento> formaPagamento = formaPagamentoRepository.findById(Id);
		
		if(formaPagamento.isPresent()) {
			return ResponseEntity.ok(formaPagamento.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FormaPagamento adicionar(@RequestBody FormaPagamento formaPagamento) {
		return cadastroFormaPagamentoService.salvar(formaPagamento);
	}
	
	@PutMapping("/{formaPagamentoId}")
	public ResponseEntity<FormaPagamento> atualizar(@PathVariable("formaPagamentoId") Long id, @RequestBody FormaPagamento formaPagamento){
		Optional<FormaPagamento> formaPagamentoAtual = formaPagamentoRepository.findById(id);
		
		if(formaPagamentoAtual.isPresent()) {
			
			BeanUtils.copyProperties(formaPagamento, formaPagamentoAtual.get(), "id");
			
			FormaPagamento formaPagamentoNovo = cadastroFormaPagamentoService.salvar(formaPagamentoAtual.get());
			return ResponseEntity.ok(formaPagamentoNovo);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{formaPagamentoId}")
	public ResponseEntity<FormaPagamento> remover(@PathVariable("formaPagamentoId") Long id){
		try {
			cadastroFormaPagamentoService.exclui(id);
			return ResponseEntity.noContent().build();
		}catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
