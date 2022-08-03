/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import clases.Consulta;
import clases.Direccion;
import clases.Especialidad;
import clases.Medico;
import clases.Paciente;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import listeners.ActionListenerHospitalAgregarMedico;
import listeners.ActionListenerHospitalBuscarHospital;
import listeners.ActionListenerHospitalModifico;
import listeners.ActionListenerHospitalPantallas;
import listeners.ActionListenerHospitalRegistrar;
import listeners.ActionListenerPaginadoConsultas;
import listeners.KeyListenerLetras;
import listeners.KeyListenerNumero;




public class InternalHospital extends javax.swing.JInternalFrame{
    ArrayList<Consulta> consultas;
    JScrollPane scroll;
    public static int base=25;
    Label label,label2;
    JLabel paginaActual,paginaFinal,conector;
    JPanel superior,inferior,derecha,izquierda;
    JPanel registro,modifico,consulto;
    JButton avanzarPagina,retrocederPagina;
    Button registrar,modificar,consultar,agregarMedico,buscarHospital;
    TextField nombre,ruc,telefono,ciudad,calle,numero,rucHospital;
    TextArea medicos;
    Button registrarHospital,modificarHospital,consultarHospital;
    Dimension dimensionSuperior = new Dimension(900, 50);
    Dimension dimensionInferior = new Dimension(900, 800);
    Dimension dimension2 = new Dimension(900, 900);
    JTable tabla=new JTable();
    DefaultTableModel modelo= (DefaultTableModel) tabla.getModel(); 
    public static String textoMedico;
    
            /**
* Constructor que genera los componentes del hospital 
*
* Creado el 03 de Marzo, 2022, 23:20 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/
    public InternalHospital() {
        this.pack();
        label=new Label();
        label.setSize(800, 50);
        label.setText("HOSPITAL");
        label.setFont(new Font("Serif", Font.PLAIN, 30));
        this.setBackground(Color.white);
        
        superior=new JPanel();
        superior.setBackground(Color.white);
        superior.setSize(dimensionSuperior);
        superior.add(label);
        
        inferior=new JPanel();
        inferior.setLayout(null);
        inferior.setBackground(Color.YELLOW);
        inferior.setSize(dimensionInferior);
        
        izquierda=new JPanel();
        izquierda.setBackground(Color.red);
        izquierda.setLayout(new BoxLayout(izquierda, BoxLayout.Y_AXIS));
        izquierda.setBounds(0, 50, 100, 850);
        
        registrar=new Button("REGISTRAR");
        modificar=new Button("MODIFICAR");
        
        registrar.setBackground(Color.black);
        registrar.setForeground(Color.white);
        modificar.setBackground(Color.black);
        modificar.setForeground(Color.white);

        
        izquierda.add(registrar);
        izquierda.add(modificar);

        
        inferior.add(izquierda);
        
        derecha=new JPanel();
        derecha.setBackground(Color.white);
        derecha.setLayout(new CardLayout());
        derecha.setBounds(101, 50, 800, 850);
        inferior.add(derecha);
        
        
        
        this.add(superior);
        this.add(inferior);
        
        this.setResizable(true);
        this.setClosable(true);
        //this.setMaximizable(true);
        this.setSize(900, 900);
        this.setMaximumSize(dimension2);
        this.setVisible(true);

        //crear paneles para crud
        panelRegistrar();
        panelModificar();
        //action listener
        registrar.addActionListener(new ActionListenerHospitalPantallas(derecha,registro));
        modificar.addActionListener(new ActionListenerHospitalPantallas(derecha,modifico));
         
    }
            /**
* Función que aloja los componentes del panel de registro del hospital
*
* Creado el 03 de Marzo, 2022, 23:40 horas
*
* @authores: Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/
    private void panelRegistrar(){
        registro=new JPanel();
        registro.setBackground(Color.white);
        registro.setBounds(0, 0, 800, 850);
        registro.setLayout(null);
        //Crear los labels 
        Label lblNombre = new Label("NOMBRE :");
        lblNombre.setFont(new Font("Serif", Font.PLAIN, 30));
        lblNombre.setBounds(100, 40, 270, 50);
        
        Label lblRuc = new Label("RUC :");
        lblRuc.setFont(new Font("Serif", Font.PLAIN, 30));
        lblRuc.setBounds(100, 160, 270, 50);
      
        Label lblTelefono = new Label("TELEFONO :");
        lblTelefono.setFont(new Font("Serif", Font.PLAIN, 30));
        lblTelefono.setBounds(100, 280, 270, 50);
   
        Label lblDireccion = new Label("DIRECCION :");
        lblDireccion.setFont(new Font("Serif", Font.PLAIN, 30));
        lblDireccion.setBounds(100, 400, 270, 50);
     
        Label lblMedico = new Label("MEDICO :");
        lblMedico.setFont(new Font("Serif", Font.PLAIN, 30));
        lblMedico.setBounds(100, 600, 270, 50);
        //creo el Boton
        registrarHospital=new Button("REGISTRAR");
        registrarHospital.setFont(new Font("Serif", Font.BOLD, 40));
        registrarHospital.setBounds(400, 750, 270, 50);
        //creo los Texfield
        nombre=new TextField();
        nombre.setFont(new Font("Serif", Font.ITALIC, 20));
        nombre.setBounds(420, 50, 270, 30);
        
        ruc=new TextField();
        ruc.setFont(new Font("Serif", Font.ITALIC, 20));
        ruc.setBounds(420, 170, 270, 30);
        
        telefono=new TextField();
        telefono.setFont(new Font("Serif", Font.ITALIC, 20));
        telefono.setBounds(420, 290, 270, 30);
        
        ciudad=new TextField();
        ciudad.setFont(new Font("Serif", Font.ITALIC, 20));
        ciudad.setBounds(420, 410, 270, 30);
        
        calle=new TextField();
        calle.setFont(new Font("Serif", Font.ITALIC, 20));
        calle.setBounds(420, 460, 270, 30);
        
        numero=new TextField();
        numero.setFont(new Font("Serif", Font.ITALIC, 20));
        numero.setBounds(420, 510, 270, 30);
        
        medicos=new TextArea();
        medicos.setFont(new Font("Serif", Font.ITALIC, 10));
        medicos.setBounds(420, 610, 270, 100);
        medicos.setEditable(false);
        
        //boton para agregar los medicos
        agregarMedico=new Button("+");
        agregarMedico.setFont(new Font("Serif", Font.ITALIC, 40));
        agregarMedico.setBounds(700, 610, 50, 50);
        agregarMedico.setEnabled(true);
        agregarMedico.addActionListener(new ActionListenerHospitalAgregarMedico(medicos,agregarMedico));
        //Añado los labels al GridLayou
       
        registro.add(lblNombre);
        registro.add(nombre);
        registro.add(lblRuc);
        registro.add(ruc);
        registro.add(lblTelefono);
        registro.add(telefono);
        registro.add(lblDireccion);
        registro.add(ciudad);
        registro.add(calle);
        registro.add(numero);
        registro.add(lblMedico);
        registro.add(medicos);
        registro.add(agregarMedico);
        registrarHospital.addActionListener(new ActionListenerHospitalRegistrar(nombre, ruc, telefono, ciudad, calle, numero, medicos));
        
        nombre.addKeyListener(new KeyListenerLetras());
        ruc.addKeyListener(new KeyListenerNumero());
        ciudad.addKeyListener(new KeyListenerLetras());
        calle.addKeyListener(new KeyListenerLetras());
        telefono.addKeyListener(new KeyListenerNumero());
        numero.addKeyListener(new KeyListenerNumero());
        
        /*registro.add(new TextField("HOLA"));
        registro.add(new Label("RECUERDE LLENAR TODOS LOS CAMPOS ANTES DE REGISTAR!"));*/
        registro.add(registrarHospital);
    }
    
            /**
* Función que aloja los componentes del panel de modificar hospital 
*
* Creado el 03 de Marzo, 2022, 24:00 horas
*
* @authores: Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/
    private void panelModificar(){
        modifico=new JPanel();
        modifico.setBackground(Color.white);
        modifico.setBounds(0, 0, 800, 850);
        modifico.setLayout(null);
        //Crear los labels 
        Label lblNombre = new Label("NOMBRE :");
        lblNombre.setFont(new Font("Serif", Font.PLAIN, 30));
        lblNombre.setBounds(100, 120, 270, 50);
        
        Label lblRuc = new Label("RUC :");
        lblRuc.setFont(new Font("Serif", Font.PLAIN, 30));
        lblRuc.setBounds(100, 240, 270, 50);
      
        Label lblTelefono = new Label("TELEFONO :");
        lblTelefono.setFont(new Font("Serif", Font.PLAIN, 30));
        lblTelefono.setBounds(100, 350, 270, 50);
   
        Label lblDireccion = new Label("DIRECCION :");
        lblDireccion.setFont(new Font("Serif", Font.PLAIN, 30));
        lblDireccion.setBounds(100, 480, 270, 50);
     
        //creo el Boton para modificar
        modificarHospital=new Button("MODIFICAR");
        modificarHospital.setFont(new Font("Serif", Font.BOLD, 40));
        modificarHospital.setBounds(220, 650, 270, 50);
        
        //creo el TextField boton para buscar por ruc 
        rucHospital=new TextField("ruc a buscar");
        rucHospital.setFont(new Font("Serif", Font.ITALIC, 20));
        rucHospital.setBounds(10,30,270,30);
        
        //creo el boton para buscar por ruc 
        buscarHospital=new Button("BUSCAR");
        buscarHospital.setFont(new Font("Serif", Font.BOLD,20));
        buscarHospital.setBounds(290,30,270,30);
        
        //creo los Texfield
        nombre=new TextField("Ingrese El Nombre");
        nombre.setFont(new Font("Serif", Font.ITALIC, 20));
        nombre.setBounds(420, 130, 320, 30);
        
        ruc=new TextField("Ingrese El Ruc");
        ruc.setFont(new Font("Serif", Font.ITALIC, 20));
        ruc.setBounds(420, 230, 320, 30);
        
        telefono=new TextField("Ingrese El Telefono");
        telefono.setFont(new Font("Serif", Font.ITALIC, 20));
        telefono.setBounds(420, 340, 270, 30);
        
        ciudad=new TextField("Ingrese La Ciudad");
        ciudad.setFont(new Font("Serif", Font.ITALIC, 20));
        ciudad.setBounds(420, 490, 270, 30);
        
        calle=new TextField("Ingrese La Calle");
        calle.setFont(new Font("Serif", Font.ITALIC, 20));
        calle.setBounds(420, 530,270, 30);
        
        numero=new TextField("Ingrese El Numero");
        numero.setFont(new Font("Serif", Font.ITALIC, 20));
        numero.setBounds(420, 570, 270, 30);
        
        //Añado los labels al GridLayou
       
        modifico.add(lblNombre);
        modifico.add(nombre);
        modifico.add(lblRuc);
        modifico.add(ruc);
        modifico.add(lblTelefono);
        modifico.add(telefono);
        modifico.add(lblDireccion);
        modifico.add(ciudad);
        modifico.add(calle);
        modifico.add(numero);
        modifico.add(rucHospital);
        modifico.add(buscarHospital);
        /*registro.add(new TextField("HOLA"));
        registro.add(new Label("RECUERDE LLENAR TODOS LOS CAMPOS ANTES DE REGISTAR!"));*/
        buscarHospital.addActionListener(new ActionListenerHospitalBuscarHospital( rucHospital,nombre,ruc, telefono, ciudad, calle, numero));
        modificarHospital.addActionListener(new ActionListenerHospitalModifico(rucHospital,nombre,ruc, telefono, ciudad, calle, numero));
        
        nombre.addKeyListener(new KeyListenerLetras());
        ruc.addKeyListener(new KeyListenerNumero());
        ciudad.addKeyListener(new KeyListenerLetras());
        calle.addKeyListener(new KeyListenerLetras());
        telefono.addKeyListener(new KeyListenerNumero());
        numero.addKeyListener(new KeyListenerNumero());
        
        modifico.add(modificarHospital);
        
    }

}
