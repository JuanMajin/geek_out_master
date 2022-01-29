package model;
import java.util.ArrayList;
import java.util.Arrays;

/**Class SectorPuntaje se encarga de guardar los puntajes e irlos añadiendo cada ronda
 * @autor Juan-J Majin-M juan.majin@correounivalle.edu.co
 * @author Diana Cadena diana.marcela.cadena@correounivalle.edu.co
 * @version v.1.0.0 date:11/01/2022

 */

public class SectorPuntaje {
    public int[] PUNTAJES = { 1, 3, 6, 10, 15, 21, 28, 36, 45, 55 };
    private ArrayList<Dado> dados;
    private String nombre;
    private int puntajeRonda;

    /**
     * class constructor
     * @param nombre
     * @param numeroDados
     */

    public SectorPuntaje(String nombre, int numeroDados) {
        this.nombre = nombre;
        dados = new ArrayList<Dado>(numeroDados);
        puntajeRonda = 0;
    }

    /**
     * Actualizar el puntaje cada ronda
     */

    public void actualizarPuntaje() {
        puntajeRonda = 0;
        for (int i = 0; i < dados.size(); i++) {
            puntajeRonda = puntajeRonda + PUNTAJES[i];
        }
    }

    /**
     * Agregar el dado 42 al puntaje
     * @param dado
     */

    public void agregarDado42(Dado dado) {
        dados.add(dado);
        actualizarPuntaje();
    }

    public ArrayList<Dado> getDados() {

        return dados;
    }

    public String getNombre() {

        return nombre;
    }

    public int getPuntajeRonda() {

        return puntajeRonda;
    }


    public void perderTodo() {
        dados = new ArrayList<Dado>(0);
        actualizarPuntaje();
    }

    public void setDados(ArrayList<Dado> dados) {

        this.dados = dados;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public void setPuntaje(int puntaje) {

        this.puntajeRonda = puntaje;
    }

    @Override
    public String toString() {
        return " PUNTAJES=" + Arrays.toString(PUNTAJES)
                + ",\n puntaje=" + puntajeRonda ;
    }
}
