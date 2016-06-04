package de.hawhh.informatik.sml.mediathek.materialien.medien;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import de.hawhh.informatik.sml.mediathek.fachwerte.Geldbetrag;

/**
 */
public class KonsolenVideospielTest extends AbstractVideospielTest
{

    @Test
    public void testGetMedienBezeichnung()
    {
    	KonsolenVideospiel videospiel = getMedium();
    	assertEquals("KonsolenVideospiel", videospiel.getMedienBezeichnung());
    }
    
    @Override
    protected KonsolenVideospiel getMedium()
    {
        return new KonsolenVideospiel(TITEL, KOMMENTAR, SYSTEM);
    }
    
    @Test
    public void testBerechneMietgebuehr()
    {
    	KonsolenVideospiel videospiel = getMedium();
        assertEquals(Geldbetrag.get(200), videospiel.berechneMietgebuehr(1));
        assertEquals(Geldbetrag.get(200), videospiel.berechneMietgebuehr(2));
        assertEquals(Geldbetrag.get(900), videospiel.berechneMietgebuehr(3));
        assertEquals(Geldbetrag.get(900), videospiel.berechneMietgebuehr(5));
        assertEquals(Geldbetrag.get(1600), videospiel.berechneMietgebuehr(6));
        assertEquals(Geldbetrag.get(3000), videospiel.berechneMietgebuehr(13));
    }
    
    @Test
    public void testGetPreisNachTagen()
    {
    	KonsolenVideospiel videospiel = getMedium();
        assertEquals(0, videospiel.getPreisNachTagen(1));
        assertEquals(0, videospiel.getPreisNachTagen(2));
        assertEquals(700, videospiel.getPreisNachTagen(3));
        assertEquals(700, videospiel.getPreisNachTagen(5));
        assertEquals(1400, videospiel.getPreisNachTagen(6));
        assertEquals(2800, videospiel.getPreisNachTagen(13));
    }

}
