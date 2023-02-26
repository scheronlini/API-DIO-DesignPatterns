package com.scheronlini.DIOPadroesdeProjetos.service;

import com.scheronlini.DIOPadroesdeProjetos.model.entity.Endereco;
import com.scheronlini.DIOPadroesdeProjetos.model.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Iterable<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Endereco findById(String id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        return endereco.get();
    }
}
