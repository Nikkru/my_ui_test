package threading_1;

public class Runner3 {
    private static final String MESSAGE_TEMPLATE_THREAD_STATE = "%s : %s" + System.lineSeparator();
    private static final int AMOUNT_MILLISECONDS_TO_JOIN_IN_THREAD_ON_MAIN = 2000;

    public static void main(String[] args) throws InterruptedException {
        final Thread mainThread = Thread.currentThread();
        final Thread thread = new Thread(() -> {
            try {
                mainThread.join(AMOUNT_MILLISECONDS_TO_JOIN_IN_THREAD_ON_MAIN);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            showThreadState(Thread.currentThread());
            throw new RuntimeException();
        });

        thread.start();
        Thread.sleep(1000);
        showThreadState(thread);
        thread.join();
        showThreadState(thread);
    }

    private static void showThreadState(final Thread thread) {
        System.out.printf(String.format(MESSAGE_TEMPLATE_THREAD_STATE, thread.getName(), thread.getState()));
    }
}
