package List.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        itens.add(new Item(nome, preco, quantidade));
        System.out.println("Item adicionado: " + nome);
    }

    public void removerItem(String nome) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                itens.remove(item);
                System.out.println("Item removido: " + nome);
                return; // Sai do método após remover
            }
        }
        System.out.println("Item não encontrado: " + nome);
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }

    public void exibirItens() {
        if (itens.isEmpty()) {
            System.out.println("O carrinho está vazio!");
        } else {
            System.out.println("\nItens no Carrinho:");
            for (Item item : itens) {
                System.out.println(item); // Usa o toString() de Item
            }
        }
    }

    // Método main para testar a classe
    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        carrinho.adicionarItem("Notebook", 3500.00, 1);
        carrinho.adicionarItem("Mouse", 50.99, 2);
        carrinho.adicionarItem("Teclado", 120.50, 1);

        carrinho.exibirItens();

        carrinho.removerItem("Mouse");

        carrinho.exibirItens();

        System.out.printf("\nValor total do carrinho: R$ %.2f", carrinho.calcularValorTotal());
    }
}