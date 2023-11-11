package threading_1;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Server {
    private static final String MESSAGE_TEMPLATE_THREAD_STATE = "%s : %s" + System.lineSeparator();

    private static final String MESSAGE_REQUEST_WAS_SENT = System.lineSeparator() + "Request was sent";
    private static final String MESSAGE_RESPONSE_WAS_RECEIVED = System.lineSeparator() + "Request was received";
    private static final String SERVER_WAS_STOPPED = "Server was stopped";
    private static final String MESSAGE_THREAD_WAS_INTERRUPTED = "Tread was interrupted";
    private static final int DURATION_IN_SECONDS_DELIVERING_RESPONDS = 1;
    private static final int TIME_WAITING_IN_SECONDS_BEFORE_STOPPING_THREAD = 5;

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        final Thread communicationThread = new Thread(()-> {
            while (true) {
                try {
                    doRequest();
//                    if (Thread.currentThread().isInterrupted()) {
//                        System.out.println(MESSAGE_THREAD_WAS_INTERRUPTED);
//                    }
                } catch (final InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().isInterrupted());
                    System.out.println(MESSAGE_THREAD_WAS_INTERRUPTED);
                }
            }
        });
        communicationThread.start();
        showThreadState(communicationThread);

        final Thread stoppingThread = new Thread(() -> {
            if (isServerShouldBeOffed()) {
                communicationThread.interrupt();
                System.out.println(MESSAGE_THREAD_WAS_INTERRUPTED);
                stopServer();
            }
        });
        SECONDS.sleep(TIME_WAITING_IN_SECONDS_BEFORE_STOPPING_THREAD);
        stoppingThread.start();
        showThreadState(stoppingThread);
    }

    private static void doRequest() throws InterruptedException {
        count++;
        System.out.println(MESSAGE_REQUEST_WAS_SENT + " " + count);
        SECONDS.sleep(DURATION_IN_SECONDS_DELIVERING_RESPONDS);
        System.out.println(MESSAGE_RESPONSE_WAS_RECEIVED);
    }

    private static void showThreadState(final Thread thread) {
        System.out.printf(String.format(MESSAGE_TEMPLATE_THREAD_STATE, thread.getName(), thread.getState()));
    }

    private static boolean isServerShouldBeOffed() {
        return true;
    }

    private static void stopServer() {
        System.out.println(SERVER_WAS_STOPPED);
    }
}
