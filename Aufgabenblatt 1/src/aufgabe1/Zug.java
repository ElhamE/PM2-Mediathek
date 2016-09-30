/**
 * 
 */
package aufgabe1;

/**
 * @author Imon Bashir, Elham Esmat
 */
public class Zug
{
    private final Lokomotive _lok;

    /**
     * Initialisiert ein neues Zug-Exemplar.
     * 
     * @param lok Die Lokomotive des Zugs
     * @require lok != null
     */
    public Zug(Lokomotive lok)
    {
        assert lok != null : "Vorbedingung verletzt: lok != null";
        _lok = lok;
    }

    /**
     * Hängt einen Zugteil (bestehend aus mindestens einem Wagon) hinten dran
     * 
     * @param wagon Ein anderes Wagon-Exemplar
     */
    public void haengeAn(Wagon wagon)
    {
        _lok.anhaengen(wagon);
    }
    
    /**
     *  Liefert eine Auflistung bestehend aus den aneinandergehängten Beschreibungen aller Wagons.
     *  
     *  @return alle Beschreibungen der Waggons des Zugs
     */
    public String gibZugbeschreibung1()
    {
        return gibZugbeschreibung1Hilfe(_lok);
    }

    /**
     * Hilfsmethode von gibZubeschreibung1().
     */
    private String gibZugbeschreibung1Hilfe(Wagon aktuellerWagon)
    {
        if (aktuellerWagon == null)
        {
            return "";
        }
        else
        {
            return  " | " + aktuellerWagon.toString()
                    + gibZugbeschreibung1Hilfe(aktuellerWagon.getNachfolger());
        }
    }
    
    /**
     *  iterative Implementierung von gibZugbeschreibung1()
     */
    public String gibZugbeschreibung1Iterativ()
    {
        Wagon aktuellerWagon = _lok;
        String result = "";
        do
        {
            result = result + " | " + aktuellerWagon.toString();
            aktuellerWagon = aktuellerWagon.getNachfolger();
        }
        while (aktuellerWagon != null);
        return result;
    }

    /**
     *  alternative Implementierung von gibZugbeschreibung1()
     */
    public String gibZugbeschreibung2()
    {
        return _lok.getBeschreibungen();
    }
}
