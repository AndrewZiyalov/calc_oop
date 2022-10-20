import com.company.calc.Calculator;
import com.company.calc.parser.ParserOperation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcTests {

    @Test
    public void sumCorrectTest(){
        final ParserOperation parserOperation = new ParserOperation();
        final Calculator calculator = new Calculator(parserOperation);
        assertEquals("1 + 1 = 2",2,calculator.calculate("1+1"));
        assertEquals("1 + 1 + 1= 3",3,calculator.calculate("1+1+1"));
        assertEquals("1.2 + 1.3 + 1.4= 3.9",3.9,calculator.calculate("1.2 + 1.3 + 1.4"));
        assertEquals("1 + 1.3 + 1.922= 4.222",4.222,calculator.calculate("1 + 1.3 + 1.922"));
        assertEquals("1 + 1.322255 + 1.922= 4.2443",4.2443,calculator.calculate("1 + 1.322255 + 1.922"));
    }

    @Test
    public void subCorrectTest(){
        final ParserOperation parserOperation = new ParserOperation();
        final Calculator calculator = new Calculator(parserOperation);
        assertEquals("12.2 - 1 = 11.2",11.2,calculator.calculate("12.2 - 1"));
        assertEquals("1 - 1 - 1= -1",-1,calculator.calculate("1 - 1 - 1"));
        assertEquals("20 - 11 - 5 = 4", 4, calculator.calculate("20 - 11 - 5"));
    }

    @Test
    public void divCorrectTest(){
        final ParserOperation parserOperation = new ParserOperation();
        final Calculator calculator = new Calculator(parserOperation);
        assertEquals("1 / 1 = 1",1,calculator.calculate("1/1"));
        assertEquals("2 / 4 = 0.5",0.5,calculator.calculate("2/4"));
        assertEquals("20 / 4 / 3 = 1.6667",1.6667,calculator.calculate("20 / 4 / 3"));
        assertEquals("2 / 4 = 0.5",0.5,calculator.calculate("2/4"));

    }

    @Test
    public void multiplyCorrectTest(){
        final ParserOperation parserOperation = new ParserOperation();
        final Calculator calculator = new Calculator(parserOperation);
        assertEquals("1 * 1 = 1",1,calculator.calculate("1*1"));
        assertEquals("1 * 2 * 3 = 6",6,calculator.calculate("1 * 2 * 3"));
        assertEquals("1 * 2 * 0 = 0",0,calculator.calculate("1 * 2 * 0"));
        assertEquals("1.1 * 2.23234 * 3.343 = 8.2091",8.2091,calculator.calculate("1.1 * 2.23234 * 3.343"));
    }

    @Test
    public void allOperationsInOneExpression() {
        final ParserOperation parserOperation = new ParserOperation();
        final Calculator calculator = new Calculator(parserOperation);
        assertEquals("1 + 1 - 4 * 6 / 3 = -4",-4,calculator.calculate("1 + 1 - 4 * 6 / 3 "));
    }

    @Test(expected = ArithmeticException.class)
    public void incorrectDivOperation(){
        try {
            final ParserOperation parserOperation = new ParserOperation();
            final Calculator calculator = new Calculator(parserOperation);
            calculator.calculate("1/0");
        }
        catch (ArithmeticException re)
        {
            String message = "Деление на ноль";
            assertEquals(message, re.getMessage());
            throw re;
        }
    }

    @Test(expected = RuntimeException.class)
    public void incorrectExpression1(){
        try {
            final ParserOperation parserOperation = new ParserOperation();
            final Calculator calculator = new Calculator(parserOperation);
            calculator.calculate("a + b");
        }
        catch(RuntimeException re)
        {
            String message = "Недопустимые символы в выражении";
            assertEquals(message, re.getMessage());
            throw re;
        }
    }

    @Test(expected = RuntimeException.class)
    public void incorrectExpression2(){
        try
        {
            final ParserOperation parserOperation = new ParserOperation();
            final Calculator calculator = new Calculator(parserOperation);
            calculator.calculate("1 +- 2");
        }
        catch(RuntimeException re)
        {
            String message = "Неверное выражение";
            assertEquals(message, re.getMessage());
            throw re;
        }
    }



}
