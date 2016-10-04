/**
 * 
 */
package aufgabe2;

import java.util.LinkedList;


/**
 * @author Imon Bashir, Elham Esmat
 */
public class Zug
{
    private final LinkedList<Wagon> _zug;

    /**
     * Initialisiert ein neues Zug-Exemplar.
     * 
     * @param lok Die Lokomotive des Zugs
     * @require lok != null
     */
    public Zug(Lokomotive lok)
    {
        assert lok != null : "Vorbedingung verletzt: lok != null";
        _zug = new LinkedList<Wagon>();
        _zug.addFirst(lok);
    }

    /**
     * Hängt einen Wagon hinten dran
     *  
     * @param wagon Ein anderes Wagon-Exemplar
     * 
     * @require wagon != null
     */
    public void haengeAn(Wagon wagon)
    {
        _zug.addLast(wagon);
    }
    
    /**
     *  Liefert eine Auflistung bestehend aus den aneinandergehängten Beschreibungen aller Wagons.
     *  
     *  @return alle Beschreibungen der Waggons des Zugs
     */
    public String gibZugbeschreibung()
    {
        String result = "";
        for (Wagon wagon: _zug)
        {
            result = result + wagon.toString() + " | ";
        }
        return result;
    }
}
