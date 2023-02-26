package com.scheronlini.DIOPadroesdeProjetos;

import com.scheronlini.DIOPadroesdeProjetos.model.entity.*;
import com.scheronlini.DIOPadroesdeProjetos.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {

        Endereco endereco1 = new Endereco("89224-021", "Rua Senador Rodrigo Lobo", "de 935/936 ao fim", "Jardim Iririú", "Joinville", "sc", "4209102 ", "", "47", "8179");
        Endereco endereco2 = new Endereco("01031-020", "Rua Doutor Luiz Silveira", "", "Centro", "São Paulo", "SP", "3550308", "1004", "11", "7107");

        enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));

        Cliente cliente1 = new Cliente(null, "Scheronlini Martins", endereco1);
        Cliente cliente2 = new Cliente(null, "Antonio Martins", endereco2);

        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));

        Produto prod1 = new Produto(null, "batedeira britania", "eletrodomestico", 399.99, "sc");
        Produto prod2 = new Produto(null, "Livro", "livrarias", 90.00, "sc");
        Produto prod3 = new Produto(null, "Smartphone", "eletronicos", 2000.00, "SP");
        Produto prod4 = new Produto(null, "furadeira", "ferrramentas", 699.00, "RS");

        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4));

        Pedido pedido1 = new Pedido(null, cliente1);
        Pedido pedido2 = new Pedido(null, cliente2);

        pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));

        ItemPedido itemPedido1 = new ItemPedido(null, prod1, 2, pedido1, prod1.getValor());
        ItemPedido itemPedido2 = new ItemPedido(null, prod2, 1, pedido1, prod2.getValor());
        ItemPedido itemPedido3 = new ItemPedido(null, prod2, 1, pedido2, prod2.getValor());
        ItemPedido itemPedido4 = new ItemPedido(null, prod3, 3, pedido2, prod3.getValor());
        ItemPedido itemPedido5 = new ItemPedido(null, prod4, 1, pedido2, prod4.getValor());

        itemPedidoRepository.saveAll(Arrays.asList(itemPedido1, itemPedido2, itemPedido3, itemPedido4, itemPedido5));
        pedido1.getItemPedido().add(itemPedido1);
        pedido1.getItemPedido().add(itemPedido2);

        pedido2.getItemPedido().add(itemPedido3);
        pedido2.getItemPedido().add(itemPedido4);
        pedido2.getItemPedido().add(itemPedido5);
        pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));

        cliente1.getPedidos().add(pedido1);
        cliente2.getPedidos().add(pedido2);

        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));

    }
}