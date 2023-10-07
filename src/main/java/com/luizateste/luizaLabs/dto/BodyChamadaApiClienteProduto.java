package com.luizateste.luizaLabs.dto;

import com.luizateste.luizaLabs.entity.Produtos;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BodyChamadaApiClienteProduto implements Serializable {

    private String nome;
    private String email;
    private ArrayList<Produtos> listasProdutos;
}
