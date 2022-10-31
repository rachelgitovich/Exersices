public class Plane implements Vehicle{
    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.getName());
    }
    @Override
    public VehicleType getType(){
        return VehicleType.PLANE;
    }
}
