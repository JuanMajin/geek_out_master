package tests;

import model.Dado;
import model.Partida;

import java.util.Scanner;
/*
public class TestPartida {
    static Partida partida = new Partida();
    static Scanner sc = new Scanner(System.in);

    public static void imprimirEstado() throws InterruptedException {
        System.out.println("Numero ronda:");
        System.out.println(partida.getRonda());
        System.out.println("Puntaje Global:");
        System.out.println(partida.getPuntajeGlobal());
        System.out.println("Puntaje Ronda:");
        System.out.println(partida.getPuntaje().getPuntajeRonda());
        partida.getActivos().imprimirDados();
        partida.getInactivos().imprimirDados();
        partida.getUtilizados().imprimirDados();
        partida.getPuntaje().imprimirDados();
    }

    public static void main(String[] args) throws InterruptedException {
        imprimirEstado();
        System.out.println("Seleccione un dado activo: ");
        int dadoSel = sc.nextInt();
        Dado sel = partida.getActivos().getDados().get(dadoSel);
        partida.poder42(sel);
        Thread.sleep(2000);
        imprimirEstado();
        System.out.println("Seleccione un dado activo: ");
        int dadoSel2 = sc.nextInt();
        Dado sel2 = partida.getActivos().getDados().get(dadoSel2);
        partida.poder42(sel2);
        Thread.sleep(2000);
        imprimirEstado();
        System.out.println("Finalizando ronda...");
        Thread.sleep(2000);
        partida.finalizarRonda();
        imprimirEstado();
    }
}*/