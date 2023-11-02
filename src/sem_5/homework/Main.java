package sem_5.homework;

import java.util.concurrent.Semaphore;

/*
* Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
Вилки лежат на столе между каждой парой ближайших философов.
Каждый философ может либо есть, либо размышлять.
Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
Философ может взять только две вилки сразу, то есть обе вилки должны быть свободны
Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза
* */
public class Main {
    public static void main(String[] args) {
//        Semaphore table = new Semaphore(2);
//
//        new Philosopher(table, "Сократ").start();
//        new Philosopher(table, "Платон").start();
//        new Philosopher(table, "Аристотель").start();
//        new Philosopher(table, "Лосев").start();
//        new Philosopher(table, "Конфуций").start();
        Table table = new Table();

        for (Philosopher p: table.philosophers) {
            p.start();
        }

    }
}
