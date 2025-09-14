package org.example;

import java.util.ArrayList;
import java.util.List;

public class Ex3 {
    static class ItemDeCompra {
        private String produto;
        private double preco;
        private int quantidade;

        public ItemDeCompra(String produto, double preco, int quantidade) {
            this.produto = produto;
            this.preco = preco;
            this.quantidade = quantidade;
        }

        public String getProduto() {
            return produto;
        }

        public double getPreco() {
            return preco;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public double getSubtotal() {
            return preco * quantidade;
        }

        @Override
        public String toString() {
            return produto + " - R$ " + preco + " x " + quantidade + " = R$ " + getSubtotal();
        }
    }

    // Classe que representa o carrinho de compras
    public static class CarrinhoDeCompras {
        private List<ItemDeCompra> itens;

        public CarrinhoDeCompras() {
            itens = new ArrayList<>();
        }

        public void adicionarProduto(String produto, double preco, int quantidade) {
            itens.add(new ItemDeCompra(produto, preco, quantidade));
        }

        public void adicionarProduto(ItemDeCompra produto){
            itens.add(produto);
        }

        public double calcularTotal() {
            double total = 0;
            for (ItemDeCompra item : itens) {
                total += item.getSubtotal();
            }
            return total;
        }

        public void exibirResumo() {
            System.out.println("=== Resumo da Compra ===");
            for (ItemDeCompra item : itens) {
                System.out.println(item);
            }
            System.out.println("Total da compra: R$ " + calcularTotal());
        }
    }
}
