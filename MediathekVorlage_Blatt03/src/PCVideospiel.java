
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
        assert titel != null : "Vorbedingung verletzt: titel != null";
        assert kommentar != null : "Vorbedingung verletzt: kommentar != null";
        assert system != null : "Vorbedingung verletzt: system != null";
        _titel = titel;
        _kommentar = kommentar;
        _system = system;
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
            return ((mietTage - 7) / 5) * 500 + betragAngefangeneFuenfTage(mietTage - 7);  
        }       
    }
    
    private int betragAngefangeneFuenfTage(int zahl)
    {
        if ((zahl % 5) > 0)
        {
            return 500;
        }
        return 0;
            
    }
}
