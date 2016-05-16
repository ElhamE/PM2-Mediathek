import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DVDTest extends AbstractMediumTest
{
	private static final String REGISSEUR = "DVD Regisseur";

	public DVDTest()
	{
		_medium1 = getMedium();
		_medium2 = getMedium();
	}

    @Test
    public void testGetMedienBezeichnung()
    {
        assertEquals("DVD", _medium1.getMedienBezeichnung());
    }
    
	
	@Test
	public void testKonstruktor()
	{
		super.testKonstruktor();
		assertEquals(LAENGE, ((DVD) _medium1).getLaufzeit());
		assertEquals(REGISSEUR, ((DVD) _medium1).getRegisseur());
	}

	@Test
	public void testSetter()
	{
		super.testSetter();
		((DVD) _medium1).setLaufzeit(90);
		assertEquals(90, ((DVD) _medium1).getLaufzeit());
		((DVD) _medium1).setRegisseur("Regisseur2");
		assertEquals("Regisseur2", ((DVD) _medium1).getRegisseur());
	}

	private DVD getMedium()
	{
		return new DVD(TITEL, KOMMENTAR, REGISSEUR, LAENGE);
	}

}
