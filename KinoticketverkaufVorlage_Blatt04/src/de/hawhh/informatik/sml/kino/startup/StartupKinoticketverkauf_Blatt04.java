package de.hawhh.informatik.sml.kino.startup;

import javax.swing.SwingUtilities;
import de.hawhh.informatik.sml.kino.fachwerte.Datum;
import de.hawhh.informatik.sml.kino.fachwerte.FSK;
import de.hawhh.informatik.sml.kino.fachwerte.Geldbetrag;
import de.hawhh.informatik.sml.kino.fachwerte.Uhrzeit;
import de.hawhh.informatik.sml.kino.materialien.Film;
import de.hawhh.informatik.sml.kino.materialien.Kino;
import de.hawhh.informatik.sml.kino.materialien.Kinosaal;
import de.hawhh.informatik.sml.kino.materialien.Vorstellung;
import de.hawhh.informatik.sml.kino.werkzeuge.kasse.KassenWerkzeug;

/**
 * Startet die Anwendung.
 * 
 * @author SE2-Team, PR2-Team
 * @version SoSe 2016
 */
public class StartupKinoticketverkauf_Blatt04
{
    /**
     * Die Main-Methode.
     * 
     * @param args die Aufrufparameter.
     */
    public static void main(String[] args)
    {
        final Kino kino = erzeugeKinoMitBeispieldaten();
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new KassenWerkzeug(kino);
            }
        });
    }

    /**
     * Erzeugt ein Kino mit einigen Vorstellungen.
     */
    private static Kino erzeugeKinoMitBeispieldaten()
    {
        final Kinosaal[] saele = { new Kinosaal("Saal 1", 20, 25),
                new Kinosaal("Saal 2", 16, 20), new Kinosaal("Saal 3", 10, 16) };

        // Filme: Auszug aus den Top 10 Deutschland laut kino.de, KW 20, 2016.
        Film[] filme = {
                new Film("The Witch", 93, FSK.FSK16, false),
                new Film("Bad Neighbors 2", 92, FSK.FSK12, false),
                new Film("Angry Birds", 98, FSK.FSK0, false),
                new Film("The Jungle Book", 106, FSK.FSK6, false),
                new Film("X-Men: Apokalypse", 145, FSK.FSK12, true) };

        Uhrzeit nachmittag = Uhrzeit.get(17, 30);
        Uhrzeit abend = Uhrzeit.get(20, 0);
        Uhrzeit spaet = Uhrzeit.get(22, 30);
        Uhrzeit nacht = Uhrzeit.get(1, 0);

        Datum d1 = Datum.heute();
        Datum d2 = d1.naechsterTag();
        Datum d3 = d2.naechsterTag();

        final Vorstellung[] vorstellungen = {
                // Heute
                new Vorstellung(saele[0], filme[2], nachmittag, abend, d1, Geldbetrag.get(500)),
                new Vorstellung(saele[0], filme[0], abend, spaet, d1, Geldbetrag.get(700)),
                new Vorstellung(saele[0], filme[0], spaet, nacht, d1, Geldbetrag.get(700)),

                new Vorstellung(saele[1], filme[3], nachmittag, abend, d1, Geldbetrag.get(900)),
                new Vorstellung(saele[1], filme[1], spaet, nacht, d1, Geldbetrag.get(800)),

                new Vorstellung(saele[2], filme[3], abend, spaet, d1, Geldbetrag.get(1000)),
                new Vorstellung(saele[2], filme[4], spaet, nacht, d1, Geldbetrag.get(900)),

                // Morgen
                new Vorstellung(saele[0], filme[0], abend, spaet, d2, Geldbetrag.get(500)),
                new Vorstellung(saele[0], filme[0], spaet, nacht, d2, Geldbetrag.get(700)),

                new Vorstellung(saele[1], filme[2], nachmittag, abend, d2, Geldbetrag.get(900)),
                new Vorstellung(saele[1], filme[4], abend, nacht, d2, Geldbetrag.get(800)),

                new Vorstellung(saele[2], filme[3], nachmittag, abend, d2, Geldbetrag.get(1000)),
                new Vorstellung(saele[2], filme[1], spaet, nacht, d2, Geldbetrag.get(900)),

                // Übermorgen
                new Vorstellung(saele[0], filme[1], abend, spaet, d3, Geldbetrag.get(500)),
                new Vorstellung(saele[0], filme[1], spaet, nacht, d3, Geldbetrag.get(700)),

                new Vorstellung(saele[1], filme[2], nachmittag, abend, d3, Geldbetrag.get(900)),
                new Vorstellung(saele[1], filme[0], abend, nacht, d3, Geldbetrag.get(800)),

                new Vorstellung(saele[2], filme[3], abend, spaet, d3, Geldbetrag.get(1000)),
                new Vorstellung(saele[2], filme[4], spaet, nacht, d3, Geldbetrag.get(900)) };

        return new Kino(saele, vorstellungen);
    }
}
