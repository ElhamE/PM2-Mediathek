package aufgabe1.einfachesNetz;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import aufgabe1.Widerstandsnetz;

/**
 * Testet die einfachen Widerstandsnetze.
 * 
 * @author Imon Bashir, Elham Esmat
 */
public class WiderstandTest
{
    private Widerstandsnetz _einfach;
    
    private Potenziometer _potenziometer;
    
    /**
     * Initialisiert Testexemplare.
     */
    public WiderstandTest()
    {
        _einfach = new Widerstand(50);
        _potenziometer = new Potenziometer(0);
    }
    
    @Test
    public void testKonstruktor()
    {
        assertNotNull(_einfach);
        assertNotNull(_potenziometer);
    }
    
    @Test
    public void getOhm()
    {
        assertTrue(50 == _einfach.getOhm());
        assertTrue(0 == _potenziometer.getOhm());
        _potenziometer.setOhm(75);
        assertTrue(75 == _potenziometer.getOhm());
    }
    
    @Test
    public void getAnzahlWiderstaende()
    {
        assertTrue(1 == _einfach.getAnzahlWiderstaende());
        assertTrue(1 == _potenziometer.getAnzahlWiderstaende());
    }
    

}
