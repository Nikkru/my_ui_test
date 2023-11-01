package sem_5.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Table extends Thread {
    private Forks forks;
    private List<Philosopher> philosophers;
    private CountDownLatch countDownLatch;

    public Table(Forks forks) {
        this.forks = forks;
        countDownLatch = new CountDownLatch(5);
        philosophers = new ArrayList<>(5);

        philosophers.add(new Philosopher("1", countDownLatch, forks));
        philosophers.add(new Philosopher("2", countDownLatch, forks));
        philosophers.add(new Philosopher("3", countDownLatch, forks));
        philosophers.add(new Philosopher("4", countDownLatch, forks));
        philosophers.add(new Philosopher("5", countDownLatch, forks));
    }
}
