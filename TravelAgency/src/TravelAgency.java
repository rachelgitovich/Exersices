import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelAgency {
    VehicleFactory vehicleFactory;
    List<Vehicle> availableVehicles;
    Map<Passenger, Vehicle> usedVehicles;


    public TravelAgency() {
        vehicleFactory=VehicleFactory.getInstance();
        usedVehicles=new HashMap<>();
        availableVehicles =new ArrayList<>();
        availableVehicles.add(vehicleFactory.createVehicle(VehicleType.PLANE));
        availableVehicles.add(vehicleFactory.createVehicle(VehicleType.BUS));
        availableVehicles.add(vehicleFactory.createVehicle(VehicleType.BUS));
        availableVehicles.add(vehicleFactory.createVehicle(VehicleType.BUS));
        availableVehicles.add(vehicleFactory.createVehicle(VehicleType.BUS));
        availableVehicles.add(vehicleFactory.createVehicle(VehicleType.TAXI));
        availableVehicles.add(vehicleFactory.createVehicle(VehicleType.TAXI));
        availableVehicles.add(vehicleFactory.createVehicle(VehicleType.TAXI));
        availableVehicles.add(vehicleFactory.createVehicle(VehicleType.TAXI));
        availableVehicles.add(vehicleFactory.createVehicle(VehicleType.TAXI));
        availableVehicles.add(vehicleFactory.createVehicle(VehicleType.TAXI));
        availableVehicles.add(vehicleFactory.createVehicle(VehicleType.TAXI));
        availableVehicles.add(vehicleFactory.createVehicle(VehicleType.TAXI));
        availableVehicles.add(vehicleFactory.createVehicle(VehicleType.BOAT));
        availableVehicles.add(vehicleFactory.createVehicle(VehicleType.BOAT));
        availableVehicles.add(vehicleFactory.createVehicle(VehicleType.BOAT));
    }
    public void assignVehicle(Passenger passenger){
        if(availableVehicles.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("there are no more available vehicles");
        }
        if(availableVehicles.stream().anyMatch(v->v.getType().equals(passenger.getFavoriteVehicle()))){
           Vehicle vehicle= availableVehicles.stream().filter(v->v.getType().equals(passenger.getFavoriteVehicle())).findFirst().get();
           availableVehicles.remove(vehicle);
           usedVehicles.put(passenger, vehicle);
        }
        else{
            Vehicle vehicle=availableVehicles.get(0);
            availableVehicles.remove(0);
            usedVehicles.put(passenger, vehicle);
        }
        if(availableVehicles.isEmpty()){
            usedVehicles.forEach((p,v)->v.transport(p));
        }
    }
}
