
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 */
public class KonsolenVideospielTest extends AbstractVideospielTest
{

    @Test
    public void testGetMedienBezeichnung()
    {
    	assertEquals("KonsolenVideospiel", _videospiel.getMedienBezeichnung());
    }
    
    @Override
    protected KonsolenVideospiel getMedium()
    {
        return new KonsolenVideospiel(TITEL, KOMMENTAR, SYSTEM);
    }
    
    @Test
    public void testBerechneMietgebuehr()
    {
        assertEquals(Geldbetrag.get(200), _videospiel.berechneMietgebuehr(1));
        assertEquals(Geldbetrag.get(200), _videospiel.berechneMietgebuehr(2));
        assertEquals(Geldbetrag.get(900), _videospiel.berechneMietgebuehr(3));
        assertEquals(Geldbetrag.get(900), _videospiel.berechneMietgebuehr(5));
        assertEquals(Geldbetrag.get(1600), _videospiel.berechneMietgebuehr(6));
        assertEquals(Geldbetrag.get(3000), _videospiel.berechneMietgebuehr(13));
    }
    
    @Test
    public void testGetPreisNachTagen()
    {
        assertEquals(0, _videospiel.getPreisNachTagen(1));
        assertEquals(0, _videospiel.getPreisNachTagen(2));
        assertEquals(700, _videospiel.getPreisNachTagen(3));
        assertEquals(700, _videospiel.getPreisNachTagen(5));
        assertEquals(1400, _videospiel.getPreisNachTagen(6));
        assertEquals(2800, _videospiel.getPreisNachTagen(13));
    }

}
