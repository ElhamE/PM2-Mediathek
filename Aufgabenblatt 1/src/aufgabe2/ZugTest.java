
package aufgabe2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * @author Imon Bashir, Elham Esmat
 *
 */
public class ZugTest
{
	private Zug _zug;
	
	public ZugTest()
	{
		_zug = new Zug(new Lokomotive(10));
	}
	
	@Test
	/**
	 * Testet den Konstruktor dieser Klasse.
	 */
	public void testKonstruktor()
	{
		assertNotNull(_zug);
	}
	
	private Wagon getWagon()
	{
		return new Personenwagon(15);
	}
	
	@Test
	public void TestGibZugbeschreibung()
	{
		Wagon wagon = getWagon();
		_zug.haengeAn(wagon);
		assertEquals(
				"Lokomotive mit Zugkraft: 10 | Personenwagon mit 15 Sitzplätzen | ",
				_zug.gibZugbeschreibung());
	}
}
