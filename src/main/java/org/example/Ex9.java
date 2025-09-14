package org.example;

public class Ex9 {
    static class Processador {

        /**
         * Executa o processamento de um valor textual,
         * caso ele não seja nulo.
         *
         * @param valor Texto a ser processado
         */
        public void executar(String valor) {
            if (valor != null) {
                System.out.println("Processando: " + valor);
            }
        }
    }

}
