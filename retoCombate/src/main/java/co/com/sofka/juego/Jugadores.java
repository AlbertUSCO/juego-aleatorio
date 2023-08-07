package co.com.sofka.juego;


import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static co.com.sofka.juego.Batalla.maquina;

public class Jugadores {

    private String nickname;
    private Personaje personaje;

    public Personaje getPersonaje() {
        return personaje;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }



    public byte esMaquina(byte tamanio){
        boolean numeroValido =false;
        byte numeroHumano;
        if(maquina){
            Random numeroRandom = new Random();
            int numeroMaquina =  numeroRandom.nextInt((tamanio - 1) + 1) + 1;
            byte  numeroMaquinaByte = (byte) numeroMaquina;
            return numeroMaquinaByte;
        }
        do {
            Scanner lector = new Scanner(System.in);
             numeroHumano = (byte) lector.nextInt();
            if (numeroHumano >= (byte)1 && numeroHumano <=tamanio){
                numeroValido=true;
                break;
            }
            System.out.println("Numero invalido ingrese un numero entre: " + 1 + " y " + tamanio);

        }while (!numeroValido);

        return numeroHumano;
    }

    public void mostrarPersonaje() throws IOException {
        String link = "src\\main\\java\\co\\com\\sofka\\util\\personajes.json";
        Reader myReader = Files.newBufferedReader(Paths.get(link));
        Gson gson = new Gson();
        Gson gson2 = new Gson();
        Map<?,?> userMap = gson.fromJson(myReader,Map.class);
        byte menuPrincipal;
        byte menuClase;
        byte menuPersonaje;

        System.out.println("Escoja la Raza de su personaje:\n" +
                             " Digite\n"+ " 1.Humano \n 2.Elfo \n 3.Orco");
        menuPrincipal = esMaquina((byte)3);
        switch (menuPrincipal){
            case 1:{
                System.out.println("Escoja la clase de su personaje:\n" +
                                    " Digite\n"+ " 1.Mago \n 2.Guerrero");
                        menuClase = esMaquina((byte) 2);
                        switch (menuClase){
                            case 1: {

                                Personaje mago1 = gson2.fromJson(gson.toJson(userMap.get("mago1")), Personaje.class);
                                System.out.println("presione 1");
                                mago1.imprimirPersonajes(mago1);

                                Personaje mago2 = gson2.fromJson(gson.toJson(userMap.get("mago2")), Personaje.class);
                                System.out.println("presione 2");
                                mago2.imprimirPersonajes(mago2);

                                menuPersonaje = esMaquina((byte) 2);
                                switch (menuPersonaje) {
                                    case 1: {
                                        this.personaje = mago1;
                                        break;
                                    }
                                    case 2: {
                                        this.personaje = mago2;
                                        break;
                                    }
                                }
                                break;
                            }
                            case 2: {
                                Personaje guerrero1 = gson2.fromJson(gson.toJson(userMap.get("guerrero1")), Personaje.class);
                                System.out.println("presione 1");
                                guerrero1.imprimirPersonajes(guerrero1);

                                Personaje guerrero2 = gson2.fromJson(gson.toJson(userMap.get("guerrero2")),Personaje.class);
                                System.out.println("presione 2");
                                guerrero2.imprimirPersonajes(guerrero2);

                                menuPersonaje = esMaquina((byte) 2);
                                switch (menuPersonaje) {
                                    case 1: {
                                        this.personaje = guerrero1;
                                        break;
                                    }
                                    case 2: {
                                        this.personaje = guerrero2;
                                        break;
                                    }
                                }
                                break;
                            }

                        }

                break;

                }

            case 2:{
               System.out.println("Escoja la clase de su personaje:\n" +
                                    " Digite\n"+ " 1.Arquero \n 2.Picaro");
                                 menuClase = esMaquina((byte) 2);
                 switch (menuClase) {
                   case 1: {

                        Personaje arquero1 = gson2.fromJson(gson.toJson(userMap.get("arquero1")), Personaje.class);
                        System.out.println("presione 1");
                        arquero1.imprimirPersonajes(arquero1);

                        Personaje arquero2 = gson2.fromJson(gson.toJson(userMap.get("arquero2")), Personaje.class);
                        System.out.println("presione 2");
                        arquero2.imprimirPersonajes(arquero2);

                        menuPersonaje = esMaquina((byte) 2);
                        switch (menuPersonaje) {
                        case 1: {
                            this.personaje = arquero1;
                            break;
                        }
                        case 2: {
                            this.personaje = arquero2;
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    Personaje picaro1 = gson2.fromJson(gson.toJson(userMap.get("picaro1")), Personaje.class);
                    System.out.println("presione 1");
                    picaro1.imprimirPersonajes(picaro1);

                    Personaje picaro2 = gson2.fromJson(gson.toJson(userMap.get("picaro2")), Personaje.class);
                    System.out.println("presione 2");
                    picaro2.imprimirPersonajes(picaro2);

                    menuPersonaje = esMaquina((byte) 2);
                    switch (menuPersonaje) {
                        case 1: {
                            this.personaje = picaro1;
                            break;
                        }
                        case 2: {
                            this.personaje = picaro2;
                            break;
                        }
                    }
                    break;
                }
            }
            break;
            }
            case 3:{
                    System.out.println("Escoja la clase de su personaje:\n" +
                        " Digite\n"+ " 1.Cazador \n 2.Brujo");
                    menuClase = esMaquina((byte) 2);
                    switch (menuClase) {

                        case 1: {

                        Personaje cazador1 = gson2.fromJson(gson.toJson(userMap.get("cazador1")), Personaje.class);
                        System.out.println("presione 1");
                        cazador1.imprimirPersonajes(cazador1);

                        Personaje cazador2 = gson2.fromJson(gson.toJson(userMap.get("cazador2")), Personaje.class);
                        System.out.println("presione 2");
                        cazador2.imprimirPersonajes(cazador2);

                        menuPersonaje = esMaquina((byte) 2);
                        switch (menuPersonaje) {
                            case 1: {
                                this.personaje = cazador1;
                                break;
                            }
                            case 2: {
                                this.personaje = cazador2;
                                break;
                            }
                        }
                        break;
                    }
                    case 2: {
                        Personaje brujo1 = gson2.fromJson(gson.toJson(userMap.get("brujo1")), Personaje.class);
                        System.out.println("presione 1");
                        brujo1.imprimirPersonajes(brujo1);

                        Personaje brujo2 = gson2.fromJson(gson.toJson(userMap.get("brujo2")), Personaje.class);
                        System.out.println("presione 2");
                        brujo2.imprimirPersonajes(brujo2);

                        menuPersonaje = esMaquina((byte) 2);
                        switch (menuPersonaje) {
                            case 1: {
                                this.personaje = brujo1;
                                break;
                            }
                            case 2: {
                                this.personaje = brujo2;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
            default:{
                System.out.println("dato incorrecto");
            }

        }

    }

}
