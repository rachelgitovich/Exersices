public class Farmer {
    private Farm farm;

    public Farmer() throws Exception {
        farm=new Farm();
    }

    public void moveAnimal(AnimalType type) throws Exception {
        farm.acquire(type, Gender.randomGender()).move();
    }

}
