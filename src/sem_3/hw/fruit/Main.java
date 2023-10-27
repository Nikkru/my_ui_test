package sem_3.hw.fruit;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Fruit> fruitBox = new Box<>();


        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());

//        Fruit orange = fruitBox.get(0);
//        if (orange instanceof Orange) {
//            Orange orange1 = (Orange) orange;
//        }

        orangeBox.add(new Orange());
        orangeBox.add(new Orange());

        System.out.println(appleBox.compare(orangeBox));
        appleBox.transferTo(fruitBox);
    }
}
