
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 */
public class PCVideospielTest
{
    private static final String KOMMENTAR = "Kommentar";
    private static final String TITEL = "Titel";
    private static final String BEZEICHNUNG = "Videospiel";
    private static final String SYSTEM = "System";
    private PCVideospiel  _PCSpiel;

    public PCVideospielTest()
    {
        _PCSpiel = getMedium();
    }

    @Test
    public void testeKonsolenVideospiel()
    {
        assertEquals(TITEL, _PCSpiel.getTitel());
        assertEquals(KOMMENTAR, _PCSpiel.getKommentar());
        assertEquals(SYSTEM, _PCSpiel.getSystem());
    }

    @Test
    public void testGetMedienBezeichnung()
    {
        assertEquals(BEZEICHNUNG, _PCSpiel.getMedienBezeichnung());
    }

    protected PCVideospiel getMedium()
    {
        return new PCVideospiel(TITEL, KOMMENTAR, SYSTEM);
    }

    @Test
    public final void testSetKommentar()
    {
        PCVideospiel medium = getMedium();
        medium.setKommentar("Kommentar2");
        assertEquals(medium.getKommentar(), "Kommentar2");
    }

    @Test
    public final void testSetTitel()
    {
        PCVideospiel medium = getMedium();
        medium.setTitel("Titel2");
        assertEquals(medium.getTitel(), "Titel2");
    }
    
    @Test
    public final void testBerechneMietgebuehr()
    {
        PCVideospiel medium = getMedium();
        assertEquals(Geldbetrag.get(200), medium.berechneMietgebuehr(1));
        assertEquals(Geldbetrag.get(200), medium.berechneMietgebuehr(2));
        assertEquals(Geldbetrag.get(200), medium.berechneMietgebuehr(7));
        assertEquals(Geldbetrag.get(700), medium.berechneMietgebuehr(8));
        assertEquals(Geldbetrag.get(1200), medium.berechneMietgebuehr(13));
        assertEquals(Geldbetrag.get(1200), medium.berechneMietgebuehr(17));
        assertEquals(Geldbetrag.get(1700), medium.berechneMietgebuehr(18));
    }
    
    @Test
    public final void testBerechneMietgebuehrNichtNull()
    {
        PCVideospiel medium = getMedium();
        assertNotNull(medium.berechneMietgebuehr(5));
    }

}