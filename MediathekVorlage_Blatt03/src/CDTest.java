import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CDTest extends AbstractMediumTest
{
	private static final String INTERPRET = "CD Interpret";

    @Test
    public void testGetMedienBezeichnung()
    {
    	CD cd = getMedium();
        assertEquals("CD", cd.getMedienBezeichnung());
    }
	
	@Test
	public void testKonstruktor()
	{
		super.testKonstruktor();
		CD cd = getMedium();
		assertEquals(LAENGE, cd.getSpiellaenge());
		assertEquals(INTERPRET, cd.getInterpret());
	}

	@Test
	public void testSetter()
	{
		super.testSetter();
		CD cd = getMedium();
		cd.setInterpret("Interpret2");
		assertEquals(cd.getInterpret(), "Interpret2");
		cd.setSpiellaenge(99);
		assertEquals(cd.getSpiellaenge(), 99);
	}

	@Override
	protected CD getMedium()
	{
		return new CD(TITEL, KOMMENTAR, INTERPRET, LAENGE);
	}

}
