package GUI.Admin;

import GUI.imagenes.MiImagen;
import pojo.Vacante;
import util.Util;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class VacantesPublicadas extends JFrame {
    private JList<Vacante> jList;
    private DefaultListModel<Vacante> elementos;
    private JPanel panelContenedor, panelBoton, panelLista,pnlDetalles;
    private JButton btnActualizar,btnEliminar,btnRegresar;
    private JLabel nombre,sueldo,nombre1,sueldo1,numero,numero1;
    //
    private DefaultTableModel modelo;
    private JTable Table;

    private ArrayList<Vacante> vacanteArrayList = NuevaVacante.getVacanteArrayList();

    public VacantesPublicadas(){
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
        btnActualizar = new JButton();
        btnEliminar = new JButton();
        jList = new JList<>();
        btnRegresar = new JButton();
        btnActualizar.setText("Actualizar");
        btnEliminar.setText("Eliminar vacante");
        btnRegresar.setText("Regresar");
        pnlDetalles = new JPanel();

        nombre = new JLabel("Nombre vacante: ");
        sueldo = new JLabel("Sueldo: ");
        numero = new JLabel("Vacantes disponibles: ");
        nombre1 = new JLabel();
        sueldo1 = new JLabel();
        numero1 = new JLabel();
    }
    private void configurarVentana(){
        setTitle("Formulario lista");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(700, 550);
        setLocationRelativeTo(null);
    }
    private void dibujarCuerpo(){
        panelLista.setLayout(new GridLayout(1,0));
        panelLista.add(jList);
        panelLista.setPreferredSize(new Dimension(300,300));

        panelBoton.setLayout(new FlowLayout());
        panelBoton.setPreferredSize(new Dimension(650,50));
        panelBoton.add(btnEliminar);
        panelBoton.add(btnActualizar);
        panelBoton.add(btnRegresar);

        pnlDetalles.setLayout(new GridLayout(3,2));
        pnlDetalles.add(nombre);
        pnlDetalles.add(nombre1);
        pnlDetalles.add(sueldo);
        pnlDetalles.add(sueldo1);
        pnlDetalles.add(numero);
        pnlDetalles.add(numero1);


        panelContenedor.setLayout(new BoxLayout(panelContenedor,BoxLayout.Y_AXIS));
        panelContenedor.add(panelLista);
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
        btnActualizar.addActionListener(e -> {
            showList();
        });
        btnEliminar.addActionListener(e -> {
            eliminar();
        });
        btnRegresar.addActionListener(e -> {
            setVisible(false);
            new PanelAdmin(new MiImagen(40,0));
        });
        jList.addListSelectionListener(e -> {
            detalles();
        });
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
            numero1.setText("");
        }
    }

    private void showList(){
        elementos = new DefaultListModel<>();
        for (Vacante elemento : vacanteArrayList) {
            elementos.addElement(elemento);
        }
        jList.setModel(elementos);
    }

    private void eliminar(){
        int index = jList.getSelectedIndex();
        if(index==-1){
            JOptionPane.showMessageDialog(this,"Selecciona un elemento de la lista");
        }else{
            vacanteArrayList.remove(index);
        }
    }
}
