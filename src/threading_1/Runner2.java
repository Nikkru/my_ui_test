package threading_1;

import static java.lang.Thread.currentThread;
import static java.util.stream.IntStream.rangeClosed;

public class Runner2 {
    private static final int FROM_NUMBER_FIRST_THREAD = 1;
    private static final int TO_NUMBER_FIRST_THREAD = 500;

    private static final int FROM_NUMBER_SECOND_THREAD = 501;
    private static final int TO_NUMBER_SECOND_THREAD = 1000;

//    private static final int TIME_WAITING_IN_MILLIS = 1000;

    private static final String TEMPLATE_MESSAGED_THREAD_NAME_AND_NUMBER = "%s : %d" + System.lineSeparator();

    public static void main(String[] args) throws InterruptedException {
        final TaskSummingNumbers firstTask = new TaskSummingNumbers(FROM_NUMBER_FIRST_THREAD, TO_NUMBER_FIRST_THREAD);
        final Thread firstThread = new Thread(firstTask);
        firstThread.start();
        final TaskSummingNumbers secondTask = new TaskSummingNumbers(FROM_NUMBER_SECOND_THREAD, TO_NUMBER_SECOND_THREAD);
        final Thread secondThread = new Thread(secondTask);
        secondThread.start();
//        startThread(secondTask);
//        final TaskSummingNumbers firstTask = startSubTask(FROM_NUMBER_FIRST_THREAD, TO_NUMBER_FIRST_THREAD);
//        final TaskSummingNumbers secondTask = startSubTask(FROM_NUMBER_SECOND_THREAD, TO_NUMBER_SECOND_THREAD);
        waitForTaskFinished(firstThread, secondThread);
        final int resultNumber = firstTask.getResultNumber() + secondTask.getResultNumber();
        printThreadNameAndNumber(resultNumber);
//        System.out.println(resultNumber);

    }
/*
    private static void startThread(final Runnable runnable) {
        final Thread thread = new Thread(runnable);
        thread.start();
    }
*/
//    private static TaskSummingNumbers startSubTask(final int fromNumber, final int toNumber) {
//        final TaskSummingNumbers subTask = new TaskSummingNumbers(fromNumber, toNumber);
//        final Thread thread = new Thread(subTask);
//        thread.start();
//        return subTask;
//    }

    private static void printThreadNameAndNumber(final int number) {
        System.out.printf(TEMPLATE_MESSAGED_THREAD_NAME_AND_NUMBER, currentThread().getName(), number);
    }

//    Логика ожидания
    private static void waitForTaskFinished(final Thread... threads) throws InterruptedException {
//        Thread.sleep(TIME_WAITING_IN_MILLIS);
        for (final Thread thread : threads) {
            thread.join();
        }
    }

    private static final class TaskSummingNumbers implements Runnable {
        private static final int INITIAL_VALUE_RESULT_NUMBER = 0;

        private final int fromNumber;
        private final int toNumber;
        private int resultNumber;

        public TaskSummingNumbers(final int fromNumber, final int toNumber) {
            this.fromNumber = fromNumber;
            this.toNumber = toNumber;
            this.resultNumber = INITIAL_VALUE_RESULT_NUMBER;
        }

        public int getResultNumber() {
            return resultNumber;
        }

        @Override
        public void run() {
            rangeClosed(fromNumber, toNumber).forEach(i -> resultNumber += i);
            printThreadNameAndNumber(resultNumber);
//            System.out.println(resultNumber);
        }
    }
}
