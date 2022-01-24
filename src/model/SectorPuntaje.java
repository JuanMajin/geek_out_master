package model;

import java.util.ArrayList;
import java.util.Arrays;

public class SectorPuntaje {
    public int[] PUNTAJES = { 1, 3, 6, 10, 15, 21, 28, 36, 45, 55 };
    private ArrayList<Dado> dados;
    private String nombre;
    private int puntajeRonda;

    public SectorPuntaje(String nombre, int numeroDados) {
        this.nombre = nombre;
        dados = new ArrayList<Dado>(numeroDados);
        puntajeRonda = 0;
    }

    public void actualizarPuntaje() {
        puntajeRonda = 0;
        for (int i = 0; i < dados.size(); i++) {
            puntajeRonda = puntajeRonda + PUNTAJES[i];
        }
    }

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

    public void imprimirDados() {
        System.out.println(nombre);
        for (int i = 0; i < dados.size(); i++) {
            System.out.print(dados.get(i).getCaraSup());
            System.out.print(dados.get(i).getCaraInf() + " ");
        }
        System.out.println();
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
        return "SectorPuntaje [PUNTAJES=" + Arrays.toString(PUNTAJES) + ", dados=" + dados + ", nombre=" + nombre
                + ", puntaje=" + puntajeRonda + "]";
    }

}
