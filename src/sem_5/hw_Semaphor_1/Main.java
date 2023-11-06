package sem_5.hw_Semaphor_1;

public class Main {
    private static final int NUMBEROFPHILOSIPHERS = 5;
    private static final int NUMBEROFDINNERS = 3;
    private static Philosopher[] philosophers = new Philosopher[NUMBEROFPHILOSIPHERS];
    private static Fork[] forks = new Fork[NUMBEROFPHILOSIPHERS];

    public static void main(String[] args) {
        for (int i = 0; i < NUMBEROFPHILOSIPHERS; i++) {
            forks[i] = new Fork(i);
        }
        for (int i = 0; i < NUMBEROFPHILOSIPHERS; i++) {
            philosophers[i] = new Philosopher(i, NUMBEROFDINNERS, forks[i], forks[(i + 1) % NUMBEROFPHILOSIPHERS]);
            philosophers[i].start();
        }
    }
}
