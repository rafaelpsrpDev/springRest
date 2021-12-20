package com.rafaelpsrpDev.algafood_api.cidade.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.rafaelpsrpDev.algafood_api.AlgafoodApiApplication;
import com.rafaelpsrpDev.algafood_api.domain.model.Cidade;
import com.rafaelpsrpDev.algafood_api.domain.repository.CidadeRepository;

public class ConsultarCidadeMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
		List<Cidade> cidade = cidadeRepository.todas();
		
		for(Cidade cidades : cidade) {
			System.out.println(cidades.getId() + " - " + cidades.getNome());
		}
		
	}

}
