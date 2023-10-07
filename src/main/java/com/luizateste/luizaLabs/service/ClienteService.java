package com.luizateste.luizaLabs.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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

@Service
public class ClienteService {
	
	 	@Autowired
	    private ClienteRepository clienteRepository;
	 	
	 	@Autowired
	    private ProdutoRepository produtoRepository;

	 	public ResponseEntity createClient(Cliente cliente) {
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

	public ResponseEntity saveProduct(Cliente body) {
		ResponseEntity responseEntity;
		try{
			clienteRepository.save(body);
			responseEntity = new ResponseEntity<>(body, HttpStatus.CREATED);
		}catch (Exception e){
			System.out.println("[Erro] ClienteController.saveProduct() - " + e);
			responseEntity = new ResponseEntity<>(body, HttpStatus.GATEWAY_TIMEOUT);
		}
		return responseEntity;
	}
}
