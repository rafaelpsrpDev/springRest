package com.rafaelpsrpDev.algafood_api.cidade.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.rafaelpsrpDev.algafood_api.AlgafoodApiApplication;
import com.rafaelpsrpDev.algafood_api.domain.model.Cidade;
import com.rafaelpsrpDev.algafood_api.domain.model.Estado;
import com.rafaelpsrpDev.algafood_api.domain.repository.CidadeRepository;
import com.rafaelpsrpDev.algafood_api.domain.repository.CozinhaRepository;

public class InclusaoCidadeMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
		
		Cidade cidade = new Cidade();
		
		Estado estado = new Estado();
		estado.setId(1L);
		
		cidade.setNome("Barreiras");
		cidade.setEstado(estado);
		
		cidadeRepository.adicionar(cidade);
		
		
		
	}

}
