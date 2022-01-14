import javax.swing.*;
import java.awt.*;

/**
 * This class is used for ...
 * @autor Juan-J Majin-M juan.majin@correounivalle.edu.co
 * @version v.1.0.0 date:29/11/2021
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

    private JButton lanzar,ayuda,salir,dado1,dado2,dado3,dado4,dado5,dado6,dado7,dado8,dado9,dado10;
    private JPanel panelDadosActivos,panelDadosInactivos,panelTarjetaPuntuacion,panelDadosUtilizados;
    private ImageIcon imageDados,imagePuntuacion;
    private JTextArea mensajesSalida,resultadosDados;
    private Escucha escucha;
    private ModelJuego modelJuego;
    private Header headerProject;

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Geek Out Masters");
        //this.setSize(200,100);
        //this.setUndecorated(true);
        this.setBackground(new Color(0,0,255,255));
        this.setForeground(new Color(0,0,255));
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
        //Set up JComponents
        headerProject = new Header("Geek Out Masters", Color.BLACK);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(headerProject,constraints);
        //this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout

        ayuda = new JButton(" ? ");

        //ayuda.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(ayuda,constraints);

        salir = new JButton("Salir");
        //salir.addActionListener(escucha);
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(salir,constraints);

        panelDadosActivos = new JPanel();
        panelDadosActivos.setPreferredSize(new Dimension(300,180));
        panelDadosActivos.setBorder(BorderFactory.createTitledBorder("Dados Activos"));
        //panelDadosActivos.add(dado1);
        //panelDadosActivos.add(dado2);
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelDadosActivos,constraints);

        panelDadosInactivos = new JPanel();
        panelDadosInactivos.setPreferredSize(new Dimension(300,180));
        panelDadosInactivos.setBorder(BorderFactory.createTitledBorder("Dados Inactivos"));
        //panelDadosInactivos.add(dado1);
        //panelDadosInactivos.add(dado2);
        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelDadosInactivos,constraints);

        panelTarjetaPuntuacion = new JPanel();
        panelTarjetaPuntuacion .setPreferredSize(new Dimension(300,180));
        panelTarjetaPuntuacion .setBorder(BorderFactory.createTitledBorder("Tarjeta de Puntuacion"));
        //panelTarjetaPuntuacion .add(dado1);
        //panelTarjetaPuntuacion .add(dado2);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelTarjetaPuntuacion ,constraints);

        panelDadosUtilizados = new JPanel();
        panelDadosUtilizados.setPreferredSize(new Dimension(300,180));
        panelDadosUtilizados.setBorder(BorderFactory.createTitledBorder("Dados Utilizados"));
        //panelDadosUtilizados  .add(dado1);
        //panelDadosUtilizados  .add(dado2);
        constraints.gridx=1;
        constraints.gridy=4;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelDadosUtilizados  ,constraints);

        lanzar = new JButton("lanzar");
        //lanzar.addActionListener(escucha);

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
    private class Escucha {

    }
}
