/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import clases.Especialidad;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import listeners.ActionListenerConsultaBuscarPaciente;
import listeners.ActionListenerPacienteBuscarPaciente;
import listeners.ActionListenerPacienteModifico;
import listeners.KeyListenerLetras;
import listeners.KeyListenerNumero;



/**
 *
 * @author GAMER
 */
public class InternalPaciente extends javax.swing.JInternalFrame{
    Label label;
    Dimension dimension2 = new Dimension(900, 900);
    Button modificar;
    Button modificarPaciente,buscarPaciente;
    JPanel panel;
    JPanel registro,modifico,consulto;
    private TextArea medicos;
    Especialidad especialidades;
    TextField nombre, apellidos,telefono,cedula,ciudad,calle,numero,idHistorial;
            /**
*Constructor que contiene los componentes  de la parte administrativa del paciente 
*
* Creado el 04 de Marzo, 2022, 10:00 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/
    public InternalPaciente() {
        this.pack();
        this.setBackground(Color.white);
        label=new Label("PACIENTE");
        label.setBounds(330, 10, 270, 20);
        label.setFont(new Font("Serif", Font.PLAIN, 30));
        
        this.setResizable(true);
        this.setClosable(true);
        this.setMaximizable(true);
        this.setSize(900, 900);
        this.setMaximumSize(dimension2);
        panel=new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.add(label);
        //Crear los labels 
        idHistorial=new TextField();
        idHistorial.setFont(new Font("Serif", Font.ITALIC, 20));
        idHistorial.setBounds(10,40,270,30);
        
        //creo el boton para buscar por ruc 
        buscarPaciente=new Button("BUSCAR");
        buscarPaciente.setFont(new Font("Serif", Font.BOLD,20));
        buscarPaciente.setBounds(290,40,270,30);
        
        Label lblNombre = new Label("NOMBRE :");
        lblNombre.setFont(new Font("Serif", Font.PLAIN, 30));
        lblNombre.setBounds(100, 90, 270, 50);

        Label lblApellidos = new Label("APELLIDOS :");
        lblApellidos.setFont(new Font("Serif", Font.PLAIN, 30));
        lblApellidos.setBounds(100, 210, 270, 50);

        Label lblTelefono = new Label("TELEFONO :");
        lblTelefono.setFont(new Font("Serif", Font.PLAIN, 30));
        lblTelefono.setBounds(100, 330, 270, 50);

        Label lblDireccion = new Label("DIRECCION :");
        lblDireccion.setFont(new Font("Serif", Font.PLAIN, 30));
        lblDireccion.setBounds(100, 450, 270, 50);

        Label lblCedula = new Label("CEDULA :");
        lblCedula.setFont(new Font("Serif", Font.PLAIN, 30));
        lblCedula.setBounds(100, 650, 270, 50);

        //creo el Boton
        modificarPaciente=new Button("MODIFICAR");
        modificarPaciente.setFont(new Font("Serif", Font.BOLD, 40));
        modificarPaciente.setBounds(400, 800, 270, 50);
       

        //creo los Texfield
        nombre=new TextField();
        nombre.setFont(new Font("Serif", Font.ITALIC, 20));
        nombre.setBounds(420, 100, 270, 30);

        apellidos=new TextField();
        apellidos.setFont(new Font("Serif", Font.ITALIC, 20));
        apellidos.setBounds(420, 220, 270, 30);

        telefono=new TextField();
        telefono.setFont(new Font("Serif", Font.ITALIC, 20));
        telefono.setBounds(420, 340, 270, 30);

        ciudad=new TextField();
        ciudad.setFont(new Font("Serif", Font.ITALIC, 20));
        ciudad.setBounds(420, 460, 270, 30);

        calle=new TextField();
        calle.setFont(new Font("Serif", Font.ITALIC, 20));
        calle.setBounds(420, 510, 270, 30);

        numero=new TextField();
        numero.setFont(new Font("Serif", Font.ITALIC, 20));
        numero.setBounds(420, 560, 270, 30);

        cedula=new TextField();
        cedula.setFont(new Font("Serif", Font.ITALIC, 20));
        cedula.setBounds(420, 660, 270, 30);

        //Añado los labels al GridLayou
        panel.add(idHistorial);
        panel.add(buscarPaciente);
        panel.add(lblNombre);
        panel.add(nombre);
        panel.add(lblApellidos);
        panel.add(apellidos);
        panel.add(lblTelefono);
        panel.add(telefono);
        panel.add(lblDireccion);
        panel.add(ciudad);
        panel.add(calle);
        panel.add(numero);
        panel.add(lblCedula);
        panel.add(cedula);
        /*registro.add(new TextField("HOLA"));
        registro.add(new Label("RECUERDE LLENAR TODOS LOS CAMPOS ANTES DE REGISTAR!"));*/
        panel.add(modificarPaciente);
        buscarPaciente.addActionListener(new ActionListenerPacienteBuscarPaciente(idHistorial, nombre, apellidos, telefono, cedula, calle, numero, numero, medicos, medicos, ciudad));
        modificarPaciente.addActionListener(new ActionListenerPacienteModifico(idHistorial, nombre, apellidos, telefono, cedula, calle, numero, numero, medicos, medicos, ciudad));
        nombre.addKeyListener(new KeyListenerLetras());
        apellidos.addKeyListener(new KeyListenerLetras());
        ciudad.addKeyListener(new KeyListenerLetras());
        calle.addKeyListener(new KeyListenerLetras());
        telefono.addKeyListener(new KeyListenerNumero());
        numero.addKeyListener(new KeyListenerNumero());
        cedula.addKeyListener(new KeyListenerNumero());
         this.add(panel);
        this.setVisible(true);
    }
     
}
