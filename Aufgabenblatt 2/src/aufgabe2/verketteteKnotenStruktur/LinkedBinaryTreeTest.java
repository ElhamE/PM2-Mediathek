package aufgabe2.verketteteKnotenStruktur;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Dies Testklasse testet Knoten.
 * 
 * @author Imon Bashir, Elham Esmat
 */
public class LinkedBinaryTreeTest
{
    private LinkedBinaryTree _baum1;

    private LinkedBinaryTree _baum2;

    private LinkedBinaryTree _baum3;

    /**
     * Initialisiert Testexemplare.
     */
    public LinkedBinaryTreeTest()
    {
        _baum1 = new LinkedBinaryTree(-100);
        _baum2 = new LinkedBinaryTree(200, _baum1);
        _baum3 = new LinkedBinaryTree(5, _baum1, _baum2);
    }

    @Test
    public void testKonstruktoren()
    {
        assertNotNull(_baum1);
        assertNotNull(_baum2);
        assertNotNull(_baum3);
    }

    @Test
    public void testGetValue()
    {
        assertEquals(-100, _baum1.getValue());
        assertEquals(200, _baum2.getValue());
        assertEquals(5, _baum3.getValue());
    }

    @Test
    public void testGetLeftChild()
    {
        assertEquals(null, _baum1.getLeftTree());
        assertEquals(_baum1, _baum2.getLeftTree());
        assertEquals(_baum1, _baum3.getLeftTree());
    }

    @Test
    public void testGetRightChild()
    {
        assertEquals(null, _baum1.getRightTree());
        assertEquals(null, _baum2.getRightTree());
        assertEquals(_baum2, _baum3.getRightTree());
    }

    @Test
    public void testGetSum()
    {
        assertEquals(-100, _baum1.getSum());
        assertEquals(100, _baum2.getSum());
        assertEquals(5, _baum3.getSum());
    }

    @Test
    public void testGetSize()
    {
        assertEquals(1, _baum1.getSize());
        assertEquals(2, _baum2.getSize());
        assertEquals(4, _baum3.getSize());
    }

}
