package org.example;

public class Ex10 {
    static class Servico {

        /**
         * Processa o dado informado, convertendo-o para letras maiúsculas.
         * Caso o dado seja nulo ou vazio, lança uma exceção informativa.
         *
         * @param dado Texto a ser processado
         */
        public void processar(String dado) {
            if (dado == null || dado.isBlank()) {
                throw new IllegalArgumentException("O dado não pode ser nulo.");
            }
            System.out.println("Processando: " + dado.toUpperCase());
        }
    }

}
