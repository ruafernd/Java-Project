public class Funcionario extends Pessoa{
    private String cargo;
    public Funcionario (String nome, String cpf, String cargo){
        super(nome,cpf);
        this.cargo = cargo;
    }

    @Override
    public void exibirDados(){
        System.out.println("Funcionário: " + getNome() +"-CPF:" + getCpf() +" -Cargo:" + cargo);
    }
}
