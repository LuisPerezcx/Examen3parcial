package GUI.Admin;

import GUI.HomeGUI;
import GUI.imagenes.MiImagen;

import javax.swing.*;
import java.awt.*;

public class PanelAdmin extends  JFrame{
    private JPanel panelContenedor,panelBtn1;
    private final MiImagen miImagen;
    private JButton btnCrear, btnConsultar, btnPostulaciones,btnRegresar;
    public PanelAdmin(MiImagen miImagen){
        initComponents();
        initFrame();
        this.miImagen = miImagen;
        setPanelContainer();
        addActionListeners();
        add(panelContenedor);
    }
    private void initComponents(){
        panelContenedor = new JPanel();
        btnCrear = new JButton("Crear nueva vacante");
        btnConsultar = new JButton("Consultar vacantes publicadas");
        panelBtn1 = new JPanel();
        btnPostulaciones = new JButton("Consultar Postulaciones");
        btnRegresar = new JButton("Regresar");

    }
    private void initFrame(){
        setTitle("inicio");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(350,420);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    private void setPanelContainer(){
        panelContenedor.setLayout(new GridLayout(2,1));
        panelContenedor.add(miImagen);

        panelBtn1.setLayout(new GridLayout(7,1));

        panelBtn1.add(btnCrear);
        panelBtn1.add(new JLabel());
        panelBtn1.add(btnConsultar);
        panelBtn1.add(new JLabel());
        panelBtn1.add(btnPostulaciones);
        panelBtn1.add(new JLabel());
        panelBtn1.add(btnRegresar);

        panelContenedor.add(panelBtn1);
    }
    private void addActionListeners(){
        btnCrear.addActionListener(e -> {
            setVisible(false);
            new NuevaVacante();
        });
        btnConsultar.addActionListener(e -> {
            setVisible(false);
            new VacantesPublicadas();
        });
        btnPostulaciones.addActionListener(e -> {
            setVisible(false);
            new Postulados();
        });
        btnRegresar.addActionListener(e -> {
            setVisible(false);
            new HomeGUI(new MiImagen(1,0));
        });
    }
}
