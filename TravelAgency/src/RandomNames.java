import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNames {
    private static List<String> names=new ArrayList<>(Arrays.asList("Liam","Noah","Oliver","Elijah","James","William","Benjamin","Lucas","Henry","Theodore","Tom","Jack","Alexander","Daniel","Samuel","Jacob","David"));
    public static String generateRandomName() {
        int index= ThreadLocalRandom.current().nextInt(names.size());
        String name = names.get(index);
        names.remove(index);
        return name;
    }
}
