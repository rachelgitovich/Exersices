public class Taxi implements Vehicle{
    @Override
    public void transport(Passenger passenger) {
        System.out.println(passenger.getName());
    }
    @Override
    public VehicleType getType(){
        return VehicleType.TAXI;
    }
}
