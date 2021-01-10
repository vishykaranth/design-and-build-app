package decorator;

public class VanillaFlavor extends Flavor {
    public VanillaFlavor(IceCream iceCream) {
        super(iceCream);
    }

    public double getPrice(){
        return super.getPrice() + 1.0;
    }
}
