package model;

import java.util.Random;

/**
 * Class Dado generate a Random value between 1 and 6
 * Se establecen las caras superiores e inferiores
 * @autor Juan-J Majin-M juan.majin@correounivalle.edu.co
 * @author Diana Cadena diana.marcela.cadena@correounivalle.edu.co
 * @version v.1.0.0 date:11/01/2022
 */

public class Dado {

    private static Random random = new Random();
    private String caraSup;
    private String caraInf;
    private String id;

    /**
     * Se generan las caras de forma aleatoria
     */
    public Dado(String id) {
        setCaras(random.nextInt(6) + 1);
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaraInf() {
        return caraInf;
    }

    public String getCaraSup() {
        return caraSup;
    }



    /**
     * Permite invirtir Cara
     */
    public void invertirCara() {
        String temp = caraSup;
        caraSup = caraInf;
        caraInf = temp;
    }

    /**
     * Permite relanzar Dado
     */

    public void relanzarDado() {
        setCaras(random.nextInt(6) + 1);
    }

    public void setCaraInf(String caraInf) {
        this.caraInf = caraInf;
    }

    /**
     * Establece las caras superiores e inferiores
     * @param n
     */
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