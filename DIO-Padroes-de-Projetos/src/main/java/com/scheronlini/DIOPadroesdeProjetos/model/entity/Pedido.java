package com.scheronlini.DIOPadroesdeProjetos.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToMany(mappedBy = "pedido")
    private Set<ItemPedido> itemPedido = new HashSet<>();
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant data;


    public Pedido() {
    }
    public Pedido(Long id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.data = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<ItemPedido> getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(Set<ItemPedido> itemPedido) {
        this.itemPedido = itemPedido;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public Double getFrete() {
        Double frete = 0.0;
        for (ItemPedido itens : itemPedido) {
            if (itens.getProduto().getLocalizacaoEstoque().equalsIgnoreCase(cliente.getEndereco().getUf())) {
                frete = 0.0;
            }else {
                frete = 45.0;
            }
        }return frete;
    }
    public Double getValorTotal(){
        Double total = 0.0;
        for (ItemPedido itens: itemPedido) {
            total += itens.getSubtotal();
        }
        return total + getFrete();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}