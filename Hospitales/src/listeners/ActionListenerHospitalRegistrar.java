package listeners;

import clases.Archivo;
import clases.Direccion;
import clases.Especialidad;
import clases.Hospital;
import clases.Medico;
import clases.Persona;
import static gui.InternalHospital.textoMedico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.InternalMedico;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;

public class ActionListenerHospitalRegistrar implements ActionListener {
	
        private TextField nombre,ruc,telefono,ciudad,calle,numero;
        private TextArea medicos;
	
	public ActionListenerHospitalRegistrar() {
                
	}

    public ActionListenerHospitalRegistrar(TextField nombre, TextField ruc, TextField telefono, TextField ciudad, TextField calle, TextField numero, TextArea medicos) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
        this.medicos = medicos;
    }
        
/**
*Evento que permitirá crear un Hospital
* Creado el 08 de Marzo, 2022, 21:30 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/   
	@Override
	public void actionPerformed(ActionEvent e) {
            if(nombre.getText().toString().trim().length()>0 && ruc.getText().toString().trim().length()>0 && telefono.getText().toString().trim().length()>0 && ciudad.getText().toString().trim().length()>0 && calle.getText().toString().trim().length()>0 && numero.getText().toString().trim().length()>0&&medicos.getText().toString().trim().length()>0){
                if(telefono.getText().toString().trim().length()==10 && ruc.getText().toString().trim().length()==10){
                    Archivo archivoMedico=new Archivo(); 
                    Archivo archivo=new Archivo();
                    String valoresMedico[]=textoMedico.split("-");
                    String direccionFinal[]=valoresMedico[5].split(" ");
                    try{
                        if(archivo.validarArchivo("Hospitales")){
                            Hospital hospital=new Hospital(nombre.getText().toString().trim(), ruc.getText().toString().trim(), telefono.getText().toString().trim(), new Direccion(ciudad.getText().toString().trim(), calle.getText().toString().trim(), Integer.parseInt(numero.getText().toString().trim())), new Medico(valoresMedico[0], valoresMedico[6],valoresMedico[1], valoresMedico[2], valoresMedico[4],valoresMedico[3], new Direccion(direccionFinal[0], direccionFinal[1],Integer.parseInt(direccionFinal[2]))));
                            archivo.escribirBinario("Hospitales", hospital);
                        }else{
                            Hospital hospital=new Hospital(nombre.getText().toString().trim(), ruc.getText().toString().trim(), telefono.getText().toString().trim(), new Direccion(ciudad.getText().toString().trim(), calle.getText().toString().trim(), Integer.parseInt(numero.getText().toString().trim())), new Medico(valoresMedico[0], valoresMedico[6],valoresMedico[1], valoresMedico[2], valoresMedico[4],valoresMedico[3], new Direccion(direccionFinal[0], direccionFinal[1],Integer.parseInt(direccionFinal[2]))));
                            archivo.añadirBinario("Hospitales", hospital);
                        }
                    }catch(Exception a){
                        System.err.println(a);
                    }
                    try{
                        if(archivo.validarArchivo("Medicos")){
                            Persona pmedico=new Medico(valoresMedico[0], valoresMedico[6],valoresMedico[1], valoresMedico[2], valoresMedico[4],valoresMedico[3], new Direccion(direccionFinal[0], direccionFinal[1],Integer.parseInt(direccionFinal[2])));
                            archivoMedico.escribirBinario("Medicos",pmedico);                    
                        }else{
                            Persona pmedico=new Medico(valoresMedico[0], valoresMedico[6],valoresMedico[1], valoresMedico[2], valoresMedico[4],valoresMedico[3], new Direccion(direccionFinal[0], direccionFinal[1],Integer.parseInt(direccionFinal[2])));
                            archivoMedico.añadirBinario("Medicos",pmedico);                    
                        }
                    }catch(Exception a){
                          System.err.println(a);
                    }                       
                }else{
                       JOptionPane.showMessageDialog(null, "RUC Y TELEFONO DEBE TENER 10 NUMEROS");
                }

                
            }else{
                 JOptionPane.showMessageDialog(null, "LOS CAMPOS NO PUEDEN ESTAR VACIOS!");
            }

                
                
	}
}
