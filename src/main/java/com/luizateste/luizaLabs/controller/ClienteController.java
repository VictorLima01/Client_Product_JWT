package com.luizateste.luizaLabs.controller;

import com.luizateste.luizaLabs.dto.BodyChamadaApiClienteProduto;
import com.luizateste.luizaLabs.entity.Cliente;
import com.luizateste.luizaLabs.repository.ClienteRepository;
import com.luizateste.luizaLabs.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> list() {
        return clienteRepository.findAll();
    }

    @PostMapping("/clientes")
    public ResponseEntity createClient(@Valid @RequestBody Cliente cliente) {
        ResponseEntity response = this.clienteService.createClient(cliente);
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }
    @GetMapping(value="/clientes/{id}")
    public ResponseEntity findById(@PathVariable("id") long clienteId){
        return clienteRepository.findById(clienteId)
                .map(record -> {
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

    // Save a product to a client
    @PostMapping(value="/clientes/save-product")
    public ResponseEntity saveProduct(@Valid @RequestBody Cliente body){
        ResponseEntity responseEntity = this.clienteService.saveProduct(body);
        return responseEntity;
    }

}
