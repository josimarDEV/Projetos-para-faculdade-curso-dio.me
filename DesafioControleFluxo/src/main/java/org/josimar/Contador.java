package org.josimar;

import java.util.Scanner;

public class Contador {
	public static void main(String[] args) {
		Scanner terminal = new Scanner(System.in);
		System.out.println("Digite o primeiro parâmetro");
		int parametroUm = terminal.nextInt();
		System.out.println("Digite o segundo parâmetro");
		int parametroDois = terminal.nextInt();

		try {
			//chamando o método contendo a lógica de contagem
			contar(parametroUm, parametroDois);

		}catch (ParametrosInvalidosException e) {
			//imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
            System.err.println("O segundo deve ser maior que o primeiro");
		}

	}
	static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
		if (parametroUm < parametroDois) {
            int valor = parametroDois - parametroUm;
            for (int i = 1; i <= valor; i++) {
                System.out.println(i);
            }

        }
		else {
			throw new ParametrosInvalidosException();
		}
	}
}