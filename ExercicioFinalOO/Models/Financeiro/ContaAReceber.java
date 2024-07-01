package ExercicioFinalOO.Models.Financeiro;

import ExercicioFinalOO.Models.Pessoa.Cliente;

public class ContaAReceber extends Financeiro {
    private Cliente cliente;
    private String nota_fiscal;

    @Override
    public void entrada() {
        super.entrada();

    }

    @Override
    public void imprimir() {
        super.imprimir();

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNota_fiscal() {
        return nota_fiscal;
    }

    public void setNota_fiscal(String nota_fiscal) {
        this.nota_fiscal = nota_fiscal;
    }

}
