package aufgabe2.verketteteKnotenStruktur;

import aufgabe2.BinaryTree;

/**
 * Diese Klasse modelliert Binaerbaeume als einfach verkettete Struktur von
 * Knoten (engl. Node).
 * 
 * @author Imon Bashir, Elham Esmat
 */
public class LinkedBinaryTree implements BinaryTree
{
    private final Node _root;

    private final LinkedBinaryTree _leftTree;

    private final LinkedBinaryTree _rightTree;

    /**
     * Dieser Konstruktor initialisiert einen neuen Baum, so dass er nur aus
     * einem Wurzelknoten mit dem gegebenen Wert besteht.
     * 
     * @param value der positiver bzw. negativer Wert des Wurzelknotens
     * @ensure getValue() == value
     */
    public LinkedBinaryTree(int value)
    {
        _root = new Node(value);
        _leftTree = null;
        _rightTree = null;
    }

    /**
     * Dieser Konstruktor initialisiert einen neuen Baum bestehend aus einer
     * Wurzel und einem "linken" Teilbaum.
     * 
     * @param value der positiver bzw. negativer Wert des Wurzelknotens
     * @param leftTree der Teilbaum
     * @require leftTree != null
     * @ensure getValue() == value
     * @ensure getLeftTree().equals(leftTree) == true
     */
    public LinkedBinaryTree(int value, LinkedBinaryTree leftTree)
    {
        assert leftTree != null : "Vorbedingung verletzt: leftTree != null";
        _root = new Node(value, leftTree._root);
        _leftTree = leftTree;
        _rightTree = null;
    }

    /**
     * Dieser Konstruktor initialisiert einen neuen Baum bestehend aus einer
     * Wurzel und zwei Teilbaeumen ("links" und "rechts").
     * 
     * @param value der positiver bzw. negativer Wert des Wurzelknotens
     * @param leftTree der "linke" Teilbaum
     * @param rightTree der "rechte" Teilbaum
     * @require leftTree != null
     * @require rightTree != null
     * @ensure getValue() == value
     * @ensure getLeftTree().equals(leftTree) == true
     * @ensure getRightTree().equals(leftTree) == true
     */
    public LinkedBinaryTree(int value, LinkedBinaryTree leftTree,
            LinkedBinaryTree rightTree)
    {
        assert leftTree != null : "Vorbedingung verletzt: leftTree != null";
        assert rightTree != null : "Vorbedingung verletzt: rightTree != null";
        _root = new Node(value, leftTree._root, rightTree._root);
        _leftTree = leftTree;
        _rightTree = rightTree;
    }

    @Override
    public int getValue()
    {
        return _root.getValue();
    }

    @Override
    public BinaryTree getLeftTree()
    {
        return _leftTree;
    }

    @Override
    public BinaryTree getRightTree()
    {
        return _rightTree;
    }

    @Override
    public int getSum()
    {
        return _root.getSum();
    }

    @Override
    public int getSize()
    {
        return _root.getNodeCount();
    }

    @Override
    public void print()
    {
        _root.drucke();
    }
}
