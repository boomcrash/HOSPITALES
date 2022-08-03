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

public class ActionListenerConsultaBuscarPaciente implements ActionListener {
	
        private TextField idHistorial,nombre,apellidos,telefono,cedula,calle,numero,consultorio,ciudad;
        private TextArea diagnostico,receta;
        public static String historial=null;


    public ActionListenerConsultaBuscarPaciente(TextField idHistorial, TextField nombre, TextField apellidos, TextField telefono, TextField cedula, TextField calle, TextField numero, TextField consultorio, TextArea diagnostico, TextArea receta,TextField ciudad) {
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
* Evento que permite validar el carnet del médico para ingresar al panel de médico 
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
            boolean bool=false;
            try{
                if(idHistorial.getText().toString().trim().length()>0){
                    Archivo archivo=new Archivo();
                    if(archivo.validarArchivo("pacientes")){
                        JOptionPane.showMessageDialog(null,"El archivo pacientes no existe aun : (Agregue un registro paciente)");
                    }else{
                         archivo.leerBinario("pacientes");        
                         for(int i=0;i<listaPaciente.size();i++){
                             if(idHistorial.getText().toString().equalsIgnoreCase(listaPaciente.get(i).getId_Historial())){
                                historial=listaPaciente.get(i).getId_Historial();
                                idHistorial.setEditable(false);
                                nombre.setText(listaPaciente.get(i).getNombre());
                                nombre.setEditable(false);
                                 apellidos.setText(listaPaciente.get(i).getApellidos());
                                apellidos.setEditable(false);
                                  telefono.setText(listaPaciente.get(i).getTelefono());
                                telefono.setEditable(false);
                                cedula.setText(listaPaciente.get(i).getCedula());
                                cedula.setEditable(false);
                                 calle.setText(listaPaciente.get(i).getDirecciones().getCalle());
                                calle.setEditable(false);
                                  numero.setText(String.valueOf(listaPaciente.get(i).getDirecciones().getNumero()));
                                numero.setEditable(false);
                                  ciudad.setText(listaPaciente.get(i).getDirecciones().getCiudad());  
                                ciudad.setEditable(false);
                                 bool=true;
                               }

                         }
                         if(bool==false){
                             JOptionPane.showMessageDialog(null,"NO EXISTE EL PACIENTE!");
                         }
                    }                
                }else{
                    JOptionPane.showMessageDialog(null,"EL CAMPO DE BUSQUEDA ESTA VACIO!");
                }
                       
            }catch(Exception a){
                System.out.print("");
            }
            if(listaPaciente.size()>0){
                System.out.println("Existen los pacientes");
            }else{
                System.out.print("No Existen pacientes");
            }    
        }

}
