import service.SistemaRestaurante;
import model.Cliente;
import model.Produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaRestaurante sistema = new SistemaRestaurante();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== SISTEMA DE RESTAURANTE ===");
            System.out.println("1. Cadastrar Mesa");
            System.out.println("2. Adicionar Cliente");
            System.out.println("3. Adicionar Pedido");
            System.out.println("4. Fechar Mesa");
            System.out.println("5. Listar Mesas");
            System.out.println("6. Listar Funcionários");
            System.out.println("7. Exibir Cardápio");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1: // Cadastrar Mesa
                    System.out.print("Digite o número da mesa: ");
                    int numeroMesa = scanner.nextInt();
                    scanner.nextLine();
                    sistema.cadastrarMesa(numeroMesa);
                    break;

                case 2: // Adicionar Cliente
                    System.out.print("Digite o número da mesa: ");
                    numeroMesa = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();
                    sistema.adicionarCliente(numeroMesa, new Cliente(nomeCliente, cpfCliente));
                    break;

                case 3: // Adicionar Pedido
                    System.out.print("Digite o número da mesa: ");
                    numeroMesa = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do cliente: ");
                    nomeCliente = scanner.nextLine();
                    // Exibir cardápio antes de escolher o produto
                    sistema.exibirCardapio();
                    System.out.print("Escolha o número do produto: ");
                    int numeroProduto = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();
                    sistema.adicionarPedido(numeroMesa, nomeCliente, numeroProduto, quantidade);
                    break;

                case 4: // Fechar Mesa
                    System.out.print("Digite o número da mesa: ");
                    numeroMesa = scanner.nextInt();
                    scanner.nextLine();
                    sistema.fecharMesa(numeroMesa);
                    break;

                case 5: // Listar Mesas
                    sistema.listarMesas();
                    break;

                case 6: // Listar Funcionários
                    sistema.listarFuncionarios();
                    break;

                case 7: // Exibir Cardápio
                    sistema.exibirCardapio();
                    break;

                case 0: // Sair
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
