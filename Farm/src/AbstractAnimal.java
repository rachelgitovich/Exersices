import java.util.Map;

public abstract class AbstractAnimal implements Animal {
    private int id;
    private double weight;
    private Gender gender;

    private static int idCounter = 1;

    public Gender getGender() {
        return gender;
    }

    public AbstractAnimal(double weight, Gender gender) {
        this.id = idCounter++;
        this.weight = weight;
        this.gender = gender;
    }

    public static double randomWeight(double minWeight, double maxWeight) {
        return (Math.random() * (maxWeight - minWeight) + minWeight);
    }

}
