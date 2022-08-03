package listeners;

import clases.Archivo;
import clases.Direccion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.InternalHospital;
import gui.JfPrincipal;
import static gui.JfPrincipal.listaHospital;
import static gui.JfPrincipal.listaPaciente;
import java.awt.TextArea;
import java.awt.TextField;
import javax.swing.JPanel;
import static listeners.ActionListenerHospitalBuscarHospital.rucHospitales;
import static listeners.ActionListenerPacienteBuscarPaciente.historialPaciente;

public class ActionListenerHospitalModifico implements ActionListener {
	
        TextField rucHospital,  nombre,  ruc,  telefono,  ciudad,  calle,  numero;
        Archivo archivo=new Archivo();

    public ActionListenerHospitalModifico(TextField rucHospital, TextField nombre, TextField ruc, TextField telefono, TextField ciudad, TextField calle, TextField numero) {
        this.rucHospital = rucHospital;
        this.nombre = nombre;
        this.ruc = ruc;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
    }



	

	     /**
*Evento que permite modificar un hospital 
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
            if(rucHospital.getText().toString().trim().length()>0 &&  nombre.getText().toString().trim().length()>0 && ruc.getText().toString().trim().length()>0 && telefono.getText().toString().trim().length()>0 && ciudad.getText().toString().trim().length()>0 && calle.getText().toString().trim().length()>0 && numero.getText().toString().trim().length()>0){
                boolean guardado=false;
                if(rucHospitales.length()>0){
                    if(telefono.getText().toString().trim().length()==10 && ruc.getText().toString().trim().length()==10){
                        try{
                            archivo.leerBinario("pacientes");
                            for(int i=0;i<listaHospital.size();i++){
                                if(listaHospital.get(i).getRuc().equalsIgnoreCase(rucHospitales)){

                                    System.out.println(ruc.getText().toString().trim());

                                    listaHospital.get(i).setNombre(nombre.getText().toString().trim());
                                    listaHospital.get(i).setRuc(ruc.getText().toString().trim());
                                    listaHospital.get(i).getDireccion().setCiudad(ciudad.getText().toString().trim());
                                    listaHospital.get(i).getDireccion().setCalle(calle.getText().toString().trim());
                                    listaHospital.get(i).getDireccion().setCiudad(numero.getText().toString().trim());

                                    listaHospital.get(i).setTelefono(telefono.getText().toString().trim());
                                }
                            }
                            archivo.eliminarFichero("Hospitales");
                            for(int i=0;i<listaHospital.size();i++){
                                if(i==0){
                                    archivo.escribirBinario("Hospitales", listaHospital.get(i));
                                    guardado=true;
                                }else{
                                    archivo.añadirBinario("Hospitales", listaHospital.get(i));
                                    guardado=true;
                                }
                            }
                            if(guardado){
                                JOptionPane.showMessageDialog(null, "SE HA MODIFICADO CORRECTAMENTE");
                            }
                        }catch(Exception a){
                            System.err.println(a);
                            JOptionPane.showMessageDialog(null, "ERROR AL TRATAR DE MODIFCAR HOSPITAL, REVISE LOS CAMPOS");
                        }                        
                    }else{
                                 JOptionPane.showMessageDialog(null, "RUC Y TELEFONO DEBE TENER 10 NUMEROS");
                    }

                }else{
                    JOptionPane.showMessageDialog(null, "PRIMERO BUSQUE UN HOSPITAL A MODIFICAR");
                }
            }else{
                 JOptionPane.showMessageDialog(null, "LOS CAMPOS NO PUEDEN ESTAR VACIOS!");
            }
            
	}
}
