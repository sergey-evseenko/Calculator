package testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestsForMultiply {
    private CalculatorTests calculatorTests;
    @BeforeMethod
    public void createCalculator(){
        calculatorTests = new CalculatorTests();
    }

    @Test
    public void testMultiplyPositive() throws InterruptedException {
        double minus = calculatorTests.multiply(1,2);
        assertEquals(minus, 2, "Invalid expected result for minus!");
    }

    @Test
    public void testMultiplyNegative(){
        double minus = calculatorTests.multiply(-1,-2);
        assertEquals(minus, 2, "Invalid expected result for minus!");
    }



}
