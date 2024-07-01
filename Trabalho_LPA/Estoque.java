package Trabalho_LPA;

import javax.swing.JOptionPane;

public class Estoque {

    static void totalProducao() {
        int porcento30 = 10000;
        int valortotal = (porcento30 * 100) / 30;
        JOptionPane.showMessageDialog(null, "100% da produção equivale a: " + valortotal + " unidades / mês",
                "Produção total", JOptionPane.INFORMATION_MESSAGE);
        // tambem equivale a produção mensal

    }

    static int producaoDiaria(int valortotal) {
        int diaria = valortotal / 30;
        JOptionPane.showMessageDialog(null, "A produção diária é de : " + diaria + " unidades / dia", "Produção Diária",
                JOptionPane.INFORMATION_MESSAGE);
        return diaria;

        // divide-se o valor da produção mensal por 30
        // para encontrar producao diaria
    }

    static int producaoAnual(int valortotal) {
        int anual = valortotal * 12;
        JOptionPane.showMessageDialog(null, "A produção anual é de : " + anual + " unidades / ano", "Produção Anual",
                JOptionPane.INFORMATION_MESSAGE);
        System.out.println(" A produção anual é de  : " + anual + " unidades / ano");
        return anual;

        // multiplica valor da produção mensal por 12
        // para encontrar producao anual

    }
}
