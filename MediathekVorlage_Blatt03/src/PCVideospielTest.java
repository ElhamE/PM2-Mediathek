
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 */
public class PCVideospielTest extends AbstractVideospielTest
{

    @Override
    protected PCVideospiel getMedium()
    {
        return new PCVideospiel(TITEL, KOMMENTAR, SYSTEM);
    }    
    
    @Test
    public void testGetMedienBezeichnung()
    {
    	PCVideospiel videospiel = getMedium();
    	assertEquals("PCVideospiel", videospiel.getMedienBezeichnung());
    }
    
    @Test
    public void testBerechneMietgebuehr()
    {
    	PCVideospiel videospiel = getMedium();
        assertEquals(Geldbetrag.get(200),videospiel.berechneMietgebuehr(1));
        assertEquals(Geldbetrag.get(200), videospiel.berechneMietgebuehr(2));
        assertEquals(Geldbetrag.get(200), videospiel.berechneMietgebuehr(7));
        assertEquals(Geldbetrag.get(700), videospiel.berechneMietgebuehr(8));
        assertEquals(Geldbetrag.get(1200), videospiel.berechneMietgebuehr(13));
        assertEquals(Geldbetrag.get(1200), videospiel.berechneMietgebuehr(17));
        assertEquals(Geldbetrag.get(1700), videospiel.berechneMietgebuehr(18));
    }
    
    @Test
    public void testGetPreisNachTagen()
    {
    	PCVideospiel videospiel = getMedium();
        assertEquals(0, videospiel.getPreisNachTagen(1));
        assertEquals(0, videospiel.getPreisNachTagen(2));
        assertEquals(0, videospiel.getPreisNachTagen(7));
        assertEquals(500, videospiel.getPreisNachTagen(8));
        assertEquals(1000, videospiel.getPreisNachTagen(13));
        assertEquals(1000, videospiel.getPreisNachTagen(17));
        assertEquals(1500, videospiel.getPreisNachTagen(18));
    }

}