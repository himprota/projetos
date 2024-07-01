package Trabalho_LPA;

import java.util.Calendar;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class EntradaItens {

    // Atributos da classe
    public int codigo;
    public String nome;
    Date data;
    String fornecedor;
    public int quantidade;
    String local;
    double valor;

    public EntradaItens(int codigo, String nome, String fornecedor, int quantidade, String local,
            double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.data = gerarData(); // Inicializa a data chamando o método gerarData()
        this.fornecedor = fornecedor;
        this.quantidade = quantidade;
        this.local = local;
        this.valor = valor;
    }

    static Date gerarData() {
        Random r = new Random();
        // Gerar um ano aleatório entre o ano minimo e o maximo
        int anoRandom = r.nextInt(2006, 2023);

        // Gerando um mes aleatorio (1-12)
        int mesRandom = r.nextInt(12) + 1;

        // Gerando um dia aleatorio (1-31)
        int diaRandom = r.nextInt(31) + 1;

        // Criando um objeto calendario com um ano, mes e dia aleatorio
        Calendar DataRandom = Calendar.getInstance();
        DataRandom.set(anoRandom, mesRandom - 1, diaRandom);

        // Convertendo o objeto calendário para uma data
        Date dataValidade = DataRandom.getTime();

        System.out.print("Data de Fabricação: " + dataValidade);

        return dataValidade;
    }

    // Método para imprimir os detalhes do item
    void imprimirItem() {
        String mensagem = String.format(
                "Código do Produto: %d%nNome do Produto: %s %nFornecedor: %s %nQuantidade: %d %nLocal de Armazenagem: %s %nValor de compra: %.2f R$ %nData: %s",
                this.codigo, this.nome, this.fornecedor, this.quantidade, this.local,
                this.valor, this.data); // formatar e exibir os detalhes do item

        JOptionPane.showMessageDialog(null, mensagem, "Detalhes do produto", JOptionPane.INFORMATION_MESSAGE); // mensagem
                                                                                                               // para
                                                                                                               // exibição
                                                                                                               // do
                                                                                                               // item

    }

    // Método estático para cadastrar itens em duas listas diferentes
    static void cadastrarItem(List<EntradaItens> itens, List<EntradaItens> itens2) {
        Random r = new Random();
        EntradaItens lista[] = new EntradaItens[100];

        // criação de um vetor computador para ser utilizado na criacao dos produtos
        String computador[] = { "Processador",
                "Placa de Vídeo",
                "Placa-Mãe",
                "Memória RAM",
                "Armazenamento SSD",
                "Armazenamento HDD",
                "Fonte de Alimentação",
                "Gabinete",
                "Ventoinha de Resfriamento",
                "Memória",
                "Armazenamento",
                "Resfriamento CPU",
                "Resfriamento GPU",
                "Chipset da Placa-Mãe",
                "Placa de Rede",
                "Placa de Som",
                "Unidade Óptica",
                "Ventoinha do Sistema",
                "Chassi",
                "Monitor de Computador",
                "Teclado",
                "Mouse",
                "Caixas de Som",
                "Webcam",
                "Impressora",
                "Scanner",
                "Roteador",
                "Modem",
                "Fones de Ouvido",
                "Microfone",
                "Pen Drive",
                "HD Externo",
                "HD Interno",
                "Unidade Central de Processamento",
                "Placa de Vídeo",
                "Placa-Mãe",
                "Módulo de Memória",
                "Dispositivo de Armazenamento",
                "Sistema de Resfriamento",
                "Unidade de Alimentação",
                "Caixa de Computador",
                "Dispositivos Periféricos",
                "Dispositivos de Entrada",
                "Dispositivos de Saída",
                "Dispositivos de Rede",
                "Dispositivos de Áudio",
                "Dispositivos de Armazenamento",
                "Placas de Interface", };

        // criação de um vetor eletronicos para ser utilizado na criacao dos produtos
        String eletronicos[] = { "Smartphone",
                "Tablet",
                "Televisão",
                "Camera digital",
                "Fones de ouvido",
                "Caixas de som Bluetooth",
                "Smartwatch",
                "Console de videogame",
                "Microondas",
                "Geladeira",
                "Maquina de lavar roupa",
                "Secadora de roupas",
                "Arcondicionado",
                "Aspirador de pó robô",
                "Roteador Wi-Fi",
                "Projetor",
                "Camera de seguranca",
                "Lampadas inteligentes",
                "Chromecast",
                "Impressora 3D",
                "Auriculares sem Fio",
                "Carregador Portatil",
                "Drone",
                "Robo de Limpeza",
                "Console de Jogos Portatil",
                "Oculos de Realidade Virtual",
                "Barra de Som",
                "Monitor de Bebê",
                "Relogio Inteligente",
                "Termometro Infravermelho",
                "Cafeteira Inteligente",
                "Balanca Inteligente",
                "Maquina de Cafe Expresso",
                "Caixa de Som Inteligente",
                "Lampada Conectada",
                "E-reader",
                "Ventilador Inteligente",
                "Cadeado Inteligente",
                "Camera de Acao",
                "Forno Eletrico",
                "Alto-falante Bluetooth",
                "Fita LED Inteligente",
                "Mouse Gamer",
                "Teclado Mecânico",
                "Monitor Gamer",
                "Headset para Jogos",
                "Cadeira Gamer",
                "Controle Remoto Inteligente",
                "Assistente Virtual",
                "Relógio Despertador Inteligente" };

        // criação de um vetor fornecedor para ser utilizado na criacao dos produtos
        String fornecedor[] = { "Intel",
                "AMD",
                "Nvidia",
                "ASUS",
                "MSI",
                "Gigabyte",
                "EVGA",
                "Corsair",
                "Crucial",
                "Kingston",
                "Samsung",
                "Western Digital",
                "Seagate",
                "NZXT",
                "Cooler Master",
                "Thermaltake",
                "Fractal Design",
                "ASRock",
                "Biostar",
                "Aorus",
                "Electrolux",
                "Samsung",
                "Panasonic",
                "Bosch",
                "LG",
                "Sony",
        };

        for (int i = 0; i < lista.length; i++) {

            int aleatorio = r.nextInt(computador.length); // pegando um dos elementos aleatoriamente do vetor
                                                          // computadores
            int fornecedoraleatorio = r.nextInt(fornecedor.length); // pegando um dos elementos aleatoriamente do vetor
                                                                    // fornecedor
            String fornecedores = fornecedor[fornecedoraleatorio];
            String computadores = computador[aleatorio];

            EntradaItens item = new EntradaItens(i + 1, computadores, fornecedores,
                    r.nextInt(1, 10000), "Pecas de computador", r.nextDouble(1, 1000));
            // atribuindo variaveis no construtor
            // se for selecionado um elemento do vetor computadores, o local é setado como
            // "peças de computador"
            itens.add(item); // criando o item

        }
        for (int i = 0; i < lista.length; i++) {
            int aleatorio = r.nextInt(eletronicos.length); // pegando um dos elementos aleatoriamente do vetor
                                                           // eletronicos
            int fornecedorAleatorio = r.nextInt(fornecedor.length); // pegando um dos elementos aleatoriamente do vetor
                                                                    // fornecedor
            String fornecedorEscolhido = fornecedor[fornecedorAleatorio];
            String eletronicoEscolhido = eletronicos[aleatorio];

            EntradaItens item2 = new EntradaItens(i + 101, eletronicoEscolhido, fornecedorEscolhido,
                    r.nextInt(1, 10000), "Eletronicos", r.nextDouble(1, 500));
            // atribuindo variaveis no construtor
            // se for selecionado um elemento do vetor eletronicos, o local é setado como
            // "Eletronicos"
            itens2.add(item2);

        }
        JOptionPane.showMessageDialog(null, "200 itens foram cadastrados"); // mostra uma mensagem indicando que 200
                                                                            // itens foram cadastrados
    };

    static void pesquisarItemPorCodigo(List<EntradaItens> itens, List<EntradaItens> itens2) {
        boolean encontrado = false;

        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto "));

        // apos usuario digitar o codigo, as 2 listas sao percorridas e o codigo
        // inserido é comparado aos codigos presentes nas 2 listas
        // se for encontrado, o item com o mesmo codigo será impresso
        for (EntradaItens item : itens) {
            if (item.codigo == codigo) {
                item.imprimirItem();
                encontrado = true;
                break;
            }
        }
        // apos usuario digitar o codigo, as 2 listas sao percorridas e o codigo
        // inserido é comparado aos codigos presentes nas 2 listas
        // se for encontrado, o item com o mesmo codigo será impresso
        for (EntradaItens item : itens2) {
            if (item.codigo == codigo) {
                item.imprimirItem();
                encontrado = true;
                break;
            }

        }

        // se o item nao for encontrado pelo codigo, sera necessario cadastrá-lo

        if (!encontrado) {
            try {
                JOptionPane.showMessageDialog(null, "Produto não encontrado, cadastre-o");

                int codigoItem = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do item")); // janela de
                                                                                                            // dialogo
                                                                                                            // para
                                                                                                            // inserir
                                                                                                            // codigo do
                                                                                                            // item
                String nomeItem = JOptionPane.showInputDialog("Informe o nome do produto"); // janela de dialogo para
                                                                                            // inserir nome do item
                String fornecedorItem = JOptionPane.showInputDialog("Informe o fornecedor do produto"); // janela de
                                                                                                        // dialogo para
                                                                                                        // inserir
                                                                                                        // fornecedor do
                                                                                                        // item
                int quantidadeItem = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade")); // janela de
                                                                                                            // dialogo
                                                                                                            // para
                                                                                                            // inserir
                                                                                                            // quantidade
                                                                                                            // do item
                String armazenamentoItem = JOptionPane.showInputDialog("Informe o local de armazenamento"); // janela de
                                                                                                            // dialogo
                                                                                                            // para
                                                                                                            // inserir
                                                                                                            // local de
                                                                                                            // armazenamento
                                                                                                            // do item
                double valorItem = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor do item")); // janela
                                                                                                             // de
                                                                                                             // dialogo
                                                                                                             // para
                                                                                                             // inserir
                                                                                                             // preço do
                                                                                                             // item
                EntradaItens novoItem = new EntradaItens(codigoItem, nomeItem, fornecedorItem,
                        quantidadeItem, armazenamentoItem,
                        valorItem); // criando o item com base no que o usuario digitou
                itens.add(novoItem);

                novoItem.imprimirItem();

            } catch (ConcurrentModificationException cme) {
                JOptionPane.showMessageDialog(null, "Item adicionado!"); // tratamento de erro,pois como estamos
                                                                         // adicionando mais um elemento a uma lista
                                                                         // criada de maneira inesperada, ao inves de
                                                                         // mostrar o erro, a mensagem "item adicionado"
                                                                         // será disponibilizada

            }
        }

    }

    static void pesquisarItemPorNome(List<EntradaItens> itens, List<EntradaItens> itens2) {
        boolean encontrado = false;
        String nome = (JOptionPane.showInputDialog("Qual o nome do produto? "));

        // apos usuario digitar o nome do produto, as 2 listas sao percorridas e o nome
        // inserido é comparado aos nomes presentes nas 2 listas
        // se for encontrado, o item com o mesmo nome será impresso

        for (EntradaItens item : itens) {
            if (item.nome.equals(nome.trim())) {

                item.imprimirItem();
                encontrado = true;
            }
        }
        // apos usuario digitar o nome do produto, as 2 listas sao percorridas e o nome
        // inserido é comparado aos nomes presentes nas 2 listas
        // se for encontrado, o item com o mesmo nome será impresso
        for (EntradaItens item : itens2) {
            if (item.nome.equals(nome.trim())) {

                item.imprimirItem();
                encontrado = true;
            }

        }
        // se o item nao for encontrado pelo nome, sera necessario cadastrá-lo
        if (!encontrado) {
            try {
                JOptionPane.showMessageDialog(null, "Produto não encontrado, cadastre-o");

                int codigoItem = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do item")); // janela de
                                                                                                            // dialogo
                                                                                                            // para
                                                                                                            // inserir
                                                                                                            // codigo do
                                                                                                            // item
                String nomeItem = JOptionPane.showInputDialog("Informe o nome do produto"); // janela de dialogo para
                                                                                            // inserir nome do item
                String fornecedorItem = JOptionPane.showInputDialog("Informe o fornecedor do produto"); // janela de
                                                                                                        // dialogo para
                                                                                                        // inserir
                                                                                                        // fornecedor do
                                                                                                        // item
                int quantidadeItem = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade")); // janela de
                                                                                                            // dialogo
                                                                                                            // para
                                                                                                            // inserir
                                                                                                            // quantidade
                                                                                                            // do item
                String armazenamentoItem = JOptionPane.showInputDialog("Informe o local de armazenamento"); // janela de
                                                                                                            // dialogo
                                                                                                            // para
                                                                                                            // inserir
                                                                                                            // local de
                                                                                                            // armazenamento
                                                                                                            // do item
                double valorItem = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor do item")); // janela
                                                                                                             // de
                                                                                                             // dialogo
                                                                                                             // para
                                                                                                             // inserir
                                                                                                             // preço do
                                                                                                             // item
                EntradaItens novoItem = new EntradaItens(codigoItem, nomeItem, fornecedorItem,
                        quantidadeItem, armazenamentoItem,
                        valorItem); // criando o item com base no que o usuario digitou
                itens.add(novoItem);

                novoItem.imprimirItem(); // imprimindo o item recentemente criado

            } catch (ConcurrentModificationException cme) {
                JOptionPane.showMessageDialog(null, "Item adicionado!"); // tratamento de erro,pois como estamos
                                                                         // adicionando mais um elemento a uma lista
                                                                         // criada de maneira inesperada, ao inves de
                                                                         // mostrar o erro, a mensagem "item adicionado"
                                                                         // será disponibilizada

            }
        }

    }
}
