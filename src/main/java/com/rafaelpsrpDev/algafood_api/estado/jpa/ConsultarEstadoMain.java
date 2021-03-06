package com.rafaelpsrpDev.algafood_api.estado.jpa;

import java.util.Iterator;
import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.rafaelpsrpDev.algafood_api.AlgafoodApiApplication;
import com.rafaelpsrpDev.algafood_api.domain.model.Estado;
import com.rafaelpsrpDev.algafood_api.domain.repository.EstadoRepository;

public class ConsultarEstadoMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		EstadoRepository estadoRepository = applicationContext.getBean(EstadoRepository.class);
		List<Estado> estado = estadoRepository.todas();
		
		for (Estado estados : estado) {
			System.out.println(estados.getId() + " - " + estados.getNome());
		}

	}

}
