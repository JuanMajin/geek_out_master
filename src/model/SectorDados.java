package model;
import java.util.ArrayList;

/**Class SectorDados creación de array que contiene los dados
 * y también el nombre del sector en  que se encuentran
 * @autor Juan-J Majin-M juan.majin@correounivalle.edu.co
 * @author Diana Cadena diana.marcela.cadena@correounivalle.edu.co
 * @version v.1.0.0 date:11/01/2022
 */

public class SectorDados {

    private String nombre;
    private ArrayList<Dado> dados;

    /**
     * class constructor
     * @param nombreSector
     * @param numeroDados
     */

    public SectorDados(String nombreSector, int numeroDados, ArrayList<String> ids) {
        nombre = nombreSector;
        dados = new ArrayList<Dado>(numeroDados);
        for (int i = 0; i < numeroDados; i++) {
            dados.add(new Dado(ids.get(i)));
        }
    }

    /**
     * Array de los dados
     * @return
     */

    public ArrayList<Dado> getDados() {
        return dados;
    }

    /**
     * Nombre del dado
     * @return
     */

    public String getNombre() {

        return nombre;
    }

    /**
     * Se encarga de mover los dados
     * @param dado
     * @param sectorActual
     * @param sectorFinal
     */

    public void moverDado(Dado dado, SectorDados sectorActual, SectorDados sectorFinal) {
        sectorActual.getDados().remove(dado);
        sectorFinal.getDados().add(dado);
    }

    public void setDados(ArrayList<Dado> dados) {

        this.dados = dados;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }
}