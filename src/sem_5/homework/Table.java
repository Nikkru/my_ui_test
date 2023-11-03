package sem_5.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Table extends Thread {
//    private Philosopher philosopher;
    public List<Philosopher> philosophers;
    private Semaphore semaphore = new Semaphore(2);
    private List<Fork> forks;

    public Table() {
//        this.philosopher = philosopher;
//        this.semaphore = semaphore;
        philosophers = new ArrayList<>(5);
        forks = new ArrayList<>(philosophers.size());

        putForks();

        philosophers.add(new Philosopher(semaphore,"1", forks.get(4), forks.get(0)));
        philosophers.add(new Philosopher(semaphore,"2", forks.get(0), forks.get(1)));
        philosophers.add(new Philosopher(semaphore,"3", forks.get(1), forks.get(2)));
        philosophers.add(new Philosopher(semaphore,"4", forks.get(2), forks.get(3)));
        philosophers.add(new Philosopher(semaphore,"5", forks.get(3), forks.get(4)));
    }

    private void putForks() {
        int i = 0;
        while (i < 5) {
            forks.add(new Fork());
            i++;
        }
    }

    private void refreshAndWork(Philosopher philosopher) {
        try {
            semaphore.acquire();
            System.out.println(philosopher.getName() + " берет вилки и трапезничает");
            philosopher.full = true;
            sleep(1000);

            System.out.println(philosopher.getName() + " кладет вилки и филосовствует");

            philosopher.full = false;
            semaphore.release();
            sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Всё запуталось");
        }
    }

    @Override
    public void run() {
            for (int j = 0; j < philosophers.size()-1; j++) {
                if (j == 0) {
                    if (!philosophers.get(philosophers.size()-1).full && !philosophers.get(j).full && !philosophers.get(j+1).isFull()) {
                        refreshAndWork(philosophers.get(j));
                    }
                }
                if (j > 0 && j < philosophers.size()-1) {
                    if (!philosophers.get(j - 1).isFull() && !philosophers.get(j).isFull() && !philosophers.get(j+1).isFull()) {
                        refreshAndWork(philosophers.get(j));
                    }
                }
                if (j == philosophers.size()-1) {
                    if (!philosophers.get(j - 1).isFull() && !philosophers.get(j).isFull() && !philosophers.get(0).isFull()) {
                        refreshAndWork(philosophers.get(j));
                }
            }
        }
    }
}
