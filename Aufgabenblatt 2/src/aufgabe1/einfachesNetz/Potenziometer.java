package aufgabe1.einfachesNetz;

/**
 * Diese Klasse modelliert einfache Widerstaende mit regelbaren
 * Widerstandswerten.
 * 
 * @author Imon Bashir, Elham Esmat
 */
public class Potenziometer extends Widerstand
{
    /**
     * Initialisiert ein Potenziometer-Exemplare.
     * 
     * @param ohm der Wert des Widerstands in Ohm
     * @require ohm >= 0
     * @ensure getOhm() == ohm
     */
    public Potenziometer(int ohm)
    {
        super(ohm);
    }

    /**
     * Setzt einen neuen Widerstandswert.
     * 
     * @param ohm der neue Widerstandswert
     * @require ohm >= 0
     * @ensure getOhm() == ohm
     */
    public void setOhm(int ohm)
    {
        _widerstandswert = ohm;
    }
}
