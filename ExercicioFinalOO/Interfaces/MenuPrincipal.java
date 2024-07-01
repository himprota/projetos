package ExercicioFinalOO.Interfaces;

import java.util.Scanner;

import ExercicioFinalOO.Controllers.ClienteController;

public class MenuPrincipal {
    private ClienteController clienteController = new ClienteController();

    public void exibirMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1- Cadastrar cliente ");
        System.out.println("2- Ler cliente ");
        System.out.println("3- Atualizar cliente ");
        System.out.println("4- Remover cliente ");

        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:
                this.clienteController.create();
                break;

            case 2:
                this.clienteController.read();
                break;
            case 3:
                this.clienteController.update();
                break;
            case 4:
                this.clienteController.delete();
                break;

        }

    }

    public ClienteController getClienteController() {
        return clienteController;
    }

    public void setClienteController(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

}
