package com.scheronlini.DIOPadroesdeProjetos.controller;

import com.scheronlini.DIOPadroesdeProjetos.model.entity.Endereco;
import com.scheronlini.DIOPadroesdeProjetos.model.entity.ItemPedido;
import com.scheronlini.DIOPadroesdeProjetos.model.repository.EnderecoRepository;
import com.scheronlini.DIOPadroesdeProjetos.service.EnderecoService;
import com.scheronlini.DIOPadroesdeProjetos.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("enderecos")
public class EnderecoResController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<Iterable<Endereco>> buscarTodos(){
        return ResponseEntity.ok().body(enderecoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok().body(enderecoService.findById(id));
    }
}
