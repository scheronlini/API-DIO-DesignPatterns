package com.scheronlini.DIOPadroesdeProjetos.controller;

import com.scheronlini.DIOPadroesdeProjetos.model.entity.Cliente;
import com.scheronlini.DIOPadroesdeProjetos.model.entity.Produto;
import com.scheronlini.DIOPadroesdeProjetos.service.ClienteService;
import com.scheronlini.DIOPadroesdeProjetos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
public class ProdutoResController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Iterable<Produto>> buscarTodos(){
        return ResponseEntity.ok().body(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(produtoService.findById(id));
    }
}
