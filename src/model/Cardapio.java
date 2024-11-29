package model;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private List<Produto> produtos;

    public Cardapio() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(String nome) {
        produtos.removeIf(produto -> produto.getNome().equals(nome));
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public Produto buscarProduto(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }
}
