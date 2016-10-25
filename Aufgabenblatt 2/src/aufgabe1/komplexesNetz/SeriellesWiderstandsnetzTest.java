package aufgabe1.komplexesNetz;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import aufgabe1.Widerstandsnetz;
import aufgabe1.einfachesNetz.Widerstand;

/**
 * Testet die seriellen Widerstandsnetze.
 * 
 * @author Imon Bashir, Elham Esmat
 */
public class SeriellesWiderstandsnetzTest
{
    private SeriellesWiderstandsnetz _reihe1;

    private SeriellesWiderstandsnetz _reihe2;

    private SeriellesWiderstandsnetz _reihe3;

    /**
     * Initialisert Testexemplare
     */
    public SeriellesWiderstandsnetzTest()
    {
        _reihe1 = new SeriellesWiderstandsnetz(getNetz(100), getNetz(250));
        _reihe2 = new SeriellesWiderstandsnetz(_reihe1, _reihe1);
        _reihe3 = new SeriellesWiderstandsnetz(_reihe1, _reihe2);
    }

    @Test
    public void testKonstruktor()
    {
        assertNotNull(_reihe1);
        assertNotNull(_reihe2);
        assertNotNull(_reihe3);
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
        assertTrue(350 == _reihe1.getOhm());
        assertTrue(700 == _reihe2.getOhm());
        assertTrue(1050 == _reihe3.getOhm());
    }

    @Test
    public void testGetAnzahlWiderstaende()
    {
        assertTrue(2 == _reihe1.getAnzahlWiderstaende());
        assertTrue(4 == _reihe2.getAnzahlWiderstaende());
        assertTrue(6 == _reihe3.getAnzahlWiderstaende());
    }

}
