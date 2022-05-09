package com.luizateste.luizaLabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luizateste.luizaLabs.entity.Produtos;

public interface ProdutoRepository extends JpaRepository<Produtos, Long>{

}
