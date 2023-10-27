package sem_3.hw.fruit;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {
    private final List<T> container;

    public Box() {
        container = new ArrayList<>();
    }
//    public void addAll(List<? super T> list) {
//        container.addAll(list);
//    }
//    private <T> void addHelper(List<T> list) {
//        container.addAll(list);
//    }
    void add(T fruit) {
        container.add(fruit);
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
