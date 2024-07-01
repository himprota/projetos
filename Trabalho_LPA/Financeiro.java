package Trabalho_LPA;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Financeiro {
    public double gastoTotal;

    // Método estático para calcular as despesas fixas
    static double calcularDespesasFixas(ArrayList<Funcionario> funcionarios, double somaSalarios) {
        Random r = new Random();

        // Gerar valores aleatórios para as despesas de água, luz e impostos

        double gastosAgua = r.nextDouble(2500, 7000);
        double gastosLuz = r.nextDouble(5000, 9000);
        double impostos = r.nextDouble(6000, 8000);

        // Calcular o gasto total somando todas as despesas
        double gastoTotal = gastosAgua + gastosLuz + somaSalarios + impostos;

        // Criar uma mensagem formatada com os detalhes das despesas
        String mensagem = String.format(
                "Gastos de água: %.2f R$%nGastos de luz: %.2f R$%nSalário dos empregados: %.2f R$%nImpostos: %.2f R$%nGasto total: %.2f R$",
                gastosAgua, gastosLuz, somaSalarios, impostos, gastoTotal);

        // Exibir a mensagem usando um JOptionPane
        JOptionPane.showMessageDialog(null, mensagem, "Gastos da empresa", JOptionPane.INFORMATION_MESSAGE);

        // Perguntar ao usuário se deseja ver o custo operacional
        int opcao = JOptionPane.showConfirmDialog(null, "Gostaria de ver o custo operacional?", "Confirmação",
                JOptionPane.YES_NO_CANCEL_OPTION);

        // Se o usuário escolher sim, chamar o método custoOperacional, senão, voltar ao
        // Menu
        if (opcao == JOptionPane.YES_OPTION) {
            custoOperacional(gastoTotal);

        } else {
            Menu.main(null);
        }
        // retornar o gasto total
        return gastoTotal;

    }

    // Método estático para calcular o custo operacional

    static double custoOperacional(double gastototal) {
        // Solicitar ao usuário a quantidade de pallets mensais
        int palletMensal = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de pallets mensais"));

        // Calcular o custo de cada pallet individual
        double custoPallet = gastototal / palletMensal;

        // Criar uma mensagem formatada com o custo por pallet
        String mensagem = String.format(
                "O custo de cada pallet individual é: %.2f R$%n",
                custoPallet);

        // Exibir a mensagem usando um JOptionPane
        JOptionPane.showMessageDialog(null, mensagem, "Informação Pallets", JOptionPane.INFORMATION_MESSAGE);

        // Retornar o custo por pallet
        return custoPallet;

    }

}
