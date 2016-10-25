package aufgabe1.einfachesNetz;

import aufgabe1.AbstractWiderstandsnetz;

/**
 * Diese Klasse modelliert einfache Widerstaende.
 * 
 * @author Imon Bashir, Elham Esmat
 */
public class Widerstand extends AbstractWiderstandsnetz
{
    protected int _widerstandswert;

    /**
     * Initialisiert einfache Widerstands-Exemplare.
     * 
     * @param ohm der Wert des Widerstands in Ohm
     * @require ohm >= 0
     * @ensure getOhm() == ohm
     */
    public Widerstand(int ohm)
    {
        assert ohm >= 0 : "Vorbedingung verletzt: ohm >= 0";
        _widerstandswert = ohm;
    }

    @Override
    public double getOhm()
    {
        assert _widerstandswert >= 0 : "Nachbedingung verletzt: _widerstandswert >= 0";
        return _widerstandswert;
    }

    @Override
    public int getAnzahlWiderstaende()
    {
        return 1;
    }
}
