package threading_1;

import static java.lang.System.out;
import static java.util.stream.IntStream.range;

public class Priority {
    private static final String MESSAGE_TEMPLATE_THREAD_NAME_PRIORITY = "%s : %d" + System.lineSeparator();

    public static void main(String[] args) {
        printThreadNameAndPriority(Thread.currentThread());
//        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        final Thread thread = new Thread(() -> printThreadNameAndPriority(Thread.currentThread()));
        thread.start();

        final Thread thread1 = new Thread(new Task());
        thread1.setPriority(9);
        thread1.start();

        out.println("Main mis finished.");
    }

    private static void printThreadNameAndPriority(final Thread thread) {
        out.printf(String.format(MESSAGE_TEMPLATE_THREAD_NAME_PRIORITY, thread.getName(), thread.getPriority()));
    }

    private static final class Task implements Runnable {
        @Override
        public void run() {
            range(0, 100).forEach(out::println);
        }
    }
}
