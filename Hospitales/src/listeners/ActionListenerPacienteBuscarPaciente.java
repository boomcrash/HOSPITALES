package listeners;

import clases.Archivo;
import gui.InternalConsulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.InternalMedico;
import static gui.JfPrincipal.listaMedico;
import static gui.JfPrincipal.listaPaciente;
import java.awt.TextArea;
import java.awt.TextField;
import javax.swing.JDesktopPane;

public class ActionListenerPacienteBuscarPaciente implements ActionListener {
	
        private TextField idHistorial,nombre,apellidos,telefono,cedula,calle,numero,consultorio,ciudad;
        private TextArea diagnostico,receta;
        public static String historialPaciente=null;


    public ActionListenerPacienteBuscarPaciente(TextField idHistorial, TextField nombre, TextField apellidos, TextField telefono, TextField cedula, TextField calle, TextField numero, TextField consultorio, TextArea diagnostico, TextArea receta,TextField ciudad) {
        this.idHistorial = idHistorial;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.cedula = cedula;
        this.calle = calle;
        this.numero = numero;
        this.consultorio = consultorio;
        this.diagnostico = diagnostico;
        this.receta = receta;
        this.ciudad=ciudad;
    }
     /**
* Evento que permite buscar paciente
*
* Creado el 04 de Marzo, 2022, 11:00 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/   
    
    	@Override
	public void actionPerformed(ActionEvent e) {
            if(idHistorial.getText().toString().trim().length()>0){
                    boolean bool=false;
               try{
                   Archivo archivo=new Archivo();
                   if(archivo.validarArchivo("pacientes")){
                       JOptionPane.showMessageDialog(null,"El archivo pacientes no existe aun : (Agregue un registro paciente)");
                   }else{
                        archivo.leerBinario("pacientes");        
                        for(int i=0;i<listaPaciente.size();i++){
                            if(idHistorial.getText().toString().equalsIgnoreCase(listaPaciente.get(i).getId_Historial())){
                               historialPaciente=listaPaciente.get(i).getId_Historial();

                               nombre.setText(listaPaciente.get(i).getNombre());

                                apellidos.setText(listaPaciente.get(i).getApellidos());

                                 telefono.setText(listaPaciente.get(i).getTelefono());

                               cedula.setText(listaPaciente.get(i).getCedula());

                                calle.setText(listaPaciente.get(i).getDirecciones().getCalle());

                                 numero.setText(String.valueOf(listaPaciente.get(i).getDirecciones().getNumero()));

                                 ciudad.setText(listaPaciente.get(i).getDirecciones().getCiudad());  

                                bool=true;

                              }

                        }
                        if(bool==false){
                            JOptionPane.showMessageDialog(null,"NO EXISTE EL PACIENTE!");
                        }
                   }


               }catch(Exception a){
                   System.out.print("");
               }
               if(listaPaciente.size()>0){
                   System.out.println("Existen los pacientes");
               }else{
                   System.out.print("No Existen pacientes");
               }    
            }else{
                 JOptionPane.showMessageDialog(null,"CAMPO A BUSCAR VACIO!");
            }
           
        }

}
