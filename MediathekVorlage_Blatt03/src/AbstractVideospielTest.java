
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public abstract class AbstractVideospielTest
{
    protected static final String KOMMENTAR = "Kommentar";
    protected static final String TITEL = "Titel";
    protected static final String SYSTEM = "System";
    protected AbstractVideospiel _videospiel;
    
    public AbstractVideospielTest()
    {
    	_videospiel = getMedium();
    }
   
    protected abstract AbstractVideospiel getMedium();
    
    @Test
    public void testeVideospiel()
    {
        assertEquals(TITEL, _videospiel.getTitel());
        assertEquals(KOMMENTAR, _videospiel.getKommentar());
        assertEquals(SYSTEM, _videospiel.getSystem());
    }   
    
    @Test
    public abstract void testGetMedienBezeichnung();
    
    @Test
    public void testSetKommentar()
    {
    	_videospiel.setKommentar("Kommentar2");
        assertEquals(_videospiel.getKommentar(), "Kommentar2");
    }
    
    @Test
    public void testGetFormatiertenString()
    {
        assertNotNull(_videospiel.getFormatiertenString());
    }

    @Test
    public void testSetTitel()
    {
    	_videospiel.setTitel("Titel2");
        assertEquals(_videospiel.getTitel(), "Titel2");
    }
    
    @Test
    public abstract void testBerechneMietgebuehr();
    
    @Test
    public void testBerechneMietgebuehrNichtNull()
    {
    	assertNotNull(_videospiel.berechneMietgebuehr(1));
        assertNotNull(_videospiel.berechneMietgebuehr(5));
        assertNotNull(_videospiel.berechneMietgebuehr(8));
    }
    
    @Test
    public abstract void testGetPreisNachTagen();
}
