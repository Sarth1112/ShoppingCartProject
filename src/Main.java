import CartManagement.ShoppingCart;
import model.Product;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nSelect options: ");
            System.out.println("1) Add Product");
            System.out.println("2) Remove Product");
            System.out.println("3) Decrement Product");
            System.out.println("4) View Cart");
            System.out.println("5) Exit");
            System.out.print("Response: ");

            int res = Integer.parseInt(input.nextLine());

            if (res == 1) {
                System.out.print("Enter Name: ");
                String name = input.nextLine();
                System.out.print("Enter Description: ");
                String description = input.nextLine();
                System.out.print("Enter Price: ");
                double price = Double.parseDouble(input.nextLine());
                cart.add(new Product(name, description, price));
            } else if (res == 2) {
                System.out.print("Enter name of the product to remove: ");
                String name = input.nextLine();
                cart.remove(name);
            } else if (res == 3) {
                System.out.print("Enter name of the product to decrement: ");
                String name = input.nextLine();
                cart.decrement(name);
            } else if (res == 4) {
                cart.displayCart();
            } else if (res == 5) {
                running = false;
                System.out.println("Exiting. Goodbye!");
            } else {
                System.out.println("Invalid input. Please try again.");
            }
            System.out.println("Current Cart Total: $" + cart.getTotal());
        }
    }
}