package de.hawhh.informatik.sml.kino.werkzeuge.platzverkauf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JPanel;
import de.hawhh.informatik.sml.kino.fachwerte.Geldbetrag;
import de.hawhh.informatik.sml.kino.fachwerte.Platz;
import de.hawhh.informatik.sml.kino.materialien.Kinosaal;
import de.hawhh.informatik.sml.kino.materialien.Vorstellung;
import de.hawhh.informatik.sml.kino.werkzeuge.barzahlung.BarzahlungsWerkzeug;

/**
 * Mit diesem Werkzeug können Plätze verkauft und storniert werden. Es arbeitet
 * auf einer Vorstellung als Material. Mit ihm kann angezeigt werden, welche
 * Plätze schon verkauft und welche noch frei sind.
 * 
 * Dieses Werkzeug ist ein eingebettetes Subwerkzeug. Es kann nicht beobachtet
 * werden.
 * 
 * @author SE2-Team, PR2-Team
 * @version SoSe 2016
 */
public class PlatzVerkaufsWerkzeug
{
    // Die aktuelle Vorstellung, deren Plätze angezeigt werden. Kann null sein.
    private Vorstellung _vorstellung;

    private PlatzVerkaufsWerkzeugUI _ui;

    /**
     * Initialisiert das PlatzVerkaufsWerkzeug.
     */
    public PlatzVerkaufsWerkzeug()
    {
        _ui = new PlatzVerkaufsWerkzeugUI();
        registriereUIAktionen();
        // Am Anfang wird keine Vorstellung angezeigt:
        setVorstellung(null);
    }

    /**
     * Gibt das Panel dieses Subwerkzeugs zurück. Das Panel sollte von einem
     * Kontextwerkzeug eingebettet werden.
     * 
     * @ensure result != null
     */
    public JPanel getUIPanel()
    {
        return _ui.getUIPanel();
    }

    /**
     * Fügt der UI die Funktionalität hinzu mit entsprechenden Listenern.
     */
    private void registriereUIAktionen()
    {
        _ui.getVerkaufenButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Set<Platz> plaetze = _ui.getPlatzplan().getAusgewaehltePlaetze();
                Geldbetrag preis = _vorstellung.getPreisFuerPlaetze(plaetze);
                BarzahlungsWerkzeug barzahlung = new BarzahlungsWerkzeug(preis);
                if (barzahlung.sollVerkaufDurchgefuehrtWerden())
                {
                    verkaufePlaetze(_vorstellung);
                }
                else
                {
                    for (Platz platz: plaetze)
                    {
                        _ui.getPlatzplan().markierePlatzAlsFrei(platz);
                        aktualisierePlatzplan();
                    }
                }   
            }
        });

        _ui.getStornierenButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                stornierePlaetze(_vorstellung);
            }
        });

        _ui.getPlatzplan().addPlatzSelectionListener(
                new PlatzSelectionListener()
                {
                    @Override
                    public void auswahlGeaendert(PlatzSelectionEvent event)
                    {
                        reagiereAufNeuePlatzAuswahl(event
                                .getAusgewaehltePlaetze());
                    }
                });
    }

    /**
     * Reagiert darauf, dass sich die Menge der ausgewählten Plätze geändert
     * hat.
     * 
     * @param plaetze die jetzt ausgewählten Plätze.
     */
    private void reagiereAufNeuePlatzAuswahl(Set<Platz> plaetze)
    {
        _ui.getVerkaufenButton().setEnabled(istVerkaufenMoeglich(plaetze));
        _ui.getStornierenButton().setEnabled(istStornierenMoeglich(plaetze));
        aktualisierePreisanzeige(plaetze);
    }

    /**
     * Aktualisiert den anzuzeigenden Gesamtpreis
     */
    private void aktualisierePreisanzeige(Set<Platz> plaetze)
    {

        if (istVerkaufenMoeglich(plaetze))
        {
            Geldbetrag preis = _vorstellung.getPreisFuerPlaetze(plaetze);
            _ui.getPreisLabel().setText("Gesamtpreis: " + preis + "€");
        }
        else
        {
            _ui.getPreisLabel().setText("Gesamtpreis:");
        }
    }

    /**
     * Prüft, ob die angegebenen Plätze alle storniert werden können.
     */
    private boolean istStornierenMoeglich(Set<Platz> plaetze)
    {
        return !plaetze.isEmpty() && _vorstellung.sindStornierbar(plaetze);
    }

    /**
     * Prüft, ob die angegebenen Plätze alle verkauft werden können.
     */
    private boolean istVerkaufenMoeglich(Set<Platz> plaetze)
    {
        return !plaetze.isEmpty() && _vorstellung.sindVerkaufbar(plaetze);
    }

    /**
     * Setzt die Vorstellung. Sie ist das Material dieses Werkzeugs. Wenn die
     * Vorstellung gesetzt wird, muss die Anzeige aktualisiert werden. Die
     * Vorstellung darf auch null sein.
     */
    public void setVorstellung(Vorstellung vorstellung)
    {
        _vorstellung = vorstellung;
        aktualisierePlatzplan();
    }

    /**
     * Aktualisiert den Platzplan basierend auf der ausgwählten Vorstellung.
     */
    private void aktualisierePlatzplan()
    {
        if (_vorstellung != null)
        {
            Kinosaal saal = _vorstellung.getKinosaal();
            _ui.getPlatzplan().setAnzahlPlaetze(saal.getAnzahlReihen(),
                    saal.getAnzahlSitzeProReihe());

            for (Platz platz : saal.getPlaetze())
            {
                if (_vorstellung.istPlatzVerkauft(platz))
                {
                    _ui.getPlatzplan().markierePlatzAlsVerkauft(platz);
                }
            }
        }
        else
        {
            _ui.getPlatzplan().setAnzahlPlaetze(0, 0);
        }
    }

    /**
     * Verkauft die ausgewählten Plaetze.
     */
    private void verkaufePlaetze(Vorstellung vorstellung)
    {
        Set<Platz> plaetze = _ui.getPlatzplan().getAusgewaehltePlaetze();
        vorstellung.verkaufePlaetze(plaetze);
        aktualisierePlatzplan();
    }

    /**
     * Storniert die ausgewählten Plaetze.
     */
    private void stornierePlaetze(Vorstellung vorstellung)
    {
        Set<Platz> plaetze = _ui.getPlatzplan().getAusgewaehltePlaetze();
        vorstellung.stornierePlaetze(plaetze);
        aktualisierePlatzplan();
    }
}
