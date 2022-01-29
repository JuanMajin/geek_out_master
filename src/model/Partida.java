package model;

import java.util.ArrayList;

/**
 * Partida apply geek out master rules.
 * 1. El Meeple permite relanzar otro dado en juego, es decir, de la sección dados activos.
 * 2. La Nave Espacial envía un dado no usado (de la sección dados activos) a la sección de dados
 * inactivos.
 * 3. El Superhéroe permite que cualquier dado no usado (sección dados activos) sea volteado y
 * colocado en su cara opuesta.
 * 4. El Corazón permite tomar un dado de la sección de dados inactivos y lanzarlo para que sea un
   nuevo dado activo.
 * 5. El Dragón es la cara que se quiere evitar, ya que si al final de la ronda es el último dado activo que
 * queda se habrán perdido todos los puntos ganados y acumulados.
 * 6. 42 es cara que permite sumar puntos al final de la ronda.
 * muestra la ronda en la que se encuentra el jugador
 * @autor Juan-J Majin-M juan.majin@correounivalle.edu.co
 * @author Diana Cadena diana.marcela.cadena@correounivalle.edu.co
 * @version v.1.0.0 date:11/01/2022
 */

public class Partida {
    private SectorDados activos;
    private SectorDados inactivos;
    private SectorDados utilizados;
    private SectorPuntaje puntaje;
    private int puntajeGlobal;
    private int ronda;

    /**
     * Class constructor
     */

    public Partida (ArrayList<String> idsActivos, ArrayList<String> idsInactivos, ArrayList<String> idsUtilizados) {
        activos = new SectorDados("Dados activos: ", 7, idsActivos);
        inactivos = new SectorDados("Dados inactivos: ", 3, idsInactivos);
        utilizados = new SectorDados("Dados utilizados: ", 0, idsUtilizados);
        puntaje = new SectorPuntaje("Puntaje: ", 0);
        puntajeGlobal = 0;
        ronda = 1;
    }

    /**
     * Poder dragon
     * @param dragon
     */
    public void Dragon(Dado dragon) {
        puntaje.perderTodo();
    }

    /**
     * Establece el final de la ronda
     */
    public void finalizarRonda( ArrayList<String> idsActivos, ArrayList<String> idsInactivos,  ArrayList<String> idsUtilizados) {
        puntajeGlobal = puntajeGlobal + puntaje.getPuntajeRonda();
        activos = new SectorDados("Dados activos: ", 7,idsActivos);
        inactivos = new SectorDados("Dados inactivos: ", 3,idsInactivos);
        utilizados = new SectorDados("Dados utilizados: ", 0,idsUtilizados);
        puntaje = new SectorPuntaje("Puntaje: ", 0);
        ronda = ronda + 1;
    }

    public SectorDados getActivos() {

        return activos;
    }

    public SectorDados getInactivos() {

        return inactivos;
    }

    public SectorPuntaje getPuntaje() {

        return puntaje;
    }

    public int getPuntajeGlobal() {

        return puntajeGlobal;
    }

    public int getRonda() {

        return ronda;
    }

    public SectorDados getUtilizados() {

        return utilizados;
    }

    /**
     * Dado 42 sumar punto
     * @param dado42
     */

    public void poder42(Dado dado42) {
        puntaje.agregarDado42(dado42);
        activos.getDados().remove(dado42);
    }

    /**
     * Poder cohete
     * @param cohete
     * @param poder
     */
    public void poderCohete(Dado cohete, Dado poder) {
        activos.moverDado(cohete, activos, utilizados);
        activos.moverDado(poder, activos, inactivos);
    }

    /**
     * Poder corazon
     * @param corazon
     * @param poder
     */
    public void poderCorazon(Dado corazon, Dado poder) {
        activos.moverDado(corazon, activos, utilizados);
        inactivos.moverDado(poder, inactivos, activos);
        poder.relanzarDado();
    }

    /**
     * Poder heroe
     * @param heroe
     * @param poder
     */
    public void poderHeroe(Dado heroe, Dado poder) {
        activos.moverDado(heroe, activos, utilizados);
        poder.invertirCara();
    }

    /**
     * Poder meeple
     * @param mepple
     * @param poder
     */
    public void poderMepple(Dado mepple, Dado poder) {
        activos.moverDado(mepple, activos, utilizados);
        poder.relanzarDado();
    }

    public void setActivos(SectorDados activos) {

        this.activos = activos;
    }

    public void setInactivos(SectorDados inactivos) {

        this.inactivos = inactivos;
    }

    public void setPuntaje(SectorPuntaje puntaje) {

        this.puntaje = puntaje;
    }

    public void setPuntajeGlobal(int puntajeGlobal) {

        this.puntajeGlobal = puntajeGlobal;
    }

    public void setRonda(int ronda) {

        this.ronda = ronda;
    }

    public void setUtilizados(SectorDados utilizados) {

        this.utilizados = utilizados;
    }
}
