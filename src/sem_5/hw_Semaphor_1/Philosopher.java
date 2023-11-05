package sem_5.hw_Semaphor_1;

import java.util.Random;

public class Philosopher extends Thread {
    private final int id;
    private int dinnersCount;
    private final Fork leftFork;
    private final Fork rightFork;
    private int count = 0;

    public Philosopher(int id, int dinnersCount, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.dinnersCount = dinnersCount;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void eat() {
        try {
            Thread.sleep(500);
            System.out.println("Philosopher " + id + " completed their dinner " + (count + 1) + " times");
        } catch (InterruptedException ex) {
            System.out.println("Что-то не так");
        }
    }

    private void takeFork(Fork fork) throws InterruptedException {
        if (!fork.isAvailable()) {
            System.out.println("Philosopher " + id + " is waiting for fork " + fork.getID());
        }
        fork.acquire();
        System.out.println("Fork " + fork.getID() + " taken by Philosopher " + id);
    }

    @Override
    public void run() {
        if (!leftFork.isAvailable() && !rightFork.isAvailable()) {
            try {
                while (count < dinnersCount) {
                    Thread.sleep(new Random().nextInt(500));
                    takeFork(leftFork);
                    takeFork(rightFork);
                    System.out.println("Now philosopher " + id + " is eating");
                    eat();
                    System.out.println(
                                    "Philosopher " + id + " put fork " + leftFork.getID()
                                    + " and fork " + rightFork.getID() + System.lineSeparator()
                                    + "Now philosopher " + id + " is thinking");
                    leftFork.release();
                    rightFork.release();
                    count++;
                }
            } catch (InterruptedException ex) {
                System.out.println("Что-то не так");
            }
        }
    }
}
