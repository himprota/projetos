package PROVA_LPA;

import java.util.Scanner;

public class Jogada {
    // Scanner para leitura de entrada do usuário
    Scanner sc = new Scanner(System.in);
    // Inicialização das variáveis de linha e coluna
    int linha = 0;
    int coluna = 0;

    // Método para realizar as jogadas no tabuleiro
    public void jogar(char criarTabuleiro[][]) {
        // Variáveis para controle do número de navios restantes e do contador de
        // jogadas
        int navio = 5, contador = 0;

        // Loop principal do jogo
        while (navio > 0) {
            contador++;
            int jogadaLinha, jogadaColuna;

            // Solicita e valida a entrada da linha da jogada
            do {
                System.out.println("Faça sua jogada\nEscolha a posição da linha: ");
                jogadaLinha = sc.nextInt() - 1;
                if (jogadaLinha >= linha || jogadaLinha < 0) {
                    System.out.println("Posição inválida");
                    System.out.println();
                }
            } while (jogadaLinha >= linha || jogadaLinha < 0);

            // Solicita e valida a entrada da coluna da jogada
            do {
                System.out.println("Escolha a posição da coluna: ");
                jogadaColuna = sc.nextInt() - 1;
                if (jogadaColuna >= coluna || jogadaColuna < 0) {
                    System.out.println("Posição inválida");
                    System.out.println();
                }
            } while (jogadaColuna >= coluna || jogadaColuna < 0);

            // Avalia o resultado da jogada e atualiza o tabuleiro
            if (criarTabuleiro[jogadaLinha][jogadaColuna] == 'n') {
                criarTabuleiro[jogadaLinha][jogadaColuna] = 'x';
                printTabuleiro(criarTabuleiro);
                System.out.println("Você acertou!\n\n");
                navio--;
            } else if (criarTabuleiro[jogadaLinha][jogadaColuna] == 'a') {
                criarTabuleiro[jogadaLinha][jogadaColuna] = 'o';
                printTabuleiro(criarTabuleiro);
                System.out.println("Você errou!\n\n");
            } else {
                System.out.println("Essa posição já foi atacada\n\n");
            }
        }
        // Mensagem de vitória ao final do jogo
        System.out.println("Você venceu com " + contador + " tentativas");
    }

    // Método privado para imprimir o tabuleiro
    private void printTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int k = 0; k < tabuleiro[i].length; k++) {
                if (tabuleiro[i][k] == 'x') {
                    System.out.print("X  ");
                } else if (tabuleiro[i][k] == 'o') {
                    System.out.print("O  ");
                } else {
                    System.out.print("~  ");
                }
            }
            System.out.println();
        }
    }

}
