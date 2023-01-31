package com.product.organizer.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.organizer.domain.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
