package sem_5.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Table extends Thread {
    private List<Fork> allForks;
    private List<Philosopher> philosophers;
    private List<AtTheTablePlace> atTheTablePlaces;

    private CountDownLatch countDownLatch;

    public Table() {
        countDownLatch = new CountDownLatch(5);
        allForks = new ArrayList<>(5);
        philosophers = new ArrayList<>(5);

//        allForks.add(new Fork("1"));
//        allForks.add(new Fork("2"));
//        allForks.add(new Fork("3"));
//        allForks.add(new Fork("4"));
//        allForks.add(new Fork("5"));



//        philosophers.add(new Philosopher("1", countDownLatch, new ArrayList<Fork>()));
//        philosophers.add(new Philosopher("2", countDownLatch, forks));
//        philosophers.add(new Philosopher("3", countDownLatch, forks));
//        philosophers.add(new Philosopher("4", countDownLatch, forks));
//        philosophers.add(new Philosopher("5", countDownLatch, forks));
    }
}
