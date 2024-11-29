package model;

public class Cozinheiro extends Funcionario {

    public Cozinheiro(String nome, String cpf, double salario) {
        super(nome, cpf, salario, "Cozinheiro");  // Definindo o cargo como "Cozinheiro"
    }

    @Override
    public void exibirDados() {
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Salário: R$ " + getSalario());
        System.out.println("Cargo: " + getCargo());  // Usando o método getCargo()
    }
}
