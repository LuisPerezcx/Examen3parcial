package GUI.Admin;

import GUI.imagenes.MiImagen;
import pojo.Vacante;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;

public class NuevaVacante extends JFrame implements ChangeListener {

    private JLabel nombre,numero,fecha,sueldo,descripcion;
    private JTextField txtNombre,txtNumero,txtFecha,txtSueldo,txtExperiencia;
    private JTextArea txtDescripcion;
    private JRadioButton experiencia;
    private JPanel panelContenedor,pnlRegistrar;
    private JButton btnPublicar, btnRegresar;
    public static ArrayList<Vacante> vacanteArrayList = new ArrayList<>();
    private String experiencia1 = "Sin experiencia";

    public NuevaVacante(){
        initComponents();
        initFrame();
        setPanelContainer();
        addActionListeners();
        add(panelContenedor);
    }
    private void initComponents(){
        pnlRegistrar = new JPanel();
        panelContenedor = new JPanel();
        btnPublicar = new JButton("Publicar vacante");
        btnRegresar = new JButton("Regresar");

        nombre = new JLabel("NOMBRE DE LA VACANTE");
        numero = new JLabel("NÚMERO DE VACANTES");
        fecha = new JLabel("FECHA DE PUBLICACIÓN");
        sueldo = new JLabel("SUELDO DE LA VACANTE");
        descripcion = new JLabel("DESCRIPCION DE LA VACANTE");

        experiencia = new JRadioButton("¿Éxperiencia?");

        txtNombre = new JTextField();
        txtNumero = new JTextField();
        txtFecha = new JTextField();
        txtSueldo = new JTextField();
        txtExperiencia= new JTextField();
        txtExperiencia.setEnabled(false);
        txtDescripcion = new JTextArea();

    }
    private void initFrame(){
        setTitle("inicio");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500,330);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    private void setPanelContainer(){
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
        panelContenedor.add(new JLabel("REGISTRAR NUEVO EMPLEO"));

        pnlRegistrar.setLayout(new GridLayout(8,2));
        pnlRegistrar.add(nombre);
        pnlRegistrar.add(txtNombre);
        pnlRegistrar.add(numero);
        pnlRegistrar.add(txtNumero);
        pnlRegistrar.add(experiencia);
        pnlRegistrar.add(txtExperiencia);
        pnlRegistrar.add(fecha);
        pnlRegistrar.add(txtFecha);
        pnlRegistrar.add(sueldo);
        pnlRegistrar.add(txtSueldo);
        pnlRegistrar.add(descripcion);
        pnlRegistrar.add(txtDescripcion);
        pnlRegistrar.add(new JLabel());
        pnlRegistrar.add(new JLabel());
        pnlRegistrar.add(btnPublicar);
        pnlRegistrar.add(btnRegresar);


        panelContenedor.add(pnlRegistrar);
    }
    private void addActionListeners(){
        btnPublicar.addActionListener(e -> {
            agregarVacante();
            clear();
        });
        btnRegresar.addActionListener(e -> {
            setVisible(false);
            new PanelAdmin(new MiImagen(40,0));
        });
        experiencia.addChangeListener(this);
    }
    private void agregarVacante(){
        String nombre,fecha,sueldo,descripcion;

        nombre = txtNombre.getText();
        int numero = -1;
        String ejemplares = txtNumero.getText();
        while (numero == -1){
            try {
                numero = Integer.parseInt(ejemplares);
            } catch (NumberFormatException e) {
                ejemplares = JOptionPane.showInputDialog(null, "Ingresa numero de vacantes", "Datos no validos", JOptionPane.PLAIN_MESSAGE);
            }
        }
        fecha = txtFecha.getText();
        sueldo = txtSueldo.getText();
        descripcion = txtDescripcion.getText();

        vacanteArrayList.add(new Vacante(nombre,numero,fecha,sueldo,descripcion,experiencia1));

    }
    private void clear(){
        txtNombre.setText("");
        txtNumero.setText("");
        txtFecha.setText("");
        txtSueldo.setText("");
        txtExperiencia.setText("");
        txtDescripcion.setText("");
        experiencia.setSelected(false);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(experiencia.isSelected()){
            txtExperiencia.setEnabled(true);
            experiencia1 = txtExperiencia.getText();
        }else{
            txtExperiencia.setEnabled(false);
            txtExperiencia.setText("");
        }
    }

    public static ArrayList<Vacante> getVacanteArrayList() {
        return vacanteArrayList;
    }
}
