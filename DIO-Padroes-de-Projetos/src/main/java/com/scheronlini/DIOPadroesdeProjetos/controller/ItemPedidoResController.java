package com.scheronlini.DIOPadroesdeProjetos.controller;

import com.scheronlini.DIOPadroesdeProjetos.model.entity.ItemPedido;
import com.scheronlini.DIOPadroesdeProjetos.model.entity.Produto;
import com.scheronlini.DIOPadroesdeProjetos.service.ItemPedidoService;
import com.scheronlini.DIOPadroesdeProjetos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("itenspedido")
public class ItemPedidoResController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public ResponseEntity<Iterable<ItemPedido>> buscarTodos(){
        return ResponseEntity.ok().body(itemPedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(itemPedidoService.findById(id));
    }
}
