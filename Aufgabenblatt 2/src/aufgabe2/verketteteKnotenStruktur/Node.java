package aufgabe2.verketteteKnotenStruktur;

/**
 * Exemplare dieser Klasse repraesentieren einen Knoten eines Baumes.
 * 
 * @author Imon Bashir, Elham Esmat
 */
class Node
{
    private int _value;

    private Node _leftChild;

    private Node _rightChild;

    /**
     * Initialisiert Node-Exemplare mit einem Wert, aber ohne Kindknoten.
     * 
     * @param value der Wert dieses Knotens
     * @ensure getValue() == value
     */
    public Node(int value)
    {
        this(value, null, null);
    }

    /**
     * Initialisiert Node-Exemplare mit einem Wert und mit einem Kindknoten.
     * 
     * @param value der Wert dieses Knotens
     * @param leftChild der "linke" Kindknoten dieses Knotens
     * @ensure getValue() == value
     * @ensure getLeftChild().equals(leftChild) == true
     */
    public Node(int value, Node leftChild)
    {
        this(value, leftChild, null);
    }

    /**
     * Initialisiert Node-Exemplare mit einem Wert und mit zwei Kindknoten.
     * 
     * @param value der Wert dieses Knotens
     * @param leftChild der "linke" Kindknoten dieses Knotens
     * @param rightChild der "rechte" Kindknoten dieses Knotens
     * @ensure getValue() == value
     * @ensure getLeftChild().equals(leftChild) == true
     * @ensure getRightChild().equals(rightChild) == true
     */
    public Node(int value, Node leftChild, Node rightChild)
    {
        _value = value;
        _leftChild = leftChild;
        _rightChild = rightChild;
    }

    /**
     * Liefert den "linken" Kindknoten dieses Knotens (falls vorhanden).
     * 
     * @return ein Kindknoten oder null
     */
    public Node getLeftChild()
    {
        return _leftChild;
    }

    /**
     * Liefert den "rechten" Kindknoten dieses Knotens (falls vorhanden).
     * 
     * @return ein Kindknoten oder null
     */
    public Node getRightChild()
    {
        return _rightChild;
    }

    /**
     * Liefert den im Knoten gespeicherten Wert.
     * 
     * @return positiver bzw. negativer Wert
     */
    public int getValue()
    {
        return _value;
    }

    /**
     * Liefert die Summe aus den Werten dieses Knotens und seinen Kindern (falls
     * vorhanden).
     * 
     * @return Summe der Knotenwerte
     */
    public int getSum()
    {
        int result = getValue();
        if ((_leftChild != null) && (_rightChild != null))
        {
            result = result + _leftChild.getSum() + _rightChild.getSum();
        }
        else if (_leftChild != null)
        {
            result = result + _leftChild.getSum();
        }
        return result;
    }

    /**
     * Liefert die Anzahl der Knoten des durch diesen Knoten repraesentierten
     * Teilbaums.
     * 
     * @return Knotenanzahl
     * @ensure result >= 1
     */
    public int getNodeCount()
    {
        int result = 1;
        if ((_leftChild != null) && (_rightChild != null))
        {
            result = result + _leftChild.getNodeCount()
                    + _rightChild.getNodeCount();
        }
        else if (_leftChild != null)
        {
            result = result + _leftChild.getNodeCount();
        }
        assert result >= 1 : "Nachbedingung verletzt: result >= 1";
        return result;
    }

    /**
     * Gibt die Werte des durch diesen Knoten repraesentierten Teilbaums auf der
     * Konsole aus mithilfe eines Tiefendurchlaufs.
     */
    public void drucke()
    {
        System.err.print(getValue() + " | ");
        if ((_leftChild != null) && (_rightChild != null))
        {
            _leftChild.drucke();
            _rightChild.drucke();
        }
        else if (_leftChild != null)
        {
            _leftChild.drucke();
        }
    }

}
