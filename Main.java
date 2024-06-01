/*
 * Author: Natasya Sofian
 * Date: 2 June 2024
 */





import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Customers customers = new Customers();

        while (true) {
            System.out.println("1. Create a new customer");
            System.out.println("2. Add a burger to a customer's order");
            System.out.println("3. Remove a burger from a customer's order");
            System.out.println("4. Print all customers and their orders");
            System.out.println("5. Exit");

            int choice;
            while (true) {
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for choice.");
                    scanner.next(); // Clear the invalid input
                }
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter customer name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter customer address:");
                    String address = scanner.nextLine();
                    System.out.println("Enter customer ID:");
                    int id;
                    while (true) {
                        try {
                            id = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer for customer ID.");
                            scanner.next(); // Clear the invalid input
                        }
                    }

                    Customer customer = new Customer(name, address, id);
                    customers.addCustomer(customer);

                    break;
                case 2:
                    System.out.println("Enter customer ID:");
                    int customerId;
                    while (true) {
                        try {
                            customerId = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer for customer ID.");
                            scanner.next(); // Clear the invalid input
                        }
                    }
                    Customer customerToAddBurger = findCustomer(customers, customerId);

                    if (customerToAddBurger!= null) {
                        System.out.println("Enter burger name:");
                        String burgerName = scanner.nextLine();
                        System.out.println("Enter burger cost:");
                        double burgerCost;
                        while (true) {
                            try {
                                burgerCost = scanner.nextDouble();
                                scanner.nextLine(); // Consume the newline character
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid double for burger cost.");
                                scanner.next(); // Clear the invalid input
                            }
                        }
                        System.out.println("Enter ingredient names (separated by commas):");
                        String ingredientNames = scanner.nextLine();

                        String[] ingredientsArray = ingredientNames.split(",");
                        List<Ingredient> ingredients = new ArrayList<>();

                        for (String ingredientName : ingredientsArray) {
                            ingredients.add(new Ingredient(ingredientName, 1, 1, "Supplier", 10));
                        }

                        Burger burger = new Burger(burgerName, burgerCost, ingredients);
                        customerToAddBurger.getBurgerOrder().addBurger(burger);
                    } else {
                        System.out.println("Customer not found");
                    }

                    break;
                case 3:
                    System.out.println("Enter customer ID:");
                    int customerIdToRemoveBurger;
                    while (true) {
                        try {
                            customerIdToRemoveBurger = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer for customer ID.");
                            scanner.next(); // Clear the invalid input
                        }
                    }
                    Customer customerToRemoveBurger = findCustomer(customers, customerIdToRemoveBurger);

                    if (customerToRemoveBurger!= null) {
                        System.out.println("Enter burger name to remove:");
                        String burgerNameToRemove = scanner.nextLine();

                        Burger burgerToRemove = customerToRemoveBurger.getBurgerOrder().findBurger(burgerNameToRemove);

                        if (burgerToRemove!= null) {
                            customerToRemoveBurger.getBurgerOrder().removeBurger(burgerToRemove);
                        } else {
                            System.out.println("Burger not found");
                        }
                    } else {
                        System.out.println("Customer not found");
                    }

                    break;
                case 4:
                    customers.printCustomers();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static Customer findCustomer(Customers customers, int id) {
        for (Customer customer : customers.getCustomers()) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}
