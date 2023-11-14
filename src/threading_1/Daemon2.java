package threading_1;

public class Daemon2 {
    public static void main(String[] args) throws InterruptedException {
        final Thread firestDaemonThread = new Thread(() -> {
            printThreadNameAndStatus(Thread.currentThread());
            final Thread secondDaemonThread = new Thread(() -> printThreadNameAndStatus(Thread.currentThread()));
            secondDaemonThread.start();
            try {
                secondDaemonThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        firestDaemonThread.setDaemon(true);
        firestDaemonThread.start();

        firestDaemonThread.join();
    }

    private static void printThreadNameAndStatus(final Thread thread) {
        System.out.printf("%s : %b" + System.lineSeparator(), thread.getName(), thread.isDaemon());
    }
}
