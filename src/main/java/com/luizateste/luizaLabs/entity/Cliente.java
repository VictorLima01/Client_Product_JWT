package com.luizateste.luizaLabs.entity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="CLIENTE")
@Table(name = "cliente")
public class Cliente {
		
		@Id
		@GeneratedValue(strategy = GenerationType.UUID)
	    private String id;
	 	
	    private String nome;
	    private String email;
	    
	    @ManyToMany(targetEntity=Produtos.class, fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
		@JoinColumn(name = "id")
	   // @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private List<Produtos> listasProdutos;

}
