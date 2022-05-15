import java.util.ArrayList;
import java.util.List;

public class Shop {

    private static final long BUY = 3000;
    private final List<Car> cars = new ArrayList<>();

    public synchronized Car sellCar() {
        try {
            System.out.format("%s зашёл в автосалон!\n", Thread.currentThread().getName());
            while (cars.isEmpty()) {
                System.out.println("Машин нет!");
                wait();
            }
            Thread.sleep(BUY);
            System.out.format("%s уехал на новом автомобиле! \n", Thread.currentThread().getName());
            return cars.remove(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public synchronized void addCar(Car car) {
        cars.add(car);
        notify();
    }
}