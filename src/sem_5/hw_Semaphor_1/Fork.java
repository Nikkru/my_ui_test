package sem_5.hw_Semaphor_1;

import java.util.concurrent.Semaphore;

public class Fork {
    private final Semaphore mutex = new Semaphore(1);
    private final int id;

    public Fork(int id) {
        this.id = id;
    }

    void acquire() throws InterruptedException {
        mutex.acquire();
    }

    void release() {
        mutex.release();
    }

    boolean isAvailable() {
        return mutex.equals(null);
    }

    int getID() {
        return id;
    }
}
