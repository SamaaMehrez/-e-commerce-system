package E_Commerce;

public class Customer{
    private String name;
    private double balance;
    private Cart cart;
    public Customer(String name,double balance, Cart cart){
        this.name = name;
        this.cart = cart;
        this.balance = balance;
    }
    public void addToCart(Product product, int quantity){
        cart.addItem(product, quantity);
    }
    public void Checkout(){
        System.out.println("Customer " + name + " has been checked out.");
        double total = cart.getTotalPaidAmount();
        if(total > balance){
            System.out.println("<-- Insufficient balance -->");
            return;
        }
        if(cart.IsEmpty()){
            System.out.println("Your Cart is empty");
        }
        System.out.println("** Shipment Notice **");
        cart.printItemsWeight();
        System.out.println("\n" + "** Checkout Receipt **");
        cart.printCheckout();
        balance -= total;
    }
    public void printBalance(){
        System.out.println("Your Balance after checkout: " + balance);
        System.out.println("-----------------------------------------");
    }

}

