package GUI;

import GUI.Admin.LoginAdmin;
import GUI.Usuario.PanelUsuario;
import GUI.imagenes.MiImagen;

import javax.swing.*;
import java.awt.*;

public class HomeGUI extends JFrame {
    private JPanel panelContenedor,panelBtn1;
    private final MiImagen miImagen;
    private JButton btnUsuario, btnAdmin;
    public HomeGUI(MiImagen miImagen){
        initComponents();
        initFrame();
        this.miImagen = miImagen;
        setPanelContainer();
        addActionListeners();
        add(panelContenedor);
    }
    private void initComponents(){
        panelContenedor = new JPanel();
        btnUsuario = new JButton("USUARIO");
        btnAdmin = new JButton("ADMINISTRADOR");
        panelBtn1 = new JPanel();

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

        panelBtn1.add(btnUsuario);
        panelBtn1.add(new JLabel());
        panelBtn1.add(btnAdmin);

        panelContenedor.add(panelBtn1);
    }
    private void addActionListeners(){
        btnUsuario.addActionListener(e -> {
            setVisible(false);
            new PanelUsuario(new MiImagen(5,0));
        });
        btnAdmin.addActionListener(e -> {
            setVisible(false);
            new LoginAdmin(new MiImagen(100,0));
        });
    }
}
