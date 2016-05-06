import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class VideospielTest
{
	private static final String KOMMENTAR = "Kommentar";
	private static final String TITEL = "Titel";
	private static final String BEZEICHNUNG = "Videospiel";
	private static final String PLATTFORM = "PM2";
	private Videospiel _vid1;
	private Videospiel _vid2;

	public VideospielTest()
	{
		_vid1 = getMedium();
		_vid2 = getMedium();
	}

	@Test
	public void testGetMedienBezeichnung()
	{
		assertEquals(BEZEICHNUNG, _vid1.getMedienBezeichnung());
	}

	@Test
	public void testKonstruktor()
	{
		assertEquals(TITEL, _vid1.getTitel());
		assertEquals(KOMMENTAR, _vid1.getKommentar());
		assertEquals(PLATTFORM, _vid1.getPlattform());
	}

	@Test
    public void testGetFormatiertenString()
    {
    	assertNotNull(_vid1.getFormatiertenString());
    }
	
	@Test
	/*
	 * Von ein und der selben CD kann es mehrere Exemplare geben, die von
	 * unterschiedlichen Personen ausgeliehen werden können.
	 */
	public void testEquals()
	{
		assertFalse("Mehrere Exemplare der gleichen CD sind ungleich",
				_vid1.equals(_vid2));
		assertTrue("Dasselbe Exemplare der gleichen CD ist gleich",
				_vid1.equals(_vid1));
	}

	private Videospiel getMedium()
	{
		return new Videospiel(TITEL, KOMMENTAR, PLATTFORM);
	}

}
