package org.example;
import java.util.*;

public class Ex5 {
    // ===== CAMADA MODEL =====
    static class Conta {
        private String titular;
        private double saldo;

        public Conta(String titular, double saldoInicial) {
            this.titular = titular;
            this.saldo = saldoInicial;
        }

        public String getTitular() {
            return titular;
        }

        public double getSaldo() {
            return saldo;
        }

        public void depositar(double valor) {
            saldo += valor;
        }

        public boolean sacar(double valor) {
            if (valor <= saldo) {
                saldo -= valor;
                return true;
            }
            return false;
        }
    }
    static class BancoService {
        private List<Conta> contas;

        public BancoService() {
            contas = new ArrayList<>();
        }

        public void criarConta(String titular, double saldoInicial) {
            contas.add(new Conta(titular, saldoInicial));
        }

        public Conta buscarConta(String titular) {
            for (Conta conta : contas) {
                if (conta.getTitular().equalsIgnoreCase(titular)) {
                    return conta;
                }
            }
            return null;
        }

        public boolean transferir(String origem, String destino, double valor) {
            Conta contaOrigem = buscarConta(origem);
            Conta contaDestino = buscarConta(destino);

            if (contaOrigem != null && contaDestino != null && contaOrigem.sacar(valor)) {
                contaDestino.depositar(valor);
                return true;
            }
            return false;
        }

        public void listarContas() {
            for (Conta conta : contas) {
                System.out.println(conta.getTitular() + " - Saldo: " + conta.getSaldo());
            }
        }
    }
    static class SistemaBancarioApp {
        public static void main(String[] args) {
            BancoService banco = new BancoService();

            banco.criarConta("João", 1000.0);
            banco.criarConta("Maria", 500.0);

            banco.listarContas();

            System.out.println("\nTentando transferir R$ 200 de João para Maria...");
            if (banco.transferir("João", "Maria", 200.0)) {
                System.out.println("Transferência realizada com sucesso.");
            } else {
                System.out.println("Erro na transferência.");
            }

            System.out.println("\nSituação final:");
            banco.listarContas();
        }
    }
}
