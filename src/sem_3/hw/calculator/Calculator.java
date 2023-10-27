package sem_3.hw.calculator;
/*
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
sum(), multiply(), divide(), subtract(). Параметры этих методов – два числа разного типа
(но необязательно разного между собой), над которыми должна быть произведена операция.
*/

public class Calculator {
    public static <T extends Number> double sum(T num1, T num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public  static <T extends Number> double multiply(T num1, T num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    public  static <T extends Number> double divide(T num1, T num2) {
        if (num2.doubleValue() == 0) {throw new ArithmeticException("Недопустимая операция");}
        return num1.doubleValue() / num2.doubleValue();
    }

    public  static <T extends Number> double substract(T num1, T num2) {
        return num1.doubleValue() - num2.doubleValue();
    }

}
