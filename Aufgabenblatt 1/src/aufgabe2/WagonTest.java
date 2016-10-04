package aufgabe2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * @author Imon Bashir & Elham Esmat
 */
public class WagonTest
{
	private Wagon _wagon;

	public WagonTest()
	{
		_wagon = new Lokomotive(10);
	}

	@Test
	/**
	 * Testet den Konstruktor dieser Klasse.
	 */
	public void testKonstruktor()
	{
		assertNotNull(_wagon);
	}

	@Test
	public void testToString()
	{
		assertEquals("Lokomotive mit Zugkraft: 10", _wagon.toString());
	}
}
