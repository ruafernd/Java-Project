public class Cliente extends Pessoa {
     private String telefone;
     public Cliente (String nome , String cpf, String telefone) {
        super(nome,cpf);
        this.telefone = telefone;
     }
    
    public String getTelefone(){
        return telefone;
    }
    
    @Override
    public void exibirDados(){
      System.out.println("Cliente: + getNome() +"+" -CPF:" + getCpf() +"-Telefone:" + telefone);
    }
}
