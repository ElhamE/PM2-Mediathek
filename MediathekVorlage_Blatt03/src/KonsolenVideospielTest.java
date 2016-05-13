
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 */
public class KonsolenVideospielTest
{
    private static final String KOMMENTAR = "Kommentar";
    private static final String TITEL = "Titel";
    private static final String BEZEICHNUNG = "Videospiel";
    private static final String SYSTEM = "System";
    private KonsolenVideospiel  _konsolenSpiel;

    public KonsolenVideospielTest()
    {
        _konsolenSpiel = getMedium();
    }

    @Test
    public void testeKonsolenVideospiel()
    {
        assertEquals(TITEL, _konsolenSpiel.getTitel());
        assertEquals(KOMMENTAR, _konsolenSpiel.getKommentar());
        assertEquals(SYSTEM, _konsolenSpiel.getSystem());
    }

    @Test
    public void testGetMedienBezeichnung()
    {
        assertEquals(BEZEICHNUNG, _konsolenSpiel.getMedienBezeichnung());
    }

    protected KonsolenVideospiel getMedium()
    {
        return new KonsolenVideospiel(TITEL, KOMMENTAR, SYSTEM);
    }

    @Test
    public final void testSetKommentar()
    {
        KonsolenVideospiel medium = getMedium();
        medium.setKommentar("Kommentar2");
        assertEquals(medium.getKommentar(), "Kommentar2");
    }

    @Test
    public final void testSetTitel()
    {
        KonsolenVideospiel medium = getMedium();
        medium.setTitel("Titel2");
        assertEquals(medium.getTitel(), "Titel2");
    }
    
    @Test
    public final void testBerechneMietgebuehr()
    {
        KonsolenVideospiel medium = getMedium();
        assertEquals(Geldbetrag.get(200), medium.berechneMietgebuehr(1));
        assertEquals(Geldbetrag.get(200), medium.berechneMietgebuehr(2));
        assertEquals(Geldbetrag.get(900), medium.berechneMietgebuehr(3));
        assertEquals(Geldbetrag.get(900), medium.berechneMietgebuehr(5));
        assertEquals(Geldbetrag.get(1600), medium.berechneMietgebuehr(6));
        assertEquals(Geldbetrag.get(3000), medium.berechneMietgebuehr(13));
    }
    
    @Test
    public final void testBerechneMietgebuehrNichtNull()
    {
        KonsolenVideospiel medium = getMedium();
        assertNotNull(medium.berechneMietgebuehr(5));
    }

}
