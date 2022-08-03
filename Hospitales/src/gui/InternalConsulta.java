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
import javax.swing.JComboBox;
import javax.swing.JPanel;
import listeners.ActionListenerConsultaBuscarPaciente;
import static listeners.ActionListenerConsultaBuscarPaciente.historial;
import listeners.ActionListenerConsultaRegistrar;
import listeners.ActionListenerPacienteModifico;
import listeners.KeyListenerLetras;
import listeners.KeyListenerNumero;



/**
 *
 * @author GAMER
 */
public class InternalConsulta extends javax.swing.JInternalFrame{
    Label label;
    Dimension dimension2 = new Dimension(900, 900);
    Button modificar;
    Button generarConsulta,buscarPaciente;
    JPanel panel;
    JPanel registro,modifico,consulto;
    private TextArea medicos,diagnostico,receta;
    Especialidad especialidades;
    TextField nombre, apellidos,telefono,cedula,ciudad,calle,numero,idHistorial,consultorio;
    
/**
* Constructor con los componentes que pertenecen a la interfaz de consulta
*
* Creado el 04 de Marzo, 2022, 13:00 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/
    public InternalConsulta() {
        this.pack();
        this.setBackground(Color.white);
        label=new Label("CONSULTA");
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
        Label lblNombre = new Label("NOMBRE :");
        lblNombre.setFont(new Font("Serif", Font.PLAIN, 30));
        lblNombre.setBounds(10, 90, 150, 50);

        Label lblApellidos = new Label("APELLIDO :");
        lblApellidos.setFont(new Font("Serif", Font.PLAIN, 30));
        lblApellidos.setBounds(460, 90, 190, 50);

        Label lblTelefono = new Label("TELEFONO :");
        lblTelefono.setFont(new Font("Serif", Font.PLAIN, 30));
        lblTelefono.setBounds(10, 160, 190, 50);
        
         Label lblcedula = new Label("CEDULA :");
        lblcedula.setFont(new Font("Serif", Font.PLAIN, 30));
        lblcedula.setBounds(460, 160, 190, 50);
        
        Label lbldireccion = new Label("DIRECCION :");
        lbldireccion.setFont(new Font("Serif", Font.PLAIN, 30));
        lbldireccion.setBounds(10, 230, 190, 50);

        Label lblConsultorio = new Label("CONSULTORIO :");
        lblConsultorio.setFont(new Font("Serif", Font.PLAIN, 30));
        lblConsultorio.setBounds(150, 300, 270, 50);

        Label lblDiagnostico = new Label("DIAGNOSTICO :");
        lblDiagnostico.setFont(new Font("Serif", Font.PLAIN, 30));
        lblDiagnostico.setBounds(10, 400, 270, 50);

        Label lblReceta = new Label("RECETA :");
        lblReceta.setFont(new Font("Serif", Font.PLAIN, 30));
        lblReceta.setBounds(10, 550, 270, 50);

        //creo el Boton
        
        generarConsulta=new Button("GENERAR");
        generarConsulta.setFont(new Font("Serif", Font.BOLD, 40));
        generarConsulta.setBounds(300, 800, 270, 50);

        
         //creo el boton para buscar por ruc 
        buscarPaciente=new Button("BUSCAR");
        buscarPaciente.setFont(new Font("Serif", Font.BOLD,20));
        buscarPaciente.setBounds(290,40,100,30);
        
        //creo los Texfield
                //creo el TextField boton para buscar por ruc 
        idHistorial=new TextField();
        idHistorial.setFont(new Font("Serif", Font.ITALIC, 20));
        idHistorial.setBounds(10,40,270,30);
        
        nombre=new TextField();
        nombre.setFont(new Font("Serif", Font.ITALIC, 20));
        nombre.setBounds(200, 100, 200, 30);

        apellidos=new TextField();
        apellidos.setFont(new Font("Serif", Font.ITALIC, 20));
        apellidos.setBounds(650, 100, 200, 30);

        telefono=new TextField();
        telefono.setFont(new Font("Serif", Font.ITALIC, 20));
        telefono.setBounds(200, 170, 200, 30);
                
        cedula=new TextField();
        cedula.setFont(new Font("Serif", Font.ITALIC, 20));
        cedula.setBounds(650, 170, 200, 30);

        
        ciudad=new TextField();
        ciudad.setFont(new Font("Serif", Font.ITALIC, 20));
        ciudad.setBounds(220, 240, 200, 30);

        calle=new TextField();
        calle.setFont(new Font("Serif", Font.ITALIC, 20));
        calle.setBounds(440, 240, 200, 30);

        numero=new TextField();
        numero.setFont(new Font("Serif", Font.ITALIC, 20));
        numero.setBounds(660, 240, 200, 30);

        consultorio=new TextField();
        consultorio.setFont(new Font("Serif", Font.ITALIC, 20));
        consultorio.setBounds(440, 310, 200, 30);
        
        diagnostico=new TextArea();
        diagnostico.setFont(new Font("Serif", Font.ITALIC, 20));
        diagnostico.setBounds(300, 400, 500, 100);

        receta=new TextArea();
        receta.setFont(new Font("Serif", Font.ITALIC, 20));
        receta.setBounds(300, 550, 500, 100);

        //Añado los labels al GridLayou
        panel.add(lblNombre);
        panel.add(nombre);
        panel.add(lblApellidos);
        panel.add(apellidos);
        panel.add(lblTelefono);
         panel.add(lbldireccion);
        panel.add(telefono);
        panel.add(lblcedula);
        panel.add(lblConsultorio);
        panel.add(ciudad);
        panel.add(calle);
        panel.add(numero);
        panel.add(receta);
        panel.add(diagnostico);
        panel.add(lblDiagnostico);
        panel.add(lblReceta);
        panel.add(cedula);
         panel.add(idHistorial);
         panel.add(buscarPaciente);
         panel.add(consultorio);
        /*registro.add(new TextField("HOLA"));
        registro.add(new Label("RECUERDE LLENAR TODOS LOS CAMPOS ANTES DE REGISTAR!"));*/
        panel.add(generarConsulta);
        buscarPaciente.addActionListener(new ActionListenerConsultaBuscarPaciente(idHistorial,nombre,apellidos,telefono,cedula,calle,numero,consultorio,diagnostico,receta,ciudad));
        generarConsulta.addActionListener(new ActionListenerConsultaRegistrar(historial,nombre,apellidos,telefono,cedula,calle,numero,consultorio,diagnostico,receta,ciudad));
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
