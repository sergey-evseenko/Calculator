package testng;

public class CalculatorTests {

    public double sum(double a, double b){
        return a+b;
    }

    public double minus(double a, double b){
        return a-b;
    }

    public double multiply(double a, double b){
        return a*b;
    }

    public double division(double a, double b){
        if (b==0){
            throw  new ArithmeticException("Division by zero!");
        }
        return a/b;
    }
}
