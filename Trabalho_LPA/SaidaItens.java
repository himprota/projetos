package Trabalho_LPA;

import java.util.List;

import javax.swing.JOptionPane;

public class SaidaItens extends EntradaItens {
    String cliente;
    int total;

    // Construtor da classe

    public SaidaItens(int codigo, String nome, String fornecedor, int quantidade, String local, double valor,
            String cliente, int total) {
        super(codigo, nome, fornecedor, quantidade, local, valor);
        this.cliente = cliente;
        this.total = total;
    }

    // Método para imprimir os detalhes da saída do item

    void imprimirSaida() {
        String mensagem = String.format(
                "%nCódigo do Produto: %d%nNome do Produto: %s %nNome do cliente: %s %nQuantidade: %d %n Total de itens comprados: %d %n",
                this.codigo, this.nome, this.cliente, this.quantidade, this.total);

        // Exibição da mensagem usando JOptionPane

        JOptionPane.showMessageDialog(null, mensagem, "Detalhes do produto", JOptionPane.INFORMATION_MESSAGE);

    }

    // Método estático para realizar a compra de um item

    static void comprarItem(List<EntradaItens> itens, List<EntradaItens> itens2) {

        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do produto para compra "));
        for (EntradaItens item : itens) {
            if (item.codigo == codigo) {
                item.imprimirItem();

                // Entrada da quantidade desejada para compra e nome do cliente

                int quantidadeCompra = Integer.parseInt(JOptionPane.showInputDialog("Quantos deseja comprar? "));
                String cliente = JOptionPane.showInputDialog("Qual o seu nome?");

                // Verificação da disponibilidade em estoque

                if (quantidadeCompra > item.quantidade) {

                    JOptionPane.showMessageDialog(null,
                            "Impossível comprar! Quantidade de compra maior que no estoque");
                } else {
                    // Atualização da quantidade em estoque e criação de um novo objeto SaidaItens

                    item.quantidade = item.quantidade - quantidadeCompra;
                    int totalCompra = quantidadeCompra;
                    SaidaItens saidaItem = new SaidaItens(codigo, item.nome, item.fornecedor, item.quantidade,
                            item.local, item.valor, cliente, totalCompra);
                    // Impressão dos detalhes da saída do item

                    saidaItem.imprimirSaida();
                }
            } 

        }

        // Repetição do mesmo processo para a segunda lista de itens (itens2)

        for (EntradaItens item : itens2) {
            if (item.codigo == codigo) {
                item.imprimirItem();
                int quantidadeCompra = Integer.parseInt(JOptionPane.showInputDialog("Quantos deseja comprar? "));
                String cliente = JOptionPane.showInputDialog("Qual o seu nome?");

                if (quantidadeCompra > item.quantidade) {

                    JOptionPane.showMessageDialog(null,
                            "Impossível comprar! Quantidade de compra maior que no estoque");
                } else {

                    item.quantidade = item.quantidade - quantidadeCompra;
                    int totalCompra = quantidadeCompra;
                    SaidaItens saidaItem = new SaidaItens(codigo, item.nome, item.fornecedor, item.quantidade,
                            item.local, item.valor, cliente, totalCompra);

                    saidaItem.imprimirSaida();
                }
            }
        }

    }
}
