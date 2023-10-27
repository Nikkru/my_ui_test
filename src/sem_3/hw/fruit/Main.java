package sem_3.hw.fruit;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orngeBox = new Box<>();
        Box<Fruit> fruitBox = new Box<>();


        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        orngeBox.add(new Orange());
        orngeBox.add(new Orange());

        System.out.println(appleBox.compare(orngeBox));
        appleBox.transferTo(fruitBox);
    }
}
