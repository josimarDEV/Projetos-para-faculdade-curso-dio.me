package org.josimar.Candidatura.ProcessoSeletivo;

public class Case1 {
    public static void main(String[] args) {
        ProcessoSeletivo(1900.0);
        ProcessoSeletivo(2000.0);
        ProcessoSeletivo(2200.0);
    }
    static void ProcessoSeletivo(Double salarioPretendido){
        Double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        }else if (salarioBase.equals(salarioPretendido)){
            System.out.println("LIGAR PARA O CANDIDATO, COM CONTRA PROPOSTA");
        }else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}



