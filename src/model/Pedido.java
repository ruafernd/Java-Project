public class Pedido {
    private Produto produto;
    private int quantidade;
    
    public Pedido(Produto produto, int quantidade) {
    this.produto = produto;
    this.quantidade = quantidade;
}
    
  public double calcularSubtotal() {
    return produto.getPreco() * quantidade;
}
    
  public String getDescricao() {
    return quantidade + "x " + produto.getNome();
}
}
