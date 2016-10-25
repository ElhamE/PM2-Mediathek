package aufgabe1.komplexesNetz;

import aufgabe1.AbstractWiderstandsnetz;
import aufgabe1.Widerstandsnetz;

/**
 * Diese Klasse enthaelt die gemeinsamen Elemente von komplexen Widerstandsnetzen.
 * 
 * @author Imon Bashir, Elham Esmat
 */
abstract class ZusammengesetztesWiderstandsnetz
        extends AbstractWiderstandsnetz
{
    private Widerstandsnetz _erstesNetz;

    private Widerstandsnetz _zweitesNetz;

    public ZusammengesetztesWiderstandsnetz(Widerstandsnetz eins,
            Widerstandsnetz zwei)
    {
        assert(eins != null)
                && (zwei != null) : "Vorbedingung verletzt: (eins != null) && (zwei != null)";
        _erstesNetz = eins;
        _zweitesNetz = zwei;
    }

    @Override
    public int getAnzahlWiderstaende()
    {
        return _erstesNetz.getAnzahlWiderstaende()
                + _zweitesNetz.getAnzahlWiderstaende();
    }

    /**
     * Liefert den ersten Teil des Widerstandsnetzes.
     * 
     * @ensure result != null
     * @return das erste Widerstandsnetz
     */
    public Widerstandsnetz getErstesNetz()
    {
        return _erstesNetz;
    }

    /**
     * Liefert den zweiten Teil des Widerstandsnetzes.
     * 
     * @ensure result != null
     * @return das zweite Widerstandsnetz
     */
    public Widerstandsnetz getZweitesNetz()
    {
        return _zweitesNetz;
    }
}
