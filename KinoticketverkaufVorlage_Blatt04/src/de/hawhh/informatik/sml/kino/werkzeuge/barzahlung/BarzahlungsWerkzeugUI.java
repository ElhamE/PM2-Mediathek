package de.hawhh.informatik.sml.kino.werkzeuge.barzahlung;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import de.hawhh.informatik.sml.kino.fachwerte.Geldbetrag;

/**
 * Die GUI des {@link BarzahlungsWerkzeug}.
 * 
 * @author Imon Bashir, Elham Esmat
 * @version SoSe 2016
 */
public class BarzahlungsWerkzeugUI
{
    private JDialog _frame;
    private JLabel _zuZahlenderBetragLabel;
    private JTextField _eingabefeld;
    private JLabel _rueckgeldLabel;
    private JButton _ok;
    private JButton _abbrechen;
    
    public BarzahlungsWerkzeugUI(Geldbetrag preis)
    {
        _frame = new JDialog();
        _frame.setTitle("Bitte Geld einzahlen!");
        
        Container contentPane = new JPanel();
        _frame.setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        
        _zuZahlenderBetragLabel = new JLabel("Zu zahlender Betrag: " + preis.getFormatiertenString() + "€");
        contentPane.add(_zuZahlenderBetragLabel);
        
        _eingabefeld = new JTextField();
        contentPane.add(_eingabefeld);
        
        _rueckgeldLabel = new JLabel("Rückgeld: 0€");
        contentPane.add(getRueckgeldLabel());
        
        Container panel = new JPanel();
        contentPane.add(panel);
        panel.setLayout(new FlowLayout());
        
        _ok = new JButton("OK");
        panel.add(_ok);
        _ok.setEnabled(false);
        
        _abbrechen = new JButton("Abbrechen");
        panel.add(_abbrechen);
        
        _frame.pack();
        _frame.setResizable(false);
        _frame.setLocationRelativeTo(null);
        _frame.setModal(true);
        
    }

	public JTextField getEingabefeld()
	{
		return _eingabefeld;
	}
	
	public JLabel getRueckgeldLabel()
	{
		return _rueckgeldLabel;
	}
	
	public JLabel getzuZahlenderBetragLabel()
	{
		return _zuZahlenderBetragLabel;
	}
	
	public JButton getOkButton()
	{
		return _ok;
	}
	
	public JButton getAbbrechenButton()
	{
		return _abbrechen;
	}

    /**
     * Schließt das Fenster.
     */
    public void schliesseFenster()
    {
        _frame.dispose();
    }

    /**
     * Öffnet das Fenster.
     */
    public void oeffneFenster()
    {
    	_frame.setVisible(true);
    }
    
}
