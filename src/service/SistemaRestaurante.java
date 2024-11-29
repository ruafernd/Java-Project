package service;

import model.Cardapio;
import model.Cliente;
import model.Mesa;
import model.Produto;

import java.util.HashMap;
import java.util.Map;

public class SistemaRestaurante {
    private Map<Integer, Mesa> mesas;
    private Cardapio cardapio;

    public SistemaRestaurante() {
        mesas = new HashMap<>();
        cardapio = new Cardapio();

        // Adicionando produtos ao cardápio (exemplo)
        cardapio.adicionarProduto(new Produto("Macarronada", 20.00));
        cardapio.adicionarProduto(new Produto("Pizza", 30.00));
        cardapio.adicionarProduto(new Produto("Suco", 5.00));
    }

    // Método para adicionar pedido
    public void adicionarPedido(int numeroMesa, String nomeCliente, int numeroProduto, int quantidade) {
        Mesa mesa = mesas.get(numeroMesa);
        if (mesa != null) {
            Cliente cliente = mesa.buscarCliente(nomeCliente);
            if (cliente != null) {
                // Buscar o produto selecionado pelo número
                Produto produto = cardapio.listarProdutos().get(numeroProduto - 1); // Subtraímos 1 porque o número começa em 1

                if (produto != null) {
                    mesa.adicionarPedido(cliente, produto, quantidade);
                    System.out.println("Pedido adicionado: " + produto.getNome() + " - Quantidade: " + quantidade);
                } else {
                    System.out.println("Produto não encontrado.");
                }
            } else {
                System.out.println("Cliente não encontrado na mesa.");
            }
        } else {
            System.out.println("Mesa não encontrada.");
        }
    }

    // Método para exibir cardápio
    public void exibirCardapio() {
        System.out.println("\n=== CARDÁPIO ===");
        int i = 1;
        for (Produto produto : cardapio.listarProdutos()) {
            System.out.println(i++ + ". " + produto.getNome() + ", R$ " + produto.getPreco());
        }
    }

    // Método para cadastrar mesa
    public void cadastrarMesa(int numeroMesa) {
        if (!mesas.containsKey(numeroMesa)) {
            mesas.put(numeroMesa, new Mesa(numeroMesa));
            System.out.println("Mesa " + numeroMesa + " cadastrada com sucesso!");
        } else {
            System.out.println("Mesa já cadastrada.");
        }
    }

    // Método para adicionar cliente à mesa
    public void adicionarCliente(int numeroMesa, Cliente cliente) {
        Mesa mesa = mesas.get(numeroMesa);
        if (mesa != null) {
            mesa.adicionarCliente(cliente);
            System.out.println("Cliente " + cliente.getNome() + " adicionado à mesa " + numeroMesa);
        } else {
            System.out.println("Mesa não encontrada.");
        }
    }

    // Método para listar as mesas
    public void listarMesas() {
        System.out.println("\n=== MESAS ===");
        if (mesas.isEmpty()) {
            System.out.println("Nenhuma mesa cadastrada.");
        } else {
            for (Mesa mesa : mesas.values()) {
                System.out.println("Mesa " + mesa.getNumero());
            }
        }
    }

    // Método para fechar mesa (aqui você pode somar valores, por exemplo)
    public void fecharMesa(int numeroMesa) {
        Mesa mesa = mesas.get(numeroMesa);
        if (mesa != null) {
            double conta = mesa.calcularConta();
            System.out.println("Conta total da mesa " + numeroMesa + ": R$ " + conta);
            mesas.remove(numeroMesa);  // Remover mesa ao fechar
        } else {
            System.out.println("Mesa não encontrada.");
        }
    }

    // Método para listar funcionários (exemplo simples)
    public void listarFuncionarios() {
        System.out.println("\n=== FUNCIONÁRIOS ===");
        // Aqui você pode listar funcionários cadastrados, caso necessário
    }
}
