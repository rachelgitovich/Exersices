public class Parrot extends AbstractAnimal {
    public Parrot(double weight, Gender gender) {
        super(weight, gender);
    }

    @Override
    public void move() {
        System.out.println("Parrot Flying!!!");
    }

    @Override
    public Animal mate(Animal animal) throws Exception {

        if (!(animal instanceof Parrot)) {
            throw new Exception("Animals should be the same type");
        }
        if (((Parrot) animal).getGender() == this.getGender()) {
            throw new Exception("Animals should be different gender");
        }
        return new Parrot(AbstractAnimal.randomWeight(0.1, 1.5), Gender.randomGender());
    }

}
