package sem_3.hw.pair;

/*
Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
а также переопределение метода toString(), возвращающее строковое представление пары.
 */

public class Pair<A, B> {
    private A a;
    private B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    @Override
    public String toString() {
        return "( first element " + a + " second element " + b;
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(10, "ten");
    }
}
