package org.example;

import org.example.domain.model.User;
import org.example.infrastructure.UserRepository;
import org.example.util.AnagramGenerator;

import java.util.Scanner;

public class AnagramasMain {
    public static void main(String[] args) {
        String input = "abc";
        AnagramGenerator generator = new AnagramGenerator();
        System.out.println("Anagramas gerados: ");
        AnagramGenerator.generateAnagrams(input).forEach(System.out::println);

        UserRepository userRepository = new UserRepository();

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            // Menu de opções
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar usuário");
            System.out.println("2 - Encontrar usuário");
            System.out.println("3 - Atualizar usuário");
            System.out.println("4 - Excluir usuário");
            System.out.println("5 - Sair");
            option = scanner.nextInt();
            scanner.nextLine();  // Consome a nova linha após a opção

            switch (option) {
                case 1:
                    // Adicionar usuário
                    System.out.println("Digite o nome do usuário:");
                    String name = scanner.nextLine();
                    System.out.println("Digite o email do usuário:");
                    String email = scanner.nextLine();
                    System.out.println("Digite o endereço do usuário:");
                    String address = scanner.nextLine();
                    System.out.println("Digite o telefone do usuário:");
                    String phone = scanner.nextLine();
                    System.out.println("O usuário é admin? (true/false):");
                    boolean isAdmin = scanner.nextBoolean();
                    scanner.nextLine();  // Consumir a nova linha após a entrada booleana

                    // ID pode ser gerado automaticamente ou passado como argumento
                    User newUser = new User(1, name, email, address, phone, isAdmin);
                    userRepository.save(newUser);
                    System.out.println("Usuário adicionado com sucesso!");
                    break;

                case 2:
                    // Encontrar usuário
                    System.out.println("Digite o ID do usuário que deseja encontrar:");
                    int findId = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha após o nextInt
                    User foundUser = userRepository.findById(findId);

                    if (foundUser != null) {
                        System.out.println("Usuário encontrado: " + foundUser);
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case 3:
                    // Atualizar usuário
                    System.out.println("Digite o ID do usuário que deseja atualizar:");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha

                    User existingUser = userRepository.findById(updateId);
                    if (existingUser != null) {
                        System.out.println("Digite o novo nome (deixe em branco para não alterar):");
                        String newName = scanner.nextLine();
                        if (!newName.isEmpty()) existingUser.setName(newName);

                        System.out.println("Digite o novo email (deixe em branco para não alterar):");
                        String newEmail = scanner.nextLine();
                        if (!newEmail.isEmpty()) existingUser.setEmail(newEmail);

                        System.out.println("Digite o novo endereço (deixe em branco para não alterar):");
                        String newAddress = scanner.nextLine();
                        if (!newAddress.isEmpty()) existingUser.setAddress(newAddress);

                        System.out.println("Digite o novo telefone (deixe em branco para não alterar):");
                        String newPhone = scanner.nextLine();
                        if (!newPhone.isEmpty()) existingUser.setPhone(newPhone);

                        userRepository.update(existingUser);
                        System.out.println("Usuário atualizado com sucesso!");
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case 4:
                    // Excluir usuário
                    System.out.println("Digite o ID do usuário que deseja excluir:");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha após o nextInt
                    userRepository.delete(deleteId);
                    System.out.println("Usuário excluído com sucesso!");
                    break;

                case 5:
                    // Sair do programa
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 5);

        scanner.close();
    }
}
