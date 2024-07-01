package ExercicioFinalOO.Models.Pessoa;

public class Endereco extends Pessoa {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private int cep;

    @Override
    public void entrada() {
        super.entrada();

        System.out.println("Digite o logradouro");
        this.setLogradouro(leia.next());

        System.out.println("Digite o numero");
        this.setNumero(leia.next());

        System.out.println("Digite o complemento");
        this.setComplemento(leia.next());

        System.out.println("Digite o bairro");
        this.setBairro(leia.next());

        System.out.println("Digite a cidade");
        this.setCidade(leia.next());

        System.out.println("Digite o estado");
        this.setEstado(leia.next());

        System.out.println("Digite o cep");
        this.setCep(leia.nextInt());

    }

    @Override
    public void imprimir() {
        super.imprimir();

    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

}
