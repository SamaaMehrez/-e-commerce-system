package E_Commerce;

interface Shippable {
    double getWeight();
    String getName();
}
public class ShippableProduct extends Product implements Shippable{
    private double weight;
    public ShippableProduct(String name, double price, int quantity,int weight, boolean expired) {
        super(name, price, quantity,expired);
        this.weight = weight;
    }


    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}

