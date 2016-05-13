import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DVDTest
{
    private static final String KOMMENTAR = "Kommentar";
    private static final String TITEL = "Titel";
    private static final String BEZEICHNUNG = "DVD";
    private static final int LAENGE = 100;
    private static final String REGISSEUR = "DVD Regisseur";
    private DVD _dvd1;
    private DVD _dvd2;

    public DVDTest()
    {
        _dvd1 = getMedium();
        _dvd2 = getMedium();
    }

    @Test
    public void testGetMedienBezeichnung()
    {
        String dvdBezeichnung = BEZEICHNUNG;
        assertEquals(dvdBezeichnung, _dvd1.getMedienBezeichnung());
    }

    @Test
    public void testKonstruktor()
    {
        assertEquals(TITEL, _dvd1.getTitel());
        assertEquals(KOMMENTAR, _dvd1.getKommentar());
        assertEquals(LAENGE, _dvd1.getLaufzeit());
        assertEquals(REGISSEUR, _dvd1.getRegisseur());
    }

    @Test
    public final void testSetter()
    {
        _dvd1.setKommentar("Kommentar2");
        assertEquals(_dvd1.getKommentar(), "Kommentar2");
        _dvd1.setTitel("Titel2");
        assertEquals(_dvd1.getTitel(), "Titel2");
        _dvd1.setLaufzeit(90);
        assertEquals(90, _dvd1.getLaufzeit());
        _dvd1.setRegisseur("Regisseur2");
        assertEquals("Regisseur2", _dvd1.getRegisseur());
    }

    @Test
    /*
     * Von ein und der selben DVD kann es mehrere Exemplare geben, die von
     * unterschiedlichen Personen ausgeliehen werden können.
     */
    public void testEquals()
    {
        assertFalse("Mehrere Exemplare der gleichen DVD sind gleich",
                _dvd1.equals(_dvd2));
        assertTrue("Mehrere Exemplare der gleichen DVD sind ungleich",
                _dvd1.equals(_dvd1));
    }

    @Test
    public final void testGetFormatiertenString()
    {
        Medium medium = getMedium();
        assertNotNull(medium.getFormatiertenString());
    }
    
    @Test
    public final void testBerechneMietgebuehr()
    {
        Medium medium = getMedium();
        assertEquals(Geldbetrag.get(300), medium.berechneMietgebuehr(1));
        assertEquals(Geldbetrag.get(600), medium.berechneMietgebuehr(2));
        assertEquals(Geldbetrag.get(2100), medium.berechneMietgebuehr(7));
    }
    
    @Test
    public final void testBerechneMietgebuehrNichtNull()
    {
        Medium medium = getMedium();
        assertNotNull(medium.berechneMietgebuehr(5));
    }

    protected DVD getMedium()
    {
        return new DVD(TITEL, KOMMENTAR, REGISSEUR, LAENGE);
    }

}
