package decorator;

public class StrawberryFlavor extends Flavor {
    public StrawberryFlavor(IceCream iceCream) {
        super(iceCream);
    }

    public double getPrice(){
        return super.getPrice() + 2.0;
    }
}