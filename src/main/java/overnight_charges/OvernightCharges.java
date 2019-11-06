package overnight_charges;

import overnight_charges.position.Position;
import overnight_charges.price.Price;

import java.math.BigDecimal;

public class OvernightCharges {
    private Position position;
    private Price price;

    public double getCharges() {
        BigDecimal priceVal = new BigDecimal(price.getPrice());
        BigDecimal positionVal = new BigDecimal(position.getPositionValue());

        return positionVal.multiply(priceVal).doubleValue();
    }

    public void setPosition(Position position) {

        this.position = position;
    }

    public void setPrice(Price price) {

        this.price = price;
    }
}
