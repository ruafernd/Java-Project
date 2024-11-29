package model;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private int numero;
    private List<Cliente> clientes;
    private List<Pedido> pedidos;

    // Construtor com dois parâmetros: número da mesa e lista de clientes
    public Mesa(int numero) {
        this.numero = numero;
        this.clientes = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarCliente(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public void adicionarPedido(Cliente cliente, Produto produto, int quantidade) {
        Pedido pedido = new Pedido(cliente, produto, quantidade);
        pedidos.add(pedido);
    }

    public double calcularConta() {
        double total = 0;
        for (Pedido pedido : pedidos) {
            total += pedido.getProduto().getPreco() * pedido.getQuantidade();
        }
        return total;
    }
}
