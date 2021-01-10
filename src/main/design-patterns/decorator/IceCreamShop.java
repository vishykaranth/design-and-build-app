package decorator;

public class IceCreamShop {
    public static void main(String[] args) {
        IceCream iceCream = new VanillaFlavor(
                new PlasticCupContainer(
                        new ConcreteIceCream()
                )
        );
        System.out.println(iceCream.getPrice());


        iceCream = new VanillaFlavor(
                new EdibleConeContainer(
                        new ConcreteIceCream()
                )
        );
        System.out.println(iceCream.getPrice());

        iceCream = new VanillaFlavor(
                new EdibleCupContainer(
                        new ConcreteIceCream()
                )
        );
        System.out.println(iceCream.getPrice());


        iceCream = new VanillaFlavor(
                new StrawberryFlavor(
                        new EdibleCupContainer(
                                new ConcreteIceCream()
                        )
                )
        );
        System.out.println(iceCream.getPrice());


        iceCream = new VanillaFlavor(
                new StrawberryFlavor(
                        new EdibleCupContainer(
                                new ChocolateSyrupTopping(
                                        new ConcreteIceCream()
                                )
                        )
                )
        );
        System.out.println(iceCream.getPrice());
    }
}