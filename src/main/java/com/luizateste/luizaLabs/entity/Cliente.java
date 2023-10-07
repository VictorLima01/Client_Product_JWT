package com.luizateste.luizaLabs.entity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="CLIENTE")
public class Cliente {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	
	    private String nome;
	    private String email;
	    
	    @ManyToMany(targetEntity=Produtos.class, fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
		@JoinColumn(name = "id")
	   // @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private List<Produtos> listasProdutos;

}
