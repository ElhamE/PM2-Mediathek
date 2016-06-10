package de.hawhh.informatik.sml.kino.fachwerte;

import de.hawhh.informatik.sml.kino.fachwerte.Geldbetrag;

/**
 * Ein Geldbetrag in Euro, gespeichert als ganze Euro- und ganze Cent-Beträge.
 * 
 * @author Imon Bashir, Elham Esmat
 * @version SoSe 2016
 */
public final class Geldbetrag
{
    /**
     * Der Euro-Anteil eines Geldbetrags.
     */
    private int _euro;

    /**
     * Der Cent-Anteil eines Geldbetrags.
     */
    private int _cent;

    private Geldbetrag(int eurocent)
    {
        _euro = eurocent / 100;
        _cent = eurocent % 100;
    }
    
    /**
     * Wählt einen Geldbetrag aus.
     * 
     * @param eurocent Der Betrag in ganzen Euro-Cent
     * @require eurocent.intValue() >= 0;
     */
    public static Geldbetrag get(Integer eurocent)
    {
        assert eurocent.intValue() >= 0 : "Vorbedingung verletzt: eurocent.intValue() >= 0";
        return new Geldbetrag(eurocent.intValue());
    }

    /**
     * Wählt einen Geldbetrag aus.
     * 
     * @param eurocent Der Betrag in ganzen Euro-Cent
     * @require eurocent >= 0;
     */
    public static Geldbetrag get(int eurocent)
    {
        assert eurocent >= 0 : "Vorbedingung verletzt: eurocent >= 0";
        return new Geldbetrag(eurocent);
    }
    
    /**
     * Wählt einen Geldbetrag aus.
     * 
     * @param eurocent Der Betrag in (Euro),(Cent)
     * @require eurocent.matches("[0-9]+,[0-9]{2}?");
     */
    public static Geldbetrag get(String eurocent)
    {
    	String regex = "[0-9]+,[0-9]{2}?";
        assert eurocent.matches(regex) : "Vorbedingung verletzt: eurocent >= 0";
        String euroAnteil = eurocent.substring(0, eurocent.length()-3);
        String centAnteil = eurocent.substring(eurocent.length()-2);
        int result = Integer.parseInt(euroAnteil) * 100 + Integer.parseInt(centAnteil);        
        return new Geldbetrag(result);
    }

    /**
     * Gibt den Eurobetrag ohne Cent zurück.
     * 
     * @return Den Eurobetrag ohne Cent.
     */
    public int getEuroAnteil()
    {
        return _euro;
    }

    /**
     * Gibt den Centbetrag ohne Eurobetrag zurück.
     */
    public int getCentAnteil()
    {
        return _cent;
    }

    /**
     * Liefert einen formatierten String des Geldbetrags in der Form
     * "(Euro),(Cent)" zurück.
     * 
     * @return eine String-Repräsentation des Geldbetrags.
     */
    public String getFormatiertenString()
    {
        return _euro + "," + getFormatiertenCentAnteil();
    }

    private String getFormatiertenCentAnteil()
    {
        if (_cent < 10)
        {
            return "0" + _cent;
        }
        return "" + _cent;
    }
    
    /**
     * Gibt diesen Geldbetrag in der Form "(Euro),(Cent)" zurück.
     */
    @Override
    public String toString()
    {
        return getFormatiertenString();
    }

    /**
     * Liefert die Summe zweier Geldbeträge.
     * 
     * @param betrag Ein Geldbetrag, der mit diesem summiert werden soll
     * @require betrag != null
     * @return ein Geldbetrag, der die Summe von zwei Geldbeträgen repräsentiert
     */
    public Geldbetrag addiere(Geldbetrag betrag)
    {
        assert betrag != null : "Vorbedingung verletzt: betrag != null";
        int result = getEuroCent(this) + getEuroCent(betrag);
        return new Geldbetrag(result);
    }

    /**
     * Liefert die Differenz zweier Geldbeträge.
     * 
     * @param betrag Ein Geldbetrag, der von diesem abgezogen werden soll
     * @require betrag != null
     * @require getEuroCent(this) >= getEuroCent(betrag)
     * @return ein Geldbetrag, der die Differenz von zwei Geldbeträgen
     *         repräsentiert
     */
    public Geldbetrag subtrahiere(Geldbetrag betrag)
    {
        assert betrag != null : "Vorbedingung verletzt: betrag != null";
        assert getEuroCent(this) >= getEuroCent(
                betrag) : "Vorbedingung verletzt: getEuroCent(this) >= getEuroCent(betrag)";
        int result = getEuroCent(this) - getEuroCent(betrag);
        return new Geldbetrag(result);
    }

    /**
     * Liefert das Produkt des Geldbetrags mit einer Zahl.
     * 
     * @param faktor Die Zahl, mit welcher der Geldbetrag multipliziert wird
     * @require faktor >= 0
     * @return ein Geldbetrag, der die Multiplikation eines Geldbetrags mit
     *         einer Zahl repräsentiert
     */
    public Geldbetrag multipliziere(int faktor)
    {
        assert faktor >= 0 : "Vorbedingung verletzt: faktor >= 0";
        int result = getEuroCent(this) * faktor;
        return new Geldbetrag(result);
    }

    /**
     * Liefert einen übergebenen Geldbetrag als Eurocent-Betrag
     * 
     * @return Eurocent-Darstellung eines Geldbetrags.
     */
    public int getEuroCent(Geldbetrag betrag)
    {
        return betrag._euro * 100 + betrag._cent;
    }

    @Override
    public boolean equals(Object object)
    {
        boolean result = false;
        if (object instanceof Geldbetrag)
        {
            Geldbetrag betrag = (Geldbetrag) object;
            result = (_euro == betrag._euro)
                    && (_cent == betrag._cent);
        }
        return result;
    }

    @Override
    public int hashCode()
    {
        return getEuroCent(this);
    }
    
}
