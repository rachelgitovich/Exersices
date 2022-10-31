public class Passenger {
    private String name;
    private VehicleType favoriteVehicle;

    public Passenger(String name) {
        this.name = name;
        this.favoriteVehicle = VehicleType.randomType();
    }

    public String getName() {
        return name;
    }

    public VehicleType getFavoriteVehicle() {
        return favoriteVehicle;
    }
}
