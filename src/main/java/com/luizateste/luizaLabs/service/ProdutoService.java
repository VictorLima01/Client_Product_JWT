package com.luizateste.luizaLabs.service;

import java.util.List;

import javax.validation.Valid;

import com.luizateste.luizaLabs.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luizateste.luizaLabs.entity.Produtos;
import com.luizateste.luizaLabs.repository.ClienteRepository;
import com.luizateste.luizaLabs.repository.ProdutoRepository;

@RestController
@RequestMapping("/api")
public class ProdutoService {
	@Autowired
    private ClienteRepository clienteRepository;
	
	@Autowired
    private ProdutoRepository produtoRepository;

	public ResponseEntity createProduto(Produtos produto) {
		List<Produtos> produtos = produtoRepository.findAll();
		if(produtos.size() == 0) {
			produtoRepository.save(produto);
		}else {
			for (Produtos produtoType : produtos) {
				if(produtoType.getId().equals(produto.getId())) {
					System.out.println("Produto duplicado!");
					return new ResponseEntity<>(produto, HttpStatus.BAD_REQUEST);
				}else {
					produtoRepository.save(produto);
				}
			}
		}
		return new ResponseEntity<>(produto, HttpStatus.CREATED);
	}

}
