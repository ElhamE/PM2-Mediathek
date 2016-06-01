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
//    protected AbstractMedium _medium1;
//    protected AbstractMedium _medium2;
//    
//    public AbstractMediumTest()
//    {
//    	_medium1 = getMedium();
//    	_medium2 = getMedium();
//    }
    
    @Test
    public abstract void testGetMedienBezeichnung();
    
    @Test
    public void testKonstruktor()
    {
    	AbstractMedium medium = getMedium();
        assertEquals(TITEL, medium.getTitel());
        assertEquals(KOMMENTAR, medium.getKommentar());
    }
    
    @Test
    public void testSetter()
    {
    	AbstractMedium medium = getMedium();
    	medium.setTitel("Titel2");
        assertEquals(medium.getTitel(), "Titel2");
        medium.setKommentar("Kommentar2");
        assertEquals(medium.getKommentar(), "Kommentar2");
    }
    
    @Test
    /*
     * Von ein und dem selben Medium kann es mehrere Exemplare geben, die von
     * unterschiedlichen Personen ausgeliehen werden können.
     */
    public void testEquals()
    {
    	AbstractMedium medium1 = getMedium();
    	AbstractMedium medium2 = getMedium();
        assertFalse("Mehrere Exemplare des gleichen Mediums sind gleich",
                medium1.equals(medium2));
        assertTrue("Mehrere Exemplare des gleichen Mediums sind ungleich",
                medium1.equals(medium1));
    }
    
    @Test
    public void testGetFormatiertenString()
    {
    	AbstractMedium medium = getMedium();
        assertNotNull(medium.getFormatiertenString());
    }
    
    @Test
    public void testBerechneMietgebuehr()
    {
    	AbstractMedium medium = getMedium();
        assertEquals(Geldbetrag.get(300), medium.berechneMietgebuehr(1));
        assertEquals(Geldbetrag.get(600), medium.berechneMietgebuehr(2));
        assertEquals(Geldbetrag.get(2100), medium.berechneMietgebuehr(7));
    }
    
    @Test
    public void testBerechneMietgebuehrNichtNull()
    {
    	AbstractMedium medium = getMedium();
    	assertNotNull(medium.berechneMietgebuehr(1));
        assertNotNull(medium.berechneMietgebuehr(5));
        assertNotNull(medium.berechneMietgebuehr(8));
    }
    
    
	protected abstract AbstractMedium getMedium();

}
