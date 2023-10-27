package sem_3.hw.calculator;

public class Main {
    public static void main(String[] args) {
        //        деление
        double num1 = 9;
        double num2 = 3.3;
        double result = Calculator.divide(num1, num2);
        System.out.println(num1 + " / " + num2 + " = " + result);
        //        умножение
        result = Calculator.multiply(num1, num2);
        System.out.println(num1 + " * " + num2 + " = " + result);
        //        сложение
        result = Calculator.sum(num1, num2);
        System.out.println(num1 + " + " + num2 + " = " + result);
        //        вычитание
        result = Calculator.substract(num1, num2);
        System.out.println(num1 + " - " + num2 + " = " + result);
    }
}
