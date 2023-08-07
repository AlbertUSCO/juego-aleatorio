package co.com.sofka.util;

import java.util.Random;

public enum Periodo {
    Dia,
    Noche;

    public static Periodo escojerPeriodo() {
        Periodo[] values = Periodo.values();
        int lenght = values.length;
        int random = new Random().nextInt(lenght);
        return values[random];
    }
}
