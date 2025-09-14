package org.example;
import java.util.ArrayList;
import java.util.List;

public class Ex4 {
    static class Livro {
        private String titulo;
        private boolean disponivel;

        public Livro(String titulo) {
            this.titulo = titulo;
            this.disponivel = true; // todo livro começa disponível
        }

        public String getTitulo() {
            return titulo;
        }

        public boolean isDisponivel() {
            return disponivel;
        }

        public void emprestar() {
            if (disponivel) {
                disponivel = false;
            } else {
                throw new IllegalStateException("Livro já está emprestado.");
            }
        }

        public void devolver() {
            disponivel = true;
        }

        @Override
        public String toString() {
            return titulo + " - " + (disponivel ? "Disponível" : "Emprestado");
        }
    }

    // Classe que gerencia a Biblioteca
    static class Biblioteca {
        private List<Livro> livros;

        public Biblioteca() {
            livros = new ArrayList<>();
        }

        public void adicionarLivro(String titulo) {
            livros.add(new Livro(titulo));
        }

        public void adicionarLivro(Livro livro){
            livros.add(livro);
        }

        public void emprestarLivro(String titulo) {
            for (Livro livro : livros) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    if (livro.isDisponivel()) {
                        livro.emprestar();
                        System.out.println("Livro emprestado: " + titulo);
                    } else {
                        System.out.println("Livro não disponível.");
                    }
                    return;
                }
            }
            System.out.println("Livro não encontrado.");
        }

        public void devolverLivro(String titulo) {
            for (Livro livro : livros) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    livro.devolver();
                    System.out.println("Livro devolvido: " + titulo);
                    return;
                }
            }
            System.out.println("Livro não encontrado.");
        }

        public void listarLivros() {
            System.out.println("=== Catálogo da Biblioteca ===");
            for (Livro livro : livros) {
                System.out.println(livro);
            }
            System.out.println("=== === === === === ===");
        }
    }
}
