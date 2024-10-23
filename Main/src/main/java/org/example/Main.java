package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void sair() {
        System.out.println("\nJogo encerrado!!");
        System.exit(0);
    }

    public static  int nivelDificuldade() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\nInsira o nivel de dificuldade desejado \n Fácil - 1 \n Médio - 2 \n Difícil - 3 ");

        while (true) {
            int numDeMovimentos;
            int dificuldade = entrada.nextInt();

            if (dificuldade == 1){
                return numDeMovimentos = 20;
            }else if(dificuldade == 2){
                return numDeMovimentos = 40;
            }else if(dificuldade == 3){
                return numDeMovimentos = 80;
            }else {
                System.out.println("O valor inserido não está entre as opções! \n  " +
                        "Insira o nivel de dificuldade desejado \n Fácil - 1 \n Médio - 2 \n Difícil - 3");
            }
        }
    }


    public static int[][] movimentosValidos(int[] posicaoZero) {
        Random roleta = new Random();

        if (posicaoZero[0] == 0 && posicaoZero[1] == 0){
            int[][] posicoes = {{0,1},{1,0}};
            return posicoes;
        }else if (posicaoZero[0] == 0 && posicaoZero[1] == 1){
            int[][] posicoes = {{0,0},{0,2},{1,1}};
            return posicoes;
        }else if (posicaoZero[0] == 0 && posicaoZero[1] == 2){
            int[][] posicoes = {{0,1},{1,2}};
            return posicoes;
        }else if (posicaoZero[0] == 1 && posicaoZero[1] == 0){
            int[][] posicoes = {{0,0},{1,1},{2,0}};
            return posicoes;
        }else if (posicaoZero[0] == 1 && posicaoZero[1] == 1){
            int[][] posicoes = {{0,1},{1,0},{1,2},{2,1}};
            return posicoes;
        }else if (posicaoZero[0] == 1 && posicaoZero[1] == 2){
            int[][] posicoes = {{0,2},{1,1},{2,2}};
            return posicoes;
        }else if (posicaoZero[0] == 2 && posicaoZero[1] == 0){
            int[][] posicoes = {{1,0},{2,1}};
            return posicoes;
        }else if (posicaoZero[0] == 2 && posicaoZero[1] == 1){
            int[][] posicoes = {{2,0},{1,1},{2,2}};
            return posicoes;
        }else{
            int[][] posicoes = {{1,2},{2,1}};
            return posicoes;
        }
    }
    public static void exibirMatriz(int[][] matriz){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static int[][] embaralharJogo(int numDeMovimentos,int[][] matriz){
        Random sorteio = new Random();


        int[] posicaoZero = {2,2};

        for (int i = 0; i < numDeMovimentos ; i++) {
            int[]posicaoAnteriorZero = posicaoZero;

            int[][] posicoes = movimentosValidos(posicaoZero);

            int posicaoSorteada = sorteio.nextInt(0,posicoes.length);

            int[] posicaoMovimento = posicoes[posicaoSorteada] ;


            int valorFuturaPosicaoZero = matriz[posicaoMovimento[0]][posicaoMovimento[1]];

            matriz[posicaoMovimento[0]][posicaoMovimento[1]] = 0;

            matriz[posicaoAnteriorZero[0]][posicaoAnteriorZero[1]] = valorFuturaPosicaoZero;
            posicaoZero[0] = posicaoMovimento[0];
            posicaoZero[1] = posicaoMovimento[1];

        }

        return matriz;
    }

    public static void iniciarJogo(){
        int[][] matrizInicial = {
                {1,2,3},
                {4,5,6},
                {7,8,0},
        };
        System.out.println("Aqui está a matriz inicial\n");
        exibirMatriz(matrizInicial);

        int [][] matriz = embaralharJogo(nivelDificuldade(), matrizInicial);

        System.out.println("\nMatriz embaralhada!\n");
        exibirMatriz(matriz);
        System.out.println("\nComece a jogar! Escolha o seu primeiro movimento: \n");

    }

    public static void instrucoes() {
        Scanner entrada = new Scanner(System.in);
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

        System.out.println("Deseja iniciar o jogo?\n"
                + "- Sim - (1)\n"
                + "- Não - (2)\n");

        int escolha = entrada.nextInt();
        switch (escolha) {
            case 1:
                iniciarJogo();
                break;

            case 2:
                sair();
                break;
        }
        entrada.close();
    }

    public static void menu() {
        Scanner entrada = new Scanner(System.in);

        System.out.println(
                "      Bem vindo ao Racha Cuca \n - Sair - (0) \n - Deseja iniciar um novo jogo - (1) \n - Instruções de jogo - (2) \n ");

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
                main(null);
        }
        entrada.close();

    }

    public static void main(String[] args) {
        menu();
    }
}