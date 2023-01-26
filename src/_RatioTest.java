import junit.framework.TestCase;

public class _RatioTest extends TestCase {
    
    Ratio elRadio = new Ratio();

    public void testRatioOn(){
        assertEquals(true, elRadio.getOn());

        assertEquals("Apagando...", elRadio.turnOffRatio());

        assertEquals(false, elRadio.getOn());

        assertEquals("Hey! Esta apagado.", elRadio.turnOffRatio());

        assertEquals("Encendiendo...", elRadio.turnOnRatio());
    }
    
    public void testDial(){
        
        String changueFrec = elRadio.changeFrecuence();
        assertEquals("Se cambio de AM a FM", changueFrec);
        
        String expectedDial = "Ahora estas en 88.1 de FM";
        String actualDial = elRadio.moveDial(0);
        assertEquals(expectedDial, actualDial);
    }
}
