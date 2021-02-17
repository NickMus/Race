import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {}
//
//        Semaphore smp = new Semaphore(0);
//
//
//
//        new Thread(() -> {
//            CyclicBarrier cb = new CyclicBarrier(4);
//            try {
//                smp.acquire();
//                System.out.println(this.name + " готовится");
//                Thread.sleep(500 + (int) (Math.random() * 800));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(this.name + " готов");
//            try {
//                cb.await();
//            } catch (InterruptedException | BrokenBarrierException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//
//        new Thread(() -> {
//            try {
//                smp.acquire();
//                for (int i = 0; i < race.getStages().size(); i++) {
//                    race.getStages().get(i).go(this);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                smp.release();
//            }
//
//        }).start();
//    }
}








