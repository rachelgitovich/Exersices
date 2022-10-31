public class VehicleFactory {
    private static VehicleFactory instance;
    private VehicleFactory(){}
    public static VehicleFactory getInstance(){
        if(instance==null){
            instance = new VehicleFactory();
        }
        return instance;
    }
    public Vehicle createVehicle(VehicleType type) {
        switch (type) {
            case PLANE:
                return new Plane();
            case BUS:
                return new Bus();
            case TAXI:
                return new Taxi();
            case BOAT:
                return new Boat();
            default:
                throw new IllegalArgumentException(String.format("Vehicle type not supported: %s", type));
        }
    }
}
