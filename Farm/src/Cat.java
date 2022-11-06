public class Cat extends AbstractAnimal {
    public Cat(double weight, Gender gender) {
        super(weight, gender);
    }

    @Override
    public void move() {
        System.out.println("Cat moving!!!");
    }

    @Override
    public Animal mate(Animal animal) throws Exception {
        if (!(animal instanceof Cat)) {
            throw new Exception("Animals should be the same type");
        }
        if (((Cat) animal).getGender() == this.getGender()) {
            throw new Exception("Animals should be different gender");
        }
        return new Cat(AbstractAnimal.randomWeight(3, 5), Gender.randomGender());
    }

}
