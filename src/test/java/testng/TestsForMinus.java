package testng;

import org.testng.IRetryAnalyzer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertEquals;

public class TestsForMinus {

    private CalculatorTests calculatorTests;
    @BeforeMethod
    public void createCalculator(){
        calculatorTests = new CalculatorTests();
    }

    @Parameters({"a","b", "result"})
    @Test
    public void testMinusPositive(@Optional("0") double a, @Optional("0") double b, @Optional("0") double result){
        double minus = calculatorTests.minus(a,b);
        assertEquals(minus, result, "Invalid expected result for minus!");
    }

    @Test
    public void testMinusNegative() throws InterruptedException {
        double minus = calculatorTests.minus(-1,-2);
        assertEquals(minus, 1, "Invalid expected result for minus!");
    }

    @Test(retryAnalyzer = Retry.class)
    public void flackyTest(){
        if (new Random().nextBoolean()){
            throw new ArithmeticException();
        }

    }
}
