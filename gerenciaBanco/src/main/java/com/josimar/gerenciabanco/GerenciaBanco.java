/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.josimar.gerenciabanco;

/**
 *
 * @author JOSIMAR_ADS
 */
import java.util.Scanner;

public class GerenciaBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RealizarOperacoes realizarOperacoes = new RealizarOperacoes();
        
        // Boas-vindas ao usuário
        System.out.println("\nSejam Bem vindo ao Banco Silva!\n");

        // Solicitação do primeiro nome do usuário
        System.out.println("Digite seu primeiro nome: ");
        String nome =  scanner.next();
        
        // Solicitação do sobrenome do usuário
        System.out.println("Digite seu sobrenome: ");
        String sobrenome = scanner.next();

        // Solicitação do CPF do usuário e formatação
        System.out.println("Digite seu cpf (apenas números): ");
        String cpf = scanner.next();
        String cpfFormatado = formatarCPF(cpf);
        
        int escolha;
        do {
            // Pega o saldo atual do cliente, colocando dentro do do while ele fica o loop entao toda vez que o saldo muda ele muda junto, pegando fora só pegao saldo atual e não altera o valor
            double saldo = realizarOperacoes.getSaldo();
            // Exibição do menu
            exibirMenu(nome, sobrenome, cpfFormatado, saldo);
            escolha = scanner.nextInt();

            // Switch para tratar as escolhas do usuário
            switch (escolha) {
                case 1:
                    System.out.println("Digite o valor de Depósito:R$ ");
                    double valorDeposito = scanner.nextDouble();
                    realizarOperacoes.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.println("Digite o valor para saque:R$ ");
                    double valorSaque = scanner.nextDouble();
                    realizarOperacoes.sacar(valorSaque);
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    System.out.println("Obrigado por utilizar nosso Banco volte Sempre!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente");
            }
        } while (escolha != 4);
        
        scanner.close();

    }

    // Método para exibir o menu com as informações do usuário
    /**
     * Exibe o menu do banco com as informações do usuário.
     * 
     * @param nome O primeiro nome do usuário.
     * @param sobrenome O sobrenome do usuário.
     * @param cpfFormatado O CPF formatado do usuário.
     */
    public static void exibirMenu(String nome, String sobrenome, String cpfFormatado, double saldo){
        System.out.println("\n      --- MENU---");
        System.out.println("Bem vindo ao Banco Digital");
        System.out.println("\nUsuário: " + nome + " " + sobrenome);
        System.out.println("CPF: " + cpfFormatado + "");
        System.out.println("Saldo:R$ " + saldo + "\n");
        System.out.println("1. Realizar Depósito");
        System.out.println("2. Realizar Saque");
        System.out.println("3. Sair");
        System.out.println("Escolha uma opção: ");
    }

    // Método para formatar o CPF
    /**
     * Formata o CPF inserindo pontos e hífen.
     * 
     * @param cpf O CPF a ser formatado.
     * @return O CPF formatado.
     */
    public static String formatarCPF(String cpf) {
        // Expressão regular para formatar o CPF
        String cpfFormatado = cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        return cpfFormatado;
    }

}


class RealizarOperacoes {
    private double saldo;
    
    // Método construtor para inicializar o saldo
    public RealizarOperacoes(){
        this.saldo = 0;
    }

    // Método para realizar um saque na conta
    /**
     * Realiza uma operação de saque na conta.
     * 
     * @param valor O valor a ser sacado.
     * @return true se o valor for menor ou igual ao saldo, false caso contrário.
     */
    public boolean sacar(double valor) {
        if (valor <= saldo && valor > 0){
            saldo = saldo - valor;
            return true;
        }
        else
            return false;
    }

    // Método para realizar um depósito na conta
    /**
     * Realiza uma operação de depósito na conta.
     * 
     * @param valor O valor a ser depositado.
     * @return true se o valor for maior que zero, false caso contrário.
     */
    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
            return true;
        }
        else
            return false;
    }

    // Método para obter o saldo do cliente
    /**
     * Retorna o saldo da conta.
     * 
     * @return O saldo da conta.
     */
    public double getSaldo(){
        return saldo;
    }
}
