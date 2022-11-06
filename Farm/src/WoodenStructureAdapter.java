public class WoodenStructureAdapter implements WoodenStructures {
    Horse horse;

    public WoodenStructureAdapter(Horse horse) {

        this.horse = horse;
    }
    public WoodenStructureAdapter() {
        super();
        this.horse = new Horse(AbstractAnimal.randomWeight(0.2, 1), Gender.randomGender());
    }


    @Override
    public void roll() {
        horse.move();
    }

    @Override
    public WoodenStructures replicate() {
        return new WoodenStructureAdapter();
    }
}
