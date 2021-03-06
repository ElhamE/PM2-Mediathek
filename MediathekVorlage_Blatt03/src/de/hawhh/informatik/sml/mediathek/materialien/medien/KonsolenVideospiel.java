package de.hawhh.informatik.sml.mediathek.materialien.medien;
public class KonsolenVideospiel extends AbstractVideospiel
{
    /**
     * Initialisiert ein neues KonsolenVideospiel.
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
    public KonsolenVideospiel(String titel, String kommentar, String system)
    {
    	super(titel, kommentar, system, "KonsolenVideospiel");
    }
    
    @Override
    public int getPreisNachTagen(int mietTage)
    {
        assert mietTage > 0 : "Vorbedingung verletzt: mietTage > 0";
        return (mietTage / 3) * 700;       
    }

}
