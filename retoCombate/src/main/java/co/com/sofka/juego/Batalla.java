package co.com.sofka.juego;

import co.com.sofka.util.Clima;
import co.com.sofka.util.Periodo;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Batalla {

    public static boolean maquina = true;

    private Jugadores jugadores[] = new Jugadores[2];

    private static Scanner scanner = new Scanner(System.in);
    private Byte numeroJugadores;
    private final String NICKNAME_PC = "COMPUTER";
    private Historial historial = new Historial();
    private Jugadores personaje;
    private String clima;
    private String periodoDelDia;

    public Byte getNumeroJugadores( ) {

        return numeroJugadores;
    }

    public void setNumeroJugadores(Byte numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }

    public void configurar() throws IOException {

        if (numeroJugadores==2){
            maquina=false;
            listarJugador();

        }else {
            maquina=false;
            listarJugador();
            maquina=true;
            Jugadores computadora = new Jugadores();
            computadora.setNickname(NICKNAME_PC);
            computadora.mostrarPersonaje();
            jugadores[1] = computadora;

        }

    }

    private void listarJugador() throws IOException{

        for (int i = 0; i < numeroJugadores; i++) {
            Jugadores jugador = new Jugadores();

            System.out.println("Por favor ingrese datos del jugador " + (i + 1));
            System.out.println("");
            System.out.print("Nickname: ");
            jugador.setNickname(scanner.nextLine());
            jugador.mostrarPersonaje();
            jugadores[i] = jugador;

        }
    }

    public void jugar() throws IOException {
        boolean turno_jugador_1 = true;

        Random ramdonBoolean = new Random();
        int i = ramdonBoolean.nextInt(2);
        int j = i==0 ? 1:0;
        String periodoDia = String.valueOf( Periodo.escojerPeriodo());
        String clima= String.valueOf(Clima.escojerClima());
        String log= "";
        historial.setJugador1(jugadores[i].getNickname());
        historial.setJugador2(jugadores[j].getNickname());
        historial.setPeriodoDia(periodoDia);
        historial.setClima(clima);
        System.out.println("*************************************************************************************************************");
        System.out.println("El periodo del día para esta batalla es: " + periodoDia);
        System.out.println("El clima para esta batalla es: " + clima);
        System.out.println("primer turno:" +jugadores[i].getNickname() +" con el personaje "+ jugadores[i].getPersonaje().getNombre());
        System.out.println("segundo turno:" +jugadores[j].getNickname() +" con el personaje "+ jugadores[j].getPersonaje().getNombre());
        while ( jugadores[i].getPersonaje().getPuntosDeVida() >=0 && jugadores[j].getPersonaje().getPuntosDeVida()>=0){
            String accion[];
            if(turno_jugador_1){

                accion=jugadores[i].getPersonaje().elejirAccion();
                if ( Integer.parseInt(accion[1])==-1){
                    System.out.println(jugadores[i].getPersonaje().getNombre()+" "+accion[0]+ ", "+jugadores[j].getPersonaje().getNombre()+" pierde un turno");
                    String linea = String.valueOf(jugadores[i].getPersonaje().getNombre()+" "+accion[0]+ ", "+jugadores[j].getPersonaje().getNombre()+" pierde un turno");
                    log += "\n"+linea;
                    continue;
                }
                if ( Integer.parseInt(accion[1])==0){
                    System.out.println(jugadores[i].getPersonaje().getNombre()+" "+accion[0]);
                    String linea = String.valueOf(jugadores[i].getPersonaje().getNombre()+" "+accion[0]);
                    jugadores[i].getPersonaje().setDefensa((byte)(jugadores[i].getPersonaje().getDefensa()+1));
                    log += "\n"+linea;
                    continue;
                }
                jugadores[j].getPersonaje().modificarVida(Byte.parseByte(accion[1]));
                System.out.println(jugadores[i].getPersonaje().getNombre()+ " "+accion[0] +"causando un daño de "+accion[1]+", vida restante de " +jugadores[j].getPersonaje().getNombre() +  " " + jugadores[j].getPersonaje().getPuntosDeVida());
                String linea = String.valueOf(jugadores[i].getPersonaje().getNombre()+ " "+accion[0] +"causando un daño de "+accion[1]+", vida restante de " +jugadores[j].getPersonaje().getNombre() +  " " + jugadores[j].getPersonaje().getPuntosDeVida());
                log += "\n"+linea;
                turno_jugador_1=false;
            }
            else {
                accion=jugadores[j].getPersonaje().elejirAccion();
                if ( Integer.parseInt(accion[1])==-1){
                    System.out.println(jugadores[j].getPersonaje().getNombre()+" "+accion[0]+ ", "+jugadores[i].getPersonaje().getNombre()+" pierde un turno");
                    String linea = String.valueOf(jugadores[j].getPersonaje().getNombre()+" "+accion[0]+ ", "+jugadores[i].getPersonaje().getNombre()+" pierde un turno");
                    log += "\n"+linea;
                    continue;
                }
                if ( Integer.parseInt(accion[1])==0){
                    System.out.println(jugadores[j].getPersonaje().getNombre()+" "+accion[0]);
                    String linea = String.valueOf(jugadores[j].getPersonaje().getNombre()+" "+accion[0]);
                    jugadores[i].getPersonaje().setDefensa((byte)(jugadores[j].getPersonaje().getDefensa()+1));
                    log += "\n"+linea;
                    continue;
                }
                jugadores[i].getPersonaje().modificarVida(Byte.parseByte(accion[1]));
                System.out.println(jugadores[j].getPersonaje().getNombre()  + " "+accion[0] +"causando un daño de "+accion[1]+ ", vida restante de "+ jugadores[i].getPersonaje().getNombre()+  " " + jugadores[i].getPersonaje().getPuntosDeVida());
                String linea = String.valueOf(jugadores[j].getPersonaje().getNombre()+ " "+accion[0] +"causando un daño de "+accion[1]+", vida restante de " +jugadores[i].getPersonaje().getNombre() +  " " + jugadores[i].getPersonaje().getPuntosDeVida());
                log += "\n"+linea;
                turno_jugador_1=true;

            }
        }
        historial.setCombateLog(log);
        String ganador=((jugadores[i].getPersonaje().getPuntosDeVida())<=0)?jugadores[j].getNickname():jugadores[i].getNickname();
        historial.setGanador(ganador);
        System.out.println("El Ganador es: " + ganador);

        historial.guardarHistorial(historial);

    }
}
