package org.example;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity) {
        if (quantity > 0) {
            pizzas.add(pizzaType);
            quantities.add(quantity);
            System.out.println("Order added.");
        } else {
            System.out.println("Quantity must be positive.");
        }
    }

    public static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity) {
        if (index >= 0 && index < quantities.size()) {
            if (newQuantity > 0) {
                quantities.set(index, newQuantity);
                System.out.println("Order updated.");
            } else {
                System.out.println("Quantity must be positive.");
            }
        }
    }

    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index) {
        if (index >= 0 && index < pizzas.size()) {
            pizzas.remove(index);
            quantities.remove(index);
            System.out.println("Order removed.");
        }
    }

    public static void printOrders(ArrayList<String> pizzas, ArrayList<Integer> quantities) {
        System.out.println("\n--- Current Orders ---");
        if (pizzas.isEmpty()) {
            System.out.println("No orders yet.");
        } else {
            for (int i = 0; i < pizzas.size(); i++) {
                System.out.printf("%d. %s x %d\n", (i + 1), pizzas.get(i), quantities.get(i));
            }
        }
        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> pizzas = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Order");
            System.out.println("2. Update Order");
            System.out.println("3. Remove Order");
            System.out.println("4. View Orders");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = -1;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Pizza type: ");
                    String pizzaType = scanner.nextLine();
                    System.out.print("Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    addOrder(pizzas, quantities, pizzaType, quantity);
                    break;

                case 2:
                    printOrders(pizzas, quantities);
                    System.out.print("Order number to update: ");
                    int updateIndex = scanner.nextInt() - 1;
                    if (updateIndex >= 0 && updateIndex < pizzas.size()) {
                        System.out.print("New quantity: ");
                        int newQuantity = scanner.nextInt();
                        scanner.nextLine();
                        updateOrder(quantities, updateIndex, newQuantity);
                    } else {
                        System.out.println("Invalid order number.");
                    }
                    break;

                case 3:
                    printOrders(pizzas, quantities);
                    System.out.print("Order number to remove: ");
                    int removeIndex = scanner.nextInt() - 1;
                    if (removeIndex >= 0 && removeIndex < pizzas.size()) {
                        removeOrder(pizzas, quantities, removeIndex);
                    } else {
                        System.out.println("Invalid order number.");
                    }
                    break;

                case 4:
                    printOrders(pizzas, quantities);
                    break;

                case 5:
                    System.out.println("---Thank you!---");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 5.");
                    break;
            }
        }
    }
}