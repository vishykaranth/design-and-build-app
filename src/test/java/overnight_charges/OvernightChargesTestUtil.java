package overnight_charges;

import overnight_charges.position.Position;
import overnight_charges.price.Price;

public class OvernightChargesTestUtil {
    OvernightCharges populateOvernightCharges(Position position, Price price) {
        OvernightCharges overnightCharges = new OvernightCharges();
        overnightCharges.setPosition(position);
        overnightCharges.setPrice(price);
        return overnightCharges;
    }
}
