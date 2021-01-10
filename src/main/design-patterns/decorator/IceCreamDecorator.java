package decorator;

public abstract class IceCreamDecorator implements IceCream{
    IceCream iceCream;

    public IceCreamDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    public double getPrice() {
        return iceCream.getPrice();
    }
}