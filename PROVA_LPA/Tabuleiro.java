package PROVA_LPA;

import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {
    // Método para criar o tabuleiro do jogo
    public static char[][] criarTabuleiro() {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int linha = 0, coluna = 0;

        // Solicita ao usuário o número de linhas e colunas do tabuleiro até que tenha
        // pelo menos 5 espaços
        while (linha * coluna < 5) {
            System.out.println("Digite o número de linhas do tabuleiro");
            linha = sc.nextInt();
            System.out.println("Digite o número de colunas do tabuleiro");
            coluna = sc.nextInt();

            if (linha * coluna < 5) {
                System.out.println("O tabuleiro precisa ter no mínimo 5 espaços");
                pulaLinha();
                sc.close();
            }
        }

        // Cria uma matriz para representar o tabuleiro com o tamanho especificado
        char tab[][] = new char[linha][coluna];
        int linha1, coluna1;

        // Preenche aleatoriamente 5 espaços na matriz com os navios
        for (int i = 0; i < 5; i++) {
            linha1 = r.nextInt(linha);
            coluna1 = r.nextInt(coluna);

            // Garante que não haja repetição na posição escolhida
            if (tab[linha1][coluna1] == 'n') {
                i--;
            } else {
                tab[linha1][coluna1] = 'n';
            }
        }

        // Preenche o restante da matriz com 'a'
        for (int j = 0; j < linha; j++) {
            for (int k = 0; k < coluna; k++) {
                if (tab[j][k] != 'n') {
                    tab[j][k] = 'a';
                }
            }
        }

        // Imprime o tabuleiro com '~' para representar a água
        for (int j = 0; j < linha; j++) {
            for (int k = 0; k < coluna; k++) {
                System.out.print("~ ");
            }
            pulaLinha();
        }

        return tab;
    }

    // Método auxiliar para pular uma linha na saída
    public static void pulaLinha() {
        System.out.println();
        
    }
    

}
