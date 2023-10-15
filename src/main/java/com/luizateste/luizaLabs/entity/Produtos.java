package com.luizateste.luizaLabs.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import jakarta.persistence.*;

@Getter
@Setter
@Entity(name="PRODUTOS")
@Table(name = "produtos")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produtos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
    private String id;

	private String preco;
	private String image;
	private String marca;
	private String titulo;
	private String review;
}
