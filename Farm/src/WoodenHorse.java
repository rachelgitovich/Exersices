public class WoodenHorse implements WoodenStructures {
    @Override
    public void roll() {
        System.out.println("Wooden Horse rolling!");
    }

    @Override
    public WoodenHorse replicate() {
        return new WoodenHorse();
    }
}
