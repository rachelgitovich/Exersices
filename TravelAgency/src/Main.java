
public class Main {
    public static void main(String[] args) {

        TravelAgency travelAgency = new TravelAgency();
        for (int i = 0; i < 16; i++) {
            travelAgency.assignVehicle(new Passenger(RandomNames.generateRandomName()));
        }
    }
}