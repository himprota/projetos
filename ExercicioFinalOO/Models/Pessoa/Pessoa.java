package ExercicioFinalOO.Models.Pessoa;

import ExercicioFinalOO.Interfaces.InterfaceCadastro;

public abstract class Pessoa implements InterfaceCadastro {
    private int id;
    private String nome;
    private Endereco endereco;
    private Telefone telefone;

    private String email;

    @Override
    public void entrada() {
        System.out.println("Digite o id da pessoa");
        this.setId(leia.nextInt());

        System.out.println("Digite o nome da pessoa");
        this.setNome(leia.next());

        System.out.println("Digite o endereço da pessoa");
        this.getEndereco().entrada();

        System.out.println("Digite o telefone da pessoa");
        this.getTelefone().entrada();
        System.out.println("Digite o email da pessoa");
        this.setEmail(leia.next());

    }

    @Override
    public void imprimir() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
