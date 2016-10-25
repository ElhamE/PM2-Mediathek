package aufgabe1.komplexesNetz;

import aufgabe1.Widerstandsnetz;

/**
 * Diese Klasse modelliert Parallelschaltungen von Widerstandsnetzen.
 * 
 * @author Imon Bashir, Elham Esmat
 */
public class ParallelesWiderstandsnetz extends ZusammengesetztesWiderstandsnetz
{
    /**
     * Initialisiert ein Exemplar dieser Klasse, indem zwei Widerstandsnetze
     * zueinander parallel geschaltet werden.
     * 
     * @param oben das erste Widerstandsnetz
     * @param unten das zweite Widerstandsnetz
     * @require (oben != null) && (unten != null)
     * @ensure getErstesNetz().equals(oben) == true
     * @ensure getZweitesNetz().equals(unten) == true
     */
    public ParallelesWiderstandsnetz(Widerstandsnetz oben,
            Widerstandsnetz unten)
    {
        super(oben, unten);
    }

    @Override
    /**
     * @require (getErstesNetz().getOhm() > 0) && (getZweitesNetz().getOhm() >
     *          0)
     */
    public double getOhm()
    {
        assert (getErstesNetz().getOhm() > 0) && (getZweitesNetz()
                .getOhm() > 0) : "Vorbedingung verletzt: (getErstesNetz().getOhm() > 0) && (getZweitesNetz().getOhm() > 0)";
        return 1 / (1 / getErstesNetz().getOhm()
                + 1 / getZweitesNetz().getOhm());
    }

}
