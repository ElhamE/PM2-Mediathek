
abstract class AbstractVideospiel extends AbstractMedium
{
    /**
     * Der fixe Basispreis jeder Mietgebuehr 
     */
    private static final int BASISPREIS = 200;
    
    /**
     * Das System, auf dem das Spiel lauffähig ist
     */
    protected String _system;

    @Override
    public String getMedienBezeichnung()
    {
        return "Videospiel";
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
    
    public abstract int getPreisNachTagen(int mietTage);

    @Override
    public String toString()
    {
        return getFormatiertenString();
    }

    @Override
    public String getFormatiertenString()
    {
        return super.getFormatiertenString() + "\n" + "    " + "System: " + _system + "\n";
    }
}
