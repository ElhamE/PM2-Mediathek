import java.io.FileWriter;
import java.io.IOException;

/**
 * Ein VerleihProtokollierer protokolliert Verleihvorgaenge.
 * 
 * @author Imon Bashir, Elham Esmat
 * @version SoSe 2016
 */

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
	public void protokolliere(String ereignis, Verleihkarte verleihkarte) throws ProtokollierException
	{
		try	(FileWriter writer = new FileWriter("protokoll.txt", true)) 
		{
			assert ereignis != null : "Vorbedingung verletzt: ereignis != null";
			assert verleihkarte != null : "Vorbedingung verletzt: verleihkarte != null";
			switch (ereignis)
			{
				case "Ausleihe": writer.write("Ausleihe von:\n" + verleihkarte.getFormatiertenString());
								 break;
				case "Rueckgabe": writer.write("Rueckgabe von:\n" + verleihkarte.getFormatiertenString() + "am "
												+ Datum.heute() + " zurückgegeben.");
			}
		}
		catch (IOException io)
		{
			throw new ProtokollierException(io.getMessage());
		}
	}
}
