package testng;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestForDivision {

    private CalculatorTests calculatorTests;

    @BeforeClass
    public void createCalculator(){
        calculatorTests = new CalculatorTests();}

    @Test(expectedExceptions = {ArithmeticException.class})
    public void testDivisionPositive() throws InterruptedException {
        double minus = calculatorTests.division(1,0);
    }

    @Test
    public void testDivisionNegative(){
        double minus = calculatorTests.division(-1,-2);
        assertEquals(minus, 0.5, "Invalid expected result for division!");
    }

}
