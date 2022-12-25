import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTests {

    @Test
    public void onePlusOne() {
        double exp = 2.0;
        Calculator calc = new Calculator();
        double act = calc.calculator("+ 1 1");
        Assertions.assertEquals(act, exp);
    }

    @Test
    public void twoTwoMult() {
        double exp = 4.0;
        Calculator calc = new Calculator();
        double act = calc.calculator("* 2 2");
        Assertions.assertEquals(act, exp);
    }

    @Test
    public void threeDivTwo() {
        double exp = 1.5;
        Calculator calc = new Calculator();
        double act = calc.calculator("/ 2 3");
        Assertions.assertEquals(act, exp);
    }

    @Test
    public void threeMinusTwo() {
        double exp = 1.0;
        Calculator calc = new Calculator();
        double act = calc.calculator("- 2 3");
        Assertions.assertEquals(act, exp);
    }

    @Test
    public void sinTest() {
        double exp = 0.8414709848078965;
        Calculator calc = new Calculator();
        double act = calc.calculator("sin 1,0");
        Assertions.assertEquals(act, exp);
    }

    @Test
    public void cosTest() {
        double exp = -0.8414709848078965;
        Calculator calc = new Calculator();
        double act = calc.calculator("sin -1,0");
        Assertions.assertEquals(act, exp);
    }

    @Test
    public void powTest() {
        double exp = 8;
        Calculator calc = new Calculator();
        double act = calc.calculator("pow 3 2");
        Assertions.assertEquals(act, exp);
    }

    @Test
    public void logTest() {
        double exp = 2.1400661634962708;
        Calculator calc = new Calculator();
        double act = calc.calculator("log 8,5");
        Assertions.assertEquals(act, exp);
    }

    @Test
    public void sqrtTest() {
        double exp = 6;
        Calculator calc = new Calculator();
        double act = calc.calculator("sqrt 36");
        Assertions.assertEquals(act, exp);
    }

    @Test
    public void bigTest() {
        double exp = 5;
        Calculator calc = new Calculator();
        double act = calc.calculator("sqrt pow - + * / 2 5 4 3 5 10");
        Assertions.assertEquals(act, exp);
    }

    @Test
    public void sin2Test() {
        double exp = 1;
        Calculator calc = new Calculator();
        double act = calc.calculator("sin 1,5707963267948966");
        Assertions.assertEquals(act, exp);
    }
    @Test
    public void veryBigTest() {
        double exp = 16;
        Calculator calc = new Calculator();
        double act = calc.calculator("pow / * + sqrt log cos - sin 2 3 6 2 1 1,5707963267948966");
        Assertions.assertEquals(act, exp);
    }
}