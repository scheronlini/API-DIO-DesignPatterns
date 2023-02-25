package com.scheronlini.DIOPadroesdeProjetos.model.repository;

import com.scheronlini.DIOPadroesdeProjetos.model.entity.Cliente;
import com.scheronlini.DIOPadroesdeProjetos.model.entity.ItemPedido;
import org.springframework.data.repository.CrudRepository;

public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Long> {
}
