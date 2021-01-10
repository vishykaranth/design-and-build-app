package decorator;

public class ChocolateSyrupTopping extends Topping {
    public ChocolateSyrupTopping(IceCream iceCream) {
        super(iceCream);
    }

    public double getPrice(){
        return super.getPrice() + 0.60;
    }
}
