package de.hawhh.informatik.sml.mediathek.materialien.medien;

import de.hawhh.informatik.sml.mediathek.fachwerte.Geldbetrag;

/**
 * Eine abstrakte Implementation des Medium-Interfaces, die die gemeinsamen
 * Operationen von CDs, DVDs und Videospielen bereitstellt.
 * 
 * @author Imon Bashir, Elham Esmat
 * @version SoSe 2016
 */
abstract class AbstractMedium implements Medium
{

    /**
     * Ein Kommentar zum Medium
     */
    private String _kommentar;

    /**
     * Der Titel des Mediums
     */
    private String _titel;
    
    /**
     * Die Bezeichnung des Mediums
     */
    private String _medienbezeichnung;
    
    /**
     * Initialisiert ein neues Exemplar.
     * 
     * @param titel Der Titel des Mediums
     * @param kommentar Ein Kommentar zu dem Medium
     * @param mediumbezeichnung Die Bezeichnung des Mediums
     * 
     * @require titel != null
     * @require kommentar != null
     * @require medienbezeichnung != null
     * 
     * @ensure getTitel() == titel
     * @ensure getKommentar() == kommentar
     * @ensure getMedienBezeichnung() == medienbezeichnung
     */
    public AbstractMedium(String titel, String kommentar, String medienbezeichnung)
    {
        assert titel != null : "Vorbedingung verletzt: titel != null";
        assert kommentar != null : "Vorbedingung verletzt: kommentar != null";
        assert medienbezeichnung != null : "Vorbedingung verletzt: medienbezeichnung != null";
        _titel = titel;
        _kommentar = kommentar;
        _medienbezeichnung = medienbezeichnung;
    }

    @Override
    public String getMedienBezeichnung()
    {
    	return _medienbezeichnung;
    }

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
