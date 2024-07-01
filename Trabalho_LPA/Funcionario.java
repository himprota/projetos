package Trabalho_LPA;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

//bibliotecas usadas nessa parte do codigo
// aqui é feito a declaração de variaveis da classe funcionario
//do tipo public porque sera acessado apenas pela classe

public class Funcionario extends Menu {

    public String nome;
    public long cpf;
    public long rg;
    public String endereco;
    public long telefone;
    public int qtd_filhos;
    private double salarioBruto;
    private double desconto;
    private double impostoIRPF;
    private double salarioLiquido;
    public double salarioLiquidoFinal;
    private boolean calculoRealizado;
    public static double somaSalarios;

    // aqui é feito o construtor da classe funcionario, que vai receber diversos
    // tipos de dados
    // para serem manipulados no decorrer do programa

    public Funcionario(String nome, long cpf, long rg, String endereco, long telefone, int qtd_filhos,
            double salarioBruto, double desconto, double impostoIRPF, double salarioLiquido,
            double salarioLiquidoFinal) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.telefone = telefone;
        this.qtd_filhos = qtd_filhos;
        this.salarioBruto = salarioBruto;
        this.desconto = desconto;
        this.impostoIRPF = impostoIRPF;
        this.salarioLiquido = salarioLiquido;
        this.salarioLiquidoFinal = salarioLiquidoFinal;
        this.calculoRealizado = false;
    }

    // Funcão sem retorno apenas para imprimir os funcionários quando chamada

    void imprimirFuncionario() {
        String mensagem = String.format(
                "Nome: %s%nCPF: %d %nRG: %d %nEndereço: %s %nTelefone: %d %nFilhos: %d %nSalário Bruto: %.2f %nDesconto: %.2f %nImposto IRPF: %.2f %nSalário Liquido: %.2f %nSalário Liquido Final: %.2f %n",
                this.nome, this.cpf, this.rg, this.endereco, this.telefone,
                this.qtd_filhos, this.salarioBruto, this.desconto, this.impostoIRPF, this.salarioLiquido,
                this.salarioLiquidoFinal);

        JOptionPane.showMessageDialog(null, mensagem, "Detalhes do funcionário", JOptionPane.INFORMATION_MESSAGE);

    }

    static void cadastrarFuncionario(ArrayList<Funcionario> funcionarios) { // uma função para cadastrar os funcionarios
        int i = 0;
        Random r = new Random();
        boolean continuar = true;

        // dentro função é usado diversas vetores com nomes, cpfs, telefones, rgs, e
        // endereco e filhos

        String[] nomes = { "marcus", "filipe", "murilo", "hugo", "debora", "maria", "paulo", "roberto",
                "guilherme", "fred", "clark", "amanda", "jorge", "gabriel", "patrick", "renata", "penelope", "nolan",
                "mark", "cristina", "maria", "bruno", "ricardo", "jonas" };

        long[] cpf = { 521463278, 521463111, 521463555, 521463244, 521463200, 521463972, 521463158,
                521463482, 521463277, 521851278, 521463111, 521463142, 521463153, 521463178, 521463133, 521463421,
                521463000, 521463030, 521463040, 521463050 };

        long[] rg = { 521463000, 521463511, 521463444, 521463244, 222463200, 333463972, 444463158,
                331463482, 521463211, 521851278, 521463111, 521463142, 521463153, 521463178, 521463133, 521463455,
                521463000, 521463888, 521463999, 521003050 };

        long[] telefones = { 711463000, 521463511, 711463444, 711463244, 712463200, 713463972, 714463158,
                711463482, 711463211, 711851278, 711463111, 711463142, 711463153, 711463178, 711463133, 711463455,
                711463000, 711463888, 711463999, 711003050 };

        String[] enderecos = { "Avenida Sete de Setembro", "Rua Chile", "Avenida Tancredo Neves",
                "Avenida ACM (Antônio Carlos Magalhães)", "Avenida Garibaldi", "Rua da Paciência",
                "Rua Almirante Marques de Leão", "Avenida Oceânica", "Rua Barão de Itapuã", "Avenida Adhemar de Barros",
                "Rua Conselheiro Pedro Luiz", "Avenida Joana Angélica", "Rua Direita da Piedade",
                "Avenida Manoel Dias da Silva", "Rua Borges dos Reis", "Avenida Vasco da Gama", "Rua Marquês de Queluz",
                "Avenida Juracy Magalhães", "Rua Professor Milton Cayres de Brito", "Avenida São Rafael" };

        int[] filhos = { 5, 4, 2, 3, 1, 2, 4, 1, 2, 1, 2, 3, 1, 2, 1, 2, 0, 0, 0, 2 };

        for (i = 0; i < 20; i++) { // é feito um for para receber todos esses dados

            String nome = nomes[i]; // a variavel nome é a unica que não é passada pelo comando random para evitar
                                    // repetições de nomes

            int indicecpf = r.nextInt(cpf.length);
            long cpfs = cpf[indicecpf];

            int indicerg = r.nextInt(rg.length); // é criado uma variavel indice para percorrer cada um dos vetores mas
                                                 // com a função random é preenchido aleatoriamente os valores
            long rgs = rg[indicerg];

            int indicetelefone = r.nextInt(telefones.length);
            long telefone = telefones[indicetelefone];

            int indiceEnderecos = r.nextInt(enderecos.length);
            String endereco = enderecos[indiceEnderecos];

            int indicefilhos = r.nextInt(filhos.length);
            int filho = filhos[indicefilhos];

            Funcionario funcionario = new Funcionario(nome, cpfs, rgs, endereco, telefone, filho, 0, 0, 0, 0, 0);
            funcionarios.add(funcionario); // no final com o arraylist é realizado o preenchimento de 20 cadastros de
                                           // funcionarios

        }

        while (continuar) { // menu de opções que vai continuar ate chegar a opcão que quebre a condição
            int escolha = Integer.parseInt((JOptionPane.showInputDialog(
                    null,
                    "1. Mostrar funcionarios cadastrados e suas informações \n"
                            + "2. Cadastrar novo funcionário \n" + "3. Calcular salário do funcionario \n"
                            + "4. Mostrar informações completas dos funcionários com salario registrado \n"
                            + "5. Voltar para Menu principal",
                    "SETOR DE FUNCIONÁRIO",
                    JOptionPane.INFORMATION_MESSAGE)));
            try {
                switch (escolha) {

                    case 1:
                        for (Funcionario funcionario : funcionarios) { // no caso 1 o arraylist é lido com a função
                                                                       // imprimir funcionario mostrando todas suas
                                                                       // informações
                            funcionario.imprimirFuncionario();

                        }
                        break;

                    case 2:

                        String nome = (JOptionPane.showInputDialog("Informe o nome do funcionario a ser cadastrado ")); // no
                                                                                                                        // caso
                                                                                                                        // 2
                                                                                                                        // é
                                                                                                                        // perguntado
                                                                                                                        // ao
                                                                                                                        // usuario
                                                                                                                        // um
                                                                                                                        // nome
                                                                                                                        // para
                                                                                                                        // ser
                                                                                                                        // cadastrado
                        boolean funcionarioCadastrado = false; // Se o nome ja estiver no arraylist uma mensagem irá
                                                               // informar que não é possivel e encerra o loop

                        for (Funcionario funcionario : funcionarios) {
                            if (nome.equals(funcionario.nome)) {
                                JOptionPane.showMessageDialog(null, "Esse Funcionario já está cadastrado");
                                funcionario.imprimirFuncionario();
                                funcionarioCadastrado = true;
                                break;
                            }
                        }

                        if (!funcionarioCadastrado) { // caso o nome não seja encontrado o sistema vai requisitar que
                                                      // seja preenchido as informações
                            long cpfs = Long.parseLong(JOptionPane.showInputDialog("Cadastre o CPF")); // o calculo de
                                                                                                       // salario ja vem
                                                                                                       // zerado por
                                                                                                       // padrão
                            long rgs = Long.parseLong(JOptionPane.showInputDialog("Cadastre o RG"));
                            String endereco = JOptionPane.showInputDialog("Informe o endereço");
                            long telefone = Long.parseLong(JOptionPane.showInputDialog("Cadastre o telefone"));
                            int qtd_filhos = Integer
                                    .parseInt((JOptionPane.showInputDialog("Informe a quantidade de filhos")));

                            Funcionario novoFuncionario = new Funcionario(nome, cpfs, rgs, endereco, telefone,
                                    qtd_filhos,
                                    0, 0, 0, 0, 0);

                            funcionarios.add(novoFuncionario);
                            novoFuncionario.imprimirFuncionario();

                        }
                        break;
                    case 3:
                        boolean calcularOutro = true;
                        do {
                            String Nome = JOptionPane
                                    .showInputDialog("Digite o nome do funcionario que deseja procurar"); // Solicita o
                                                                                                          // nome do
                                                                                                          // funcionário
                            boolean encontrada = false; // Flag para indicar se o nome do funcionário foi encontrado
                            for (Funcionario func : funcionarios) { // Itera sobre a lista de funcionários para
                                                                    // encontrar o funcionário com o nome fornecido
                                if (Nome.equals(func.nome)) { // Se o nome do funcionário for encontrado, realiza o
                                                              // cálculo do salário
                                    func.imprimirFuncionario(); // Exibe informações do funcionário
                                    encontrada = true;
                                    String funcao = JOptionPane.showInputDialog(
                                            "Qual a sua função na empresa? (operario, supervisor, gerente, diretor)"); // Solicita
                                                                                                                       // a
                                                                                                                       // função
                                                                                                                       // do
                                                                                                                       // funcionário
                                                                                                                       // na
                                                                                                                       // empresa

                                    double salariobruto = 0;
                                    double salarioLiquido = 0;
                                    double impostoIRPF = 0; // Variáveis para armazenar informações sobre o salário
                                                            // ainda zeradas
                                    double desconto = 0;
                                    double salarioLiquidoFinal = 0;

                                    if (funcao.equals("operario")) { // se o usuario digitar operario entra nessa
                                                                     // condição
                                        double hora = Double.parseDouble(JOptionPane
                                                .showInputDialog("Informe a quantidade de horas trabalhadas no mês")); // solicita
                                                                                                                       // a
                                                                                                                       // quantidade
                                                                                                                       // de
                                                                                                                       // horas
                                                                                                                       // do
                                                                                                                       // mes
                                        double valorHoraOperario = 15.00; // o valor da hora do operario é 15 reais
                                        salariobruto = valorHoraOperario * hora; // calculo do bruto
                                        if (salariobruto > 1000 && salariobruto < 2500) {
                                            desconto = salariobruto * 0.08;
                                            salarioLiquido = salariobruto - desconto; // bloco de condicões para
                                                                                      // calcular o desconto com base no
                                                                                      // salario bruto
                                        } else if (salariobruto >= 2500 && salariobruto < 4000) {
                                            desconto = salariobruto * 0.10;
                                            salarioLiquido = salariobruto - desconto;
                                        } else if (salariobruto >= 4000 && salariobruto < 5500) {
                                            desconto = salariobruto * 0.12;
                                            salarioLiquido = salariobruto - desconto;
                                        } else if (salariobruto >= 5500) {
                                            desconto = salariobruto * 0.15;
                                            salarioLiquido = salariobruto - desconto;
                                        }

                                        if (salariobruto >= 1903 && salariobruto < 2826) {
                                            impostoIRPF = salariobruto * 0.075; // bloco de condicões para calcular o
                                                                                // ImpostoIRPF caso o salario seja maior
                                                                                // que 1903
                                        } else if (salariobruto >= 2826 && salariobruto <= 3751) {
                                            impostoIRPF = salariobruto * 0.15;
                                        } else if (salariobruto > 3751) {
                                            impostoIRPF = salariobruto * 0.22;
                                        }

                                        salarioLiquidoFinal = salarioLiquido - impostoIRPF;
                                        func.salarioLiquidoFinal = salarioLiquidoFinal;
                                        somaSalarios += func.salarioLiquidoFinal;
                                        JOptionPane.showMessageDialog(null, // bloco de condicões para calcular o
                                                                            // salarioliquido final com todos os
                                                                            // calculos realizados
                                                "Seu Salario bruto é de: " + salariobruto + '\n' // informando se paga
                                                                                                 // ou não imposto de
                                                                                                 // renda
                                                        + "Desconto do salario liquido sem o imposto IRPF: " + desconto
                                                        + '\n'
                                                        + "Imposto IRPF: " + impostoIRPF + '\n'
                                                        + "Seu salario liquido com todos os impostos descontados é: "
                                                        + salarioLiquidoFinal);
                                        if (impostoIRPF == 0) {
                                            JOptionPane.showMessageDialog(null, "Você é isento de imposto de renda");

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Você paga imposto de renda");

                                        }

                                        if (hora >= 160) { // se o funcionario tiver um valor maior igual a 160
                                                           // trabalhadas no mes ele tem direito a horas extras
                                            String resposta = JOptionPane.showInputDialog(
                                                    "Em seu ofício foram realizadas horas extras? Responda com sim ou não"); // pergunta
                                                                                                                             // se
                                                                                                                             // funcionario
                                                                                                                             // realizou
                                                                                                                             // horas
                                                                                                                             // extras
                                            if (resposta.equals("sim")) {
                                                double horasExtras = Double.parseDouble( // se sim é feito um novo
                                                                                         // calculo a partir das horas
                                                                                         // extras informadas
                                                        JOptionPane.showInputDialog("Informe as horas extras")); // as
                                                                                                                 // horas
                                                                                                                 // extras
                                                                                                                 // tem
                                                                                                                 // o
                                                                                                                 // dobro
                                                                                                                 // do
                                                                                                                 // valor
                                                                                                                 // da
                                                                                                                 // hora
                                                                                                                 // normal
                                                double valorHoraExtra = valorHoraOperario * 2.0; // Valor da hora extra
                                                                                                 // (ajuste
                                                                                                 // conforme necessário)
                                                double valorHorasExtrasTotal = horasExtras * valorHoraExtra;

                                                salarioLiquidoFinal += valorHorasExtrasTotal;
                                                JOptionPane.showMessageDialog(null, "O valor da sua hora extra é: " // informa
                                                                                                                    // a
                                                                                                                    // quantidade
                                                                                                                    // de
                                                                                                                    // horas
                                                                                                                    // extras
                                                        + valorHoraExtra + '\n' // informa o salario liquido final com
                                                                                // os descontos realizados mais a hora
                                                                                // extra
                                                        + "O valor total das horas extras é: "
                                                        + valorHorasExtrasTotal + '\n'
                                                        + "Seu salario com todos descontos mais o valor das horas extras é : "
                                                        + salarioLiquidoFinal);
                                            } else {
                                                resposta = "nao";
                                                JOptionPane.showMessageDialog(null, // se nao tiver horas suficientes é
                                                                                    // so revelado o salarioliquido
                                                                                    // final com tudo ja descontado
                                                        "Seu salario liquido com todos os impostos descontados é: "
                                                                + salarioLiquidoFinal);
                                            }
                                            if (impostoIRPF == 0) {
                                                JOptionPane.showMessageDialog(null, // caso o valor do IRPF seja 0 o
                                                                                    // funcionario não paga imposto de
                                                                                    // renda
                                                        "Você é isento de imposto de renda"); // senao ele paga imposto
                                                                                              // de renda
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Você paga imposto de renda");
                                            }
                                        }

                                    } else if (funcao.equals("supervisor")) { // se o usuario digitar supervisor entra
                                                                              // nessa condição
                                        double hora = Double.parseDouble(JOptionPane
                                                .showInputDialog("Informe a quantidade de horas trabalhadas no mês")); // solicita
                                                                                                                       // a
                                                                                                                       // quantidade
                                                                                                                       // de
                                                                                                                       // horas
                                                                                                                       // do
                                                                                                                       // mes
                                        double valorHorasupervisor = 40; // o valor da hora do operario é 15 reais
                                        salariobruto = valorHorasupervisor * hora;

                                        if (salariobruto > 1000 && salariobruto < 2500) {
                                            desconto = salariobruto * 0.08;
                                            salarioLiquido = salariobruto - desconto;
                                        } else if (salariobruto >= 2500 && salariobruto < 4000) {
                                            desconto = salariobruto * 0.10;
                                            salarioLiquido = salariobruto - desconto; // bloco de condicões para
                                                                                      // calcular o desconto com base no
                                                                                      // salario bruto
                                        } else if (salariobruto >= 4000 && salariobruto < 5500) {
                                            desconto = salariobruto * 0.12;
                                            salarioLiquido = salariobruto - desconto;
                                        } else if (salariobruto >= 5500) {
                                            desconto = salariobruto * 0.15;
                                            salarioLiquido = salariobruto - desconto;
                                        }

                                        if (salariobruto >= 1903 && salariobruto < 2826) {
                                            impostoIRPF = salariobruto * 0.075;
                                        } else if (salariobruto >= 2826 && salariobruto <= 3751) { // bloco de condicões
                                                                                                   // para calcular o
                                                                                                   // ImpostoIRPF caso o
                                                                                                   // salario seja maior
                                                                                                   // que 1903
                                            impostoIRPF = salariobruto * 0.15;
                                        } else if (salariobruto > 3751) {
                                            impostoIRPF = salariobruto * 0.22;
                                        }

                                        salarioLiquidoFinal = salarioLiquido - impostoIRPF;
                                        func.salarioLiquidoFinal = salarioLiquidoFinal;
                                        somaSalarios += func.salarioLiquidoFinal; // bloco de condicões para calcular o
                                                                                  // salarioliquido final com todos os
                                                                                  // calculos realizados
                                        func.calculoRealizado = true; // informando se paga ou não imposto de renda
                                        JOptionPane.showMessageDialog(null,
                                                "Seu Salario bruto é de: " + salariobruto + '\n'
                                                        + "Desconto do salario liquido sem o imposto IRPF: " + desconto
                                                        + '\n'
                                                        + "Imposto IRPF: " + impostoIRPF + '\n'
                                                        + "Seu salario liquido com todos os impostos descontados é: "
                                                        + salarioLiquidoFinal);
                                        if (impostoIRPF == 0) {
                                            JOptionPane.showMessageDialog(null, "Você é isento de imposto de renda");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Você paga imposto de renda");
                                        }

                                        if (hora >= 160) { // se o funcionario tiver um valor maior igual a 160
                                                           // trabalhadas no mes ele tem direito a horas extras

                                            String resposta = JOptionPane.showInputDialog(
                                                    "Em seu ofício foram realizadas horas extras? Responda com sim ou não"); // pergunta
                                                                                                                             // se
                                                                                                                             // funcionario
                                                                                                                             // realizou
                                                                                                                             // horas
                                                                                                                             // extras

                                            if (resposta.equals("sim")) {
                                                double horasExtras = Double.parseDouble( // as horas extras tem o dobro
                                                                                         // do valor da hora normal
                                                        JOptionPane.showInputDialog("Informe as horas extras")); // informa
                                                                                                                 // a
                                                                                                                 // quantidade
                                                                                                                 // de
                                                                                                                 // horas
                                                                                                                 // extras
                                                double valorHoraExtra = valorHorasupervisor * 2.0; // Valor da hora
                                                                                                   // extra
                                                                                                   // (ajuste
                                                                                                   // conforme
                                                                                                   // necessário)
                                                double valorHorasExtrasTotal = horasExtras * valorHoraExtra;

                                                salarioLiquidoFinal += valorHorasExtrasTotal;

                                                JOptionPane.showMessageDialog(null, "O valor da sua hora extra é: " // informa
                                                                                                                    // o
                                                                                                                    // salario
                                                                                                                    // liquido
                                                                                                                    // final
                                                                                                                    // com
                                                                                                                    // os
                                                                                                                    // descontos
                                                                                                                    // realizados
                                                                                                                    // mais
                                                                                                                    // a
                                                                                                                    // hora
                                                                                                                    // extra
                                                        + valorHoraExtra + " R$" + '\n'
                                                        + "O valor total das horas extras é: "
                                                        + valorHorasExtrasTotal + " R$" + '\n'
                                                        + "Seu salario com todos descontos mais o valor das horas extras é : "
                                                        + salarioLiquidoFinal + " R$");
                                            } else {
                                                resposta = "nao"; // se nao tiver horas suficientes é so revelado o
                                                                  // salarioliquido final com tudo ja descontado
                                                JOptionPane.showMessageDialog(null,
                                                        "Seu salario liquido com todos os impostos descontados é: "
                                                                + salarioLiquidoFinal + " R$");
                                            }
                                            if (impostoIRPF == 0) { // caso o valor do IRPF seja 0 o funcionario não
                                                                    // paga imposto de renda
                                                JOptionPane.showMessageDialog(null,
                                                        "Você é isento de imposto de renda"); // informando se paga ou
                                                                                              // não imposto de renda
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Você paga imposto de renda");
                                            }
                                        }

                                    } else if (funcao.equals("gerente")) { // se o usuario digitar gerente entra nessa
                                                                           // condição
                                        double hora = Double.parseDouble(JOptionPane
                                                .showInputDialog("Informe a quantidade de horas trabalhadas no mês")); // solicita
                                                                                                                       // a
                                                                                                                       // quantidade
                                                                                                                       // de
                                                                                                                       // horas
                                                                                                                       // do
                                                                                                                       // mes
                                        double valorHoraGerente = 60; // valor da hora do gerente
                                        salariobruto = valorHoraGerente * hora;

                                        if (salariobruto > 1000 && salariobruto < 2500) {
                                            desconto = salariobruto * 0.08;
                                            salarioLiquido = salariobruto - desconto;
                                        } else if (salariobruto >= 2500 && salariobruto < 4000) { // bloco de condicões
                                                                                                  // para calcular o
                                                                                                  // desconto com base
                                                                                                  // no salario bruto
                                            desconto = salariobruto * 0.10;
                                            salarioLiquido = salariobruto - desconto;
                                        } else if (salariobruto >= 4000 && salariobruto < 5500) {
                                            desconto = salariobruto * 0.12;
                                            salarioLiquido = salariobruto - desconto;
                                        } else if (salariobruto >= 5500) {
                                            desconto = salariobruto * 0.15;
                                            salarioLiquido = salariobruto - desconto;
                                        }

                                        if (salariobruto >= 1903 && salariobruto < 2826) {
                                            impostoIRPF = salariobruto * 0.075;
                                        } else if (salariobruto >= 2826 && salariobruto <= 3751) { // bloco para
                                                                                                   // calcular o Imposto
                                                                                                   // IRPF com base no
                                                                                                   // salario bruto
                                            impostoIRPF = salariobruto * 0.15;
                                        } else if (salariobruto > 3751) {
                                            impostoIRPF = salariobruto * 0.22;
                                        }

                                        salarioLiquidoFinal = salarioLiquido - impostoIRPF;
                                        func.salarioLiquidoFinal = salarioLiquidoFinal;
                                        somaSalarios += func.salarioLiquidoFinal;
                                        func.calculoRealizado = true;
                                        JOptionPane.showMessageDialog(null,
                                                "Seu Salario bruto é de: " + salariobruto + " R$" + '\n'
                                                        + "Desconto do salario liquido sem o imposto IRPF: " + desconto // bloco
                                                                                                                        // de
                                                                                                                        // condicões
                                                                                                                        // para
                                                                                                                        // calcular
                                                                                                                        // o
                                                                                                                        // salarioliquido
                                                                                                                        // final
                                                                                                                        // com
                                                                                                                        // todos
                                                                                                                        // os
                                                                                                                        // calculos
                                                                                                                        // realizados
                                                        + " R$" + '\n' // informando se paga ou não imposto de renda
                                                        + "Imposto IRPF: " + impostoIRPF + " R$" + '\n'
                                                        + "Seu salario liquido com todos os impostos descontados é: "
                                                        + salarioLiquidoFinal + " R$");
                                        if (impostoIRPF == 0) {
                                            JOptionPane.showMessageDialog(null, "Você é isento de imposto de renda");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Você paga imposto de renda");
                                        }

                                    } else if (funcao.equals("diretor")) { // se o usuario digitar diretor entra nessa
                                                                           // condição
                                        double hora = Double.parseDouble(JOptionPane
                                                .showInputDialog("Informe a quantidade de horas trabalhadas no mês")); // solicita
                                                                                                                       // a
                                                                                                                       // quantidade
                                                                                                                       // de
                                                                                                                       // horas
                                                                                                                       // do
                                                                                                                       // mes
                                        double valorHoraDiretor = 80; // valor da hora do diretor
                                        salariobruto = valorHoraDiretor * hora;

                                        if (salariobruto > 1000 && salariobruto < 2500) {
                                            desconto = salariobruto * 0.08; // bloco de condicões para calcular o
                                                                            // desconto com base no salario bruto
                                            salarioLiquido = salariobruto - desconto;
                                        } else if (salariobruto >= 2500 && salariobruto < 4000) {
                                            desconto = salariobruto * 0.10;
                                            salarioLiquido = salariobruto - desconto;
                                        } else if (salariobruto >= 4000 && salariobruto < 5500) {
                                            desconto = salariobruto * 0.12;
                                            salarioLiquido = salariobruto - desconto;
                                        } else if (salariobruto >= 5500) {
                                            desconto = salariobruto * 0.15;
                                            salarioLiquido = salariobruto - desconto;
                                        }

                                        if (salariobruto >= 1903 && salariobruto < 2826) {
                                            impostoIRPF = salariobruto * 0.075;
                                        } else if (salariobruto >= 2826 && salariobruto <= 3751) { // bloco para
                                                                                                   // calcular o Imposto
                                                                                                   // IRPF com base no
                                                                                                   // salario bruto
                                            impostoIRPF = salariobruto * 0.15;
                                        } else if (salariobruto > 3751) {
                                            impostoIRPF = salariobruto * 0.22;
                                        }

                                        salarioLiquidoFinal = salarioLiquido - impostoIRPF;
                                        func.salarioLiquidoFinal = salarioLiquidoFinal;
                                        somaSalarios += func.salarioLiquidoFinal;
                                        func.calculoRealizado = true;
                                        JOptionPane.showMessageDialog(null, // bloco de condicões para calcular o
                                                                            // salarioliquido final com todos os
                                                                            // calculos realizados
                                                "Seu Salario bruto é de: " + salariobruto + " R$" + '\n'
                                                        + "Desconto do salario liquido sem o imposto IRPF: " + desconto // informando
                                                                                                                        // se
                                                                                                                        // paga
                                                                                                                        // ou
                                                                                                                        // não
                                                                                                                        // imposto
                                                                                                                        // de
                                                                                                                        // renda
                                                        + " R$" + '\n'
                                                        + "Imposto IRPF: " + impostoIRPF + " R$" + '\n'
                                                        + "Seu salario liquido com todos os impostos descontados é: "
                                                        + salarioLiquidoFinal + " R$");
                                        if (impostoIRPF == 0) {
                                            JOptionPane.showMessageDialog(null, "Você é isento de imposto de renda");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Você paga imposto de renda");
                                        }
                                        break; // Interrompe o loop, pois a função do diretor foi processada
                                    } else {
                                        encontrada = false; // Se a função não é reconhecida, marca como não encontrada

                                    }
                                    func.salarioBruto = salariobruto;
                                    func.desconto = desconto;
                                    func.impostoIRPF = impostoIRPF; // armazena as informações sobre o salário dos
                                                                    // funcionarios em variaveis
                                    func.salarioLiquido = salarioLiquido; // passa as variaveis para os construtores que
                                                                          // estavam zerados
                                    func.salarioLiquidoFinal = salarioLiquidoFinal;
                                    func.calculoRealizado = true;
                                }

                            }
                            if (!encontrada) {
                                JOptionPane.showMessageDialog(null, "Nome não encontrado"); // Exibe mensagem se o nome
                                                                                            // do funcionário não foi
                                                                                            // encontrado

                            }
                            String resposta = JOptionPane
                                    .showInputDialog("Deseja calcular o salário de outro funcionário? (sim/não)"); // Pergunta
                                                                                                                   // se
                                                                                                                   // o
                                                                                                                   // usuário
                                                                                                                   // deseja
                                                                                                                   // calcular
                                                                                                                   // o
                                                                                                                   // salário
                                                                                                                   // de
                                                                                                                   // outro
                                                                                                                   // funcionário
                            calcularOutro = resposta.equalsIgnoreCase("sim");
                        } while (calcularOutro);
                        break;

                    case 4:
                        JOptionPane.showMessageDialog(null, "Funcionários com cálculos de salário realizados:"); // Exibe
                                                                                                                 // uma
                                                                                                                 // mensagem
                                                                                                                 // informando
                                                                                                                 // que
                                                                                                                 // serão
                                                                                                                 // mostrados
                                                                                                                 // os
                                                                                                                 // funcionários
                                                                                                                 // com
                                                                                                                 // cálculos
                                                                                                                 // de
                                                                                                                 // salário
                                                                                                                 // realizados

                        boolean peloMenosUmCalculoRealizado = false; // Flag para verificar se pelo menos um cálculo de
                                                                     // salário foi realizado
                        for (Funcionario func : funcionarios) { // Itera sobre a lista de funcionários para verificar
                                                                // quais tiveram cálculos de salário realizados
                            if (func.calculoRealizado) { // Se o cálculo foi realizado para o funcionário, exibe as
                                                         // informações do funcionário
                                func.imprimirFuncionario();
                                peloMenosUmCalculoRealizado = true;
                            }
                        }
                        if (!peloMenosUmCalculoRealizado) { // Se nenhum cálculo foi realizado, exibe uma mensagem
                                                            // informando que não há funcionários com cálculos
                                                            // realizados
                            JOptionPane.showMessageDialog(null,
                                    "Nenhum funcionário com cálculos de salário realizados");
                        }

                        System.out.println(" ");
                        break;
                    case 5:
                        Menu.main(enderecos); // Chama o método main da classe Menu, passando o array de endereços como
                                              // argumento

                    default: // Não há um break aqui, então a execução continuará para o bloco default
                        // Bloco de código que será executado caso a opção do switch não seja 5
                        // Exibe uma mensagem indicando que a opção é inválida e pede para escolher uma
                        // opção válida

                        JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, escolha uma opção válida.");
                        break;
                }
            } catch (NullPointerException npe) { // Se ocorrer uma NullPointerException, exibe uma mensagem indicando
                                                 // que a operação foi cancelada
                // e encerra o programa

                JOptionPane.showMessageDialog(null, "Operação cancelada", "FECHAR", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
    }
}
