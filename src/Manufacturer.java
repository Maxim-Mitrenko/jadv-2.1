public class Manufacturer {

    private String name;
    private static final long SEND_TIME = 5000;

    public Manufacturer(String name) {
        this.name = name;
    }

    public void sendToShop(Shop shop) {
        try {
            System.out.format("Производитель %s выпустил 1 автомобиль!\n", name);
            Thread.sleep(SEND_TIME);
            shop.addCar(new Car(this));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Toyota";
    }
}