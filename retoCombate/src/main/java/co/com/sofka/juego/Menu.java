package co.com.sofka.juego;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner= new Scanner(System.in);

    private Menu(){

    }
    public static void mostrarMenu() throws IOException {

        System.out.println("*******************************");
        System.out.println(" ¡¡¡ SUPER SOFKA CHALLENGE !!! ");
        System.out.println("*******************************");
        System.out.println("");

        byte menuInicial;
        System.out.println("Por favor elija una opción");
        System.out.println("1. Iniciar Batalla");
        System.out.println("2. Ver Historial");
        System.out.println("3. Salir del juego");

        menuInicial = scanner.nextByte();

        switch (menuInicial) {
            case 1: {
                Batalla batalla = new Batalla();

                System.out.println("Por favor ingrese el número de jugadores:");
                byte numJugador = scanner.nextByte();
                batalla.setNumeroJugadores(numJugador);

                if (numJugador < 3 && numJugador > 0) {
                    batalla.configurar();
                    batalla.jugar();
                    System.out.println("*******************************");
                    System.out.println("");
                    mostrarMenu();
                } else {
                    System.out.println("El máximo de jugadores es 2");
                    System.out.println("");
                    System.out.println("Por favor ingrese el número de jugadores:");
                    numJugador = scanner.nextByte();
                    batalla.setNumeroJugadores(numJugador);
                    batalla.configurar();
                    batalla.jugar();
                    System.out.println("*******************************");
                    System.out.println("");
                    mostrarMenu();
                }

                break;
            }
            case 2: {
                System.out.println("1. opciones de Historial");
                System.out.println("2. Regresar");
                byte menuHistorial = scanner.nextByte();
                switch (menuHistorial){
                    case 1: Historial historial=new Historial();
                        historial.buscarEnHistorial();
                        break;
                    case 2:
                        mostrarMenu();
                        break;
                }

                break;
            }
            case 3:
                break;

            default: {
                System.out.println("Dato incorrecto");
            }

        }
    }

}
