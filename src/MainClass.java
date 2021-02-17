import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
        for (int i = 0; i < CARS_COUNT; i++) {
            final int w = i + 1;
            new Thread(() -> {
                try {
                    System.out.println("Участник #" + w + " готовится");
                    Thread.sleep(500 + (int) (Math.random() * 800));
                    System.out.println("Участник #" + w + " готов");

                    cb.await();

                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }



                for (int y = 0; y < race.getStages().size(); y++) {
                    race.getStages().get(y).go(cars[w - 1]);
                }
            }).start();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}


//        new Thread(() -> {
//
//
//
//
//        }).start();







