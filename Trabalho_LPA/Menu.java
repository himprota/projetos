package Trabalho_LPA;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Menu {

    public static void main(String[] args) {
        // Listas para armazenar itens e funcionários
        List<EntradaItens> itens = new ArrayList<>();
        List<EntradaItens> itens2 = new ArrayList<>();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        // Variável para armazenar a soma dos salários dos funcionários

        double somaSalarios = Funcionario.somaSalarios;

        // Variável para armazenar a escolha do usuário no menu

        int opcao;

        try {
            do {
                // Exibe opções do menu e obtém a escolha do usuário
                opcao = Integer.parseInt((JOptionPane.showInputDialog(
                        null,
                        "1. Cadastrar Itens \n"
                                + "2. Pesquisar Item por Código \n" + "3. Pesquisar Item por Nome \n"
                                + "4. Comprar Item \n" + "5. 100% do Estoque Mensal \n"
                                + "6. Produção Diária \n" + "7. Produção Anual \n"
                                + "8. Setor de funcionários \n" + "9. Gastos da empresa\n",
                        "O que deseja consultar na empresa?",
                        JOptionPane.INFORMATION_MESSAGE)));

                // Switch para lidar com a escolha do usuário

                switch (opcao) {
                    case 1:
                        // Chama o método para cadastrar itens
                        EntradaItens.cadastrarItem(itens, itens2);
                        break;

                    case 2:
                        // Chama o método para pesquisar itens por código
                        EntradaItens.pesquisarItemPorCodigo(itens, itens2);
                        break;
                    case 3:
                        // Chama o método para pesquisar itens por nome
                        EntradaItens.pesquisarItemPorNome(itens, itens2);
                        break;
                    case 4:
                        // Chama o método para comprar itens
                        SaidaItens.comprarItem(itens, itens2);
                        break;
                    case 5:
                        // Chama o método para exibir a produção total
                        Estoque.totalProducao();
                        break;
                    case 6:
                        // Chama o método para exibir a produção diária
                        Estoque.producaoDiaria(33333);
                        break;
                    case 7:
                        // Chama o método para exibir a produção anual
                        Estoque.producaoAnual(33333);
                        break;
                    case 8:
                        // Chama o método para cadastrar funcionários
                        Funcionario.cadastrarFuncionario(funcionarios);
                        break;
                    case 9:
                        // Chama o método para calcular as despesas fixas
                        Financeiro.calcularDespesasFixas(funcionarios, somaSalarios);
                        break;

                    default:
                        // Exibe mensagem para opção inválida
                        JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente");

                }

            } while (opcao != 8); // Continua o loop até que o usuário escolha sair
        } catch (NumberFormatException nfe) {
            // Trata a exceção de formato numérico (por exemplo, se o usuário cancelar a
            // operação)

            // Encerra o programa
            System.exit(0);
        }

    }

}
