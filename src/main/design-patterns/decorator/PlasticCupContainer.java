package decorator;

public class PlasticCupContainer extends Container {
    public PlasticCupContainer(IceCream iceCream) {
        super(iceCream);
    }

    public double getPrice() {
        return super.getPrice() + 0.50;
    }
}
