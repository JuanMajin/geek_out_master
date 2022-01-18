package model;
public class SectorPuntaje {
    private int[] posicionPuntaje;
    private int marcadorDePuntaje;


    public SectorPuntaje(int puntaje){
        posicionPuntaje = new int[10];
    }
    public void marcarPuntaje(int posicion){
        marcadorDePuntaje= posicion;
    }

    public int[] getPosicionPuntaje() {
        return posicionPuntaje;
    }

    public void setPosicionPuntaje(int[] posicionPuntaje) {
        this.posicionPuntaje = posicionPuntaje;
    }

    public int getMarcadorDePuntaje() {
        return marcadorDePuntaje;
    }

    public void setMarcadorDePuntaje(int marcadorDePuntaje) {
        this.marcadorDePuntaje = marcadorDePuntaje;
    }
}
