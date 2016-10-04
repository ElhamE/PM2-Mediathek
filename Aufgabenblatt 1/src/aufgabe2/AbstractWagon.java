/**
 * 
 */
package aufgabe2;

/**
 * @author Imon Bashir, Elham Esmat
 */
abstract class AbstractWagon implements Wagon
{
    private String _bezeichnung;

    /**
     * Initialisiert einen neues Wagon-Exemplar.
     * 
     * @param bezeichnung Die Bezeichnung des Wagons
     * @require bezeichnung != null;
     */
    public AbstractWagon(String bezeichnung)
    {
        assert bezeichnung != null : "Vorbedingung verletzt: bezeichnung != null";
        _bezeichnung = bezeichnung;
    }

    public String toString()
    {
        return _bezeichnung;
    }
}
