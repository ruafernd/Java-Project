import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaRestaurante sistema = new SistemaRestaurante();

        sistema.adicionarProdutoAoCardapio("Pizza", 35.00);
        sistema.adicionarProdutoAoCardapio("Coca-Cola", 6.00);
        sistema.adicionarProdutoAoCardapio("Hambúrguer", 15.00);
        sistema.adicionarProdutoAoCardapio("Batata Frita", 10.00);

        System.out.println("Bem-vindo ao Restaurante!");
        System.out.println("Nosso cardápio:");
        System.out.println("1. Pizza - R$30.00");
        System.out.println("2. Coca-Cola - R$5.00");
        System.out.println("3. Hambúrguer - R$15.00");
        System.out.println("4. Batata Frita - R$10.00");

        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        String cpf;
        while (true) {
            System.out.print("Digite o CPF do cliente (até 11 dígitos): ");
            cpf = scanner.nextLine();
            if (cpf.matches("\\d{1,11}")) {
                break;
            } else {
                System.out.println("CPF inválido! Deve conter até 11 dígitos numéricos.");
            }
        }

        String telefone;
        while (true) {
            System.out.print("Digite o telefone do cliente (até 11 dígitos): ");
            telefone = scanner.nextLine();
            if (telefone.matches("\\d{1,11}")) {
                break;
            } else {
                System.out.println("Telefone inválido! Deve conter até 11 dígitos numéricos.");
            }
        }

        Cliente cliente = new Cliente(nome, cpf, telefone);

        boolean continuar = true;
        String[] itens = new String[10]; 
        int[] quantidades = new int[10];
        int contador = 0;

        while (continuar && contador < 10) {
            System.out.print("\nDigite o número referente ao produto que deseja (ou 0 para finalizar): ");
            int numeroProduto = scanner.nextInt();

            if (numeroProduto == 0) {
                break;
            }

            String produto = "";
            switch (numeroProduto) {
                case 1:
                    produto = "Pizza";
                    break;
                case 2:
                    produto = "Coca-Cola";
                    break;
                case 3:
                    produto = "Hambúrguer";
                    break;
                case 4:
                    produto = "Batata Frita";
                    break;
                default:
                    System.out.println("Opção inválida! Escolha um número entre 1 e 4.");
                    continue;
            }

            System.out.print("Digite a quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); 

            itens[contador] = produto;
            quantidades[contador] = quantidade;
            contador++;

            System.out.print("Deseja adicionar mais itens? (sim/não): ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("não")) {
                continuar = false;
            }
        }

        System.out.println("Formas de pagamento disponíveis:");
        System.out.println("1. Pix");
        System.out.println("2. Transferência Bancária");
        System.out.println("3. Cartão de Crédito");
        System.out.println("4. Cartão de Débito");

        String formaPagamento = "";
        boolean formaValida = false;
        while (!formaValida) {
            System.out.print("Escolha a forma de pagamento (1, 2, 3 ou 4): ");
            int opcaoPagamento = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcaoPagamento) {
                case 1:
                    formaPagamento = "Pix";
                    formaValida = true;
                    break;
                case 2:
                    formaPagamento = "Transferência Bancária";
                    formaValida = true;
                    break;
                case 3:
                    formaPagamento = "Cartão de Crédito";
                    formaValida = true;
                    break;
                case 4:
                    formaPagamento = "Cartão de Débito";
                    formaValida = true;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        sistema.realizarPedido(cliente, itens, quantidades);

        System.out.println("Forma de pagamento escolhida: " + formaPagamento);

        System.out.println("Obrigado por fazer o pedido! Volte sempre.");
        scanner.close();
    }
}
