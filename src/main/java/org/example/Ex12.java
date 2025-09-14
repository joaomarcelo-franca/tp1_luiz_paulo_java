package org.example;

public class Ex12 {
    // Exceção customizada para métodos de pagamento inválidos
    static class MetodoPagamentoInvalidoException extends RuntimeException {
        public MetodoPagamentoInvalidoException(String metodo) {
            super("Método de pagamento inválido: " + metodo);
        }
    }

    static class Pagamento {

        /**
         * Processa um pagamento de acordo com o método escolhido.
         *
         * @param valor  Valor a ser pago
         * @param metodo Método de pagamento (ex: "cartao", "boleto")
         * @throws MetodoPagamentoInvalidoException se o método não for suportado
         */
        public void processarPagamento(double valor, String metodo) {
            if ("cartao".equalsIgnoreCase(metodo)) {
                System.out.println("Pagamento de R$" + valor + " realizado via cartão.");
            } else if ("boleto".equalsIgnoreCase(metodo)) {
                System.out.println("Pagamento de R$" + valor + " realizado via boleto.");
            } else {
                throw new MetodoPagamentoInvalidoException(metodo);
            }
        }
    }

}
