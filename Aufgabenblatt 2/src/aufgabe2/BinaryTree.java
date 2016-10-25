package aufgabe2;

/**
 * Dieses Interface ermoeglicht die Benutzung eines Binaerbaums. In einem
 * Binaerbaum hat jeder Knoten maximal zwei Kinder(sog. Kindknoten).
 * 
 * @author Imon Bashir, Elham Esmat
 */
public interface BinaryTree
{
    /**
     * Liefert den im Wurzelknoten gehaltenen Wert zurueck.
     * 
     * @return positiver bzw. negativer Wert
     */
    int getValue();

    /**
     * Eine sondierende Operation, die den gesamten "linken" Teilbaum zurueck
     * gibt (falls vorhanden).
     * 
     * @return einen binären Teilbaum dieses Baums oder null
     */
    BinaryTree getLeftTree();

    /**
     * Eine sondierende Operation, die den gesamten "rechten" Teilbaum zurueck
     * gibt (falls vorhanden).
     * 
     * @return einen binären Teilbaum dieses Baums oder null
     */
    BinaryTree getRightTree();

    /**
     * Diese liefert die Summe der gespeicherten Werte aller Knoten dieses
     * Baums.
     * 
     * @return Summe aller Knotenwerte
     */
    int getSum();

    /**
     * Diese Methode liefert die Anzahl der im Baum enthaltenen Knoten.
     * 
     * @return Anzahl der Knoten
     * @ensure result >= 1
     */
    int getSize();

    /**
     * Gibt alle in dem Baum gespeicherten Knotenwerte auf der Konsole aus.
     */
    void print();
}
