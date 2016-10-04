/**
 * 
 */
package aufgabe3;

/**
 * Dieses Interface spezifiziert Stacks von Objekten. Die Elemente auf diesem
 * Stack sollen also nach dem LIFO-Prinzip verwaltet werden.
 * 
 * @author Imon Bashir & Elham Esmat
 */
public interface ADStack
{
	/**
	 * Eine verändernde Operation, legt das gegebene Objekt auf den Stack.
	 * 
	 * @param object Das Objekt, welches auf den Stack kommen soll
	 * @require object != null
	 * @ensure (top().equals(object)) == true
	 */
	void push(Object object);

	/**
	 * Prüft, ob der Stack leer ist.
	 * 
	 * @return true, wenn der Stack kein Objekt enthält, false sonst.
	 */
	boolean isEmpty();

	/**
	 * Liefert die Anzahl der Elemente des Stacks.
	 * 
	 * @return die Kardinalität des Stacks
	 * 
	 * @ensure result >= 0
	 */
	int size();
	
	/**
	 * Eine sondierende Operation, gibt das zuletzt auf den Stack gelegte
	 * Objekt zurück.
	 * 
	 * @require isEmpty() == false
	 *
	 * @return das zuletzt darauf gelegte Objekt, falls der Stack nicht leer
	 *         war
	 */
	Object top();

	/**
	 * Eine verändernde Operation, löscht das zuletzt auf den Stack gelegte
	 * Objekt, falls der Stack nicht leer war.
	 * 
	 * @require isEmpty() == false
	 */
	void pop();

	/**
	 * Liefert einen String, der für jedes enthaltene Objekt eine Zeile enthält,
	 * beginnend mit dem zuletzt auf den Stack gelegten Objekt.
	 * 
	 * @require isEmpty() == false
	 * 
	 * @ensure result != null
	 * 
	 * @return eine Beschreibung aller Objekte des Stacks
	 */
	String getStringRepresentation();
}
