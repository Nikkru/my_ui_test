package sem_3.task2;

public class MyArray<T> {
    Object[] objects = new Object[10];
    int size;

//    public MyArray() {
//        size = objects.length;
//    }

    public void add(T t) {
        if (size >= objects.length) {
            Object[] objects1 = new Object[objects.length * 2];
            System.arraycopy(
                    objects,
                    0,
                    objects1,
                    0,
                    objects.length);
            objects = objects1;
        }
        objects[size++] = t;
    }

    public void remove(int index) {
        if (index >= size) {
            System.out.println("Индекс за пределами размера массива");
        }
        System.arraycopy(
                objects,
                index + 1,
                objects,
                index,
                objects.length - index - 1);
        size--;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size-1; i++) {
            stringBuilder.append(objects[i]);
            stringBuilder.append(", ");
        }
        stringBuilder.append(objects[size-1]);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
