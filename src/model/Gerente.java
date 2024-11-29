package model;

public class Gerente extends Funcionario {

    public Gerente(String nome, String cpf, double salario) {
        super(nome, cpf, salario, "Gerente");
    }

    @Override
    public void exibirDados() {
        // Aqui você pode personalizar a forma de exibição dos dados
        System.out.println("Dados do Gerente:");
        super.exibirDados();  // Usando a implementação padrão da classe pai
    }
}
