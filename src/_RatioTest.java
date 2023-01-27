import junit.framework.TestCase;

public class _RatioTest extends TestCase {
    
    Ratio elRadio = new Ratio();

    /*
     * NOTA IMPORTANTE:
     * Si van a utilizar TestCase deben de nombrar
     * sus metodos empezando con test para que 
     * JUnit reconozca los metodos de testing.
     */

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

    public void testObtainCurrentState(){
        // Probar que la estacion AM se selecciono de forma correcta
        assertEquals(580.0, elRadio.readCurrentState(0));
        assertEquals(820.0, elRadio.readCurrentState(4));

        // Probar que la estacion FM se selecciono de forma correcta

        String changueFrec = elRadio.changeFrecuence();
        assertEquals("Se cambio de AM a FM", changueFrec); // Antes vamos a cambiar de AM a FM
        
        assertEquals(90.9, elRadio.readCurrentState(5));
    }
}
