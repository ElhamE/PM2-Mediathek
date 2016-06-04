package de.hawhh.informatik.sml.mediathek.materialien.medien;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DVDTest extends AbstractMediumTest
{
	private static final String REGISSEUR = "DVD Regisseur";

    @Test
    public void testGetMedienBezeichnung()
    {
		DVD dvd = getMedium();
        assertEquals("DVD", dvd.getMedienBezeichnung());
    }
    
	
	@Test
	public void testKonstruktor()
	{
		super.testKonstruktor();
		DVD dvd = getMedium();
		assertEquals(LAENGE, dvd.getLaufzeit());
		assertEquals(REGISSEUR, dvd.getRegisseur());
	}

	@Test
	public void testSetter()
	{
		super.testSetter();
		DVD dvd = getMedium();
		dvd.setLaufzeit(90);
		assertEquals(90, dvd.getLaufzeit());
		dvd.setRegisseur("Regisseur2");
		assertEquals("Regisseur2", dvd.getRegisseur());
	}

	@Override
	protected DVD getMedium()
	{
		return new DVD(TITEL, KOMMENTAR, REGISSEUR, LAENGE);
	}


}
