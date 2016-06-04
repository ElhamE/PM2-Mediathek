package de.hawhh.informatik.sml.mediathek.materialien.medien;

import de.hawhh.informatik.sml.mediathek.fachwerte.Geldbetrag;

public abstract class AbstractVideospiel extends AbstractMedium
{

	/**
	 * Der fixe Basispreis jeder Mietgebuehr
	 */
	private static final int BASISPREIS = 200;

	/**
	 * Das System, auf dem das Spiel lauffähig ist
	 */
	private String _system;

	/**
	 * Initialisiert ein neues Videospiel.
	 * 
     * @param titel Der Titel des Mediums
     * @param kommentar Ein Kommentar zu dem Medium
     * @param mediumbezeichnung Die Bezeichnung des Mediums
	 * @param system Die Bezeichnung des System
	 * 
     * @require titel != null
     * @require kommentar != null
     * @require medienbezeichnung != null
	 * @require system != null
	 * 
     * @ensure getTitel() == titel
     * @ensure getKommentar() == kommentar
     * @ensure getMedienBezeichnung() == medienbezeichnung
	 * @ensure getSystem() == system
	 */
	public AbstractVideospiel(String titel, String kommentar, String system , String medienbezeichnung)		
	{
		super(titel, kommentar, medienbezeichnung);
		assert system != null : "Vorbedingung verletzt: system != null";
		_system = system;
	}
	
	/**
	 * Gibt das System zurück, auf dem das Spiel lauffähig ist.
	 * 
	 * @return Das System, auf dem das Spiel ausgeführt werden kann.
	 * @ensure result != null
	 */
	public String getSystem()
	{
		return _system;
	}

	@Override
	public Geldbetrag berechneMietgebuehr(int mietTage)
	{
		assert mietTage > 0 : "Vorbedingung verletzt: mietTage > 0";
		return Geldbetrag.get(BASISPREIS + getPreisNachTagen(mietTage));
	}

	/**
	 * Gibt den variablen Preisanteil bezueglich der Mietgebuehr eines Videospiels
	 * zurück.
	 * 
	 * @param mietTage Ausleihdauer des Videospiels
	 * @return Den variablen Preisanteil
	 * @require mietTage > 0
	 * @ensure result >= 0
	 */
	public abstract int getPreisNachTagen(int mietTage);

	@Override
	public String toString()
	{
		return getFormatiertenString();
	}

	@Override
	public String getFormatiertenString()
	{
		return super.getFormatiertenString() + "\n" + "    " + "System: "
				+ _system + "\n";
	}
}
