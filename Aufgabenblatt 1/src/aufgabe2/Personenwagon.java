/**
 * 
 */
package aufgabe2;

/**
 * @author Imon Bashir, Elham Esmat
 *
 */
public class Personenwagon extends AbstractWagon
{
    private final int _sitzanzahl;
    
    /**
     *  Initialisiert ein neues Personenwagon-Exemplar.
     *  
     *  @param sitzanzahl Die Anzahl der vorhandenen Sitzplätze
     *  
     *  @require sitzanzahl >= 0
     *  
     */
    public Personenwagon(int sitzanzahl)
    {
        super("Personenwagon");
        assert sitzanzahl >= 0 : "Vorbedingung verletzt: sitzanzahl >= 0";
        _sitzanzahl = sitzanzahl;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + " mit " + _sitzanzahl + " Sitzplätzen";
    }    
}
