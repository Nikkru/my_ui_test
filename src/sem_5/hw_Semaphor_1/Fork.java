package sem_5.hw_Semaphor_1;

import java.util.concurrent.Semaphore;

public class Fork {
    private final Semaphore semaphore = new Semaphore(1);
    private final int id;
    private boolean free = true;

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public Fork(int id) {
        this.id = id;
    }

    void acquire() throws InterruptedException {
        semaphore.acquire();
    }

    void release() {
        semaphore.release();
    }

    boolean isAvailable() {
        System.out.println(semaphore.equals(0));
        return semaphore.equals(0);

    }

    int getID() {
        return id;
    }
}
