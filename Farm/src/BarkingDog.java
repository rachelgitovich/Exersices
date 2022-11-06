public class BarkingDog {
    private Dog d;

    public BarkingDog(double weight, Gender gender) {
        d = new Dog(weight, gender);
    }

    public void bark() {
        System.out.println("Wuff!! Wuff!!");
    }

    public Animal mate(Animal animal) throws Exception {
        return d.mate(animal);
    }

    public void move() {
        d.move();
    }

}
