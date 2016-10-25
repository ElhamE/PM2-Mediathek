package aufgabe2.beispielclient;

import aufgabe2.verketteteKnotenStruktur.LinkedBinaryTree;

public class StartUp
{
    public static void main(String[] args)
    {
        LinkedBinaryTree leftTree = new LinkedBinaryTree(200,
                new LinkedBinaryTree(3),
                new LinkedBinaryTree(28, new LinkedBinaryTree(14)));
        LinkedBinaryTree rightTree = new LinkedBinaryTree(105,
                new LinkedBinaryTree(7), new LinkedBinaryTree(8,
                        new LinkedBinaryTree(9, new LinkedBinaryTree(10))));
        LinkedBinaryTree tree = new LinkedBinaryTree(10, leftTree, rightTree);
        tree.print();
        try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Linker Teilbaum Groesse: " + leftTree.getSize());
        System.out.println("Rechter Teilbaum Groesse: " + rightTree.getSize());
        System.out.println("Linker Teilbaum Groesse: " + tree.getLeftTree().getSize());
        System.out.println("Rechter Teilbaum Groesse: " + tree.getRightTree().getSize());
        System.out.println("Baum Groesse: " + tree.getSize());
        System.out.println("Linker Teilbaum Wurzelwert: " + leftTree.getValue());
        System.out.println("Rechter Teilbaum Wurzelwert: " + rightTree.getValue());
        System.out.println("Baum Wurzelwert: " + tree.getValue());
        System.out.println("Baum Knotensumme: " + tree.getSum());
        System.out.println("Baum Knotensumme: " + (tree.getValue() + leftTree.getSum() + rightTree.getSum()));
    }
}