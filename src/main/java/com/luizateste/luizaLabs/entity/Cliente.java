package com.luizateste.luizaLabs.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"listasProdutos"}, allowGetters = true)
@Entity(name="CLIENTE")
public class Cliente {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	
	    private String nome;
	    private String email;
	    
	    @ManyToMany(targetEntity=Produtos.class, fetch=FetchType.EAGER)
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private List<Produtos> listasProdutos;
	
	    
		public List<Produtos> getListasProdutos() {
			return listasProdutos;
		}
		public void setListasProdutos(Produtos produto) {
			this.listasProdutos.add(produto);
		}
		public Cliente() {
			super();
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

}
