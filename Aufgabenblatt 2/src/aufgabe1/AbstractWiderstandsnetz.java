package aufgabe1;

/**
 * Diese Klasse enthaelt die gemeinsamen Elemente aller Widerstandsnetze.
 * 
 * @author Imon Bashir, Elham Esmat
 */
public abstract class AbstractWiderstandsnetz implements Widerstandsnetz
{
    public abstract double getOhm();
    
    public abstract int getAnzahlWiderstaende();
}
