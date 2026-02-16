package app;

import dao.ClienteDAO;
import model.Cliente;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();

        int escolha = 1, opcao;
        String nome, email, emailAntigo;

        while (escolha != 2) {

            System.out.println("==========CRUD==========");
            System.out.println("Escolha uma das opções a seguir:");
            System.out.println("1 - Cadastrar\n2 - Listar\n3 - Alterar\n4 - Deletar\n5 - sair");
            System.out.print("Insira a sua escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Leitura do nome e email
                    System.out.print("Insira o nome: ");
                    nome = scanner.nextLine();

                    System.out.print("Insira o email: ");
                    email = scanner.nextLine();

                    // criação do objeto cliente
                    Cliente cliente = new Cliente(nome, email);

                    // obejto clienteDAO inserindo o objeto cliente no BD
                    clienteDAO.inserir(cliente);

                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 2:
                    List<Cliente> clientes = clienteDAO.Listar();

                    for (Cliente c : clientes) {
                        System.out.println("Nome: " + c.getNome());
                        System.out.println("Email: " + c.getEmail());
                        System.out.println("-----------------");
                    }

                    break;
                case 3:
                    // Leitura do email antigo
                    System.out.print("Insira o email antigo do cliente: ");
                    emailAntigo = scanner.nextLine();

                    // Leitura dos novos dados
                    System.out.print("Insira o nome do cliente: ");
                    nome = scanner.nextLine();

                    System.out.print("Insira o email do cliente: ");
                    email = scanner.nextLine();

                    // Criação de um objeto cliente
                    cliente = new Cliente(nome, email);

                    // Objeto clienteDAO alterando o BD
                    clienteDAO.alterar(emailAntigo, cliente);

                    System.out.println("Dados alterados com sucesso!");

                    break;
                case 4:
                    // Leitura do email
                    System.out.print("Insira o email do cliente: ");
                    email = scanner.nextLine();

                    // objeto clienteDAO deletando o cliente no BD
                    clienteDAO.deletar(email);

                    System.out.println("Cliente deletado com sucesso!");
                    break;
                case 5:
                    System.out.println("FIM DO PROGRAMA!");
                    scanner.close();
                    return;

            }
            System.out.println("Deseja realizar mais alguma ação?");
            System.out.print("1 - Sim\n2 - Não\n");
            System.out.print("Insira sua resposta: ");
            escolha = scanner.nextInt();
        }

        scanner.close();

    }
}
