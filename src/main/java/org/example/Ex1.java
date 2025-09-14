package org.example;

import java.util.ArrayList;
import java.util.List;

public class Ex1 {

    // Classe que representa uma Conta
    static class Conta {
        private String nome;
        private double saldo;

        public Conta(String nome, double saldo) {
            this.nome = nome;
            this.saldo = saldo;
        }

        public String getNome() {
            return nome;
        }

        public double getSaldo() {
            return saldo;
        }

        public void debitar(double valor) {
            this.saldo -= valor;
        }

        @Override
        public String toString() {
            return "Conta: " + nome + " - Saldo: " + saldo;
        }
    }

    // Classe que gerencia o sistema financeiro
    static class SistemaFinanceiro {
        private List<Conta> contas;

        public SistemaFinanceiro() {
            contas = new ArrayList<>();
        }

        public void adicionarConta(String nome, double saldo) {
            contas.add(new Conta(nome, saldo));
        }

        public void gerarRelatorio() {
            System.out.println("== Relatório Financeiro ===");
            for (Conta conta : contas) {
                System.out.println(conta);
            }
        }

        public void processarPagamentos(double taxa) {
            for (Conta conta : contas) {
                conta.debitar(taxa);
            }
        }

        public List<Conta> getContas() {
            return contas;
        }
    }
}

