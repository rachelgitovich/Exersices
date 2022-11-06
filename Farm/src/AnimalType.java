import java.util.List;
import java.util.Random;

public enum AnimalType {
    DOG, CAT, PARROT, HORSE;
    private static final List<AnimalType> VALUES =
            List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static AnimalType randomType() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}

