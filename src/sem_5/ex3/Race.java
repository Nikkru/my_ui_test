package sem_5.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Race extends Thread {
    private List<Runner> runners;
    private CountDownLatch countDownLatch;

    public Race() {
        countDownLatch = new CountDownLatch(3);
        runners = new ArrayList<>(3);

        runners.add(new Runner("Max", countDownLatch));
        runners.add(new Runner("John", countDownLatch));
        runners.add(new Runner("Bob", countDownLatch));
    }

    @Override
    public void run() {
        goOnStart();
        try {
            countDownLatch.await();
            goAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void goAll() throws InterruptedException {
        sleep(1000);
        System.out.println("To Start!");
        sleep(1000);
        System.out.println("Attention!");
        sleep(1000);
        System.out.println("Go ahead!");
        for (Runner runner: runners) {
            runner.go();
        }
    }

    private void goOnStart() {
        for (Runner runner: runners) {
            runner.start();
        }
    }
}
