package aufgabe3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import aufgabe3.array.ADStackArrayImpl;
import aufgabe3.knoten.ADStackKnotenImpl;

/**
 * Die Testklasse von ADStack.
 * 
 * @author Imon Bashir, Elham Esmat
 */

public class ADStackTest
{
    private ADStack _stack;

    public ADStackTest()
    {
        _stack = new ADStackArrayImpl();
    }

    @Test
    /**
     * Testet, ob ein leerer Stack tatsächlich erzeugt wurde.
     */
    public void testKonstruktor()
    {
        assertNotNull(_stack);
        assertTrue(_stack.isEmpty());
    }

    @Test
    /**
     * Testet, ob das Einfügen von Objekten die Kardinalität verändert.
     */
    public void testKardinalitaet()
    {
        for (int zaehler = 1; zaehler <= 10; ++zaehler)
        {
            _stack.push("" + zaehler);
            assertFalse(_stack.isEmpty());
            assertTrue(_stack.size() == zaehler);
        }
    }

    @Test
    /**
     * Testet, ob sich das zuletzt auf den Stack gelegte Objekt an der ersten
     * Position befindet.
     */
    public void testPushAndTop()
    {
        for (int zaehler = 0; zaehler <= 9; ++zaehler)
        {
            _stack.push("" + zaehler);
            assertEquals("" + zaehler, _stack.top());
        }
    }

    @Test
    /**
     * Testet das Einfügen von Duplikaten.
     */
    public void testPushDuplikate()
    {
        String duplikat = "Duplikat";
        for (int zaehler = 1; zaehler <= 10; ++zaehler)
        {
            _stack.push(duplikat);
            assertTrue(_stack.size() == zaehler);
        }
    }

    @Test
    /**
     * Testet, ob das Entfernen von Stack-Elementen funktioniert.
     */
    public void testPopKardinalitaet()
    {
        for (int zaehler = 0; zaehler <= 9; ++zaehler)
        {
            _stack.push("" + zaehler);
            _stack.pop();
            assertTrue(_stack.isEmpty());
        }
    }

    @Test
    /**
     * Testet, ob nach dem LIFO-Prinzip umgesetzt wird.
     */
    public void testLIFO()
    {
        fuelleStackMitInhalt();
        for (int zaehler = 9; zaehler > 0; --zaehler)
        {
            _stack.pop();
            assertEquals("" + (zaehler - 1), _stack.top());
        }
    }

    @Test
    /**
     * Testet, ob eine Beschreibung geliefert wird.
     */
    public void testGetStringRepresentation()
    {
        fuelleStackMitInhalt();
        assertNotNull(_stack.getStringRepresentation());
    }

    private void fuelleStackMitInhalt()
    {
        for (int zaehler = 0; zaehler <= 9; ++zaehler)
        {
            _stack.push("" + zaehler);
        }
    }
}
