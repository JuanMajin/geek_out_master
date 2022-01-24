package model;

import java.util.ArrayList;

public class SectorDados {

    private String nombre;
    private ArrayList<Dado> dados;

    public SectorDados(String nombreSector, int numeroDados) {
        nombre = nombreSector;
        dados = new ArrayList<Dado>(numeroDados);
        for (int i = 0; i < numeroDados; i++) {
            dados.add(new Dado());
        }
    }

    public ArrayList<Dado> getDados() {
        return dados;
    }

    public String getNombre() {

        return nombre;
    }

    public void imprimirDados() {
        System.out.println(nombre);
        for (int i = 0; i < dados.size(); i++) {
            System.out.print(dados.get(i).getCaraSup());
            System.out.print(dados.get(i).getCaraInf() + " ");
        }
        System.out.println();
    }

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