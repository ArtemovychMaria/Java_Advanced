package lesson1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SalaryTest {

    private Salary salary;

    @Before
    public void setup() {
        salary = new Salary();
    }

    @Test(expected = MyException.class)
    public void itThrowsExceptionWhenSalaryInHourIsNegative() {
        int actual = salary.calculateMonthSalary(-200, 168);
    }

    @Test
    public void itCalculateCleanSalary() {
        int result = salary.calculateMonthSalary(200, 168);
        int podatok = salary.calculatePodatok(result);
        int actual = salary.calculateCleanSalary(result, podatok);
        int expected = 28560;

        Assert.assertEquals(expected, actual);
    }

}
