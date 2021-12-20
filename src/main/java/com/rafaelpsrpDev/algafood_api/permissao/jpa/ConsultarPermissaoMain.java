package com.rafaelpsrpDev.algafood_api.permissao.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.rafaelpsrpDev.algafood_api.AlgafoodApiApplication;
import com.rafaelpsrpDev.algafood_api.domain.model.Permissao;
import com.rafaelpsrpDev.algafood_api.domain.repository.PermissaoRepository;

public class ConsultarPermissaoMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		PermissaoRepository permissaoRepository = applicationContext.getBean(PermissaoRepository.class);
		List<Permissao> permissao = permissaoRepository.todas();
		
		for (Permissao permissoes : permissao) {
			System.out.println(permissoes.getId() + " - " + permissoes.getNome() + " - " + permissoes.getDescricao());
		}
		
	}
}
