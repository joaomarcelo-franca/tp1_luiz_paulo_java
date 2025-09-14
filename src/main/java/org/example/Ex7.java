package org.example;

public class Ex7 {
    static class ContaBancaria {
        private String titular;
        private double saldo;

        public ContaBancaria(String titular, double saldoInicial) {
            if (titular == null || titular.isBlank()) {
                throw new IllegalArgumentException("O titular não pode ser nulo ou vazio.");
            }
            if (saldoInicial < 0) {
                throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
            }
            this.titular = titular;
            this.saldo = saldoInicial;
        }

        public void depositar(double valor) {
            if (valor <= 0) {
                throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
            }
            saldo += valor;
        }

        public void sacar(double valor) {
            if (valor <= 0) {
                throw new IllegalArgumentException("O valor do saque deve ser positivo.");
            }
            if (valor > saldo) {
                throw new IllegalStateException("Saldo insuficiente para realizar o saque.");
            }
            saldo -= valor;
        }

        public double getSaldo() {
            return saldo;
        }

        public String getTitular() {
            return titular;
        }
    }

}
