package com.luizateste.luizaLabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luizateste.luizaLabs.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
