package GUI.Admin;

import GUI.Usuario.NuevoUsuario;
import GUI.Usuario.PanelUsuario;
import GUI.Usuario.VacantesPublicadasUsuario;
import GUI.imagenes.MiImagen;
import pojo.Postulaciones;
import util.Util;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Postulados extends JFrame {
    private JList<Postulaciones> jList;
    private DefaultListModel<Postulaciones> elementos;
    private JPanel panelContenedor, panelBoton, panelLista,panelAbajo;
    private JButton btnEliminar,btnRegresar,btnActualizar;
    //
    private DefaultTableModel modelo;
    private JTable Table;
    private JLabel nombreVacante,numeroVacantes,fecha,nombrePostulante,estudios;
    private JLabel txtNombreV,txtNumero,txtFecha,txtNombreP,txtEstudios;
    private ArrayList<Postulaciones> postulacionesArrayList = VacantesPublicadasUsuario.getPostulacionesArrayList();
    public Postulados(){
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
        btnEliminar = new JButton();
        jList = new JList<>();
        btnRegresar = new JButton();
        btnEliminar.setText("Eliminar");
        btnRegresar.setText("Regresar");
        panelAbajo = new JPanel();

        nombreVacante = new JLabel("Nombre vacante: ");
        numeroVacantes = new JLabel("Numero de vacantes disponibles: ");
        fecha = new JLabel("fecha de publicacion: ");
        nombrePostulante = new JLabel("Nombre Postulante: ");
        estudios = new JLabel("Estudios del postulante: ");

        txtNombreV = new JLabel();
        txtNumero = new JLabel();
        txtFecha = new JLabel();
        txtNombreP = new JLabel();
        txtEstudios = new JLabel();

        btnActualizar = new JButton("Actualizar");
    }
    private void configurarVentana(){
        setTitle("Formulario lista");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
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

        panelAbajo.setLayout(new GridLayout(5,2));
        panelAbajo.add(nombreVacante);
        panelAbajo.add(txtNombreV);
        panelAbajo.add(numeroVacantes);
        panelAbajo.add(txtNumero);
        panelAbajo.add(fecha);
        panelAbajo.add(txtFecha);
        panelAbajo.add(nombrePostulante);
        panelAbajo.add(txtNombreP);
        panelAbajo.add(estudios);
        panelAbajo.add(txtEstudios);


        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
        panelContenedor.add(panelLista);
        panelContenedor.add(panelBoton);
        panelContenedor.add(panelAbajo);

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
        btnEliminar.addActionListener(e -> {
            eliminar();
        });
        btnRegresar.addActionListener(e -> {
            setVisible(false);
            new PanelAdmin(new MiImagen(40,0));
        });
        btnActualizar.addActionListener(e -> {
            showList();
            detalles();
        });
        jList.addListSelectionListener(e -> {
            detalles();
        });
    }
    private void detalles(){
        int index = jList.getSelectedIndex();
        if(index!=-1){
            String aux;
            int indexVac = postulacionesArrayList.get(index).getIndexVacante();
            int indexPos = postulacionesArrayList.get(index).getIndexPostulante();

            aux = NuevaVacante.vacanteArrayList.get(indexVac).getNombre();
            txtNombreV.setText(aux);
            aux = String.valueOf(NuevaVacante.vacanteArrayList.get(indexVac).getNumero());
            txtNumero.setText(aux);
            aux = NuevaVacante.vacanteArrayList.get(indexVac).getFecha();
            txtFecha.setText(aux);
            aux = NuevoUsuario.postulanteArrayList.get(indexPos).getNomre();
            txtNombreP.setText(aux);
            aux = NuevoUsuario.postulanteArrayList.get(indexPos).getEstudios();
            txtEstudios.setText(aux);
        }else {
            txtNombreV.setText("");
            txtNumero.setText("");
            txtFecha.setText("");
            txtNombreP.setText("");
            txtEstudios.setText("");
        }
    }

    private void showList(){
        elementos = new DefaultListModel<>();
        for (Postulaciones elemento : postulacionesArrayList) {
            elementos.addElement(elemento);
        }
        jList.setModel(elementos);
    }

    private void eliminar(){
        int index = jList.getSelectedIndex();
        if(index==-1){
            JOptionPane.showMessageDialog(this,"Selecciona un elemento de la lista");
        }else{
            int indexVac = postulacionesArrayList.get(index).getIndexVacante();
            postulacionesArrayList.remove(index);
            int disponibles = NuevaVacante.vacanteArrayList.get(indexVac).getNumero();
            NuevaVacante.vacanteArrayList.get(indexVac).setNumero(disponibles+1);
        }
    }
}
