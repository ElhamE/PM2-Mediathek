package aufgabe2.verketteteKnotenStruktur;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Dies Testklasse testet Knoten.
 * 
 * @author Imon Bashir, Elham Esmat
 */
public class NodeTest
{
    private Node _knoten1;

    private Node _knoten2;

    private Node _knoten3;

    /**
     * Initialisiert Testexemplare.
     */
    public NodeTest()
    {
        _knoten1 = new Node(-100);
        _knoten2 = new Node(200, _knoten1);
        _knoten3 = new Node(5, _knoten1, _knoten2);
    }

    @Test
    public void testKonstruktoren()
    {
        assertNotNull(_knoten1);
        assertNotNull(_knoten2);
        assertNotNull(_knoten3);
    }

    @Test
    public void testGetValue()
    {
        assertEquals(-100, _knoten1.getValue());
        assertEquals(200, _knoten2.getValue());
        assertEquals(5, _knoten3.getValue());
    }

    @Test
    public void testGetLeftChild()
    {
        assertEquals(null, _knoten1.getLeftChild());
        assertEquals(_knoten1, _knoten2.getLeftChild());
        assertEquals(_knoten1, _knoten3.getLeftChild());
    }

    @Test
    public void testGetRightChild()
    {
        assertEquals(null, _knoten1.getRightChild());
        assertEquals(null, _knoten2.getRightChild());
        assertEquals(_knoten2, _knoten3.getRightChild());
    }

    @Test
    public void testGetSum()
    {
        assertEquals(-100, _knoten1.getSum());
        assertEquals(100, _knoten2.getSum());
        assertEquals(5, _knoten3.getSum());
    }

    @Test
    public void testGetNodeCount()
    {
        assertEquals(1, _knoten1.getNodeCount());
        assertEquals(2, _knoten2.getNodeCount());
        assertEquals(4, _knoten3.getNodeCount());
    }

}
