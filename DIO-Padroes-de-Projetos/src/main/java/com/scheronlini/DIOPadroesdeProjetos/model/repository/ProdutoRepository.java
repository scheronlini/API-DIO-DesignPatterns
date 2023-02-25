package com.scheronlini.DIOPadroesdeProjetos.model.repository;

import com.scheronlini.DIOPadroesdeProjetos.model.entity.Cliente;
import com.scheronlini.DIOPadroesdeProjetos.model.entity.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
