package org.example;

public class Ex8 {

//     Representa um pedido de compra realizado no sistema.

    static class Pedido {
        private int id;
        private String descricao;
        private double valor;

        public Pedido(int id, String descricao, double valor) {
            if (descricao == null || descricao.isBlank()) {
                throw new IllegalArgumentException("Descrição não pode ser vazia.");
            }
            if (valor < 0) {
                throw new IllegalArgumentException("Valor do pedido não pode ser negativo.");
            }
            if (id <= 0){
                throw new IllegalArgumentException("Valor do id nao pode ser negativo ou zero");
            }
            System.out.println("Pedido Criado com sucesso. ID: " + id);
            this.id = id;
            this.descricao = descricao;
            this.valor = valor;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDescricao() {
            return descricao;
        }

        public double getValor() {
            return valor;
        }
    }

}
