package logistics_system;

public class Truck extends Vehicle {

    private final static int capacityofTruck = 100;

    public Truck(int id, String vehicleNo) {
        super(id, vehicleNo, capacityofTruck);
    }
}
