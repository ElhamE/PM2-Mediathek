import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public abstract class AbstractMediumTest
{
    protected static final String KOMMENTAR = "Kommentar";
    protected static final String TITEL = "Titel";
    protected static final int LAENGE = 100;
    protected AbstractMedium _medium1;
    protected AbstractMedium _medium2;
    
    @Test
    public abstract void testGetMedienBezeichnung();
    
    @Test
    public void testKonstruktor()
    {
        assertEquals(TITEL, _medium1.getTitel());
        assertEquals(KOMMENTAR, _medium1.getKommentar());
    }
    
    @Test
    public void testSetter()
    {
    	_medium1.setTitel("Titel2");
        assertEquals(_medium1.getTitel(), "Titel2");
        _medium1.setKommentar("Kommentar2");
        assertEquals(_medium1.getKommentar(), "Kommentar2");
    }
    
    @Test
    /*
     * Von ein und dem selben Medium kann es mehrere Exemplare geben, die von
     * unterschiedlichen Personen ausgeliehen werden können.
     */
    public void testEquals()
    {
        assertFalse("Mehrere Exemplare des gleichen Mediums sind gleich",
                _medium1.equals(_medium2));
        assertTrue("Mehrere Exemplare des gleichen Mediums sind ungleich",
                _medium1.equals(_medium1));
    }
    
    @Test
    public void testGetFormatiertenString()
    {
        assertNotNull(_medium1.getFormatiertenString());
    }
    
    @Test
    public void testBerechneMietgebuehr()
    {
        assertEquals(Geldbetrag.get(300), _medium1.berechneMietgebuehr(1));
        assertEquals(Geldbetrag.get(600), _medium1.berechneMietgebuehr(2));
        assertEquals(Geldbetrag.get(2100), _medium1.berechneMietgebuehr(7));
    }
    
    @Test
    public void testBerechneMietgebuehrNichtNull()
    {
    	assertNotNull(_medium1.berechneMietgebuehr(1));
        assertNotNull(_medium1.berechneMietgebuehr(5));
        assertNotNull(_medium1.berechneMietgebuehr(8));
    }

}
