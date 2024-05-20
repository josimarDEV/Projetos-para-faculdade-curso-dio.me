package org.josimar.Candidatura.ProcessoSeletivo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Case2 {
    public static void main(String[] args) {
    selecionarCandidatos();
    }
    static void selecionarCandidatos(){
        DecimalFormat format = new DecimalFormat("0.00");
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};
        Double salarioBase = 2000.0;
        List<String> selecionados = new ArrayList<>();
        int selecionado = 0;
        int totalCandidatos = 0;

        for (String candidato : candidatos) {
            Double valor = valorPretendido();
            System.out.println("O candidato " + candidato + " Está pedindo " + format.format(valor));
            if (valor < salarioBase && selecionado < 5) {
                selecionados.add(candidato);
                selecionado++;
                System.out.println("LEGAL!! o candidato " + candidato + " foi selecionado.");
                System.out.println();
            } else {
                System.out.println("Que PENA! o candidato " + candidato + " Não foi selecionado.");
                System.out.println();
            }
            totalCandidatos++;
        }
        System.out.println("Candidatos consultados: " + totalCandidatos);
        System.out.println("Candidatos selecionados: " + selecionado);

        System.out.println();
        System.out.println("São ELES");
        for (int i = 0;  i < selecionados.toArray().length; i++) {
            System.out.println(selecionados.get(i));
        };

        System.out.println();
        System.out.println("Rh Entrando em contato...");
        System.out.println();

        for (int i = 0;  i < selecionados.toArray().length; i++) {
             int tentativas = 1;
            boolean continuarTentando = true;
            boolean atendeu = false;

            do {
                atendeu = atender();
                continuarTentando = !atendeu;
                if(continuarTentando){
                    tentativas++;
                }else {
                    System.out.println("Contato realizado com sucesso.");
                }
            }while (continuarTentando && tentativas < 3);

            if (atendeu) {
                System.out.println("Conseguimos contato com " + selecionados.get(i) + " na " + tentativas + " tentativa.");
                System.out.println();
            }

            else {
                System.out.println("Não conseguimos contato com " + selecionados.get(i) + " número máximo de tentativas " + tentativas + ".");
            }
        }


    }
    static double valorPretendido() {
     return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static boolean atender() {
        return new Random().nextInt(3)==1;
    }
}
