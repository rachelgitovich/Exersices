public class Horse extends AbstractAnimal {
    public Horse(double weight, Gender gender) {
        super(weight, gender);
    }

    @Override
    public void move() {
        System.out.println("Horse moving!!!");
    }

    @Override
    public Animal mate(Animal animal) throws Exception {
        if (!(animal instanceof Horse)) {
            throw new Exception("Animals should be the same type");
        }
        if (((Horse) animal).getGender() == this.getGender()) {
            throw new Exception("Animals should be different gender");
        }
        return new Horse(AbstractAnimal.randomWeight(9, 30), Gender.randomGender());
    }
}
