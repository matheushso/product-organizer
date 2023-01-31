package com.product.organizer.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.organizer.domain.entity.Produto;
import com.product.organizer.infrastructure.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	private List<Produto> listar() {
		return produtoRepository.findAll();
	}

	@GetMapping("/{id}")
	private Optional<Produto> buscar(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);

		return produto;

		// TODO Criar service e colocar as regras de negocio la
		// TODO Criar validação para retornar 404 quando não encontrado o id
	}

	@PostMapping
	private Produto salvar(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

}
