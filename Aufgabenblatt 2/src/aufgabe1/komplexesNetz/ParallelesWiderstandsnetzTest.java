package aufgabe1.komplexesNetz;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import aufgabe1.Widerstandsnetz;
import aufgabe1.einfachesNetz.Widerstand;

/**
 * Testet die parallelen Widerstandsnetze.
 * 
 * @author Imon Bashir, Elham Esmat
 */
public class ParallelesWiderstandsnetzTest
{
    private ParallelesWiderstandsnetz _parallel1;
    
    private ParallelesWiderstandsnetz _parallel2;
    
    private ParallelesWiderstandsnetz _parallel3;
    
    /**
     * Initialisert Testexemplare
     */
    public ParallelesWiderstandsnetzTest()
    {
        _parallel1 = new ParallelesWiderstandsnetz(getNetz(100), getNetz(250));
        _parallel2 = new ParallelesWiderstandsnetz(_parallel1, _parallel1);
        _parallel3 = new ParallelesWiderstandsnetz(_parallel1, _parallel2);
    }

    @Test
    public void testKonstruktor()
    {
        assertNotNull(_parallel1);
        assertNotNull(_parallel2);
        assertNotNull(_parallel3);
    }
    
    /**
     * Diese Hilfsmethode liefert ein einfaches Widerstandsnetz.
     */
    private Widerstandsnetz getNetz(int ohm)
    {
        return new Widerstand(ohm);
    }
    
    @Test
    public void testGetOhm()
    {
        assertTrue(71.42857142857143 == _parallel1.getOhm());
        assertTrue(35.714285714285715 == _parallel2.getOhm());
        assertTrue(23.809523809523807 == _parallel3.getOhm());
    }
    
    @Test
    public void testGetAnzahlWiderstaende()
    {
        assertTrue(2 == _parallel1.getAnzahlWiderstaende());
        assertTrue(4 == _parallel2.getAnzahlWiderstaende());
        assertTrue(6 == _parallel3.getAnzahlWiderstaende());
    }
    
}
