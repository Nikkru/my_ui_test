package threading_1;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Runner4 {
    public static void main(String[] args) {
        final Thread thread = new Thread(new Task());
        thread.start();

//        System.out.println(Thread.currentThread().isDaemon());
        System.out.println("Main is finished");
    }

    private static final class Task implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("I'm working");
                try {
                    SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
