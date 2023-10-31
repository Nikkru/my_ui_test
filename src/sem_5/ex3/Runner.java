package sem_5.ex3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner extends Thread {

    private String name;
    private double speed;
    private Random random;
    private CountDownLatch countDownLatch;

    public Runner(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        random = new Random();
        speed = random.nextDouble(2, 7);
    }

    @Override
    public void run() {
        try {
            goOnStart();
        synchronized (this) {
            wait();
        }
        goOnFinish();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void goOnStart() throws InterruptedException {
        System.out.println(name + " go on Start");
        sleep(random.nextInt(2, 5)*1000L);
        System.out.println(name + " on Start");
//        меням значение счетчика на 1
        countDownLatch.countDown();
    }

    private void goOnFinish() throws InterruptedException {
        sleep((long) (speed * 1000));
        System.out.println(name + " finished");
    }

    public void  go() {
        synchronized (this) {
            notify();
        }
    }
}
