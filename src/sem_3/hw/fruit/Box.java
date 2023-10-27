package sem_3.hw.fruit;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {
    private final List<T> container;

    public Box() {
        container = new ArrayList<>();
    }

    void add(T fruit) {
        container.add(fruit);
    }

    public T get(int index) {
        return container.get(index);
    }

    float getWeight() {
        return (container.isEmpty()) ? 0 : container.get(0).getWeight() * container.size();
    }

    boolean compare(Box<?> with) {
        return this.getWeight() == with.getWeight();
    }

    void transferTo(Box<? super T> dest) {
        dest.container.addAll(container);
        this.container.clear();
    }
}
