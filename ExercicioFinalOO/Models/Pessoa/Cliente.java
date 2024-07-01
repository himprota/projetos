package ExercicioFinalOO.Models.Pessoa;

public class Cliente extends PessoaJuridica {

    private Double limite_credito;
    private Endereco endereco_cobranca;

    @Override
    public void entrada() {
        super.entrada();

    }

    @Override
    public void imprimir() {
        super.imprimir();

    }

    public Double getLimite_credito() {
        return limite_credito;
    }

    public void setLimite_credito(Double limite_credito) {
        this.limite_credito = limite_credito;
    }

    public Endereco getEndereco_cobranca() {
        return endereco_cobranca;
    }

    public void setEndereco_cobranca(Endereco endereco_cobranca) {
        this.endereco_cobranca = endereco_cobranca;
    }

}
