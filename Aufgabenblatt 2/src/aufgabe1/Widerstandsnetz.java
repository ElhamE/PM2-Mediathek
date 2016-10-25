package aufgabe1;

/**
 * Dieses Interface ermoeglicht die Benutzung von Widerstandsnetzen. Ein
 * Widertstandsnetz besteht aus mindestens einem Widerstand.
 * 
 * @author Imon Bashir, Elham Esmat
 */
public interface Widerstandsnetz
{
    /**
     * Liefert den Gesamtwiderstand des Netzes in der Einheit Ohm.
     * 
     * @ensure result >= 0
     * @return den Widerstand des Widerstandsnetzes
     */
    double getOhm();

    /**
     * Liefert die Anzahl an einfachen Widerstaenden im Netz.
     * 
     * @ensure result >= 1
     * @return Anzahl der Widerstaende
     */
    int getAnzahlWiderstaende();
}
