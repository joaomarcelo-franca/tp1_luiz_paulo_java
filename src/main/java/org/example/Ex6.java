package org.example;
import java.util.List;

public class Ex6 {
    static class RelatorioFinanceiro {

        public void gerarRelatorio(List<String> clientes, List<Double> saldos) {
            imprimirCabecalho();
            imprimirCorpo(clientes, saldos);
            imprimirRodape();
        }

        private void imprimirCabecalho() {
            System.out.println("=== Relatório Financeiro ===");
        }

        private void imprimirCorpo(List<String> clientes, List<Double> saldos) {
            for (int i = 0; i < clientes.size(); i++) {
                imprimirLinhaCliente(clientes.get(i), saldos.get(i));
            }
        }

        private void imprimirLinhaCliente(String cliente, Double saldo) {
            System.out.println("Cliente: " + cliente + " - Saldo: R$ " + saldo);
        }

        private void imprimirRodape() {
            System.out.println("=========================");
            System.out.println("Fim do Relatório");
        }
    }
}
