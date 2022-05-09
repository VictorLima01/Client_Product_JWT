package com.luizateste.luizaLabs.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	  
	  
		@GetMapping("/produtos")
	    public List<Produtos> list() {
	        return produtoRepository.findAll();
	    }
	  @PostMapping("/produtos")
	   public Produtos createNote(@Valid @RequestBody Produtos produto) {
	       return produtoRepository.save(produto);
	   }

}
