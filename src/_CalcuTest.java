import junit.*;
import junit.framework.TestCase;

public class _CalcuTest extends TestCase{
    public void testSumar(){
        Calcu calcuPro = new Calcu();

        assertEquals(5, calcuPro.sumar(3, 2));
    }
}
