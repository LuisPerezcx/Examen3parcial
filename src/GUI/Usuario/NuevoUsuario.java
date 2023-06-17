package GUI.Usuario;

import GUI.imagenes.MiImagen;
import pojo.Postulante;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NuevoUsuario extends JFrame {
    private JPanel panelContenedor,pnlRegistro;
    private JLabel nomre,estudios,edad,correo,telefono;
    private JTextField txtNombre,txtEstudios,txtEdad,txtCorreo,txtTelefono;
    private JButton btnRegistrar, btnRegresar;
    public static ArrayList<Postulante> postulanteArrayList = new ArrayList<>();
    public NuevoUsuario(){
        initComponents();
        initFrame();
        setPanelContainer();
        addActionListeners();
        add(panelContenedor);
    }
    private void initFrame(){
        setTitle("inicio");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500,300);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    private void initComponents(){
        panelContenedor = new JPanel();
        pnlRegistro = new JPanel();

        nomre = new JLabel("NOMBRE COMPLETO:");
        estudios = new JLabel("NIVEL DE ESTUDIOS:");
        edad = new JLabel("EDAD:");
        correo = new JLabel("CORREO:");
        telefono = new JLabel("TELEFONO:");

        txtNombre = new JTextField();
        txtEstudios = new JTextField();
        txtEdad= new JTextField();
        txtCorreo = new JTextField();
        txtTelefono = new JTextField();


        btnRegistrar = new JButton("Registrarse");
        btnRegresar = new JButton("Regresar");
    }
    private void setPanelContainer(){
        panelContenedor.setLayout(new BoxLayout(panelContenedor,BoxLayout.Y_AXIS));
        panelContenedor.add(new JLabel("REGISTRAR NUEVO USUARIO"));

        pnlRegistro.setLayout(new GridLayout(7,2));
        pnlRegistro.add(nomre);
        pnlRegistro.add(txtNombre);
        pnlRegistro.add(estudios);
        pnlRegistro.add(txtEstudios);
        pnlRegistro.add(edad);
        pnlRegistro.add(txtEdad);
        pnlRegistro.add(correo);
        pnlRegistro.add(txtCorreo);
        pnlRegistro.add(telefono);
        pnlRegistro.add(txtTelefono);

        pnlRegistro.add(new JLabel());
        pnlRegistro.add(new JLabel());

        pnlRegistro.add(btnRegistrar);
        pnlRegistro.add(btnRegresar);

        panelContenedor.add(pnlRegistro);
    }
    private void addActionListeners(){
        btnRegistrar.addActionListener(e -> {
            agregarPostulante();
            clear();
        });
        btnRegresar.addActionListener(e -> {
            setVisible(false);
            new PanelUsuario(new MiImagen(5,0));
        });
    }
    private void agregarPostulante(){
        String nomre,estudios,edad,correo,telefono;
        nomre = txtNombre.getText();
        estudios = txtEstudios.getText();
        edad = txtEdad.getText();
        correo = txtCorreo.getText();
        telefono = txtTelefono.getText();

        postulanteArrayList.add(new Postulante(nomre,estudios,edad,correo,telefono));
    }
    private void clear(){
        txtNombre.setText("");
        txtEstudios.setText("");
        txtEdad.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
    }

    public static ArrayList<Postulante> getPostulanteArrayList() {
        return postulanteArrayList;
    }
}
