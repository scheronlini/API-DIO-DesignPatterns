package com.scheronlini.DIOPadroesdeProjetos.service;

import com.scheronlini.DIOPadroesdeProjetos.model.entity.Pedido;
import com.scheronlini.DIOPadroesdeProjetos.model.entity.Produto;
import com.scheronlini.DIOPadroesdeProjetos.model.repository.PedidoRepository;
import com.scheronlini.DIOPadroesdeProjetos.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Iterable<Pedido> findAll(){
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long id){
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.get();
    }

}
