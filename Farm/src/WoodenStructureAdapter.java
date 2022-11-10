public class WoodenStructureAdapter implements Animal {
private WoodenStructures woodenStructures;

    public WoodenStructureAdapter(WoodenStructures woodenStructures) {
        this.woodenStructures = woodenStructures;
    }

    @Override
    public void move() {
        woodenStructures.roll();
    }

    @Override
    public Animal mate(Animal animal) throws Exception {
        return new WoodenStructureAdapter(woodenStructures.replicate());
    }
}
