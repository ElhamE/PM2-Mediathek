
class PCVideospiel extends AbstractVideospiel
{
	/**
	 * Initialisiert ein neues PCVideospiel.
	 * 
	 * @param titel Der Titel des Spiels
	 * @param kommentar Ein Kommentar zum Spiel
	 * @param system Die Bezeichnung des System
	 * @require titel != null
	 * @require kommentar != null
	 * @require system != null
	 * @ensure getTitel() == titel
	 * @ensure getKommentar() == kommentar
	 * @ensure getSystem() == system
	 */
	public PCVideospiel(String titel, String kommentar, String system)
	{
		super(titel, kommentar, system, "PCVideospiel");
	}

	@Override
	public int getPreisNachTagen(int mietTage)
	{
		assert mietTage > 0 : "Vorbedingung verletzt: mietTage > 0";
		if ((mietTage - 7) <= 0)
		{
			return 0;
		}
		else if (((mietTage - 7) > 0) && ((mietTage - 7) < 5))
		{
			return 500;
		}
		else
		{
			return ((mietTage - 7) / 5) * 500
					+ betragAngefangeneFuenfTage(mietTage - 7);
		}
	}

	/**
	 * Hilfsmethode von <code>getPreisNachTagen(int)</code>
	 * 
	 * @param gekuerzteMietTage die Ausleihdauer gekuerzt um sieben Tage
	 * @return 500 wenn ein neuer Fuenftagesabschnitt begonnen wurde, sonst 0
	 */
	private int betragAngefangeneFuenfTage(int gekuerzteMietTage)
	{
		if ((gekuerzteMietTage % 5) > 0)
		{
			return 500;
		}
		return 0;

	}

}
