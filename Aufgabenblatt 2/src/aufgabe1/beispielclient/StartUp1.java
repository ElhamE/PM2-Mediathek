package aufgabe1.beispielclient;

import aufgabe1.Widerstandsnetz;
import aufgabe1.einfachesNetz.Widerstand;
import aufgabe1.komplexesNetz.ParallelesWiderstandsnetz;
import aufgabe1.komplexesNetz.SeriellesWiderstandsnetz;

public class StartUp1
{

    public static void main(String[] args)
    {
        Widerstandsnetz parallelR1R3 = new ParallelesWiderstandsnetz(
                new Widerstand(100), new Widerstand(300));
        Widerstandsnetz reiheR2 = new SeriellesWiderstandsnetz(parallelR1R3,
                new Widerstand(200));
        Widerstandsnetz reiheR4R5 = new SeriellesWiderstandsnetz(new Widerstand(400),
                new Widerstand(500));
        Widerstandsnetz parallelObenMitte = new ParallelesWiderstandsnetz(
                reiheR2, reiheR4R5);
        Widerstandsnetz alles = new ParallelesWiderstandsnetz(
                parallelObenMitte, new Widerstand(600));
        System.err.println("Gesamtwiderstand: " + alles.getOhm());
        System.out.println("Widerstandsanzahl: " + alles.getAnzahlWiderstaende());
        
    }

}
