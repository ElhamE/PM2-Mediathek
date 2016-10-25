package aufgabe1.komplexesNetz;

import aufgabe1.Widerstandsnetz;

/**
 * Diese Klasse modelliert Reihenschaltungen von Widerstandsnetzen.
 * 
 * @author Imon Bashir, Elham Esmat
 */
public class SeriellesWiderstandsnetz extends ZusammengesetztesWiderstandsnetz
{

    /**
     * Initialisiert ein Exemplar dieser Klasse, indem zwei Widerstandsnetze
     * miteinander in Reihe geschaltet werden.
     * 
     * @param links das erste Widerstandsnetz
     * @param rechts das zweite Widerstandsnetz
     * @require (links != null) && (rechts != null)
     * @ensure getErstesNetz().equals(links) == true
     * @ensure getZweitesNetz().equals(rechts) == true
     */
    public SeriellesWiderstandsnetz(Widerstandsnetz links,
            Widerstandsnetz rechts)
    {
        super(links, rechts);
    }

    @Override
    public double getOhm()
    {
        return getErstesNetz().getOhm() + getZweitesNetz().getOhm();
    }

}
