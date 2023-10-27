package sem_3.hw.cmpareArrays;
import sem_3.hw.fruit.Apple;
import sem_3.hw.fruit.Orange;

import java.util.ArrayList;
import java.util.List;

public class ArrayMulti<T> {
    private final List<T> container;

    public ArrayMulti() {
        container = new ArrayList<>();
    }
    public boolean compareArrays(ArrayMulti<?> with) {
       return this.container.size() == with.container.size() & this.getClass().getName() == with.getClass().getName();
    }
    void add(T t) {
        container.add(t);
    }

    public static void main(String[] args) {

        ArrayMulti<Apple> appleArr = new ArrayMulti<>();
        ArrayMulti<Apple> appleArrayMulti = new ArrayMulti<>();
        ArrayMulti<Orange> orangeArr = new ArrayMulti<>();

        appleArr.add(new Apple());
        appleArr.add(new Apple());
        appleArr.add(new Apple());
        appleArr.add(new Apple());

        appleArrayMulti.add(new Apple());
        appleArrayMulti.add(new Apple());
        appleArrayMulti.add(new Apple());

        orangeArr.add(new Orange());
        orangeArr.add(new Orange());
        orangeArr.add(new Orange());

        System.out.println(orangeArr.container.size());
        System.out.println(appleArrayMulti.compareArrays(appleArr));
        System.out.println(appleArrayMulti.compareArrays(orangeArr));
    }
}
