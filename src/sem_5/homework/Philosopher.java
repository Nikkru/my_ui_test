package sem_5.homework;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
//    private Fork fork;
    private Semaphore semaphore;
    private String name;
    private Fork leftFork;
    private Fork rightFork;
    private Table table;
    public boolean full;

//    public List<Fork> forks;


    public Philosopher(Semaphore semaphore, String name, Fork fork, Fork fork1) {
        this.semaphore = semaphore;
        this.name = name;
        leftFork = fork;
        rightFork = fork1;
        table = new Table();
    }

    @Override
    public void run() {
        refreshAndWork(table);
    }

    private void refreshAndWork(Table table) {
        try {
            if (!leftFork.isAreInTheHands() && !rightFork.isAreInTheHands()) {
                semaphore.acquire();
                System.out.println(name + " берет вилки и трапезничает");
                leftFork.setAreInTheHands(true);
                rightFork.setAreInTheHands(true);
                sleep(1000);

                System.out.println(name + " кладет вилки и филосовствует");
                leftFork.setAreInTheHands(false);
                rightFork.setAreInTheHands(false);
                semaphore.release();
                sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Всё запуталось");
        }
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }
}
