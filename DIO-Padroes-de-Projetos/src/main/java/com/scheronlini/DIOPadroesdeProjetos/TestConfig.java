package com.scheronlini.DIOPadroesdeProjetos;

import com.scheronlini.DIOPadroesdeProjetos.model.entity.*;
import com.scheronlini.DIOPadroesdeProjetos.model.repository.*;
import com.scheronlini.DIOPadroesdeProjetos.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.persistence.Transient;
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

        Endereco endereco1 = new Endereco("89224-545","Rua guaratingueta"," ","Iririu"," ","sc"," "," "," "," ");
        Endereco endereco2 = new Endereco("010788-000","Rua tarsicio"," ","jacarápagua"," ","sp"," "," "," "," ");

        enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2));

        Cliente cliente1 = new Cliente(null,"Scheronlini Mendes Fauser",endereco1);
        Cliente cliente2 = new Cliente(null,"Antonio da silva Martins",endereco2);

        clienteRepository.saveAll(Arrays.asList(cliente1,cliente2));

        Produto prod1= new Produto(null,"batedeira britania","eletrodomestico",399.99,"sc");
        Produto prod2= new Produto(null,"Livro","livrarias",399.99,"sc");

        produtoRepository.saveAll(Arrays.asList(prod1,prod2));

        Pedido pedido1 = new Pedido(null,cliente1);
        Pedido pedido2 = new Pedido(null,cliente2);

        pedidoRepository.saveAll(Arrays.asList(pedido1,pedido2));

        ItemPedido itemPedido1 = new ItemPedido(null,prod1,2,pedido1);
        ItemPedido itemPedido2 = new ItemPedido(null,prod2,1,pedido2);

        itemPedidoRepository.saveAll(Arrays.asList(itemPedido1,itemPedido2));
        pedido1.getItemPedido().add(itemPedido1);
        pedido2.getItemPedido().add(itemPedido2);

        pedidoRepository.saveAll(Arrays.asList(pedido1,pedido2));

        cliente1.getPedidos().add(pedido1);
        cliente2.getPedidos().add(pedido2);

        clienteRepository.saveAll(Arrays.asList(cliente1,cliente2));

    }
}
