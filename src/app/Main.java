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

        while (escolha != 2) {

            System.out.println("==========CRUD==========");
            System.out.println("Escolha uma das opções a seguir:");
            System.out.println("1 - Cadastrar\n2 - Listar\n3 - Alterar\n4 - Deletar\n5 - sair");
            System.out.print("Insira a sua escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao < 1 || opcao > 5) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }
            

            switch (opcao) {
                case 1:
                    inserir(scanner, clienteDAO);
                    break;
                case 2:
                    listar(clienteDAO);
                    break;
                case 3:
                    alterar(scanner, clienteDAO);
                    break;
                case 4:
                    deletar(scanner, clienteDAO);
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

    public static void inserir(Scanner scanner, ClienteDAO clienteDAO) {

        // Leitura do nome e email
        System.out.print("Insira o nome: ");
        String nome = scanner.nextLine().trim();


        System.out.print("Insira o email: ");
        String email = scanner.nextLine().trim();

        email = validarEmail(email, scanner);

        // criação do objeto cliente
        Cliente cliente = new Cliente(nome, email);

        // obejto clienteDAO inserindo o objeto cliente no BD
        clienteDAO.inserir(cliente);

        System.out.println("Cliente cadastrado com sucesso!");

    }

    public static void listar(ClienteDAO clienteDAO) {

        // Criação do array
        List<Cliente> clientes = clienteDAO.listar();

        // Loop pra mostrar os nome e email de cada cliente da tabela
        for (Cliente c : clientes) {
            System.out.println("Nome: " + c.getNome());
            System.out.println("Email: " + c.getEmail());
            System.out.println("-----------------");
        }
    }

    public static void alterar(Scanner scanner, ClienteDAO clienteDAO) {

        // Leitura do email antigo
        System.out.print("Insira o email antigo do cliente: ");
        String emailAntigo = scanner.nextLine().trim();
        emailAntigo = validarEmail(emailAntigo, scanner);

        // Leitura dos novos dados
        System.out.print("Insira o nome do cliente: ");
        String nome = scanner.nextLine().trim();

        System.out.print("Insira o email do cliente: ");
        String email = scanner.nextLine().trim();
        email = validarEmail(email, scanner);


        // Criação de um objeto cliente
        Cliente cliente = new Cliente(nome, email);

        // Objeto clienteDAO alterando o BD
        clienteDAO.alterar(emailAntigo, cliente);

    }

    public static void deletar(Scanner scanner, ClienteDAO clienteDAO) {

        // Leitura do email
        System.out.print("Insira o email do cliente: ");
        String email = scanner.nextLine().trim();
        email = validarEmail(email, scanner);

        // objeto clienteDAO deletando o cliente no BD
        clienteDAO.deletar(email);

    }

    public static String validarEmail(String email, Scanner scanner) {


        while (!email.contains("@") || !email.contains(".")){
            System.out.println("Email inválido! Tente novamente.");
            System.out.print("Insira o email: ");
            email = scanner.nextLine().trim();

        }

        return email;
    }

}
