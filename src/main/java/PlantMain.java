import org.example.domain.DAO.PlantDAO;
import org.example.domain.model.Plant;
import org.example.domain.service.PlantService;

import java.util.Scanner;

public class PlantMain {

    public static void main(String[] args) {
        PlantDAO plantDAO = new PlantDAO();

        PlantService plantService = new PlantService(plantDAO);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPlant Management System");
            System.out.println("1. Add Plant");
            System.out.println("2. Update Plant");
            System.out.println("3. Delete Plant");
            System.out.println("4. List Plants");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Plant Code: ");
                        int code = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Description (optional, max 10 chars): ");
                        String description = scanner.nextLine();
                        plantService.addPlant(new Plant(code, description));
                        System.out.println("Plant added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter Plant Code to Update: ");
                        int updateCode = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter New Description (max 10 chars): ");
                        String newDescription = scanner.nextLine();
                        plantService.updatePlant(new Plant(updateCode, newDescription));
                        System.out.println("Plant updated successfully.");
                        break;

                    case 3:
                        System.out.print("Enter Plant Code to Delete: ");
                        int deleteCode = scanner.nextInt();
                        System.out.print("Are you an admin? (true/false): ");
                        boolean isAdmin = scanner.nextBoolean();
                        plantService.deletePlant(deleteCode, isAdmin);
                        System.out.println("Plant deleted successfully.");
                        break;

                    case 4:
                        System.out.println("Listing all plants:");
                        plantService.listPlants().forEach(plant ->
                                System.out.println("Code: " + plant.getCode() + ", Description: " + plant.getDescription()));
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
