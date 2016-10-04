package aufgabe2.beispielclient;

/**
 * @author Imon Bashir, Elham Esmat
 */

import aufgabe2.Lokomotive;
import aufgabe2.Personenwagon;
import aufgabe2.Wagon;
import aufgabe2.Zug;

class StartupAufgabe1_2
{
    public static void main(String[] args)
    {
        Lokomotive lok = new Lokomotive(5);
        Wagon abteil1 = new Personenwagon(30);
        Wagon abteil2 = new Personenwagon(45);
        Zug zug = new Zug(lok);
        zug.haengeAn(abteil1);
        zug.haengeAn(abteil2);
        zug.haengeAn(new Lokomotive(3));
        System.out.println(zug.gibZugbeschreibung());
    }
}
