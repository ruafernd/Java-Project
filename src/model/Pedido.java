import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        itens.add(new ItemPedido(produto, quantidade));
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public void exibirPedido() {
        System.out.println("Pedido para: " + cliente.getNome());
        for (ItemPedido item : itens) {
            System.out.println(item.getDescricao());
        }
        System.out.println("Total: R$ " + calcularTotal());
    }
}
