/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import clases.Consulta;
import clases.Hospital;
import clases.Medico;
import clases.Paciente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import listeners.ActionListenerConsulta;
import listeners.ActionListenerHospital;
import listeners.ActionListenerMedico;
import listeners.ActionListenerPaciente;
import listeners.ActionListenerReportes;

/**
 *
 * @author GAMER
 */
public class JfPrincipal extends javax.swing.JFrame{
    public static  ArrayList<Medico> listaMedico;
    public static  ArrayList<Paciente> listaPaciente;
    public static  ArrayList<Consulta> listaConsulta;
    public static  ArrayList<Hospital> listaHospital;
    JDesktopPane pantalla;
    JMenuBar barra;
    JMenu menu,salir,menuConsulta,reportes;
    JMenuItem hospital,paciente,medico,crearConsulta,verReportes;
    Label label;
    Dimension dimension = new Dimension(1000, 1000);
    Dimension dimension2 = new Dimension(900, 900);
     /**
* Constructor del apartado principal que contiene los componentes de un panel de bienvenida 
*
* Creado el 02 de Marzo, 2022, 01:30 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/   
    
    public JfPrincipal() {
        super("Principal");
        listaHospital=new ArrayList<>();
        listaMedico=new ArrayList<>();
        listaConsulta=new ArrayList<>();
        listaPaciente=new  ArrayList<>();
        label=new Label();
        label.setSize(800, 200);
        label.setText("GESTIONADOR DE CONSULTAS HOSPITALARIAS");
        label.setFont(new Font("Serif", Font.PLAIN, 36));
        //genero el JdesktopPanel para alojar los Internal Frames
        pantalla=new JDesktopPane();
        pantalla.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        //propiedades principales del Jframe (agrego la pantalla y dimensiones minimas y maximas del frame)
        pantalla.setBackground(Color.black);
        this.getContentPane().add(pantalla,BorderLayout.CENTER);
        this.setPreferredSize(dimension);
        this.setSize(1000, 1000);
        this.setMaximumSize(dimension);
        this.setMinimumSize(dimension);
        this.setDefaultCloseOperation(JfPrincipal.EXIT_ON_CLOSE);
        setResizable(false);
        
        instanciarBarra();
        crearBarra( barra,  menu,menuConsulta, hospital,crearConsulta, paciente, medico,reportes,verReportes);
        
        //agrego la barra personalizada al Jframe o ventana principal
        this.setJMenuBar(barra);
        //agrego los listener a cada boton del menu
        hospital.addActionListener(new ActionListenerHospital(pantalla));
        medico.addActionListener(new ActionListenerMedico(pantalla));
        paciente.addActionListener(new ActionListenerPaciente(pantalla));
        crearConsulta.addActionListener(new ActionListenerConsulta(pantalla));
        verReportes.addActionListener(new ActionListenerReportes(pantalla));
        //creo un internalFrame de Bienvenida
        crearInternal(pantalla);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
         /**
* Función que permite instanciar la barra principal en conjunto de sus ítems 
*
* Creado el 02 de Marzo, 2022, 02:00 horas
*
* @authores: Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/   
    private void instanciarBarra(){
        //creo la barra de opcions
        barra = new JMenuBar();
        //creo un boton para la barra de opciones
        menu = new JMenu("ADMINISTRACION");
        //creo botones que son las opciones del menu
        hospital = new JMenuItem("HOSPITAL");
        medico = new JMenuItem("MEDICO");
        
        menuConsulta=new JMenu("CONSULTA");
        crearConsulta=new JMenuItem("CREAR");
        paciente = new JMenuItem("PACIENTE");
        
        
        reportes=new JMenu("REPORTES");
        verReportes=new JMenuItem("VER");
    }
    
         /**
* Función que permite la creación de la barra principal del sistema 
*
* Creado el 02 de Marzo, 2022, 02:10 horas
*
* @authores: Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/   
    private void crearBarra(JMenuBar barra, JMenu menu,JMenu menuConsulta,JMenuItem hospital,JMenuItem crearConsulta,JMenuItem paciente,JMenuItem medico,JMenu reportes,JMenuItem verReportes){
        //agrego los botones abteriores al menu
        menu.add(hospital);
        menu.add(medico);
        menu.add(paciente);
        //añado todo el menu realizado a la barra
        barra.add(menu);
        
        menuConsulta.add(crearConsulta);
        barra.add(menuConsulta);
        
        reportes.add(verReportes);
        barra.add(reportes);
    }
    
         /**
* Función que permite crear el internal Frame que alojará las diferentes vistas del sistema 
*
* Creado el 02 de Marzo, 2022, 02:40 horas
*
* @authores: Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/   
    private void crearInternal(JDesktopPane pantalla){
        JInternalFrame internalF = new JInternalFrame("internalFrame");
        internalF.setBackground(Color.white);
        internalF.setLayout(new FlowLayout());
        internalF.add(label);
        
        ImageIcon imagen=new ImageIcon("src/image/logo.png");
        JLabel lbl=new JLabel();
        lbl.setBounds(0, 70, 900, 700);
        lbl.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH)));
        internalF.add(lbl);
        this.repaint();
        //caracteristicas del internalFrame
        internalF.pack();
        internalF.setResizable(true);
	internalF.setClosable(true);
        internalF.setMaximizable(true);
        internalF.setSize(900, 900);
        internalF.setMaximumSize(dimension2);
        //agrego el internalFrame al desktop dentro del JFrame
        pantalla.add(internalF);
        internalF.setVisible(true);
        
    }
    
}
