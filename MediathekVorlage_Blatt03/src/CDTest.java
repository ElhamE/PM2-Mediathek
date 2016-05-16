import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CDTest extends AbstractMediumTest
{
	private static final String INTERPRET = "CD Interpret";

	public CDTest()
	{
		_medium1 = getMedium();
		_medium2 = getMedium();
	}

    @Test
    public void testGetMedienBezeichnung()
    {
        assertEquals("CD", _medium1.getMedienBezeichnung());
    }
	
	@Test
	public void testKonstruktor()
	{
		super.testKonstruktor();
		assertEquals(LAENGE, ((CD) _medium1).getSpiellaenge());
		assertEquals(INTERPRET, ((CD) _medium1).getInterpret());
	}

	@Test
	public void testSetter()
	{
		super.testSetter();
		((CD) _medium1).setInterpret("Interpret2");
		assertEquals(((CD) _medium1).getInterpret(), "Interpret2");
		((CD) _medium1).setSpiellaenge(99);
		assertEquals(((CD) _medium1).getSpiellaenge(), 99);
	}

	private CD getMedium()
	{
		return new CD(TITEL, KOMMENTAR, INTERPRET, LAENGE);
	}

}
