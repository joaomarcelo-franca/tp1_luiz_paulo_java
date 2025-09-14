package org.example;

public class Ex11 {
    // excecao específica para validação de CPF
    static class CpfInvalidoException extends RuntimeException {
        public CpfInvalidoException(String mensagem) {
            super(mensagem);
        }
    }

    static class ValidadorCPF {

        /**
         * valida o CPF informado de acordo com critérios básicos.
         *
         * @param cpf CPF a ser validado
         * @return true se o CPF for válido
         * @throws CpfInvalidoException se o CPF for inválido
         */
        public boolean validar(String cpf) {
            if (cpf == null || cpf.isBlank()) {
                throw new CpfInvalidoException("CPF não pode ser nulo ou vazio.");
            }

            if (cpf.length() != 11) {
                throw new CpfInvalidoException("CPF deve conter exatamente 11 dígitos.");
            }

            if (!cpf.matches("\\d+")) {
                throw new CpfInvalidoException("CPF deve conter apenas números.");
            }

            if (cpf.chars().distinct().count() == 1) {
                throw new CpfInvalidoException("CPF não pode ser formado por números repetidos.");
            }

            //aqui entraria a validação real de dígitos verificadores
            return true;
        }
    }

}
