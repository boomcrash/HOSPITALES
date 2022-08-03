package listeners;

import clases.Archivo;
import clases.Direccion;
import clases.Especialidad;
import clases.Medico;
import clases.Persona;
import clases.Validacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.InternalMedico;
import java.awt.TextField;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;

public class ActionListenerMedicoRegistrar implements ActionListener {
	
        private TextField nombre,apellidos,telefono,ciudad,calle,numero,cedula;
        private JComboBox especialidad;
	
	public ActionListenerMedicoRegistrar() {
                
	}

    public ActionListenerMedicoRegistrar(TextField nombre, TextField apellidos, TextField telefono, TextField ciudad, TextField calle, TextField numero, TextField cedula, JComboBox especialidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
        this.cedula = cedula;
        this.especialidad = especialidad;
    }
        
/*
*Evento que permitirá crear un Medico
* Creado el 08 de Marzo, 2022, 21:30 horas
*
* @authores: Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/   
	@Override
	public void actionPerformed(ActionEvent e) {
            try{
                if(nombre.getText().toString().trim().length()>0&&apellidos.getText().toString().trim().length()>0&&telefono.getText().toString().trim().length()>0&&cedula.getText().toString().trim().length()>0&&calle.getText().toString().trim().length()>0&&numero.getText().toString().trim().length()>0&&ciudad.getText().toString().trim().length()>0&&especialidad.getSelectedItem().toString().length()>0){
                    if(telefono.getText().toString().trim().length()==10&&cedula.getText().toString().trim().length()==10){
                        Validacion validar=new Validacion();
                        if(validar.validarApellido(apellidos.getText().toString().trim())){
                            Archivo archivo=new Archivo();
                            try{
                                Random random=new Random();
                                String primerosNumeros=cedula.getText().toString().trim().substring(0, 2);
                                String ultimosNumeros=cedula.getText().toString().trim().substring(8, 10);
                                int tamanioNombre=nombre.getText().toString().trim().length();
                                String apellido[]=apellidos.getText().toString().trim().split(" ");
                                String carnet=primerosNumeros+ultimosNumeros+nombre.getText().toString().trim().substring(tamanioNombre-2,tamanioNombre)+apellido[0].substring(0, 2)+apellido[1].substring(0, 2)+String.valueOf(random.nextInt(10000)+10);
                                System.out.println(carnet);
                                Persona medico=new Medico(carnet,especialidad.getSelectedItem().toString().trim(),nombre.getText().toString().trim(),apellidos.getText().toString().trim(),telefono.getText().toString().trim(),cedula.getText().toString().trim(),new Direccion(ciudad.getText().toString().trim(), calle.getText().toString().trim(), Integer.parseInt(numero.getText().toString().trim())));
                                if(archivo.validarArchivo("Medicos")){
                                    archivo.escribirBinario("Medicos", medico);
                                    JOptionPane.showMessageDialog(null,"GUARDADO CORRECTAMENTE");
                                }else{
                                    archivo.añadirBinario("Medicos", medico);
                                   JOptionPane.showMessageDialog(null,"GUARDADO CORRECTAMENTE");
                                }

                            }catch(Exception a){
                                JOptionPane.showMessageDialog(null,"ERROR AL GUARDA, ASEGURESE QUE ESTE BIEN LLENADO L FORMULARIO");
                            }                    
                        }else{
                            JOptionPane.showMessageDialog(null, "EL APELLIDO DEBE TENER ESTE ESTILO 'Apellido Apellido'");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "CEDULA Y TELEFONO DEBE TENER 10 NUMEROS");
                    }

                }else{
                    JOptionPane.showMessageDialog(null,"LOS CAMPOS NO DEBEN ESTAR VACIOS!");
                }


            }catch(Exception a){
                JOptionPane.showMessageDialog(null,"ASEGURATE DE HABER ELEGIDO UNA ESPECIALIDAD");
            }

            
	}
}
