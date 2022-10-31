import java.util.List;
import java.util.Random;

public enum VehicleType {
    PLANE, BUS, TAXI, BOAT;
    private static final List<VehicleType> VALUES =
            List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static VehicleType randomType() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
