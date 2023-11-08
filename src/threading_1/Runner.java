package threading_1;

import static java.lang.System.out;
import static java.lang.Thread.currentThread;
import static java.util.stream.IntStream.range;

public class Runner {
    private  static final int CREATED_THREADS_AMOUNT = 10;

    public static void main(String[] args) {
        final Runnable task = () -> out.println(currentThread().getName());
//        final Thread thread = new Thread(task);
//        thread.start();
        final Runnable taskCreatingThread = () -> range(0, CREATED_THREADS_AMOUNT)
                .forEach(i -> startThread(task));
        startThread(taskCreatingThread);
    }

    private static  void startThread(final Runnable runnable) {
        final Thread thread = new Thread(runnable);
        thread.start();
    }
}
