import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GameInventoryManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // For reading player input
        ArrayList<String> inventory = new ArrayList<>(); // Our player's inventory

        boolean running = true; // Controls whether the menu keeps looping

        while (running) {
            //  Display menu options
            System.out.println("\nAvailable Actions:");
            System.out.println("0 - Quit");
            System.out.println("1 - Add item(s) to inventory (comma separated)");
            System.out.println("2 - Remove item(s) from inventory (comma separated)");
            System.out.print("Choose an action: ");

            String input = scanner.nextLine(); // Read the action number
            int action;

            //  Try converting user input into an integer (0, 1, 2)
            try {
                action = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 0, 1, or 2.");
                continue; // Restart the loop
            }

            //  Perform action based on input
            switch (action) {
                case 0:
                    running = false;
                    System.out.println("Closing inventory...");
                    break;

                case 1:
                    //  Add item(s) to the inventory
                    System.out.print("Enter item(s) to add (comma separated): ");
                    String addInput = scanner.nextLine();
                    String[] addItems = addInput.split(",");

                    for (String item : addItems) {
                        String trimmedItem = item.trim().toLowerCase(); // Normalize input
                        if (!inventory.contains(trimmedItem)) {
                            inventory.add(trimmedItem);
                            System.out.println("Added: " + trimmedItem);
                        } else {
                            System.out.println("Already in inventory: " + trimmedItem);
                        }
                    }
                    break;

                case 2:
                    //  Remove item(s) from the inventory
                    System.out.print("Enter item(s) to remove (comma separated): ");
                    String removeInput = scanner.nextLine();
                    String[] removeItems = removeInput.split(",");

                    for (String item : removeItems) {
                        String trimmedItem = item.trim().toLowerCase();
                        if (inventory.contains(trimmedItem)) {
                            inventory.remove(trimmedItem);
                            System.out.println("Removed: " + trimmedItem);
                        } else {
                            System.out.println("Item not found: " + trimmedItem);
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid action. Try 0, 1, or 2.");
            }

            //  Always print inventory after each action
            printSortedInventory(inventory);
        }
    }

    //  Prints the inventory in alphabetical order
    public static void printSortedInventory(ArrayList<String> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("\nYour inventory is empty.");
            return;
        }

        ArrayList<String> sorted = new ArrayList<>(inventory); // Copy the list
        Collections.sort(sorted); // Sort A-Z

        System.out.println("\nCurrent Inventory:");
        for (int i = 0; i < sorted.size(); i++) {
            System.out.println((i + 1) + ". " + sorted.get(i));
        }
    }
}
