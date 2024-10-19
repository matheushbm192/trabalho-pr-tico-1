package org.example;

import java.util.Scanner;

public class Main{

    public static void sair(){
        System.out.println("\nJogo encerrado!!");
        System.exit(0);
    }
    public static  int nivelDificuldade() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Insira o nivel de dificuldade desejado \n Fácil - 1 \n Médio - 2 \n Difícil - 3 ");

        while (true) {
            int dificuldade = entrada.nextInt();
            if (dificuldade == 1 || dificuldade == 2 || dificuldade == 3) {

                return dificuldade;
            }else {
                System.out.println("O valor inserido não está entre as opçoes! \n  " +
                        "Insira o nivel de dificuldade desejado \n Fácil - 1 \n Médio - 2 \n Difícil - 3");
            }
        }
    }
    public static void embaralharJogo(int dificuldade){

    }
    public static void iniciarJogo(){
        embaralharJogo(nivelDificuldade());
    }

    public static void instrucoes(){
        System.out.println("\nIntruções para jogar o Quebra-Cabeça de 8 peças:\n\n"
                + "Objetivo do jogo: O jogador deve movimentar as peças utilizando o espaço vazio, até que eles fiquem orgazizados"
                + "em ordem crescente de 1 a 8,\n com o espaço vazio no último quadrado.\n\n"
                + "Como jogar:\n"
                + "- O tabuleiro é composto por 8 peças (números de 1 a 8) e um espaço vazio.\n"
                + "- Essas peças serão embaralhadas de acordo com o nível de dificuldade escolhido pelo jogador, sendo: fácil(1), médio(2) ou difícil(3) \n"
                + "- Para mover uma peça de lugar é necessário que ela esteja ao lado do espaço vazio (na horizontal ou vertical).\n"
                + "- Deslize as peças para o espaço vazio até que eles estejam na sequência crescente de 1 a 8. \n\n"
                + "Final do jogo: O jogo termina quando as peças estiverem organizadas na sequência correta e com o espaço vazio no último quadrado. \n\n"
                + "Exemplo de execução correta:\n"
                + "         1 2 3\n"
                + "         4 5 6\n"
                + "         7 8  \n");
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
                System.out.println("O valor inserido é invalido! \nTente novamente!\n");
                String[] parametros = {"param1", "param2"};
                main(parametros);
        }
    }
}