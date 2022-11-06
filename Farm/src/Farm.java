import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Farm {
    public List<Animal> animals;

    public Farm() throws Exception {
        animals = new ArrayList<Animal>();
        for (int i = 0; i < 10; i++) {
            animals.add(acquire(AnimalType.randomType(), Gender.randomGender()));
        }
    }

    public Animal acquire(AnimalType type, Gender gender) throws Exception {
        Animal animal = null;
        switch (type) {
            case CAT:
                animal = new Cat(AbstractAnimal.randomWeight(3, 5), gender);
                break;
            case DOG:
                animal = new Dog(AbstractAnimal.randomWeight(3, 5), gender);
                break;
            case PARROT:
                animal = new Parrot(AbstractAnimal.randomWeight(3, 5), gender);
                break;
            default:
                throw new Exception("type is not supported");
        }
        if(animal!=null) animals.add(animal);
        return animal;
    }
}
