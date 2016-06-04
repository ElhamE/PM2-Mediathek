package de.hawhh.informatik.sml.mediathek.startup;


import java.io.File;

import javax.swing.SwingUtilities;
import de.hawhh.informatik.sml.mediathek.services.DateiLeseException;
import de.hawhh.informatik.sml.mediathek.services.DatenEinleser;
import de.hawhh.informatik.sml.mediathek.services.KundenstammService;
import de.hawhh.informatik.sml.mediathek.services.KundenstammServiceImpl;
import de.hawhh.informatik.sml.mediathek.services.MedienbestandService;
import de.hawhh.informatik.sml.mediathek.services.MedienbestandServiceImpl;
import de.hawhh.informatik.sml.mediathek.services.VerleihService;
import de.hawhh.informatik.sml.mediathek.services.VerleihServiceImpl;
import de.hawhh.informatik.sml.mediathek.werkzeuge.MediathekWerkzeug;

/**
 * Startet die Hauptanwendung mit grafischer Oberfläche.
 * 
 * @author SE2-Team, PR2-Team
 * @version SoSe 2016
 */
class StartUpMediathek_Blatt03
{

    private static final File KUNDEN_DATEI = new File(
            "./bestand/kundenstamm.txt");
    private static final File MEDIEN_DATEI = new File(
            "./bestand/medienbestand.txt");

    private static KundenstammService _kundenstamm;
    private static MedienbestandService _medienbestand;
    private static VerleihService _verleihService;

    /**
     * Main-Methode, mit der die Anwendung gestartet wird.
     */
    public static void main(String[] args)
    {
        erstelleServices();

        final MediathekWerkzeug mediathekWerkzeug = new MediathekWerkzeug(
                _medienbestand, _kundenstamm, _verleihService);

        // Dies ist die korrekte Art eine Swing-Anwendnung zu starten.
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                mediathekWerkzeug.zeigeFenster();
            }
        });

    }

    /**
     * Erstellt die Services und lädt die Daten.
     */
    private static void erstelleServices()
    {
        try
        {
            DatenEinleser datenEinleser = new DatenEinleser(MEDIEN_DATEI,
                    KUNDEN_DATEI);
            datenEinleser.leseDaten();
            _medienbestand = new MedienbestandServiceImpl(
                    datenEinleser.getMedien());
            _kundenstamm = new KundenstammServiceImpl(datenEinleser.getKunden());
            _verleihService = new VerleihServiceImpl(_kundenstamm,
                    _medienbestand, datenEinleser.getVerleihkarten());
        }
        catch (DateiLeseException e)
        {
            e.printStackTrace();
        }
    }

}
