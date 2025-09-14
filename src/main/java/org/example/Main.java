package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Exemplo Ex1:
//        Ex1.SistemaFinanceiro sistema = new Ex1.SistemaFinanceiro();
//
//        sistema.adicionarConta("Conta Corrente", 1500.00);
//        sistema.adicionarConta("Conta Poupança", 2500.00);
//
//        sistema.gerarRelatorio();
//
//        sistema.processarPagamentos(200.00);
//
//        System.out.println("\nApós processar pagamentos:");
//        sistema.gerarRelatorio();
//
//        Exemplo Ex2:
//        Ex2.Processador processador = new Ex2.Processador();
//        processador.processar("");
//        processador.processar("dados");
//        processador.processar("Grande Cachorro");



//        Exemplo Ex3:
//        Ex3.ItemDeCompra itemDeCompra1 = new Ex3.ItemDeCompra("Lapis", 1.99, 2);
//        System.out.println(itemDeCompra1.toString());
//
//        Ex3.CarrinhoDeCompras carrinhoDeCompras1 = new Ex3.CarrinhoDeCompras();
//        carrinhoDeCompras1.adicionarProduto(itemDeCompra1);
//        System.out.println(carrinhoDeCompras1.calcularTotal());
//        carrinhoDeCompras1.exibirResumo();


//
//      Exemplo Ex4:
//        Ex4.Livro livro1 = new Ex4.Livro("O Odio");
//        System.out.println(livro1.toString());
//        livro1.emprestar();
//        System.out.println(livro1.toString());
//        livro1.devolver();
//        System.out.println(livro1.toString());
//
//        Ex4.Biblioteca biblioteca = new Ex4.Biblioteca();
//        biblioteca.adicionarLivro(livro1);
//        biblioteca.adicionarLivro("O Amor");
//        livro1.emprestar();
//        biblioteca.listarLivros();
//        biblioteca.emprestarLivro("O Odio");
//        biblioteca.emprestarLivro("O Amor");
//        biblioteca.devolverLivro("O Odio");
//        biblioteca.listarLivros();


//        Exemplo Ex5:
//        Ex5.BancoService banco = new Ex5.BancoService();
//
//        banco.criarConta("Joao", 1000.0);
//        banco.criarConta("Maria", 500.0);
//
//        System.out.println("Contas iniciais:");
//        banco.listarContas();
//
//        System.out.println("\nTransferindo R$ 300 de João para Maria...");
//        if (banco.transferir("Joao", "Maria", 300.0)) {
//            System.out.println("✅ Transferência realizada com sucesso.");
//        } else {
//            System.out.println("❌ Erro na transferência.");
//        }
//
//        System.out.println("\nSituação final das contas:");
//        banco.listarContas();
//
//
//        //       Exemplo Ex6:
//        List<String> clientes = new ArrayList<>();
//        List<Double> saldos = new ArrayList<>();
//
//        clientes.add("Joao");
//        saldos.add(banco.buscarConta("Joao").getSaldo());
//        clientes.add("Maria");
//        saldos.add(banco.buscarConta("Maria").getSaldo());
//
//        Ex6.RelatorioFinanceiro relatorioFinanceiro = new Ex6.RelatorioFinanceiro();
//        relatorioFinanceiro.gerarRelatorio(clientes, saldos);

//
//
//       Exemplo Ex7:
//        try{
//            Ex7.ContaBancaria contaBancaria =new Ex7.ContaBancaria("LP", 100);
//            contaBancaria.depositar(50);
//            contaBancaria.sacar(60);
//            contaBancaria.getSaldo();
//            Ex7.ContaBancaria contaBancaria2 =new Ex7.ContaBancaria("", 100);
//        }   catch (Exception e){
//            System.out.println("Error : " + e.getMessage());
//        }
//
//
//
//       Exemplo Ex8:
//        try {
//            Ex8.Pedido pedido = new Ex8.Pedido(1, "Hamburger Artesanal", 19.90);
//            Ex8.Pedido pedido2 = new Ex8.Pedido(2, "", 19.90);
//            Ex8.Pedido pedido3 = new Ex8.Pedido(3, "Hamburger Artesanal", -1);
//            Ex8.Pedido pedido4 = new Ex8.Pedido(0, "Hamburger Artesanal", -1);
//        } catch (IllegalArgumentException e){
//            System.out.println("Erro :" + e.getMessage());
//        }
//
//
//        Exemplo Ex9:
//        Ex9.Processador processador = new Ex9.Processador();
//        processador.executar("Pao");
//        processador.executar("");


//        Exemplo Ex10:
//        Ex10.Servico servico = new Ex10.Servico();
//        try {
//            servico.processar("Cachorro quente em falta");
//            servico.processar("");
//        } catch (IllegalArgumentException e){
//            System.out.println("Erro: " + e.getMessage());
//        }

//        Exemplo EX11:
//        Ex11.ValidadorCPF validador = new Ex11.ValidadorCPF();
//
//        try {
//            boolean valido = validador.validar("12345678901");
//            System.out.println("CPF válido? " + valido);
//        } catch (Ex11.CpfInvalidoException e) {
//            System.out.println("Erro: " + e.getMessage());
//        }


//        Exemplo Ex12:
//        Ex12.Pagamento pagamento = new Ex12.Pagamento();
//
//        try {
//            pagamento.processarPagamento(250.0, "pix"); // método inválido
//        } catch (Ex12.MetodoPagamentoInvalidoException e) {
//            System.err.println("Erro no pagamento: " + e.getMessage());
//        }
//
//        try {
//            pagamento.processarPagamento(500.0, "cartao"); // método válido
//        } catch (Ex12.MetodoPagamentoInvalidoException e) {
//            System.err.println("Erro no pagamento: " + e.getMessage());
//        }
    }
}