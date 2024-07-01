package ExercicioFinalOO.Models.Pessoa;

public class PessoaFisica extends Pessoa {
    private String cpf;
    private String rg;
    private String emissor;

    @Override
    public void entrada() {
        super.entrada();

    }

    @Override
    public void imprimir() {
        super.imprimir();

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmissor() {
        return emissor;
    }

    public void setEmissor(String emissor) {
        this.emissor = emissor;
    }

}
