package sem_3.hw.calculator;

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
