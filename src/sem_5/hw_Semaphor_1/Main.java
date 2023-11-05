package sem_5.hw_Semaphor_1;

public class Main {
    private static final int N = 5;
    private static final int DINNERSCOUNT = 3;
    private static Philosopher[] philosophers = new Philosopher[N];
    private static Fork[] forks = new Fork[N];

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            forks[i] = new Fork(i);
        }
        for (int i = 0; i < N; i++) {
            philosophers[i] = new Philosopher(i, DINNERSCOUNT, forks[i], forks[(i + 1) % N]);
            philosophers[i].start();
        }
    }
}
