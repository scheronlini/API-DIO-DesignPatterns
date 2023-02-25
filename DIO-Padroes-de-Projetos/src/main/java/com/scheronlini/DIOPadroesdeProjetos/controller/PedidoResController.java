package com.scheronlini.DIOPadroesdeProjetos.controller;

import com.scheronlini.DIOPadroesdeProjetos.model.entity.Pedido;
import com.scheronlini.DIOPadroesdeProjetos.model.entity.Produto;
import com.scheronlini.DIOPadroesdeProjetos.service.PedidoService;
import com.scheronlini.DIOPadroesdeProjetos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedidos")
public class PedidoResController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<Iterable<Pedido>> buscarTodos(){
        return ResponseEntity.ok().body(pedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(pedidoService.findById(id));
    }
}
