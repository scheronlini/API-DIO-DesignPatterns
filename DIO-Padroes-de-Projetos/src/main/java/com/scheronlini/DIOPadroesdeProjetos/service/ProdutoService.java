package com.scheronlini.DIOPadroesdeProjetos.service;

import com.scheronlini.DIOPadroesdeProjetos.model.entity.Produto;
import com.scheronlini.DIOPadroesdeProjetos.model.repository.PedidoRepository;
import com.scheronlini.DIOPadroesdeProjetos.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Iterable<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto findById(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.get();
    }

}
