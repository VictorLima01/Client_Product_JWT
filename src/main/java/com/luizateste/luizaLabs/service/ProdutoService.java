package com.luizateste.luizaLabs.service;

import java.util.List;

import javax.validation.Valid;

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
	  
	  
		@GetMapping("/produtos")
	    public List<Produtos> list() {
	        return produtoRepository.findAll();
	    }
	  @PostMapping("/produtos")
	   public Produtos createNote(@Valid @RequestBody Produtos produto) {
	       return produtoRepository.save(produto);
	   }
	  
	  @DeleteMapping(path= {"/produtos/{id}"})
	   public ResponseEntity delete(@PathVariable long id) {
		   return produtoRepository.findById(id)
				   .map(record -> {
					   produtoRepository.deleteById(id);
					  return ResponseEntity.ok().build();
				   }).orElse(ResponseEntity.notFound().build());
	   }
	   
	   @PutMapping(value="/produtos/{id}")
	   public ResponseEntity update(@PathVariable("id") long id, @RequestBody Produtos produtos) {
		   return produtoRepository.findById(id)
				   .map(record -> {
						 record.setImage(produtos.getImage());
						 record.setPreco(produtos.getPreco());
						 record.setMarca(produtos.getMarca());
						 record.setTitulo(produtos.getTitulo());
						 record.setReview(produtos.getReview());
						 produtoRepository.save(record);
						 return new ResponseEntity<>(produtos, HttpStatus.OK);
					   }).orElse(ResponseEntity.notFound().build());	   	
	   }
	   
	   @GetMapping(value="/produtos/{id}")
	   public ResponseEntity findById(@PathVariable("id") long produtosId){
	      return clienteRepository.findById(produtosId)
	              .map(record -> {
	            	  return new ResponseEntity<>(record, HttpStatus.OK);
	              }).orElse(ResponseEntity.notFound().build());
	   }

}
