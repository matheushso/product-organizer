package com.product.organizer.api.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.organizer.domain.entity.Produto;
import com.product.organizer.domain.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	private List<Produto> listar() {
		return produtoService.listar();
	}

	@GetMapping("/{id}")
	private ResponseEntity<Produto> buscar(@PathVariable Long id) {
		try {
			Produto produto = produtoService.buscar(id);
			return ResponseEntity.ok(produto);

		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	private Produto salvar(@RequestBody Produto produto) {
		return produtoService.salvar(produto);
	}

	// TODO Criar metodos Patch e Put
}
