package threading_1;

import static java.lang.System.out;
import static java.lang.Thread.currentThread;

public class Runner {
    public static void main(String[] args) {
        out.println(currentThread().getName());

        final Thread thread = new Thread() {
            @Override
            public void run() {
                out.println(currentThread().getName());
            }
        };
        thread.start();
    }
}
