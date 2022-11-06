public class Dog extends AbstractAnimal {
    public Dog(double weight, Gender gender) {
        super(weight, gender);
    }

    @Override
    public void move() {
        System.out.println("Dog jumping!!!");
    }

    @Override
    public Animal mate(Animal animal) throws Exception {
        if (!(animal instanceof Dog)) {
            throw new Exception("Animals should be the same type");
        }
        if (((Dog) animal).getGender() == this.getGender()) {
            throw new Exception("Animals should be different gender");
        }
        return new Dog(AbstractAnimal.randomWeight(9, 30), Gender.randomGender());
    }
}
