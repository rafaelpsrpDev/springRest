package com.rafaelpsrpDev.algafood_api.cidade.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.rafaelpsrpDev.algafood_api.AlgafoodApiApplication;
import com.rafaelpsrpDev.algafood_api.domain.model.Cidade;
import com.rafaelpsrpDev.algafood_api.domain.model.Estado;
import com.rafaelpsrpDev.algafood_api.domain.repository.CidadeRepository;

public class AlteracaoCidadeMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
		
		Estado estado = new Estado();
		Cidade cidade = new Cidade();
		
		estado.setId(1L);
		
		cidade.setId(1L);
		cidade.setNome("Juazeiro");
		cidade.setEstado(estado);
		
		cidadeRepository.adicionar(cidade);
	}

}
