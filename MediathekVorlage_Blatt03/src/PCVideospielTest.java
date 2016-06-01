
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
    	assertEquals("PCVideospiel", _videospiel.getMedienBezeichnung());
    }
    
    @Test
    public void testBerechneMietgebuehr()
    {
        assertEquals(Geldbetrag.get(200),_videospiel.berechneMietgebuehr(1));
        assertEquals(Geldbetrag.get(200), _videospiel.berechneMietgebuehr(2));
        assertEquals(Geldbetrag.get(200), _videospiel.berechneMietgebuehr(7));
        assertEquals(Geldbetrag.get(700), _videospiel.berechneMietgebuehr(8));
        assertEquals(Geldbetrag.get(1200), _videospiel.berechneMietgebuehr(13));
        assertEquals(Geldbetrag.get(1200), _videospiel.berechneMietgebuehr(17));
        assertEquals(Geldbetrag.get(1700), _videospiel.berechneMietgebuehr(18));
    }
    
    @Test
    public void testGetPreisNachTagen()
    {
        assertEquals(0,_videospiel.getPreisNachTagen(1));
        assertEquals(0, _videospiel.getPreisNachTagen(2));
        assertEquals(0, _videospiel.getPreisNachTagen(7));
        assertEquals(500, _videospiel.getPreisNachTagen(8));
        assertEquals(1000, _videospiel.getPreisNachTagen(13));
        assertEquals(1000, _videospiel.getPreisNachTagen(17));
        assertEquals(1500, _videospiel.getPreisNachTagen(18));
    }

}