package de.hawhh.informatik.sml.kino.fachwerte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import de.hawhh.informatik.sml.kino.fachwerte.Geldbetrag;

/**
 * @author Imon Bashir, Elham Esmat
 * @version SoSe 2016
 * 
 */
public class GeldbetragTest
{
	 @Test
	 public final void testSelektoren()
	 {
		 Geldbetrag betrag = Geldbetrag.get(123);
		 assertEquals("1,23", betrag.getFormatiertenString());
		 
		 betrag = Geldbetrag.get(new Integer(96));
		 assertEquals("0,96", betrag.getFormatiertenString());
		 
		 betrag = Geldbetrag.get("100787,99");
		 assertEquals("100787,99", betrag.getFormatiertenString());
	 }
	
    @Test
    public final void testGeldbetrag()
    {
        Geldbetrag betrag = Geldbetrag.get(100);
        assertEquals(1, betrag.getEuroAnteil());
        assertEquals(0, betrag.getCentAnteil());
        assertEquals("1,00", betrag.getFormatiertenString());

        betrag = Geldbetrag.get("0,00");
        assertEquals(0, betrag.getEuroAnteil());
        assertEquals(0, betrag.getCentAnteil());
        assertEquals("0,00", betrag.getFormatiertenString());

        betrag = Geldbetrag.get(new Integer(99));
        assertEquals(0, betrag.getEuroAnteil());
        assertEquals(99, betrag.getCentAnteil());
        assertEquals("0,99", betrag.getFormatiertenString());

        betrag = Geldbetrag.get(101);
        assertEquals(1, betrag.getEuroAnteil());
        assertEquals(1, betrag.getCentAnteil());
        assertEquals("1,01", betrag.getFormatiertenString());
    }
    
    @Test
    public final void testAddieren()
    {
        Geldbetrag betrag1 = Geldbetrag.get(100);
        Geldbetrag betrag2 = Geldbetrag.get(200);
        Geldbetrag betrag3 = betrag1.addiere(betrag2);
        assertEquals("3,00", betrag3.getFormatiertenString());
        
        betrag1 = Geldbetrag.get(0);
        betrag2 = Geldbetrag.get(759);
        betrag3 = betrag1.addiere(betrag2);
        assertEquals("7,59", betrag3.getFormatiertenString());
        
        betrag1 = Geldbetrag.get(999);
        betrag2 = Geldbetrag.get(2);
        betrag3 = betrag1.addiere(betrag2);
        assertEquals("10,01", betrag3.getFormatiertenString());
    }
    
    @Test
    public final void testSubtrahieren()
    {
        Geldbetrag betrag1 = Geldbetrag.get(200);
        Geldbetrag betrag2 = Geldbetrag.get(100);
        Geldbetrag betrag3 = betrag1.subtrahiere(betrag2);
        assertEquals("1,00", betrag3.toString());
        
        betrag1 = Geldbetrag.get(10);
        betrag2 = Geldbetrag.get(10);
        betrag3 = betrag1.subtrahiere(betrag2);
        assertEquals("0,00", betrag3.toString());
        
        betrag1 = Geldbetrag.get(1555);
        betrag2 = Geldbetrag.get(56);
        betrag3 = betrag1.subtrahiere(betrag2);
        assertEquals("14,99", betrag3.toString());
    }
    
    @Test
    public final void testMultiplizieren()
    {
        Geldbetrag betrag1 = Geldbetrag.get(111);
        Geldbetrag betrag2 = betrag1.multipliziere(0);
        assertEquals("0,00", betrag2.getFormatiertenString());
        
        betrag2 = betrag1.multipliziere(1);
        assertEquals("1,11", betrag2.getFormatiertenString());
        
        betrag2 = betrag1.multipliziere(5);
        assertEquals("5,55", betrag2.getFormatiertenString());
    }
    
    @Test
    public final void testEqualsHashcode()
    {
        Geldbetrag betrag1 = Geldbetrag.get(100);
        Geldbetrag betrag2 = Geldbetrag.get(100);
        assertTrue(betrag1.equals(betrag2));
        assertTrue(betrag1.hashCode() == betrag2.hashCode());

        Geldbetrag betrag3 = Geldbetrag.get(101);
        assertFalse(betrag1.equals(betrag3));
        assertFalse(betrag1.hashCode() == betrag3.hashCode());

        Geldbetrag betrag4 = Geldbetrag.get(1000);
        assertFalse(betrag1.equals(betrag4));
        assertFalse(betrag1.hashCode() == betrag4.hashCode());
    }
}
