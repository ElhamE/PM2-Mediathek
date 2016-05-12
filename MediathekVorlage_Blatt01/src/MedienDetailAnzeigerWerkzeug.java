import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Ein MedienDetailAnzeigerWerkzeug ist ein Werkzeug um die Details von Medien
 * anzuzeigen.
 * 
 * @author SE2-Team, PM2-Team
 * @version SoSe 2016
 */
class MedienDetailAnzeigerWerkzeug
{
	private MedienDetailAnzeigerUI _ui;

	/**
	 * Initialisiert ein neues MedienDetailAnzeigerWerkzeug.
	 */
	public MedienDetailAnzeigerWerkzeug()
	{
		_ui = new MedienDetailAnzeigerUI();
	}

	/**
	 * Setzt die Liste der Medien deren Details angezeigt werden sollen.
	 * 
	 * @param medien Eine Liste von Medien.
	 * @require (medien != null)
	 */
	public void setMedien(List<Medium> medien)
	{
		assert medien != null : "Vorbedingung verletzt: (medien != null)";
		JTextArea selectedMedienTextArea = _ui.getMedienAnzeigerTextArea();
		String text = null;
		for (Medium medium : medien)
		{
			if (medium instanceof CD)
			{
				CD cd = (CD) medium;
				text = " Titel: " + cd.getTitel();
				text = text + "\n Bezeichnung: " + cd.getMedienBezeichnung();
				text = text + "\n Interpret: " + cd.getInterpret();
				text = text + "\n Laenge: " + cd.getSpiellaenge() + " Minuten";
			}
			if (medium instanceof DVD)
			{
				DVD dvd = (DVD) medium;
				text = " Titel: " + dvd.getTitel();
				text = text + "\n Bezeichnung: " + dvd.getMedienBezeichnung();
				text = text + "\n Regisseur: " + dvd.getRegisseur();
				text = text + "\n Laufzeit: " + dvd.getLaufzeit() + " Minuten";
			}
			if (medium instanceof Videospiel)
			{
				Videospiel video = (Videospiel) medium;
				text = " Titel: " + video.getTitel();
				text = text + "\n Bezeichnung: " + video.getMedienBezeichnung();
				text = text + "\n Plattform: " + video.getPlattform();
			}
			selectedMedienTextArea.setText(text);
		}
//		for (Medium medium: medien)
//		{
//			selectedMedienTextArea.setText(medium.getFormatiertenString());
//		}
	}
	
	/**
	 * Gibt das Panel dieses Subwerkzeugs zurück.
	 * 
	 * @ensure result != null
	 */
	public JPanel getUIPanel()
	{
		return _ui.getUIPanel();
	}
}
