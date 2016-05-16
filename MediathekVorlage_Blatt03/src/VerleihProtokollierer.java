import java.io.FileWriter;
import java.io.IOException;

class VerleihProtokollierer
{

	/**
	 * Diese Methode gibt alle Verleihvorgaenge (Ausleihen und Rueckgaben) aus
	 * 
	 * @param ereignis Ein Ereignis kann eine "Ausleihe" oder "Rueckgabe" sein
	 * @param verleihkarte die Verleihkarte des verliehenen bzw. zurueckgegeben
	 *        Mediums
	 * @throws IOException
	 * @require ereignis != null
	 * @require verleihkarte != null
	 */
	public void protokolliere(String ereignis, Verleihkarte verleihkarte)
	{
		try	
		{
			assert ereignis != null : "Vorbedingung verletzt: ereignis != null";
			assert verleihkarte != null : "Vorbedingung verletzt: verleihkarte != null";
			FileWriter writer = new FileWriter("protokoll.txt", true);
			switch (ereignis)
			{
				case "Ausleihe": writer.write("Ausleihe von:\n" + verleihkarte.getFormatiertenString());
								 writer.close();
								 break;
				case "Rueckgabe": writer.write("Rueckgabe von:\n" + verleihkarte.getFormatiertenString() + "am "
												+ verleihkarte.getAusleihdatum() + " zurückgegeben.");
				                 writer.close();
			}
		}
		catch (IOException io)
		{
			System.err.println(io);
		}
	}
}
