package model;

public class Garcom extends Funcionario {

    public Garcom(String nome, String cpf, String garçonete, double salario) {
        super(nome, cpf, salario, "Garçom");  // Definindo o cargo como "Garçom"
    }

    @Override
    public void exibirDados() {
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Salário: R$ " + getSalario());
        System.out.println("Cargo: " + getCargo());  // Usando o método getCargo()
    }
}
