import model.Dado;
import model.Partida;
import model.SectorDados;
import model.SectorPuntaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * This class is used for ...
 * @autor Juan-J Majin-M juan.majin@correounivalle.edu.co
 * @author Diana Cadena diana.marcela.cadena@correounivalle.edu.co
 * @version v.1.0.0 date:11/01/2022
 */
public class GUI extends JFrame {
    public  static final String MENSAJE_INICIO="Bienvenido a Geek out masters \n"
            + "Oprime el botón lanzar para iniciar el juego, podrás utilizar el dado deseado seleccionandolo."
            + "\nEl meeple permite volver a lanzar uno de los dados activos."
            + "\nSi no hay mas acciones disponibles y hay uno o mas dragones activos pierde todos los puntos."
            + "\nEl Corazon permite tomar un dado de la sección de dados inactivos y lanzarlo para que sea un\n" +
            "nuevo dado activo."
            + "\nLa Nave Espacial envía un dado no usado (de la sección dados activos) a la sección de dados\n" +
            "inactivos."
            + "\nEl Superhéroe permite que cualquier dado no usado (sección dados activos) sea volteado y\n" +
            "colocado en su cara opuesta."
            + "\n42 es cara que permite sumar puntos al final de la ronda."
            +"\nEste juego lo jugará un único jugador y ganará si logra sumar 30 puntos en 5 rondas consecutivas de juego.";

    private JButton lanzar,ayuda,salir;
    private JLabel dado1,dado2,dado3,dado4,dado5,dado6,dado7,dado8,dado9,dado10;
    private JPanel panelDadosActivos,panelDadosInactivos,panelTarjetaPuntuacion,panelDadosUtilizados;
    private ImageIcon imageDados;
    private JTextArea mensajesSalida,resultadosDados,ronda;
    private Escucha escucha;
    private Header headerProject;
    private Partida partida;
    private SectorDados sectorDados;
    private SectorPuntaje sectorPuntaje;
    private JLabel dadoPoder;
    private  ArrayList<String> idsActivos;
    private  ArrayList<String> idsInactivos;
    private  ArrayList<String> idsUtilizados;
    private boolean enPoder;


    private String obtenerRuta(String cara) {
        String ruta = "";
        if (cara.equals("42")) {
            ruta = "src/resources/42.png";
        } else if (cara.equals("E")) {
            ruta = "src/resources/cohete.png";
        } else if (cara.equals("D")) {
            ruta = "src/resources/dragon.png";
        } else if (cara.equals("M")) {
            ruta = "src/resources/duende.png";
        } else if (cara.equals("H")) {
            ruta = "src/resources/superheroe.png";
        } else if (cara.equals("C")) {
            ruta = "src/resources/corazon.png";
        }
        return ruta;
    }


    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Geek Out Masters");
        this.setUndecorated(true);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //Create Listener Object and Control Object

        idsActivos = new ArrayList<>(7);
        idsActivos.add("dado1");
        idsActivos.add("dado2");
        idsActivos.add("dado3");
        idsActivos.add("dado4");
        idsActivos.add("dado5");
        idsActivos.add("dado6");
        idsActivos.add("dado7");

        idsInactivos = new ArrayList<>(3);
        idsInactivos.add("dado8");
        idsInactivos.add("dado9");
        idsInactivos.add("dado10");

        idsUtilizados= new ArrayList<>(0);
        escucha= new Escucha();
        partida= new Partida(idsActivos, idsInactivos, idsUtilizados);
        sectorPuntaje=partida.getPuntaje();


        //Set up JComponents
        headerProject = new Header("Geek Out Masters", Color.BLACK);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(headerProject,constraints);
        //this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout



        ayuda = new JButton(" ? ");
        ayuda.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(ayuda,constraints);

        salir = new JButton("Salir");
        salir.addActionListener(escucha);
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(salir,constraints);

        imageDados = new ImageIcon(getClass().getResource("/resources/42.png"));
        dado1= new JLabel(imageDados);
        dado1.setName("dado1");
        dado2= new JLabel(imageDados);
        dado2.setName("dado2");
        dado3= new JLabel(imageDados);
        dado1.setName("dado3");
        dado4= new JLabel(imageDados);
        dado1.setName("dado4");
        dado5= new JLabel(imageDados);
        dado1.setName("dado5");
        dado6= new JLabel(imageDados);
        dado1.setName("dado6");
        dado7= new JLabel(imageDados);
        dado1.setName("dado7");
        dado8= new JLabel(imageDados);
        dado1.setName("dado8");
        dado9= new JLabel(imageDados);
        dado1.setName("dado9");
        dado10= new JLabel(imageDados);
        dado1.setName("dado10");

        dado1.addMouseListener(escucha);
        dado2.addMouseListener(escucha);
        dado3.addMouseListener(escucha);
        dado4.addMouseListener(escucha);
        dado5.addMouseListener(escucha);
        dado6.addMouseListener(escucha);
        dado7.addMouseListener(escucha);
        dado8.addMouseListener(escucha);
        dado9.addMouseListener(escucha);
        dado10.addMouseListener(escucha);

        panelDadosActivos = new JPanel();
        panelDadosActivos.setPreferredSize(new Dimension(380,200));
        panelDadosActivos.setBorder(BorderFactory.createTitledBorder("Dados Activos"));
        panelDadosActivos.add(dado1);
        panelDadosActivos.add(dado2);
        panelDadosActivos.add(dado3);
        panelDadosActivos.add(dado4);
        panelDadosActivos.add(dado5);
        panelDadosActivos.add(dado6);
        panelDadosActivos.add(dado7);
        panelDadosActivos.addMouseListener(escucha);
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelDadosActivos,constraints);

        panelDadosInactivos = new JPanel();
        panelDadosInactivos.setPreferredSize(new Dimension(380,200));
        panelDadosInactivos.setBorder(BorderFactory.createTitledBorder("Dados Inactivos"));
        panelDadosInactivos.add(dado8);
        panelDadosInactivos.add(dado9);
        panelDadosInactivos.add(dado10);
        panelDadosInactivos.addMouseListener(escucha);
        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelDadosInactivos,constraints);

        resultadosDados = new JTextArea(6,30);
        resultadosDados.setBorder(BorderFactory.createTitledBorder("Resultados"));
        resultadosDados.setText("Debes lanzar los dados");
        resultadosDados.setBackground(null);
        resultadosDados.setEditable(false);

        ronda= new JTextArea(4,8);
        ronda.setBorder(BorderFactory.createTitledBorder("Ronda:"));
        ronda.setText("");
        ronda.setBackground(null);
        ronda.setEditable(false);

        panelTarjetaPuntuacion = new JPanel();
        panelTarjetaPuntuacion .setPreferredSize(new Dimension(380,200));
        panelTarjetaPuntuacion .setBorder(BorderFactory.createTitledBorder("Tarjeta de Puntuacion"));
        //panelTarjetaPuntuacion.add(rondas);
        //panelTarjetaPuntuacion .add(dado2);
        panelTarjetaPuntuacion.add(resultadosDados);
        panelTarjetaPuntuacion.add(ronda);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelTarjetaPuntuacion ,constraints);


        panelDadosUtilizados = new JPanel();
        panelDadosUtilizados.setPreferredSize(new Dimension(380,200));
        panelDadosUtilizados.setBorder(BorderFactory.createTitledBorder("Dados Utilizados"));
        panelDadosUtilizados.addMouseListener(escucha);
        constraints.gridx=1;
        constraints.gridy=4;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelDadosUtilizados  ,constraints);

        lanzar = new JButton("lanzar");
        lanzar.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=3;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        add(lanzar,constraints);
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener, MouseListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==lanzar) {
                ArrayList<Dado> activos = partida.getActivos().getDados();
                imageDados = new ImageIcon(obtenerRuta(activos.get(0).getCaraSup()));
                dado1.setIcon(imageDados);
                imageDados = new ImageIcon(obtenerRuta(activos.get(1).getCaraSup()));
                dado2.setIcon(imageDados);
                imageDados = new ImageIcon(obtenerRuta(activos.get(2).getCaraSup()));
                dado3.setIcon(imageDados);
                imageDados = new ImageIcon(obtenerRuta(activos.get(3).getCaraSup()));
                dado4.setIcon(imageDados);
                imageDados = new ImageIcon(obtenerRuta(activos.get(4).getCaraSup()));
                dado5.setIcon(imageDados);
                imageDados = new ImageIcon(obtenerRuta(activos.get(5).getCaraSup()));
                dado6.setIcon(imageDados);
                imageDados = new ImageIcon(obtenerRuta(activos.get(6).getCaraSup()));
                dado7.setIcon(imageDados);
                ArrayList<Dado> inactivos = partida.getInactivos().getDados();
                imageDados = new ImageIcon(obtenerRuta(inactivos.get(0).getCaraSup()));
                dado8.setIcon(imageDados);
                imageDados = new ImageIcon(obtenerRuta(inactivos.get(1).getCaraSup()));
                dado9.setIcon(imageDados);
                imageDados = new ImageIcon(obtenerRuta(inactivos.get(2).getCaraSup()));
                dado10.setIcon(imageDados);
                resultadosDados.setText(sectorPuntaje.toString());
                ronda.setText(""+partida.getRonda());

            }
                else{
                    if(e.getSource()==ayuda){
                        JOptionPane.showMessageDialog(null,MENSAJE_INICIO);
                    }else{
                        System.exit(0);
                    }
                }
            }


        @Override
        public void mouseClicked(MouseEvent e) {

            JLabel oprimido = (JLabel) e.getComponent();
            panelDadosActivos.remove(oprimido);
            panelDadosUtilizados.add(oprimido);
            revalidate();
            repaint();
            if (e.getSource()==dado1){
                panelDadosActivos.remove(dado1);
                panelDadosUtilizados.add(dado1);
                revalidate();
                repaint();
            }
            else{
                if (e.getSource()==dado2){
                    panelDadosActivos.remove(dado2);
                    panelDadosUtilizados.add(dado2);
                    revalidate();
                    repaint();
                }
                else{
                    if (e.getSource()==dado3){
                        panelDadosActivos.remove(dado3);
                        panelDadosUtilizados.add(dado3);
                        revalidate();
                        repaint();
                    }
                    else{
                        if (e.getSource()==dado4){
                            panelDadosActivos.remove(dado4);
                            panelDadosUtilizados.add(dado4);
                            revalidate();
                            repaint();
                        }
                        else{
                            if (e.getSource()==dado5){
                                panelDadosActivos.remove(dado5);
                                panelDadosUtilizados.add(dado5);
                                revalidate();
                                repaint();
                            }
                            else{
                                if (e.getSource()==dado6){
                                    panelDadosActivos.remove(dado6);
                                    panelDadosUtilizados.add(dado6);
                                    revalidate();
                                    repaint();
                                }
                                else{
                                    if (e.getSource()==dado7){
                                        panelDadosActivos.remove(dado7);
                                        panelDadosUtilizados.add(dado7);
                                        revalidate();
                                        repaint();
                                    }
                                    else{
                                        if(e.getSource()==dado8){
                                            panelDadosInactivos.remove(dado8);
                                            panelDadosUtilizados.add(dado8);
                                            revalidate();
                                            repaint();
                                        }
                                        else{
                                            if(e.getSource()==dado9){
                                                panelDadosInactivos.remove(dado9);
                                                panelDadosUtilizados.add(dado9);
                                                revalidate();
                                                repaint();
                                            }
                                            else{
                                                if(e.getSource()==dado10){
                                                    panelDadosInactivos.remove(dado10);
                                                    panelDadosUtilizados.add(dado10);
                                                    revalidate();
                                                    repaint();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        public void llamarPoder(Dado dado,String poder){
            //if(poder.equals("meeple")){
            //    partida.poderMepple();
            //}

        }
    }
}

