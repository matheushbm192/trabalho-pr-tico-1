package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    
    //array que indica a posição inicial do zero ({2,2})
    static int[] posicaoZero = {2, 2};

    //função usada para encerrar o programa  
    public static void sair() {
        System.out.println("\nJogo encerrado!!");
        //método que encerra a execução.
        System.exit(0);
    }
    
    //função que guarda o nível de dificuldade escolhido pelo usuário 
    public static  int nivelDificuldade() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("\nInsira o nivel de dificuldade desejado: \n Fácil (1) \n Médio (2) \n Difícil (3): \n");

        while (true) {
            int dificuldade = entrada.nextInt();

            if (dificuldade == 1){
                return 20;
            }else if(dificuldade == 2){
                return 40;
            }else if(dificuldade == 3){
                return 80;
            }else {
                System.out.println("\nO valor inserido não está entre as opções!\n" +
                        "Insira o nivel de dificuldade desejado: \n Fácil - 1 \n Médio - 2 \n Difícil - 3\n");
            }
        }
    }

    //função que guarda os movimentos válidos de acordo com a posição do zero
    public static int[][] movimentosValidos(int[] posicaoZero) {

        if (posicaoZero[0] == 0 && posicaoZero[1] == 0){
            //array que gurada as posições válidas
            int[][] posicoes = {{0,1},{1,0}};
            //retorna os movimentos válidos
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
    //função utilizada para exibir (imprimir) a matriz que está sendo atualizada
    public static void exibirMatriz(int[][] matriz){
        //criando as divisões na matriz
        for (int i = 0; i < 3; i++) {
            System.out.println(" --- --- ---");
            System.out.print("|");

            for (int j = 0; j < 3; j++) {
                if(matriz[i][j] != 0){
                    System.out.print(" " + matriz[i][j] + " ");
                } else {
                    System.out.print("   ");
                }
                System.out.print("|");

            }
            System.out.println();

        }
        System.out.println(" --- --- ---");
    }

    //função que atribui a nova posição de zero dentro da matriz de acordo com a jogada do usuário
    public static void movimento(int[] jogada,int[][] matriz){
        
        //guarda a posição anterior do zero
        int[]posicaoAnteriorZero = posicaoZero;
        
        //guarda o número escolhido pelo usuário para que essa se torne a nova posição de zero
        int valorFuturaPosicaoZero = matriz[jogada[0]][jogada[1]];
        
        //movendo o zero para a nova posição 
        matriz[jogada[0]][jogada[1]] = 0;
        
        //movendo o número para a antiga posição de zero
        matriz[posicaoAnteriorZero[0]][posicaoAnteriorZero[1]] = valorFuturaPosicaoZero;
        
        //atualizando o valor da nova posição
        posicaoZero[0] = jogada[0];
        posicaoZero[1] = jogada[1];


    }

    //função para embaralhar os números de acordo com o nível de dificuldade escolhido pelo usuário
    public static int[][] embaralharJogo(int numMovimentos,int[][] matriz){

        //método de sorteio
        Random sorteio = new Random();

        for (int i = 0; i < numMovimentos ; i++) {

            //guarda quais são as posições validas retornadas pela função "movimentosValidos"
            int[][] posicoes = movimentosValidos(posicaoZero);

            //sorteia uma posição de acordo com a quantidade de possibilidades 
            int posicaoSorteada = sorteio.nextInt(0,posicoes.length);

            //guarda a posição sorteada 
            int[] jogada = posicoes[posicaoSorteada];

            //chama a função "movimento" para realizar as trocas de posição na matriz 
            movimento(jogada, matriz);

        }
        //retorna a matriz embaralhada 
        return matriz; 
    }
    
    //função que retorna se o usuário ganhou ou não
    public static boolean acertou(int[][] matrizPadrao, int[][] matriz){
        //Variaveis matrizPadrao
        String matrizPadraoElementos;
        String matrizPadraoString = "";

        //Variaveis matrizFinal
        String matrizFinalElementos;
        String matrizFinalString = "";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                //Conversão matriz padrao para texto
                matrizPadraoElementos =  Integer.toString(matrizPadrao[i][j]);
                matrizPadraoString +=  matrizPadraoElementos;

                //Conversão matriz final para texto
                matrizFinalElementos =  Integer.toString(matriz[i][j]);
                matrizFinalString +=  matrizFinalElementos;

            }
        }

        //Retorna True para se as matrizes forem iguais e False para se as matrizes forem diferentes
        return matrizPadraoString.equals(matrizFinalString);

    }


    //analisa se número que o usuário informou faz um movimento válido
    public static boolean validarJogada(int jogada,int[][] matriz){
        //guarda as posições válidas de acordo com a posição do zero
        int[][] possibilidades = movimentosValidos(posicaoZero);
        
        for (int i = 0; i < possibilidades.length ; i++) {
            //separando cada posibilidade para serem avaliadas individualmente 
            int[] possibilidade = possibilidades[i];
            
            //comparando a escolha do usuario com as posições válidas
            if(jogada == matriz[possibilidade[0]][possibilidade[1]]){
                //se forem iguais, retorna true 
                return true;
            }
        }
        //se forem diferentes, retorna false 
        return false;
    }

    //pegando a posição do número escolhido pelo usuário
    public static int[] posicaoJogada(int jogada,int[][] matriz){
        int[][] posicoes = movimentosValidos(posicaoZero);
        for (int i = 0; i < posicoes.length; i++) {
            int[] posicao = posicoes[i];
            if (matriz[posicao[0]][posicao[1]] == jogada) {
                //retorna a posição da jogada (número escolhido pelo usuário)
                return posicao;
            }
        }
        //nunca entra
        return null;
    }
    public static void iniciarJogo(){
        Scanner entrada = new Scanner(System.in);
        int contaJogadas = 0;
        int[][] matrizPadrao = {
                {1,2,3},
                {4,5,6},
                {7,8,0},
        };

        //matriz inicial com valor fixo
        int[][] matriz = {
                {1,2,3},
                {4,5,6},
                {7,8,0},
        };
        //chamando a função que exibe a matriz. 
        exibirMatriz(matriz);
        System.out.println("Tabuleiro ordenado!\n");


        //armazenando dentro da variável "matriz" a matriz inicial que foi embaralhada. 
        matriz = embaralharJogo(nivelDificuldade(), matriz);
        
        System.out.println("\nTabuleiro embaralhado! Vamos começar o jogo!\n");
        //chamando a função que exibe a matriz
        exibirMatriz(matriz);
        

        System.out.println("Digite o número da peça que deseja mover: \n");

        //enquanto o usuário não ganha o jogo, o laço de repetição é executado
        while(true){
            //armazenando a escolha do usuário dentro da variável 
            int jogada = entrada.nextInt();
            
            //chama a função que analisa se a escolha do jogador é válida
            //se retornar "true", o "if" é executado
            if(validarJogada(jogada, matriz)){

                //função que realiza a mudança de posições
                movimento(posicaoJogada(jogada, matriz), matriz);

                if(acertou(matrizPadrao, matriz)){
                    System.out.println("\nParabéns! Você completou o jogo com " + contaJogadas + " movimentos\n");
                    break;
                }
                contaJogadas++;
            //se a função "validarJogo" retornar "false", ele irá executar o else
            }else {
                System.out.println("Movimento inválido. Tente novamente!");
            }
            //chama a função que exibe a matriz
            exibirMatriz(matriz);
            
            //analisa se o usuário ganhou o jogo a cada movimento que ele realiza

            System.out.println("\nQuantidades de jogadas até agora: " + contaJogadas + "\n");
            System.out.println("\nDigite o número da peça que deseja mover: ");
        }
        //se o usuário ganhar o jogo é encerrado 
        System.out.println("Jogo encerrado");
    }

    //função que exibe as intruções de jogo 
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
        //instânciando o Scanner 
        Scanner entrada = new Scanner(System.in);

        System.out.println(
                "      Bem vindo ao Racha Cuca \n - Sair - (0) \n - Deseja iniciar um novo jogo - (1) \n - Instruções de jogo - (2) \n ");
        
        //armazenando a escolha do usuário dentro da variável 
        int escolha = entrada.nextInt();

        //chamando uma função específica de acordo com a escolha do usuário 
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
        //chama a função menu 
        menu();
    }
}