/**
 * 
 */
package aufgabe1;

/**
 * @author Imon Bashir, Elham Esmat
 */
abstract class AbstractWagon implements Wagon
{
    private Wagon _nachfolger;

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
        _nachfolger = null;
    }

    public String toString()
    {
        return _bezeichnung;
    }

    @Override
    public void anhaengen(Wagon anhaenger)
    {
        assert (anhaenger != null)
                && (anhaenger != this) : "Vorbedingung verletzt: (anhaenger != null) && (anhaenger != this)";
        if (_nachfolger == null)
        {
            _nachfolger = anhaenger; 
        }
        else
        {
            _nachfolger.anhaengen(anhaenger);
        }     
    }
    
    @Override
    public Wagon getNachfolger()
    {
        return _nachfolger;
    }
    
    @Override
    public String getBeschreibungen()
    {
        if (_nachfolger == null)
        {
            return toString() + " - ";
        }
        else
        {
            return toString() + " - " + _nachfolger.getBeschreibungen();
        }
    }
//    public String getBeschreibungenIterativ()
//    {
//        /** wie gibZugbeschreibung1Iterativ(); statt _lok this benutzen*/
//    }
}
