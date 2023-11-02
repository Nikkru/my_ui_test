package sem_5.homework;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
//    private Fork fork;
    private Semaphore semaphore;
    private String name;
    private boolean full;

//    public List<Fork> forks;


    public Philosopher(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            if (!isFull()) {
                semaphore.acquire();
                System.out.println(name + " берет вилки и трапезничает");
                sleep(1000);
                setFull(true);

                System.out.println(name + " кладет вилки и филосовствует");
                semaphore.release();
                sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Всё запуталось");
        }
    }

    //    private void eat() {
//        try {
//        if (!full) {
//            semaphore.acquire();
//            sleep(1000);
//            setFull(true);
//        }
//        } catch (InterruptedException e) {
//            System.out.println("Wrong way");;
//        }
//    }

//    private void think() {
//        for (Fork f:forks) {
//            if (f.isAreInTheHands()) {
//                f.setAreInTheHands(false);
//            }
//        }
//    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }
}
