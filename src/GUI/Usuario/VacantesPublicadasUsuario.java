package GUI.Usuario;

import GUI.Admin.NuevaVacante;
import GUI.imagenes.MiImagen;
import pojo.Postulaciones;
import pojo.Postulante;
import pojo.Vacante;
import util.Util;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class VacantesPublicadasUsuario extends JFrame {
    private JList<Vacante> jList;
    private JList<Postulante> jList1;
    private DefaultListModel<Vacante> elementos;
    private DefaultListModel<Postulante> elementos1;
    private JPanel panelContenedor, panelBoton, panelLista,panelLista1,pnlDetalles;
    private JButton btnPostularse,btnRegresar;
    private JLabel nombre,sueldo,nombre1,sueldo1,numero,numero1;
    private DefaultTableModel modelo;
    private JTable Table;
    public static ArrayList<Postulaciones> postulacionesArrayList = new ArrayList<>();

    private ArrayList<Vacante> vacanteArrayList = NuevaVacante.getVacanteArrayList();
    private ArrayList<Postulante> postulanteArrayList = NuevoUsuario.getPostulanteArrayList();
    public VacantesPublicadasUsuario(){
        crearComponentes();
        configurarVentana();
        dibujarCuerpo();
        showList();

        initControl();
        configTable();

        add(panelContenedor);
        addListeners();
    }
    private void crearComponentes(){

        panelContenedor = new JPanel();
        panelBoton = new JPanel();
        panelLista = new JPanel();
        btnPostularse = new JButton();
        jList = new JList<>();
        jList1 = new JList<>();
        btnRegresar = new JButton();
        btnPostularse.setText("Postularse");
        btnRegresar.setText("Regresar");
        panelLista1 = new JPanel();

        pnlDetalles = new JPanel();

        nombre = new JLabel("Nombre vacante: ");
        sueldo = new JLabel("Sueldo: ");
        nombre1 = new JLabel();
        sueldo1 = new JLabel();
        numero= new JLabel("Vacantes disponibles: ");
        numero1 = new JLabel();
    }
    private void configurarVentana(){
        setTitle("Formulario lista");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(700, 820);
        setLocationRelativeTo(null);
    }
    private void dibujarCuerpo(){
        panelLista.setLayout(new GridLayout(1,0));
        panelLista.add(jList);
        panelLista.setPreferredSize(new Dimension(300,300));

        panelLista1.setLayout(new GridLayout(1,0));
        panelLista1.add(jList1);
        panelLista1.setPreferredSize(new Dimension(300,300));

        panelBoton.setLayout(new FlowLayout());
        panelBoton.setPreferredSize(new Dimension(650,50));
        panelBoton.add(btnPostularse);
        panelBoton.add(btnRegresar);

        pnlDetalles.setLayout(new GridLayout(3,2));
        pnlDetalles.add(nombre);
        pnlDetalles.add(nombre1);
        pnlDetalles.add(sueldo);
        pnlDetalles.add(sueldo1);
        pnlDetalles.add(numero);
        pnlDetalles.add(numero1);

        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
        panelContenedor.add(panelLista);
        panelContenedor.add(new JLabel(" "));
        panelContenedor.add(panelLista1);
        panelContenedor.add(panelBoton);
        panelContenedor.add(pnlDetalles);
    }
    private void initControl(){
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(Util.publicadas);
        Table = new JTable(modelo);
    }
    private void configTable() {
        Table.setGridColor(new Color(88, 214, 141));
        Table.setPreferredScrollableViewportSize(new Dimension(650, 0));
        JScrollPane scrollPane = new JScrollPane(Table);
        getContentPane().add(scrollPane,BorderLayout.CENTER);
    }
    private void addListeners(){
        btnPostularse.addActionListener(e -> {
            postularse();
        });
        btnRegresar.addActionListener(e -> {
            setVisible(false);
            new PanelUsuario(new MiImagen(5,0));
        });
        jList.addListSelectionListener(e -> {
            detalles();
        });
    }
    private void postularse(){
        int indexVac = jList.getSelectedIndex();
        if(indexVac!=-1){
            int indexPost = jList1.getSelectedIndex();
            if (indexPost!=-1){
                if(vacanteArrayList.get(indexVac).getNumero()>0){

                    Vacante vacante = vacanteArrayList.get(indexVac);
                    Postulante postulante = postulanteArrayList.get(indexPost);

                    int disponibles = NuevaVacante.vacanteArrayList.get(indexVac).getNumero();
                    NuevaVacante.vacanteArrayList.get(indexVac).setNumero(disponibles-1);

                    postulacionesArrayList.add(new Postulaciones(postulante,vacante,indexPost,indexVac));
                    JOptionPane.showMessageDialog(this,"Postulado exitosamente");
                    detalles();
                }else {
                    JOptionPane.showMessageDialog(this,"No hay vacantes disponibles");
                }
            }else {
                JOptionPane.showMessageDialog(this,"SELECIONA UN POSTULANTE");
            }
        }else {
            JOptionPane.showMessageDialog(this,"SELECIONA UNA VACANTE");
        }

    }
    private void detalles(){
        int index = jList.getSelectedIndex();
        if(index!=-1){
            String aux;
            aux = vacanteArrayList.get(index).getNombre();
            nombre1.setText(aux);
            aux = vacanteArrayList.get(index).getSueldo();
            sueldo1.setText(aux);
            aux = String.valueOf(vacanteArrayList.get(index).getNumero());
            numero1.setText(aux);
        }else {
            nombre1.setText("");
            sueldo1.setText("");
        }
    }
    private void showList(){
        elementos = new DefaultListModel<>();
        elementos1 = new DefaultListModel<>();
        for (Vacante elemento : vacanteArrayList) {
            elementos.addElement(elemento);
        }
        jList.setModel(elementos);

        for (Postulante elemento : postulanteArrayList) {
            elementos1.addElement(elemento);
        }
        jList1.setModel(elementos1);
    }

    public static ArrayList<Postulaciones> getPostulacionesArrayList() {
        return postulacionesArrayList;
    }
}
