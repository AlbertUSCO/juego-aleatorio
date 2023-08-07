package co.com.sofka.juego;

import com.google.gson.*;
import jdk.nashorn.internal.parser.JSONParser;


import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static co.com.sofka.juego.Menu.mostrarMenu;


public class Historial {

    private String jugador1;
    private String jugador2;
    private String periodoDia;
    private String clima;
    private String combateLog;
    private String ganador;


    public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    public String getPeriodoDia() {
        return periodoDia;
    }

    public void setPeriodoDia(String periodoDia) {
        this.periodoDia = periodoDia;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getCombateLog() {
        return combateLog;
    }

    public void setCombateLog(String combateLog) {
        this.combateLog = combateLog;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public void guardarHistorial(Historial historial) throws IOException {


        Gson gson = new Gson();
        String link = "src\\main\\java\\co\\com\\sofka\\util\\historial.json";
        BufferedReader br = new BufferedReader(new FileReader(link));
        String historialString="";
        String bfread;
        while ( (bfread = br.readLine()) != null){
            historialString += bfread;
        }
        historialString = historialString.substring(1,historialString.length()-1);
        String historialCompleto = "[";
        historialCompleto += historialString;
        String Json = gson.toJson(historial);
        Json = historialCompleto + "," + Json +"]";
        FileWriter file = new FileWriter(link);
        file.append(Json);
        file.flush();
        file.close();


    }

    public void buscarEnHistorial() throws IOException {
        boolean bandera=false;
        List <Historial> historials;
        historials = new ArrayList<>();
        Gson gson = new Gson();
        Scanner lector = new Scanner(System.in);
        byte categoria=0;
        String itemABuscar="";
        String link = "src\\main\\java\\co\\com\\sofka\\util\\historial.json";
        Reader myReader = Files.newBufferedReader(Paths.get(link));
        JsonArray arreglo = gson.fromJson(myReader,JsonArray.class);
        for (JsonElement element:arreglo){

            Historial historialLectura = new Historial();
            historialLectura = gson.fromJson(element,Historial.class);
            historials.add(historialLectura);

        }
        do{
            System.out.println("Categoria a buscar:\n1.Jugador:\n2.Ganador");
            categoria = (byte) lector.nextInt();
            if ((categoria != 1 && categoria!= 2)) System.out.println("el dato debe ser un 1 o un 2");

        }while (categoria != 1 && categoria!= 2);

        System.out.println("Ingrese el nombre del jugador");
        lector.nextLine();
        itemABuscar = lector.nextLine();

        switch (categoria){
            case 1:
               for (Historial cadaHistorial:historials){
                    if(cadaHistorial.getJugador1().equals(itemABuscar) || cadaHistorial.getJugador2().equals(itemABuscar))
                    {   System.out.println("jugador1 fue: "+cadaHistorial.getJugador1());
                        System.out.println("jugador2 fue: "+cadaHistorial.getJugador2());
                        System.out.println("Ganador fue: "+cadaHistorial.getGanador());
                        System.out.println("");
                        System.out.println("Registro del combate:"+"\n"+cadaHistorial.getCombateLog());
                        System.out.println("");
                        bandera=true;
                    }

               }
               if(!bandera) System.out.println("No se encontro el Jugador, volviendo al inicio... ");
                System.out.println("");
                mostrarMenu();
               break;
            case 2:
                for (Historial cadaHistorial:historials){
                    if (cadaHistorial.getGanador().equals(itemABuscar)){
                        System.out.println("jugador1 fue: "+cadaHistorial.getJugador1());
                        System.out.println("jugador2 fue: "+cadaHistorial.getJugador2());
                        System.out.println("Ganador fue: "+cadaHistorial.getGanador());
                        System.out.println("");
                        System.out.println("Registro del combate:"+"\n"+cadaHistorial.getCombateLog());
                        System.out.println("");
                        bandera=true;
                    }

                }
                if(!bandera) System.out.println("No se encontro el Ganador, volviendo al inicio...");
                System.out.println("");
                mostrarMenu();
                break;
            default:
                System.out.println("La opcion indicada no se encuentra en el historial");
                break;

        }

    }

}



