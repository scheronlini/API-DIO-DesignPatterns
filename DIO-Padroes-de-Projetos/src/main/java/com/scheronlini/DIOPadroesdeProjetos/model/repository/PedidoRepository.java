package com.scheronlini.DIOPadroesdeProjetos.model.repository;

import com.scheronlini.DIOPadroesdeProjetos.model.entity.Cliente;
import com.scheronlini.DIOPadroesdeProjetos.model.entity.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
}
