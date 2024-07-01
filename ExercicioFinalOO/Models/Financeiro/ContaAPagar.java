package ExercicioFinalOO.Models.Financeiro;

import ExercicioFinalOO.Models.Pessoa.Fornecedor;

public class ContaAPagar extends Financeiro {

    private Fornecedor fornecedor;
    private String boleto;

    @Override
    public void entrada() {
        super.entrada();

    }

    @Override
    public void imprimir() {
        super.imprimir();

    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getBoleto() {
        return boleto;
    }

    public void setBoleto(String boleto) {
        this.boleto = boleto;
    }

}
