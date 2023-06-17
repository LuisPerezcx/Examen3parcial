package GUI.Admin;

import GUI.HomeGUI;
import GUI.imagenes.MiImagen;
import util.Util;

import javax.swing.*;
import java.awt.*;

public class LoginAdmin extends JFrame {
    private JPanel panelContenedor, panelLogin;
    private final MiImagen miImagen;
    private JButton btnRegresar, btnAceptar;
    private JLabel usuario,contrasena;
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    public  LoginAdmin(MiImagen miImagen){
        initComponents();
        initFrame();
        this.miImagen = miImagen;
        setPanelContainer();
        addActionListeners();
        add(panelContenedor);
    }
    private void initComponents(){
        panelContenedor = new JPanel();
        btnRegresar = new JButton("Regresar");
        btnAceptar = new JButton("Aceptar");
        panelLogin = new JPanel();

        usuario = new JLabel("Usuario: ");
        contrasena = new JLabel("Contrasena: ");
        txtUsuario = new JTextField();
        txtContrasena = new JPasswordField();
    }
    private void initFrame(){
        setTitle("inicio");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500,360);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    private void setPanelContainer(){
        panelContenedor.setLayout(new GridLayout(2,1));
        panelContenedor.setPreferredSize(new Dimension(300,300));
        panelContenedor.add(miImagen);

        panelLogin.setLayout(new GridLayout(4,2));
        panelLogin.add(usuario);
        panelLogin.add(txtUsuario);
        panelLogin.add(contrasena);
        panelLogin.add(txtContrasena);

        panelLogin.add(new JLabel());
        panelLogin.add(new JLabel());

        panelLogin.add(btnRegresar);
        panelLogin.add(btnAceptar);

        panelContenedor.add(panelLogin);
    }
    private void addActionListeners(){
        btnRegresar.addActionListener(e -> {
            setVisible(false);
            new HomeGUI(new MiImagen(1,0));
        });
        btnAceptar.addActionListener(e -> {
            validar();
        });
    }
    public void validar(){
        String contrasena = Util.contrasena;
        String usuario = Util.usuario;

        String Cingresada = txtContrasena.getText();
        String Uingresado = txtUsuario.getText();

        if(/*true*/Uingresado.equals(usuario) && Cingresada.equals(contrasena)){
            setVisible(false);
            new PanelAdmin(new MiImagen(40,0));
        }else{
            JOptionPane.showMessageDialog(this,"Credenciales incorrectas");
        }
    }
}
