package sem_5.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Philosopher extends Thread {
    private Forks forks;
    private String name;
    private CountDownLatch countDownLatch;
    private boolean isWithForks;

    public Philosopher(String name, CountDownLatch countDownLatch, Forks forks) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.forks = forks;
    }

    private void eat() {
        if (forks.isInTheHands()) {
            forks.setInTheHands(false);
        };
    }

    private void think() {
        if (!forks.isInTheHands()) {
            forks.setInTheHands(true);
        };
    }
}
