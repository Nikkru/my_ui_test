package sem_5.ex1;

public class Main {
    public static void main(String[] args) {
        Friend friend1 = new Friend("Mark");
        Friend friend2 = new Friend("Klara");

        Thread thread1 = new MyThread(friend1, friend2);
        Thread thread2 = new MyThread(friend2, friend1);

        thread1.start();
        thread2.start();
    }
}
