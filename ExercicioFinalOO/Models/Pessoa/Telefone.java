package ExercicioFinalOO.Models.Pessoa;

public class Telefone extends Pessoa {
    private int ddd;
    private Long numero;

    @Override
    public void entrada() {
        super.entrada();
        System.out.println("Digite o DDD");
        this.setDdd(leia.nextInt());
        System.out.println("Digite o numero");
        this.setNumero(leia.nextLong());

    }

    @Override
    public void imprimir() {
        super.imprimir();

    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

}
