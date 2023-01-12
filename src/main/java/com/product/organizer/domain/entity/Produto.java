package com.product.organizer.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private Long preco;
	private Integer quantidade;

	// TODO Grupo deve ser um classe separada que se relacionada com Produto
	private String grupo;

}
