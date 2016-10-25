package aufgabe1.beispielclient;

import aufgabe1.Widerstandsnetz;
import aufgabe1.einfachesNetz.Potenziometer;
import aufgabe1.einfachesNetz.Widerstand;
import aufgabe1.komplexesNetz.ParallelesWiderstandsnetz;
import aufgabe1.komplexesNetz.SeriellesWiderstandsnetz;

public class StartUp2
{

    public static void main(String[] args)
    {
        Widerstandsnetz parallelR1R3 = new ParallelesWiderstandsnetz(
                new Widerstand(100), new Widerstand(300));
        Widerstandsnetz reiheR2 = new SeriellesWiderstandsnetz(parallelR1R3,
                new Widerstand(200));
        Potenziometer r4 = new Potenziometer(0);
        Widerstandsnetz reiheR4R5 = new SeriellesWiderstandsnetz(r4,
                new Widerstand(500));
        Widerstandsnetz parallelObenMitte = new ParallelesWiderstandsnetz(
                reiheR2, reiheR4R5);
        Widerstandsnetz alles = new ParallelesWiderstandsnetz(
                parallelObenMitte, new Widerstand(600));
        for (int ohm = 0; ohm <= 5000; ohm = ohm + 200)
        {
            r4.setOhm(ohm);
            System.out.println("Gesamtwiderstand: " + alles.getOhm());
        }
    }


}
