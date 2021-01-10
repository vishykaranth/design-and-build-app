package decorator;

public class EdibleCupContainer extends Container {
    public EdibleCupContainer(IceCream iceCream) {
        super(iceCream);
    }

    public double getPrice(){
        return super.getPrice() + 0.40;
    }
}
