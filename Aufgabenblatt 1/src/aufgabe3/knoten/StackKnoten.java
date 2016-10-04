/**
 * 
 */
package aufgabe3.knoten;

/**
 * @author Elham
 *
 */
public class StackKnoten
{
    private Object _inhalt;
    private StackKnoten _nachfolger;
    
    public StackKnoten(Object inhalt, StackKnoten knoten)
    {
        _inhalt = inhalt;
        _nachfolger = knoten;
    }
    
    public Object getInhalt()
    {
        return _inhalt;
    }
    
    public StackKnoten getNachfolger()
    {
        return _nachfolger;
    }
}
