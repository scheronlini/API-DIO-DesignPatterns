package com.scheronlini.DIOPadroesdeProjetos.model.repository;

import com.scheronlini.DIOPadroesdeProjetos.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
