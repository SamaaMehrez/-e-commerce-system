package E_Commerce;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private boolean expired = false;
    public Product(String name, double price, int quantity, boolean expired) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expired = expired;
    }
   public String getName() {
        return name;
    }
   public double getPrice() {
        return price;
    }
   public int getQuantity() {
        return quantity;
    }
    public boolean isExpired() {
        return expired;
    }
}
