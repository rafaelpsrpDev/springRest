package com.rafaelpsrpDev.algafood_api.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

import javax.persistence.Column;

@JsonRootName("cozinhas")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity	
@Table(name = "cozinhas")
public class Cozinha {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@JsonProperty("titulo")
	//@JsonIgnore
	@Column(nullable = false)
	private String nome;
	
	
}
