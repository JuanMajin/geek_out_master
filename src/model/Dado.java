package model;

import java.util.Random;

public class Dado {

    private static Random random = new Random();
    private String caraSup;
    private String caraInf;

    public Dado() {
        setCaras(random.nextInt(6) + 1);
    }

    public String getCaraInf() {
        return caraInf;
    }

    public String getCaraSup() {
        return caraSup;
    }

    public void invertirCara() {
        String temp = caraSup;
        caraSup = caraInf;
        caraInf = temp;
    }

    public Dado lanzarDado() {
        return new Dado();
    }

    public void setCaraInf(String caraInf) {
        this.caraInf = caraInf;
    }

    public void setCaras(int n) {
        if (n == 1) {
            caraSup = "M";
            caraInf = "E";
        } else if (n == 2) {
            caraSup = "D";
            caraInf = "H";
        } else if (n == 3) {
            caraSup = "C";
            caraInf = "42";
        } else if (n == 4) {
            caraSup = "E";
            caraInf = "M";
        } else if (n == 5) {
            caraSup = "H";
            caraInf = "D";
        } else if (n == 6) {
            caraSup = "42";
            caraInf = "C";
        } else {
            caraSup = "42";
            caraInf = "C";
        }
    }

    public void setCaraSup(String caraSup) {
        this.caraSup = caraSup;
    }

}