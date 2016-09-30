package aufgabe1.beispielclient;

/**
 * @author Imon Bashir, Elham Esmat
 */

import aufgabe1.Lokomotive;
import aufgabe1.Personenwagon;
import aufgabe1.Wagon;
import aufgabe1.Zug;

class StartupAufgabe1_1
{
    public static void main(String[] args)
    {
        Lokomotive lok = new Lokomotive(5);
        Wagon abteil1 = new Personenwagon(30);
        Wagon abteil2 = new Personenwagon(45);
        Zug zug = new Zug(lok);
        abteil1.anhaengen(abteil2);
        zug.haengeAn(abteil1);
        zug.haengeAn(new Lokomotive(3));
        System.out.println(zug.gibZugbeschreibung1());
        System.err.println(zug.gibZugbeschreibung1Iterativ());
        System.out.println(zug.gibZugbeschreibung2());
      
        //*Problem Züge können mehrere Vorgänger haben --> doppelte Verkettung ist besser*/


    }

}
