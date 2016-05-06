/**
 * Ein {@link Videospiel} ist ein Medium. Zusätzlich zu den Eigenschaften eines
 * {@link Medium}s erfasst sie Informationen zum Regisseur und zur Laufzeit.
 * 
 * @author Imon Bashir, Elham Esmat
 * @version SoSe 2016
 */
class Videospiel implements Medium
{
	/**
	 * Das System, auf dem das Medium läuft
	 */
	private String _plattform;

	/**
	 * Ein Kommentar zum Medium
	 */
	private String _kommentar;

	/**
	 * Der Titel des Mediums
	 */
	private String _titel;

	/**
	 * Initialisiert ein neues Videospiel mit den gegebenen Daten.
	 * 
	 * @param titel Der Titel des Videospiels.
	 * @param kommentar Ein Kommentar zu dem Videospiel.
	 * @param plattform Das System, auf dem das Videospiel lauffaehig ist.
	 * @require titel != null
	 * @require kommentar != null
	 * @require plattform != null
	 * @ensure getTitel() == titel
	 * @ensure getKommentar() == kommentar
	 * @ensure getPlattform() == plattform
	 */
	public Videospiel(String titel, String kommentar, String plattform)
	{
		assert titel != null : "Vorbedingung verletzt: titel != null";
		assert kommentar != null : "Vorbedingung verletzt: kommentar != null";
		assert plattform != null : "Vorbedingung verletzt: plattform != null";
		_titel = titel;
		_kommentar = kommentar;
		_plattform = plattform;
	}

    /**
     * Gibt die Plattform zurück, auf dem das Videospiel lauffaehig ist
     * 
     * @return Die Plattform des Videospiels
     * 
     * @ensure result != null
     */
	public String getPlattform()
	{
		return _plattform;
	}

    @Override
	public String getMedienBezeichnung()
	{
		return "Videospiel";
	}

    @Override
	public String getKommentar()
	{
		return _kommentar;
	}

    @Override
	public String getTitel()
	{
		return _titel;
	}
	
    @Override
    public String getFormatiertenString()
    {
        return " Titel: " + _titel + "\n Bezeichnung: Videospiel \n Plattform: " + _plattform;
    }

}
