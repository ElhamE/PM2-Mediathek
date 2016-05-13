/**
 * Eine abstrakte Implementation des Medium-Interfaces, die die gemeinsamen
 * Operationen von CD, DVD und Videospiel bereitstellt.
 * 
 * @author Imon Bashir, Elham Esmat
 * @version SoSe 2016
 */
abstract class AbstractMedium implements Medium
{

    /**
     * Ein Kommentar zum Medium
     */
    protected String _kommentar;

    /**
     * Der Titel des Mediums
     */
    protected String _titel;

    @Override
    public abstract String getMedienBezeichnung();

    @Override
    public Geldbetrag berechneMietgebuehr(int mietTage)
    {
        assert mietTage > 0 : "Vorbedingung verletzt: mietTage > 0";
        return Geldbetrag.get(mietTage * 300);
    }
    
    @Override
    public String getKommentar()
    {
        return _kommentar;
    }

    @Override
    public void setKommentar(String kommentar)
    {
        assert kommentar != null : "Vorbedingung verletzt: kommentar != null";
        _kommentar = kommentar;
    }

    public String getTitel()
    {
        return _titel;
    }

    @Override
    public void setTitel(String titel)
    {
        assert titel != null : "Vorbedingung verletzt: titel != null";
        _titel = titel;
    }

    @Override
    public String getFormatiertenString()
    {
        return getMedienBezeichnung() + ":\n" + "    " + "Titel: " + _titel + "\n" + "    " + "Kommentar: "
                + _kommentar;
    }

}
