package aufgabe1;

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

	@Test
	public void TestGetNachfolger()
	{
		assertEquals(null, _wagon.getNachfolger());
		Wagon wagon = getWagon();
		_wagon.anhaengen(wagon);
		assertEquals(wagon, _wagon.getNachfolger());
	}

	@Test
	public void TestGetBeschreibungen()
	{
		assertEquals(
				"Lokomotive mit Zugkraft: 10 - ",
				_wagon.getBeschreibungen());
		Wagon wagon = getWagon();
		_wagon.anhaengen(wagon);
		assertEquals(
				"Lokomotive mit Zugkraft: 10 - Personenwagon mit 15 Sitzplätzen - ",
				_wagon.getBeschreibungen());
	}

	private Wagon getWagon()
	{
		return new Personenwagon(15);
	}
}
