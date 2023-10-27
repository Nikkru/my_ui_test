package sem_3.task2;

public class Main {
    public static void main(String[] args) {
        MyArray<String> array = new MyArray<>();
        array.add("one");
        array.add("two");
        array.add("three");
        array.add("fore");
        System.out.println(array);
        array.remove(0);
        System.out.println(array);
    }
}
