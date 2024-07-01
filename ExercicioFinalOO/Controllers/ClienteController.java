package ExercicioFinalOO.Controllers;

import java.util.HashMap;
import java.util.Scanner;

import ExercicioFinalOO.Interfaces.InterfaceCrud;
import ExercicioFinalOO.Models.Pessoa.Cliente;

public class ClienteController implements InterfaceCrud {

    private HashMap<Integer, Cliente> clientes = new HashMap<>();

    @Override
    public void create() {
        Cliente novoCliente = new Cliente();
        novoCliente.entrada();
        this.getClientes().put(novoCliente.getId(), novoCliente);
        System.out.println("Cliente cadastrado");

    }

    @Override
    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("insira o ID");

        Integer id = sc.nextInt();

        if (this.getClientes().containsKey(id)) {

            this.getClientes().get(id).imprimir();

        } else {

            System.out.println("Não tem o cliente");

        }

    }

    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("insira o ID");

        Integer id = sc.nextInt();
        if (this.getClientes().containsKey(id)) {
            Cliente novoCliente = new Cliente();
            novoCliente.entrada();
            if(novoCliente.getId() == id){
                this.getClientes().replace(novoCliente.getId(), novoCliente);
            } else{
                System.out.println("Nao foi possivel substituir");
            }
        }

    }

    @Override
    public void delete() {

        Scanner sc = new Scanner(System.in);
        System.out.println("insira o ID");
        Integer id = sc.nextInt();

        if (this.getClientes().containsKey(id)) {

            this.getClientes().remove(id);

        } else {

            System.out.println("Não tem o cliente cadastrado");

        }

    }

    public HashMap<Integer, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<Integer, Cliente> clientes) {
        this.clientes = clientes;
    }

}
