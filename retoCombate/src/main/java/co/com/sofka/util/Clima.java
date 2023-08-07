package co.com.sofka.util;

import java.util.Random;

public enum Clima {
    Lluvioso,
    Nevado,
    Nublado;

    public static Clima escojerClima() {
        Clima[] values = Clima.values();
        int lenght = values.length;
        int random = new Random().nextInt(lenght);
        return values[random];
    }
}
