package PROVA_LPA;

import java.util.Random;

public class BatalhaNaval {

    String nome;
    int idade;
    int pontuacao = 0;

    public BatalhaNaval(String nome, int idade, int pontuacao) {
        this.nome = nome;
        this.idade = idade;
        this.pontuacao = pontuacao;
    }

    public void imprimirParticipante() {
        System.out
                .println("Nome: " + this.nome + '\n' + "Idade: " + this.idade + '\n' + "Pontuação: " + this.pontuacao);
    }

    private static boolean vitoriaJogador(char[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == 'n') {
                    return false; // Se ainda tem um navio, o jogador não venceu
                }
            }
        }
        return true; // Se não há navios ,o jogador ganhou
    }

    public static void main(String[] args) {
        Random r = new Random();

        String[] nomes = {
                "Ethan", "Olivia", "Xavier", "Zoe", "Jackson",
                "Lily", "Caleb", "Maya", "Aiden", "Scarlett",
                "Mason", "Ava", "Noah", "Grace", "Liam",
                "Sophia", "Lucas", "Isabella", "Carter", "Ella",
                "Logan", "Amelia", "Owen", "Harper", "Elijah",
                "Abigail", "Gabriel", "Emily", "Brayden", "Chloe",
                "Wyatt", "Addison", "Jayden", "Penelope", "Henry",
                "Mia", "Levi", "Natalie", "Oliver", "Aria",
                "Caleb", "Zoey", "Colton", "Aurora", "Sebastian",
                "Isla", "Daniel", "Victoria", "Dylan", "Savannah" };

        // Seleção aleatória de nomes para os jogadores
        int indice = r.nextInt(nomes.length);
        int indice2 = r.nextInt(nomes.length);
        String jogador1 = nomes[indice];
        String jogador2 = nomes[indice2];

        // Criação de dois objetos BatalhaNaval representando os jogadores
        BatalhaNaval partida = new BatalhaNaval(jogador1, r.nextInt(10, 65), 0);
        BatalhaNaval partida2 = new BatalhaNaval(jogador2, r.nextInt(10, 65), 0);

        // Impressão das informações dos jogadores
        partida.imprimirParticipante();
        System.out.println("VS");
        partida2.imprimirParticipante();

        // Criação de objetos Jogada e tabuleiro
        Jogada play = new Jogada();
        char tab[][] = Tabuleiro.criarTabuleiro();
        int nlinha = tab.length;
        int ncoluna = tab[0].length;
        play.linha = nlinha;
        play.coluna = ncoluna;

        // Jogada do jogador 1
        System.out.println("Jogada de " + partida.nome + " :");
        play.jogar(tab);

        // Verificação de vitória e atualização da pontuação
        if (vitoriaJogador(tab)) {
            System.out.println(partida.nome + " venceu!");
            partida.pontuacao = partida.pontuacao + 1;
            partida.imprimirParticipante();
        } else {
            System.out.println(partida2.nome + " venceu!");
            partida2.pontuacao = partida2.pontuacao + 1;
            partida2.imprimirParticipante();

        }

    }
}
