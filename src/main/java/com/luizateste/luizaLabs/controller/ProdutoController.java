package com.luizateste.luizaLabs.controller;

import com.luizateste.luizaLabs.entity.Produtos;
import com.luizateste.luizaLabs.repository.ProdutoRepository;
import com.luizateste.luizaLabs.service.ClienteService;
import com.luizateste.luizaLabs.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdutoController{

        @Autowired
        private ProdutoService produtoService;

        @Autowired
        private ProdutoRepository produtoRepository;

        @GetMapping("/produtos")
        public List<Produtos> list() {
                return produtoRepository.findAll();
        }

        @PostMapping("/produtos")
        public ResponseEntity createProdutos(@Valid @RequestBody Produtos produto) {
                ResponseEntity response = this.produtoService.createProduto(produto);
                return new ResponseEntity<>(response.getBody(), response.getStatusCode());
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

}
