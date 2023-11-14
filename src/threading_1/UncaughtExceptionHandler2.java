package threading_1;

public class UncaughtExceptionHandler2 {
    private static final String MESSAGE_EXCEPTION_TEMPLATE = "Exception was thrown with message '%s' in thread '%s'." + System.lineSeparator();

    public static void main(String[] args) {
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = (thread, exception) ->
                System.out.printf(MESSAGE_EXCEPTION_TEMPLATE, exception.getMessage(), thread.getName());
        final Thread thread = new Thread(new Task());

        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);

//        thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        thread.start();
    }

    private static final class Task implements Runnable {

        @Override
        public void run() {
            throw new RuntimeException("I'm run");
        }
    }
}
