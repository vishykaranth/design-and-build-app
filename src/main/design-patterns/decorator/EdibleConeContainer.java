package decorator;

public class EdibleConeContainer extends Container {
    public EdibleConeContainer(IceCream iceCream) {
        super(iceCream);
    }

    public double getPrice(){
        return super.getPrice() + 0.40;
    }
}
