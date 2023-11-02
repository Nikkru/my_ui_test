package sem_5.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Table extends Thread {
//    private Philosopher philosopher;
    public List<Philosopher> philosophers;
    private Semaphore semaphore = new Semaphore(2,true);

    public Table() {
//        this.philosopher = philosopher;
//        this.semaphore = semaphore;
        philosophers = new ArrayList<>(5);

        philosophers.add(new Philosopher(semaphore,"1"));
        philosophers.add(new Philosopher(semaphore,"2"));
        philosophers.add(new Philosopher(semaphore,"3"));
        philosophers.add(new Philosopher(semaphore,"4"));
        philosophers.add(new Philosopher(semaphore,"5"));
    }

    private void refreshAndWork(Philosopher philosopher) {
        try {
            semaphore.acquire();
            System.out.println(philosopher.getName() + " берет вилки и трапезничает");
            sleep(1000);
            philosopher.setFull(true);

            System.out.println(philosopher.getName() + " кладет вилки и филосовствует");
            semaphore.release();
            sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Всё запуталось");
        }
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 3) {
            for (int j = 0; j < philosophers.size(); j++) {
            if (!philosophers.get(j-1).isFull() && !philosophers.get(j).isFull() && !philosophers.get(j+1).isFull()) {
                refreshAndWork(philosophers.get(j));
            }
            }
        }
    }
}
