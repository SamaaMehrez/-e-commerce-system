package E_Commerce;

import java.util.*;

public class Cart {
    private Map<Product, Integer> Items = new HashMap<>();

    public void addItem(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid Quantity for " + product.getName() + ".It should be greater than 0");
        }
        if (product.getQuantity() == 0) {
            System.out.println("The " + product.getName() + " can't be  added to your cart.It's out of stock.");
        }
        if (quantity > product.getQuantity() && product.getQuantity() != 0) {
            System.out.println("Invalid Quantity for " + product.getName() + ".It should be less than or equal to " + product.getQuantity());
        }

        if (product.isExpired()) {
                System.out.println("The "+ product.getName() +" is expired.");
        }
        Items.put(product, quantity);
    }

    public double getSubTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : Items.entrySet()) {
            total += entry.getValue() * entry.getKey().getPrice();
        }
        return total;
    }

    public double getTotalWeight() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : Items.entrySet()) {
            if (entry.getKey() instanceof Shippable) {
                total += entry.getValue() * ((Shippable) entry.getKey()).getWeight();
            }
        }
        return total;

    }

    public double getShippingFees() {
        if(getTotalWeight() == 0) return 0;
        return (getTotalWeight() / 1000) * 30;

    }

    public double getTotalPaidAmount() {
        return getSubTotal() + getShippingFees();
    }

    public Boolean IsEmpty() {
        return Items.isEmpty();
    }

    public void printItemsWeight() {
        System.out.printf("%-20s %10s%n", "Item", "Weight");
        System.out.println("------------------------------");

        for (Map.Entry<Product, Integer> entry : Items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (product instanceof Shippable) {
                double weight = ((Shippable) product).getWeight() * quantity;
                System.out.printf("%-20s %10.2f g%n", quantity + "x " + product.getName(), weight);
            } else {
                System.out.printf("%-20s %10s%n", quantity + "x " + product.getName(), "N/A");
            }
        }

        System.out.println("------------------------------");
        System.out.printf("%-20s %10.2f kg%n", "Total Package Weight:", getTotalWeight() / 1000.0);
        System.out.println("------------------------------");
    }

    public void printCheckout() {
        System.out.printf("%-20s %10s%n", "Item", "Price");
        System.out.println("------------------------------");

        for (Map.Entry<Product, Integer> entry : Items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double itemTotal = product.getPrice() * quantity;

            System.out.printf("%-20s %10.2f%n", quantity + "x " + product.getName(), itemTotal);
        }

        System.out.println("------------------------------");
        System.out.printf("%-20s %10.2f%n", "Subtotal:", getSubTotal());
        System.out.printf("%-20s %10.2f%n", "Shipping Fees:", getShippingFees());
        System.out.printf("%-20s %10.2f%n", "Total Amount:", getTotalPaidAmount());
        System.out.println("------------------------------");
    }

}
