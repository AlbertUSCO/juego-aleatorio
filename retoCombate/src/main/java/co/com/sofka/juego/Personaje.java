package co.com.sofka.juego;

import java.util.List;
import java.util.Random;

public class Personaje {

    private String nombre;
    private Byte puntosDeVida;
    private Byte ataque;
    private Byte defensa;
    private boolean cuerpoACuerpo;
    private String casa;

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getNombre() {
        return nombre;
    }

    public Byte getPuntosDeVida() {
        return puntosDeVida;
    }

    public Byte getAtaque() {
        return ataque;
    }

    public Byte getDefensa() {
        return defensa;
    }

    public boolean isCuerpoACuerpo() {
        return cuerpoACuerpo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntosDeVida(Byte puntosDeVida) {
        this.puntosDeVida = puntosDeVida;
    }

    public void setAtaque(Byte ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(Byte defensa) {
        this.defensa = defensa;
    }

    public void setCuerpoACuerpo(boolean cuerpoACuerpo) {
        this.cuerpoACuerpo = cuerpoACuerpo;
    }

    public String[] golpeCuerpoAcuerpo() {
        String[] acciones = new String[2];
        int danio;
        acciones[0] = "Realiza un ataque cuerpo a cuerpo   ᕦ(ˇò_ó)ᕤ   ";
        if(this.cuerpoACuerpo)  danio = this.ataque * 2;
        else danio = this.ataque*1;
        acciones[1] = String.valueOf(danio);
        return acciones;
    }
    public String[] golpeAdistancia() {
        String[] acciones = new String[2];
        int danio;
        acciones[0] = "Realiza un ataque a distancia   (>ò_ó)> ==>   ";
        if(!this.cuerpoACuerpo)  danio = this.ataque * 2;
        else danio = this.ataque*1;
        acciones[1] = String.valueOf(danio);
        return acciones;
    }

    public String[] elejirAccion() {
        Random numeroRandom = new Random();
        String[] salida = new String[2];
        int numeroDeAccion = numeroRandom.nextInt(3);
        if(numeroDeAccion == 0) salida = golpeAdistancia();
        if(numeroDeAccion == 1) salida = golpeCuerpoAcuerpo();
        if(numeroDeAccion == 2) salida =  habilidadEspecial();
        return salida;
    }
    public String[] habilidadEspecial() {
        Random numeroRandom = new Random();
        String[] salida = new String[2];
        int numeroDeAccion =  numeroRandom.nextInt(3);
        if(numeroDeAccion == 0) salida = aturdir();
        if(numeroDeAccion == 1) salida = ataqueEspecial();
        if(numeroDeAccion == 2)salida =  defensa();
        return salida;

    }
    public String[] aturdir(){

        String[] acciones = new String[2];
        acciones[0] = "Aturde al enemigo   ¯\\(⊙_◎)/¯   ";
        acciones[1] = "-1";
        return acciones;

    }
    public String[] ataqueEspecial(){
        String[] acciones = new String[2];
        int danio;
        acciones[0] = "Realiza un ataque especial   (>̃o益o)> ︵((!))   ";
        danio = this.ataque * 3;
        acciones[1] = String.valueOf(danio);
        return acciones;

    }
    public String[] defensa(){
        String[] acciones = new String[2];
        acciones[0] = "Aumeta su defensa   (ง ò_ó)ง]]   ";
        acciones[1] = "0";
        return acciones;
    }
    public void modificarVida(byte danio) {
        setPuntosDeVida((byte)(getPuntosDeVida()+getDefensa()-danio));
    }
    public void imprimirPersonajes(Personaje personaje) {
        System.out.println("para escoger a: " + personaje.getNombre() + " de la " + personaje.getCasa() );
        System.out.println("con las siguietes estadisticas:");
        System.out.println("Puntos de vida : " + personaje.getPuntosDeVida());
        System.out.println("Ataque: " + personaje.getAtaque());
        System.out.println("Defensa: " + personaje.getDefensa());
        System.out.println("***************************************");

    }

}
