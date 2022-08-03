package listeners;

import clases.Archivo;
import clases.Direccion;
import clases.Validacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.InternalHospital;
import gui.JfPrincipal;
import static gui.JfPrincipal.listaPaciente;
import java.awt.TextArea;
import java.awt.TextField;
import javax.swing.JPanel;
import static listeners.ActionListenerPacienteBuscarPaciente.historialPaciente;

public class ActionListenerPacienteModifico implements ActionListener {
	
        TextField idHistorial,  nombre,  apellidos,  telefono,  cedula,  calle,  numero,  numero0;
        TextArea medicos, medicos0;
        TextField ciudad;
        Archivo archivo=new Archivo();

    public ActionListenerPacienteModifico(TextField idHistorial, TextField nombre, TextField apellidos, TextField telefono, TextField cedula, TextField calle, TextField numero, TextField numero0, TextArea medicos, TextArea medicos0, TextField ciudad) {
        this.idHistorial = idHistorial;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.cedula = cedula;
        this.calle = calle;
        this.numero = numero;
        this.numero0 = numero0;
        this.medicos = medicos;
        this.medicos0 = medicos0;
        this.ciudad = ciudad;
    }
	

	     /**
*Evento que permite modificar un paciente 
*
* Creado el 06 de Marzo, 2022, 11:30 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/   
	@Override
	public void actionPerformed(ActionEvent e) {
            if( nombre.getText().toString().trim().length()>0 &&  apellidos.getText().toString().trim().length()>0  &&  telefono.getText().toString().trim().length()>0 &&  cedula.getText().toString().trim().length()>0 &&  calle.getText().toString().trim().length()>0 &&  numero.getText().toString().trim().length()>0&&ciudad.getText().toString().trim().length()>0){
                if(telefono.getText().toString().trim().length()==10&&cedula.getText().toString().trim().length()==10){
                    boolean guardado=false;
                    if(historialPaciente!=null){
                        Validacion validar=new Validacion();
                        if(validar.validarApellido(apellidos.getText().toString().trim())){
                            try{
                                archivo.leerBinario("pacientes");
                                for(int i=0;i<listaPaciente.size();i++){
                                    if(listaPaciente.get(i).getId_Historial().equalsIgnoreCase(historialPaciente)){
                                        System.out.println(apellidos.getText().toString().trim());
                                        listaPaciente.get(i).setApellidos(apellidos.getText().toString().trim());
                                        listaPaciente.get(i).setCedula(cedula.getText().toString().trim());
                                        listaPaciente.get(i).getDirecciones().setCiudad(ciudad.getText().toString().trim());
                                        listaPaciente.get(i).getDirecciones().setCalle(calle.getText().toString().trim());
                                        listaPaciente.get(i).getDirecciones().setCiudad(numero.getText().toString().trim());
                                        listaPaciente.get(i).setNombre(nombre.getText().toString().trim());
                                        listaPaciente.get(i).setTelefono(telefono.getText().toString().trim());
                                    }
                                }
                                archivo.eliminarFichero("pacientes");
                                for(int i=0;i<listaPaciente.size();i++){
                                    if(i==0){
                                        archivo.escribirBinario("pacientes", listaPaciente.get(i));
                                        guardado=true;
                                    }else{
                                        archivo.añadirBinario("pacientes", listaPaciente.get(i));
                                        guardado=true;
                                    }
                                }
                                if(guardado){
                                    JOptionPane.showMessageDialog(null, "SE HA MODIFICADO CORRECTAMENTE");
                                }
                            }catch(Exception a){
                                System.err.println(a);
                                JOptionPane.showMessageDialog(null, "ERROR AL TRATAR DE MODIFCAR PACIENTE, REVISE LOS CAMPOS");
                            }                            
                        }else{
                             JOptionPane.showMessageDialog(null, "EL APELLIDO DEBE TENER ESTE ESTILO 'Apellido Apellido'");
                        }

                    }else{
                        JOptionPane.showMessageDialog(null, "PRIMERO BUSQUE UN PACIENTE A MODIFICAR");
                    }                  
                }else{
                    JOptionPane.showMessageDialog(null, "CEDULA Y TELEFONO DEBE TENER 10 NUMEROS");
                }
                
              
            }else{
                JOptionPane.showMessageDialog(null, "NO PUEDEN HABER CAMPOS VACIOS");
            }
            
	}
}
