/**
 * 
 */
package aufgabe1;

/**
 * @author Imon Bashir, Elham Esmat
 *
 */
public class Lokomotive extends AbstractWagon
{
    private final int _zugkraft;
    
    /**
     *  Initialisiert ein neues Lokomotiven-Exemplar.
     *  
     *  @param zugkraft Die Anzahl der Wagons, die gezogen werden können
     *  
     *  @require zugkraft >= 0
     *  
     */
    public Lokomotive(int zugkraft)
    {
        super("Lokomotive");
        assert zugkraft >= 0 : "Vorbedingung verletzt: zugkraft >= 0";
        _zugkraft = zugkraft;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + " mit Zugkraft: " + _zugkraft;
    }
}
