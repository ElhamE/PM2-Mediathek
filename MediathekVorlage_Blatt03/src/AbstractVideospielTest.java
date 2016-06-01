
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public abstract class AbstractVideospielTest
{
    protected static final String KOMMENTAR = "Kommentar";
    protected static final String TITEL = "Titel";
    protected static final String SYSTEM = "System";

    protected abstract AbstractVideospiel getMedium();
    
    @Test
    public void testeVideospiel()
    {
    	AbstractVideospiel videospiel = getMedium();
        assertEquals(TITEL, videospiel.getTitel());
        assertEquals(KOMMENTAR, videospiel.getKommentar());
        assertEquals(SYSTEM, videospiel.getSystem());
    }   
    
    @Test
    public abstract void testGetMedienBezeichnung();
    
    @Test
    public void testSetKommentar()
    {
    	AbstractVideospiel videospiel = getMedium();
    	videospiel.setKommentar("Kommentar2");
        assertEquals(videospiel.getKommentar(), "Kommentar2");
    }
    
    @Test
    public void testGetFormatiertenString()
    {
    	AbstractVideospiel videospiel = getMedium();
        assertNotNull(videospiel.getFormatiertenString());
    }

    @Test
    public void testSetTitel()
    {
    	AbstractVideospiel videospiel = getMedium();
    	videospiel.setTitel("Titel2");
        assertEquals(videospiel.getTitel(), "Titel2");
    }
    
    @Test
    public abstract void testBerechneMietgebuehr();
    
    @Test
    public void testBerechneMietgebuehrNichtNull()
    {
    	AbstractVideospiel videospiel = getMedium();
    	assertNotNull(videospiel.berechneMietgebuehr(1));
        assertNotNull(videospiel.berechneMietgebuehr(5));
        assertNotNull(videospiel.berechneMietgebuehr(8));
    }
    
    @Test
    public abstract void testGetPreisNachTagen();
}
