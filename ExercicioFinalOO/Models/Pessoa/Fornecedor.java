package ExercicioFinalOO.Models.Pessoa;

public class Fornecedor extends PessoaJuridica {
    private Double limite_compra;
    private String data_cadastro;
    private String site;

    @Override
    public void entrada() {
        super.entrada();

    }

    @Override
    public void imprimir() {
        super.imprimir();

    }

    public Double getLimite_compra() {
        return limite_compra;
    }

    public void setLimite_compra(Double limite_compra) {
        this.limite_compra = limite_compra;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

}
