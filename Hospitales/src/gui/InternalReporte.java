/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import clases.Archivo;
import clases.Consulta;
import clases.Direccion;
import clases.Especialidad;
import clases.Hospital;
import clases.Medico;
import clases.Paciente;
import static gui.InternalHospital.base;
import static gui.JfPrincipal.listaConsulta;
import static gui.JfPrincipal.listaHospital;
import static gui.JfPrincipal.listaMedico;
import static gui.JfPrincipal.listaPaciente;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import listeners.ActionListenerConsultaConsultas;
import listeners.ActionListenerConsultaHospitales;
import listeners.ActionListenerConsultaMedicos;
import listeners.ActionListenerConsultaPacientes;
import listeners.ActionListenerHospitalPantallas;
import listeners.ActionListenerPacienteModifico;
import listeners.ActionListenerPaginadoConsulta;
import listeners.ActionListenerPaginadoHospitales;
import listeners.ActionListenerPaginadoMedicos;
import listeners.ActionListenerPaginadoPaciente;




public class InternalReporte extends javax.swing.JInternalFrame{
    

    JScrollPane scrollHospital,scrollMedico,scrollPaciente,scrollConsulta;
    public int base=25;
    Label label,label2;
    JLabel paginaActual,paginaFinal,conector;
    JPanel superior,inferior,derecha,izquierda;
    JPanel hospitalPanel,medicoPanel,pacientePanel,consultaPanel;
    JButton avanzarPagina,retrocederPagina;
    Button hospitales,medicos,pacientes,consulta;
    TextField nombre,ruc,telefono,ciudad,calle,numero,rucHospital;
    Button registrarHospital,modificarHospital,consultarHospital;
    Dimension dimensionSuperior = new Dimension(900, 50);
    Dimension dimensionInferior = new Dimension(900, 800);
    Dimension dimension2 = new Dimension(900, 900);
    JTable tablaConsulta=new JTable();
    DefaultTableModel modeloConsulta= (DefaultTableModel) tablaConsulta.getModel(); 
     JTable tablaHospital=new JTable();
    DefaultTableModel modeloHospital= (DefaultTableModel) tablaHospital.getModel(); 
     JTable tablaMedico=new JTable();
    DefaultTableModel modeloMedico= (DefaultTableModel) tablaMedico.getModel(); 
     JTable tablaPaciente=new JTable();
    DefaultTableModel modeloPaciente= (DefaultTableModel) tablaPaciente.getModel(); 
    /**
* Constructor con los componentes que pertenecen a la interfaz de reporte
*
* Creado el 05 de Marzo, 2022, 13:00 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/
    public InternalReporte() {
        this.pack();
        label=new Label();
        label.setSize(800, 50);
        label.setText("REPORTES");
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
        
        hospitales=new Button("HOSPITALES");
        medicos=new Button("MEDICOS");
        pacientes=new Button("PACIENTES");
        consulta=new Button("CONSULTAS");
        
        hospitales.setBackground(Color.black);
        hospitales.setForeground(Color.white);
        medicos.setBackground(Color.black);
        medicos.setForeground(Color.white);
        pacientes.setBackground(Color.black);
        pacientes.setForeground(Color.white);
        consulta.setBackground(Color.black);
        consulta.setForeground(Color.white);
        
        izquierda.add(hospitales);
        izquierda.add(medicos);
        izquierda.add(pacientes);
        izquierda.add(consulta);
        
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

        
        //modelo
        setearModeloConsulta();
        setearModeloHospital();
        setearModeloMedico();
        setearModeloPaciente();
        //crear paneles para crud
        mostrarHospitales();
        mostrarMedicos();
        mostrarPacientes();
        mostrarConsultas();
 
        //action listener
        hospitales.addActionListener(new ActionListenerConsultaHospitales(derecha,hospitalPanel));
        medicos.addActionListener(new ActionListenerConsultaMedicos(derecha,medicoPanel));
        pacientes.addActionListener(new ActionListenerConsultaPacientes(derecha,pacientePanel));    
        consulta.addActionListener(new ActionListenerConsultaConsultas(derecha,consultaPanel));    
    }
        /**
* funcion que genera el modelo para la tabla de consulta
*
* Creado el 05 de Marzo, 2022, 20:00 horas
*
* @authores: Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/
    private void setearModeloConsulta(){
        modeloConsulta.addColumn("id");
        modeloConsulta.addColumn("fecha");
        modeloConsulta.addColumn("consultorio"); 
        modeloConsulta.addColumn("diagnostico");
        modeloConsulta.addColumn("receta");
        modeloConsulta.addColumn("medico");
        modeloConsulta.addColumn("paciente");
        modeloConsulta.addColumn("fila");
    }
            /**
* funcion que genera el modelo para la tabla de hospital
*
* Creado el 05 de Marzo, 2022, 23:00 horas
*
* @authores: Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/
       private void setearModeloHospital(){
        modeloHospital.addColumn("nombre");
        modeloHospital.addColumn("ruc");
        modeloHospital.addColumn("telefono"); 
        modeloHospital.addColumn("direccion");
        modeloHospital.addColumn("fila");
    }
       
               /**
* funcion que genera el modelo para la tabla de medico
*
* Creado el 05 de Marzo, 2022, 23:30 horas
*
* @authores: Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/
          private void setearModeloMedico(){
        modeloMedico.addColumn("carnet");
        modeloMedico.addColumn("especialidad");
        modeloMedico.addColumn("nombre"); 
        modeloMedico.addColumn("apellido");
        modeloMedico.addColumn("telefono");
        modeloMedico.addColumn("cedula");
        modeloMedico.addColumn("direccion");
        modeloMedico.addColumn("fila");
    }
          
                  /**
* funcion que genera el modelo para la tabla de paciente
*
* Creado el 05 de Marzo, 2022, 23:40 horas
*
* @authores: Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/
             private void setearModeloPaciente(){
        modeloPaciente.addColumn("id_Historial");
        modeloPaciente.addColumn("nombre");
        modeloPaciente.addColumn("apellido"); 
        modeloPaciente.addColumn("cedula");
        modeloPaciente.addColumn("telefono");
        modeloPaciente.addColumn("direccion");
        modeloPaciente.addColumn("fila");
    }
                     /**
* funcion que genera el listado de hospitales
*
* Creado el 05 de Marzo, 2022, 23:40 horas
*
* @authores: Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/
        private void mostrarHospitales(){
        hospitalPanel=new JPanel();
        hospitalPanel.setBackground(Color.white);
        hospitalPanel.setBounds(0, 0, 800, 850);
        hospitalPanel.setLayout(null);
        
        Archivo archivo=new Archivo();
        archivo.leerBinario("hospitales");
        System.out.println("total"+listaHospital.size());;
        String[][] rec = new String [listaHospital.size()][7];
        for(int i=0;i<listaHospital.size();i++){
            if(i<base){
                Object [] fila=new Object[5]; 
 
                fila[0]=listaHospital.get(i).getNombre(); 
                fila[1]=listaHospital.get(i).getRuc(); 
                fila[2]=listaHospital.get(i).getTelefono(); 
                fila[3]=listaHospital.get(i).getDireccion().getCiudad()+listaHospital.get(i).getDireccion().getCalle()+listaHospital.get(i).getDireccion().getNumero(); 
                fila[4]=i+1; 
                modeloHospital.addRow(fila); 
            }
           /* rec[i][]={"id", "fecha", "consultorio","diagnostico","receta","medico","paciente"}*/
        }
         
        tablaHospital.setModel(modeloHospital);
        tablaHospital.setVisible(true);
        tablaHospital.setBounds(90, 80,600, 400);
        
        
        hospitalPanel.add(tablaHospital);
      
        scrollHospital=new JScrollPane(tablaHospital);
        scrollHospital.setBounds(90, 80,600, 400);
        
        paginaActual=new JLabel("1");
        paginaActual.setBounds(323, 720,40, 20);
        paginaActual.setFont(new Font("Serif", Font.PLAIN, 20));
        
        conector=new JLabel("DE"); 
        conector.setBounds(378, 720,40, 20);
        conector.setFont(new Font("Serif", Font.PLAIN, 10));
        int contador = 0;
        for(int i=listaHospital.size();i>0;i--){
            if(i%25==0){
                contador++;
            }
        }
        if((25*contador)<listaHospital.size()){
            contador++;
        }
        paginaFinal=new JLabel(String.valueOf(contador));
        paginaFinal.setBounds(443, 720,40, 20);
        paginaFinal.setFont(new Font("Serif", Font.PLAIN, 20));
        
        
        avanzarPagina=new JButton(">>>");
        avanzarPagina.setFont(new Font("Serif", Font.BOLD, 30));
        avanzarPagina.setBounds(500, 700,80, 50);
        avanzarPagina.addActionListener(new ActionListenerPaginadoHospitales(this,tablaHospital,modeloHospital,avanzarPagina,paginaActual));
        
        retrocederPagina=new JButton("<<<");
        retrocederPagina.setFont(new Font("Serif", Font.BOLD, 30));
        retrocederPagina.setBounds(200, 700,80, 50);
        retrocederPagina.addActionListener(new ActionListenerPaginadoHospitales(this,tablaHospital,modeloHospital,retrocederPagina,paginaActual));
        
        hospitalPanel.add(scrollHospital);
        hospitalPanel.add(avanzarPagina);
        hospitalPanel.add(retrocederPagina);
        hospitalPanel.add(paginaActual);
        hospitalPanel.add(paginaFinal);
        hospitalPanel.add(conector);
    }
                /**
* funcion que genera el listado de medicos
*
* Creado el 05 de Marzo, 2022, 23:50 horas
*
* @authores: Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/
        private void mostrarMedicos(){
        medicoPanel=new JPanel();
        medicoPanel.setBackground(Color.white);
        medicoPanel.setBounds(0, 0, 800, 850);
        medicoPanel.setLayout(null);
        
          
        Archivo archivo=new Archivo();
        archivo.leerBinario("medicos");

        for(int i=0;i<listaMedico.size();i++){
            if(i<base){
                Object [] fila=new Object[8]; 
 
                fila[0]=listaMedico.get(i).getCarnet(); 
                fila[1]=listaMedico.get(i).getEspecialidad(); 
                fila[2]=listaMedico.get(i).getNombre(); 
                fila[3]=listaMedico.get(i).getApellidos(); 
                fila[4]=listaMedico.get(i).getTelefono(); 
                fila[5]=listaMedico.get(i).getCedula();
                fila[6]=listaMedico.get(i).getDirecciones().getCiudad()+listaMedico.get(i).getDirecciones().getCalle()+String.valueOf(listaMedico.get(i).getDirecciones().getNumero());
                fila[7]=i+1; 
                modeloMedico.addRow(fila); 
            }
           /* rec[i][]={"id", "fecha", "consultorio","diagnostico","receta","medico","paciente"}*/
        }
         
        tablaMedico.setModel(modeloMedico);
        tablaMedico.setVisible(true);
        tablaMedico.setBounds(90, 80,600, 400);
        
        
        medicoPanel.add(tablaMedico);
      
        scrollMedico=new JScrollPane(tablaMedico);
        scrollMedico.setBounds(90, 80,600, 400);
        
        paginaActual=new JLabel("1");
        paginaActual.setBounds(323, 720,40, 20);
        paginaActual.setFont(new Font("Serif", Font.PLAIN, 20));
        
        conector=new JLabel("DE"); 
        conector.setBounds(378, 720,40, 20);
        conector.setFont(new Font("Serif", Font.PLAIN, 10));
        int contador = 0;
        for(int i=listaMedico.size();i>0;i--){
            if(i%25==0){
                contador++;
            }
        }
        if((25*contador)<listaMedico.size()){
            contador++;
        }
        paginaFinal=new JLabel(String.valueOf(contador));
        paginaFinal.setBounds(443, 720,40, 20);
        paginaFinal.setFont(new Font("Serif", Font.PLAIN, 20));
        
        
        avanzarPagina=new JButton(">>>");
        avanzarPagina.setFont(new Font("Serif", Font.BOLD, 30));
        avanzarPagina.setBounds(500, 700,80, 50);
        avanzarPagina.addActionListener(new ActionListenerPaginadoMedicos(this,tablaMedico,modeloMedico,avanzarPagina,paginaActual));
        
        retrocederPagina=new JButton("<<<");
        retrocederPagina.setFont(new Font("Serif", Font.BOLD, 30));
        retrocederPagina.setBounds(200, 700,80, 50);
        retrocederPagina.addActionListener(new ActionListenerPaginadoMedicos(this,tablaMedico,modeloMedico,retrocederPagina,paginaActual));
        
        medicoPanel.add(scrollMedico);
        medicoPanel.add(avanzarPagina);
        medicoPanel.add(retrocederPagina);
        medicoPanel.add(paginaActual);
        medicoPanel.add(paginaFinal);
        medicoPanel.add(conector);
    }
                /**
* funcion que genera el listado de pacientes
*
* Creado el 05 de Marzo, 2022, 24:00 horas
*
* @authores: Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/
        private void mostrarPacientes(){
        pacientePanel=new JPanel();
        pacientePanel.setBackground(Color.white);
        pacientePanel.setBounds(0, 0, 800, 850);
        pacientePanel.setLayout(null);
       
        Archivo archivo=new Archivo();
        archivo.leerBinario("pacientes");

        System.out.println(listaPaciente.size());
        for(int i=0;i<listaPaciente.size();i++){
            if(i<base){
                Object [] fila=new Object[7]; 
 
                fila[0]=listaPaciente.get(i).getId_Historial(); 
                fila[1]=listaPaciente.get(i).getNombre(); 
                fila[2]=listaPaciente.get(i).getApellidos(); 
                fila[3]=listaPaciente.get(i).getCedula(); 
                fila[4]=listaPaciente.get(i).getTelefono(); 
                fila[5]=listaPaciente.get(i). getDirecciones().getCiudad()+" "+listaPaciente.get(i).getDirecciones().getCalle()+" "+listaPaciente.get(i).getDirecciones().getNumero();
                fila[6]=i+1; 
                modeloPaciente.addRow(fila); 
            }
           /* rec[i][]={"id", "fecha", "consultorio","diagnostico","receta","medico","paciente"}*/
        }
         
        tablaPaciente.setModel(modeloPaciente);
        tablaPaciente.setVisible(true);
        tablaPaciente.setBounds(90, 80,600, 400);
        
        
        pacientePanel.add(tablaPaciente);
      
        scrollPaciente=new JScrollPane(tablaPaciente);
        scrollPaciente.setBounds(90, 80,600, 400);
        
        paginaActual=new JLabel("1");
        paginaActual.setBounds(323, 720,40, 20);
        paginaActual.setFont(new Font("Serif", Font.PLAIN, 20));
        
        conector=new JLabel("DE"); 
        conector.setBounds(378, 720,40, 20);
        conector.setFont(new Font("Serif", Font.PLAIN, 10));
        int contador = 0;
        for(int i=listaPaciente.size();i>0;i--){
            if(i%25==0){
                contador++;
            }
        }
        if((25*contador)<listaPaciente.size()){
            contador++;
        }
        paginaFinal=new JLabel(String.valueOf(contador));
        paginaFinal.setBounds(443, 720,40, 20);
        paginaFinal.setFont(new Font("Serif", Font.PLAIN, 20));
        
        
        avanzarPagina=new JButton(">>>");
        avanzarPagina.setFont(new Font("Serif", Font.BOLD, 30));
        avanzarPagina.setBounds(500, 700,80, 50);
        avanzarPagina.addActionListener(new ActionListenerPaginadoPaciente(this,tablaPaciente,modeloPaciente,avanzarPagina,paginaActual));
        
        retrocederPagina=new JButton("<<<");
        retrocederPagina.setFont(new Font("Serif", Font.BOLD, 30));
        retrocederPagina.setBounds(200, 700,80, 50);
        retrocederPagina.addActionListener(new ActionListenerPaginadoPaciente(this,tablaPaciente,modeloPaciente,retrocederPagina,paginaActual));
        
        pacientePanel.add(scrollPaciente);
        pacientePanel.add(avanzarPagina);
        pacientePanel.add(retrocederPagina);
        pacientePanel.add(paginaActual);
        pacientePanel.add(paginaFinal);
        pacientePanel.add(conector);
    }
                /**
* funcion que genera el listado de consultas
*
* Creado el 06 de Marzo, 2022, 10:30 horas
*
* @authores: Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/
        private void mostrarConsultas(){
        consultaPanel=new JPanel();
        consultaPanel.setBackground(Color.white);
        consultaPanel.setBounds(0, 0, 800, 850);
        consultaPanel.setLayout(null);
       
          
        Archivo archivo=new Archivo();
        archivo.leerBinario("consulta");

        String[][] rec = new String [listaConsulta.size()][7];
        for(int i=0;i<listaConsulta.size();i++){
            if(i<base){
                Object [] fila=new Object[8]; 
 
                fila[0]=listaConsulta.get(i).getId(); 
                fila[1]=listaConsulta.get(i).getFecha(); 
                fila[2]=listaConsulta.get(i).getConsultorio(); 
                fila[3]=listaConsulta.get(i).getDiagnostico(); 
                fila[4]=listaConsulta.get(i).getReceta(); 
                fila[5]=listaConsulta.get(i).getMedico().getNombre()+" "+listaConsulta.get(i).getMedico().getApellidos(); 
                fila[6]=listaConsulta.get(i).getPaciente().getNombre()+" "+listaConsulta.get(i).getPaciente().getApellidos(); 
                fila[7]=i+1; 
                modeloConsulta.addRow(fila); 
            }
           /* rec[i][]={"id", "fecha", "consultorio","diagnostico","receta","medico","paciente"}*/
        }
         
        tablaConsulta.setModel(modeloConsulta);
        tablaConsulta.setVisible(true);
        tablaConsulta.setBounds(90, 80,600, 400);
        
        
        consultaPanel.add(tablaConsulta);
      
        scrollConsulta=new JScrollPane(tablaConsulta);
        scrollConsulta.setBounds(90, 80,600, 400);
        
        paginaActual=new JLabel("1");
        paginaActual.setBounds(323, 720,40, 20);
        paginaActual.setFont(new Font("Serif", Font.PLAIN, 20));
        
        conector=new JLabel("DE"); 
        conector.setBounds(378, 720,40, 20);
        conector.setFont(new Font("Serif", Font.PLAIN, 10));
        int contador = 0;
        for(int i=listaConsulta.size();i>0;i--){
            if(i%25==0){
                contador++;
            }
        }
        if((25*contador)<listaConsulta.size()){
            contador++;
        }
        paginaFinal=new JLabel(String.valueOf(contador));
        paginaFinal.setBounds(443, 720,40, 20);
        paginaFinal.setFont(new Font("Serif", Font.PLAIN, 20));
        
        
        avanzarPagina=new JButton(">>>");
        avanzarPagina.setFont(new Font("Serif", Font.BOLD, 30));
        avanzarPagina.setBounds(500, 700,80, 50);
        avanzarPagina.addActionListener(new ActionListenerPaginadoConsulta(this,tablaConsulta,modeloConsulta,avanzarPagina,paginaActual));
        
        retrocederPagina=new JButton("<<<");
        retrocederPagina.setFont(new Font("Serif", Font.BOLD, 30));
        retrocederPagina.setBounds(200, 700,80, 50);
        retrocederPagina.addActionListener(new ActionListenerPaginadoConsulta(this,tablaConsulta,modeloConsulta,retrocederPagina,paginaActual));
        
        consultaPanel.add(scrollConsulta);
        consultaPanel.add(avanzarPagina);
        consultaPanel.add(retrocederPagina);
        consultaPanel.add(paginaActual);
        consultaPanel.add(paginaFinal);
        consultaPanel.add(conector);
    }

}
