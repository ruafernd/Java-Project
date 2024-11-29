package model;

public abstract class Funcionario {
    private String nome;
    private String cpf;
    private double salario;
    private String cargo;

    public Funcionario(String nome, String cpf, double salario, String cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalario() {
        return salario;
    }

    public String getCargo() {
        return cargo;
    }

    // Implementação padrão para exibir dados
    public void exibirDados() {
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Salário: R$ " + getSalario());
        System.out.println("Cargo: " + getCargo());
    }
}
