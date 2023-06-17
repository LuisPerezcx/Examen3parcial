package GUI.Usuario;

import GUI.Admin.NuevaVacante;
import GUI.Admin.VacantesPublicadas;
import GUI.HomeGUI;
import GUI.imagenes.MiImagen;

import javax.swing.*;
import java.awt.*;

public class PanelUsuario extends JFrame {
    private JPanel panelContenedor,panelBtn1;
    private final MiImagen miImagen;
    private JButton btnRegistrar, btnConsultar,btnRegresar;
    public PanelUsuario(MiImagen miImagen){
        initComponents();
        initFrame();
        this.miImagen = miImagen;
        setPanelContainer();
        addActionListeners();
        add(panelContenedor);
    }
    private void initComponents(){
        panelContenedor = new JPanel();
        btnRegistrar = new JButton("Registrar usuario");
        btnConsultar = new JButton("Consultar vacantes");
        panelBtn1 = new JPanel();
        btnRegresar = new JButton("Regresar");

    }
    private void initFrame(){
        setTitle("inicio");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(350,400);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    private void setPanelContainer(){
        panelContenedor.setLayout(new GridLayout(2,1));
        panelContenedor.add(miImagen);

        panelBtn1.setLayout(new GridLayout(7,1));

        panelBtn1.add(btnRegistrar);
        panelBtn1.add(new JLabel());
        panelBtn1.add(btnConsultar);
        panelBtn1.add(new JLabel());
        panelBtn1.add(btnRegresar);

        panelContenedor.add(panelBtn1);
    }
    private void addActionListeners(){
        btnRegistrar.addActionListener(e -> {
            setVisible(false);
            new NuevoUsuario();
        });
        btnConsultar.addActionListener(e -> {
            setVisible(false);
            new VacantesPublicadasUsuario();
        });
        btnRegresar.addActionListener(e -> {
            setVisible(false);
            new HomeGUI(new MiImagen(1,0));
        });
    }
}
