package de.hawhh.informatik.sml.kino.werkzeuge.barzahlung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import de.hawhh.informatik.sml.kino.fachwerte.Geldbetrag;

/**
 * Mit diesem Werkzeug kann eine Barzahlung getätigt werden.
 * 
 * @author Imon Bashir, Elham Esmat
 * @version SoSe 2016
 */
public class BarzahlungsWerkzeug
{	

    public BarzahlungsWerkzeugUI _ui;
	private Geldbetrag _preis;
	private boolean _verkaufDurchfuehren;

	/**
	 * Initialisiert ein Barzahlungswerkzeug
	 * @require preis != null
	 * @param preis der Preis für die ausgewählten Plätze
	 */
	public BarzahlungsWerkzeug(Geldbetrag preis)
	{
		assert preis != null : "Vorbedingung verletzt: preis != null";
		_ui = new BarzahlungsWerkzeugUI(preis);
		_preis = preis;
		_verkaufDurchfuehren = false;
		registriereListener();
		_ui.oeffneFenster();
		
	}

	private void registriereListener()
	{
		_ui.getEingabefeld().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	String regex = "[0-9]+,[0-9]{2}?";
            	String betrag = _ui.getEingabefeld().getText();
                if (_preis.equals(Geldbetrag.get(0)))
                {
                    JOptionPane.showMessageDialog(null, "Es wurde schon für die Plätze gezahlt!",
                            "Warnung", JOptionPane.ERROR_MESSAGE);
                }
            	if (betrag.matches(regex))
            	{
            	    Geldbetrag geld = Geldbetrag.get(betrag);
            	    if (geld.getEuroCent(geld) >= _preis.getEuroCent(_preis))
            	    {
            	        Geldbetrag rueckgeld = geld.subtrahiere(_preis);
            	        _ui.getOkButton().setEnabled(true);
                        _ui.getRueckgeldLabel().setText("Rückgeld: " + rueckgeld + "€");
                        _preis = Geldbetrag.get("0,00");
                        _ui.getzuZahlenderBetragLabel().setText("Zu zahlender Betrag: " + _preis + "€");
            	    }
            	    else
            	    {
            	        JOptionPane.showMessageDialog(null, "Bitte einen Geldbetrag angeben, der größer gleich dem Preis ist!",
                                "Zu wenig bezahlt", JOptionPane.INFORMATION_MESSAGE);
            	    }    
            	}
            	else
            	{
            	    JOptionPane.showMessageDialog(null, "Bitte einen gültigen Geldbetrag in der Form \"Euro,Cent\" angeben!",
            	            "Eingabefehler", JOptionPane.ERROR_MESSAGE);
            	}
            }
        });
		_ui.getOkButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	_verkaufDurchfuehren = true;
            	_ui.schliesseFenster();
            }
        });
		_ui.getAbbrechenButton().addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	_ui.schliesseFenster();
            }
        });
		
	}
	
	public boolean sollVerkaufDurchgefuehrtWerden()
	{
		return _verkaufDurchfuehren;
	}

}
