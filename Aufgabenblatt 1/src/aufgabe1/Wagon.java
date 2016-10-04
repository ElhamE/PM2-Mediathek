/**
 * 
 */
package aufgabe1;

/**
 * @author Imon Bashir, Elham Esmat
 *
 */
public interface Wagon
{
    @Override
    /**
     * Liefert eine Beschreibung der Eigenschaften des Wagons.
     * 
     * @return Eigenschaften eines Wagons
     * 
     * @ensure result != null
     */
    String toString();
    
    /**
     * Hängt ein anderes Wagon-Exemplar an diesen Wagon.
     * 
     * @require (anhaenger != null) && (anhaenger != this) 
     * 
     * @ensure (getNachfolger().equals(anhaenger)) == true
     */
    void anhaengen(Wagon anhaenger);
    
    /**
     * Liefert eine Referenz auf das angehängte Wagon-Exemplar.
     * 
     * @return den Nachfolger des Wagons
     */
    Wagon getNachfolger();
    
    /**
     * Liefert die Beschreibungen dieses Wagons und seiner Nachfolger
     * 
     * @return die Beschreibungungen der Wagons
     * 
     * @ensure result != null
     */
    String getBeschreibungen();
}
