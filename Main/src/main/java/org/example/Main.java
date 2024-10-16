package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void sair(){
        System.out.println("a");
    }
    public static void iniciarJogo(){

    }
    public static void instrucoes(){

    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("      Bem vindo ao Racha Cuca \n - Sair - (0) \n - Deseja iniciar um novo jogo - (1) \n - Instruções de jogo - (2) \n ");

        int escolha = entrada.nextInt();

        switch (escolha) {
            case 0:
                sair();
            break;
            case 1:
                iniciarJogo();
            break;
            case 2:
                instrucoes();
            break;
            default:
                System.out.println("O valo inserido é invalido! \nTente novamente!!");
                String[] ola = {"ola", "fusca"};
                main(ola);
        }
    }
}