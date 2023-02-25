package com.scheronlini.DIOPadroesdeProjetos.service;

import com.scheronlini.DIOPadroesdeProjetos.model.entity.Cliente;

public interface ClienteService {

    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);


}
