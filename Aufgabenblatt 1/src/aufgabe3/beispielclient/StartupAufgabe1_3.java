package aufgabe3.beispielclient;

import aufgabe3.ADStack;
import aufgabe3.array.ADStackArrayImpl;
import aufgabe3.knoten.ADStackKnotenImpl;

/**
 * @author Imon Bashir, Elham Esmat
 */

class StartupAufgabe1_3
{
    public static void main(String[] args)
    {
    	ADStack knotenStack = new ADStackKnotenImpl();
    	ADStack arrayStack = new ADStackArrayImpl();
		for (int zaehler = 0; zaehler <= 9; ++zaehler)
		{
			knotenStack.push("" + zaehler);
			arrayStack.push("" + zaehler);
		}
		System.out.println(knotenStack.getStringRepresentation());
		System.err.println(arrayStack.getStringRepresentation());
    }
}
