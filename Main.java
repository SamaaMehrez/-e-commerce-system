import E_Commerce.Cart;
import E_Commerce.Customer;
import E_Commerce.Product;
import E_Commerce.ShippableProduct;
public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Customer customer = new Customer("Mohamed",30000,cart);
        Customer customer2 = new Customer("Ahmed",3000,cart);
        Product cheese = new ShippableProduct("cheese",100,2,200,false);
        Product biscuits = new ShippableProduct("biscuits",150,2,150,false);
        Product tv = new ShippableProduct("tv",4000,1,2000,false);
        Product scratchCard = new Product("scratchCard",30,6,false);
        Product milk = new ShippableProduct("milk",100,0,80,false);
        Product chips = new ShippableProduct("chips",100,3,10,true);
        customer.addToCart(cheese,2);
        customer.addToCart(chips,1);
        customer.addToCart(scratchCard,3);
        customer.addToCart(milk,1);
        customer.Checkout();
        customer.printBalance();
        customer2.addToCart(tv,1);
        customer2.addToCart(biscuits,1);
        customer2.Checkout();
        customer2.printBalance();
    }
}