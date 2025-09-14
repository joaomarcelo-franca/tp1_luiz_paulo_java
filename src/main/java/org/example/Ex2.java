package org.example;

public class Ex2 {
    public static class Processador {

        private static final int TAMANHO_MINIMO = 10;

        public void processar(String dado) {
            if (!isValido(dado)) {
                System.out.println("Dado inválido.");
                return;
            }

            if (isMuitoCurto(dado)) {
                System.out.println("Dado muito curto.");
                return;
            }

            System.out.println("Dado válido: " + dado);
        }

        private boolean isValido(String dado) {
            return dado != null && !dado.isEmpty();
        }

        private boolean isMuitoCurto(String dado) {
            return dado.length() <= TAMANHO_MINIMO;
        }
    }

}
