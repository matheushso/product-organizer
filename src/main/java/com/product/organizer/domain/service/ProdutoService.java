package com.product.organizer.domain.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.product.organizer.domain.entity.Produto;
import com.product.organizer.infrastructure.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> listar() {
		return produtoRepository.findAll();
	}

	public Produto buscar(@PathVariable Long id) {
		Produto produto = produtoRepository.findById(id).orElse(null);

		if (produto == null) {
			throw new EntityNotFoundException();
		}

		return produto;
	}

	public Produto salvar(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

}
