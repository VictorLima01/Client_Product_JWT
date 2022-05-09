package com.luizateste.luizaLabs.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

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
import javax.validation.Valid;

import com.luizateste.luizaLabs.entity.Cliente;
import com.luizateste.luizaLabs.repository.ClienteRepository;
import com.luizateste.luizaLabs.repository.ProdutoRepository;

@RestController
@RequestMapping("/api")
public class ClienteService {
	
	 	@Autowired
	    private ClienteRepository clienteRepository;
	 	
	 	@Autowired
	    private ProdutoRepository produtoRepository;
	 	
	   @GetMapping("/clientes")
	    public List<Cliente> list() {
	        return clienteRepository.findAll();
	    }
	   
	// Create a new cliente
	   @PostMapping("/clientes")
	   public ResponseEntity createNote(@Valid @RequestBody Cliente cliente) {
		   List<Cliente> clientes = clienteRepository.findAll();
		   if(clientes.size() == 0) {
			   clienteRepository.save(cliente);
		   }else {
			   for (Cliente clienteType : clientes) {
				    if(clienteType.getEmail().equals(cliente.getEmail())) {
				    	System.out.println("Email duplicado, digite um email válido! ");
				    	return new ResponseEntity<>(cliente, HttpStatus.BAD_REQUEST);
				    }else {
				    	clienteRepository.save(cliente);
				    }
				}
		   }
		   return new ResponseEntity<>(cliente, HttpStatus.OK);
	   }
	   
	// Get a Single cliente
	   @GetMapping(value="/clientes/{id}")
	   public ResponseEntity findById(@PathVariable("id") long clienteId){
	      return clienteRepository.findById(clienteId)
	              .map(record -> {
	            	  return new ResponseEntity<>(record, HttpStatus.OK);
	              }).orElse(ResponseEntity.notFound().build());
	   }
	   
	// Save a product to a client
	   @GetMapping(value="/clientes/save-product/idCliente={id}/idProduto={produto}")
	   public ResponseEntity saveProduct(@PathVariable("id") long clienteId, @PathVariable("produto") long produtoId){
		   Random random = new Random();
	      return clienteRepository.findById(clienteId)
	              .map(record -> {
	            	  record.setEmail(record.getEmail());
	            	  record.setNome(record.getNome());
	            	  produtoRepository.findById(produtoId).map(produto -> {
	            		 record.setListasProdutos(produto);
	            		 return ResponseEntity.ok().build();
	            	  });
	            	  
	            	  clienteRepository.deleteById(clienteId);
	            	  clienteRepository.save(record);
	            	  return new ResponseEntity<>(record, HttpStatus.OK);
	              }).orElse(ResponseEntity.notFound().build());
	   }
	   
	   @DeleteMapping(path= {"/clientes/{id}"})
	   public ResponseEntity delete(@PathVariable long id) {
		   return clienteRepository.findById(id)
				   .map(record -> {
					  clienteRepository.deleteById(id);
					  return ResponseEntity.ok().build();
				   }).orElse(ResponseEntity.notFound().build());
	   }
	   
	   @PutMapping(value="/clientes/{id}")
	   public ResponseEntity update(@PathVariable("id") long id, @RequestBody Cliente cliente) {
		   return clienteRepository.findById(id)
				   .map(record -> {
						 record.setEmail(cliente.getEmail());
						 record.setNome(cliente.getNome());
						 clienteRepository.save(record);
						 return new ResponseEntity<>(cliente, HttpStatus.OK);
					   }).orElse(ResponseEntity.notFound().build());	   	
	   }
}
