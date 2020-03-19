package testng;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class TestsForSum {

    private CalculatorTests calculatorTests;
    @BeforeClass
    public void createCalculator(){ calculatorTests = new CalculatorTests();}

    @DataProvider(name = "Incoming data for calculator")
    public Object[][] dataForSum() {
        return new Object[][]{
                {1, 2, 3},
                {-1, -2, -3},
                {0, 10, 10},
                {0,0,0},
                {1000, 2000, 3000}
        };
    }

    @Test(
            priority = 1,
            dataProvider = "Incoming data for calculator"
    )
    public void testSumPositive(double a, double b, double expectedresult) throws InterruptedException {
        double sum = calculatorTests.sum(a,b);
        assertEquals(sum, expectedresult, "Invalid expected result for sum!");
        Thread.sleep(1000);
    }

    @Test(
            enabled = true,
            groups = {"required"},
            timeOut = 11000,
            description = "verification sum functions for positive value",
            priority = 3,
            invocationCount = 10,
            threadPoolSize = 2
    )

    public void testSumNegative() throws InterruptedException {
        double sum = calculatorTests.sum(-1, -2);
        assertEquals(sum, -3, "Invalid expected result for sum!");
    }
}
