package listeners;

import clases.Archivo;
import clases.Consulta;
import clases.Direccion;
import clases.Especialidad;
import clases.Hospital;
import clases.Medico;
import clases.Paciente;
import clases.Persona;
import clases.Validacion;
import static gui.InternalHospital.textoMedico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.InternalMedico;
import static gui.JfPrincipal.listaConsulta;
import static gui.JfPrincipal.listaMedico;
import java.awt.TextArea;
import java.awt.TextField;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import static listeners.ActionListenerConsulta.medicoApellido;
import static listeners.ActionListenerConsulta.medicoCarnet;
import static listeners.ActionListenerConsulta.medicoCedula;
import static listeners.ActionListenerConsulta.medicoDireccion;
import static listeners.ActionListenerConsulta.medicoEspecialidad;
import static listeners.ActionListenerConsulta.medicoNombre;
import static listeners.ActionListenerConsulta.medicoTelefono;
import static listeners.ActionListenerConsultaBuscarPaciente.historial;

public class ActionListenerConsultaRegistrar implements ActionListener {
	
        private TextField nombre,apellidos,telefono,cedula,calle,numero,consultorio,ciudad;
        private TextArea diagnostico,receta;
	DateTimeFormatter dtf ;
        String historialId,idHistorial;

	public ActionListenerConsultaRegistrar() {
                
	}

    public ActionListenerConsultaRegistrar(String idHistorial, TextField nombre, TextField apellidos, TextField telefono, TextField cedula, TextField calle, TextField numero, TextField consultorio, TextArea diagnostico, TextArea receta,TextField ciudad) {
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
* Evento que permitirá crear una Consulta
* Creado el 08 de Marzo, 2022, 21:30 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/   
	@Override
	public void actionPerformed(ActionEvent e) {
            if(nombre.getText().toString().trim().length()>0&&apellidos.getText().toString().trim().length()>0&&telefono.getText().toString().trim().length()>0&&cedula.getText().toString().trim().length()>0&&calle.getText().toString().trim().length()>0&&numero.getText().toString().trim().length()>0&&ciudad.getText().toString().trim().length()>0&&consultorio.getText().toString().trim().length()>0&&diagnostico.getText().toString().trim().length()>0&&receta.getText().toString().trim().length()>0){
                if(telefono.getText().toString().trim().length()==10&&cedula.getText().toString().trim().length()==10){
                    Validacion validar=new Validacion();
                    if(validar.validarApellido(apellidos.getText().toString().trim())){
                            Random random=new Random();
                            String primerosNumeros=cedula.getText().toString().trim().substring(0, 2);
                            String ultimosNumeros=cedula.getText().toString().trim().substring(8, 10);
                            String apellido[]=apellidos.getText().toString().trim().split(" ");
                            System.out.println(apellidos.getText().toString().trim());
                            historialId=primerosNumeros+ultimosNumeros+nombre.getText().toString().trim().substring(0,2)+apellido[0].substring(apellido.length-2,apellido.length)+apellido[1].substring(apellido.length-2,apellido.length)+String.valueOf(random.nextInt(10000)+100);

                            String tiempo = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
                            Archivo archivoPaciente =new  Archivo();
                            archivoPaciente.leerBinario("pacientes");
                            Archivo archivo=new Archivo();
                            archivo.leerBinario("consulta");
                            try{
                                if(historial!=null){
                                    if(archivo.validarArchivo("pacientes")){

                                        Consulta consulta=new Consulta(1,tiempo,consultorio.getText().toString().trim(),diagnostico.getText().toString().trim(),receta.getText().toString().trim(),new Paciente(historialId,nombre.getText().toString().trim(),apellidos.getText().toString().trim(),telefono.getText().toString().trim(),cedula.getText().toString().trim(),new Direccion(ciudad.getText().toString().trim(),calle.getText().toString().trim(),Integer.parseInt(numero.getText().toString().trim()))),new Medico(medicoCarnet, medicoEspecialidad, medicoNombre, medicoApellido, medicoTelefono, medicoCedula, medicoDireccion));
                                        archivo.escribirBinario("consulta", consulta);
                                    }else{
                                        Consulta consulta=new Consulta(listaConsulta.size()+1,tiempo,consultorio.getText().toString().trim(),diagnostico.getText().toString().trim(),receta.getText().toString().trim(),new Paciente(historialId,nombre.getText().toString().trim(),apellidos.getText().toString().trim(),telefono.getText().toString().trim(),cedula.getText().toString().trim(),new Direccion(ciudad.getText().toString().trim(),calle.getText().toString().trim(),Integer.parseInt(numero.getText().toString().trim()))),new Medico(medicoCarnet, medicoEspecialidad, medicoNombre, medicoApellido, medicoTelefono, medicoCedula, medicoDireccion));
                                        archivo.añadirBinario("consulta", consulta);
                                    }

                                }else {
                                    if(archivo.validarArchivo("pacientes")){

                                        Consulta consulta=new Consulta(1,tiempo,consultorio.getText().toString().trim(),diagnostico.getText().toString().trim(),receta.getText().toString().trim(),new Paciente(historialId,nombre.getText().toString().trim(),apellidos.getText().toString().trim(),telefono.getText().toString().trim(),cedula.getText().toString().trim(),new Direccion(ciudad.getText().toString().trim(),calle.getText().toString().trim(),Integer.parseInt(numero.getText().toString().trim()))),new Medico(medicoCarnet, medicoEspecialidad, medicoNombre, medicoApellido, medicoTelefono, medicoCedula, medicoDireccion));
                                        archivo.escribirBinario("consulta", consulta);
                                            if(archivo.validarArchivo("pacientes")){
                                                Paciente paciente=new Paciente(historialId,nombre.getText().toString().trim(),apellidos.getText().toString().trim(),telefono.getText().toString().trim(),cedula.getText().toString().trim(),new Direccion(ciudad.getText().toString().trim(),calle.getText().toString().trim(),Integer.parseInt(numero.getText().toString().trim())));
                                                archivoPaciente.escribirBinario("pacientes",paciente);  
                                                JOptionPane.showMessageDialog(null, "SE HA CREADO CORRECTAMENE");
                                            }else{
                                                Paciente paciente=new Paciente(historialId,nombre.getText().toString().trim(),apellidos.getText().toString().trim(),telefono.getText().toString().trim(),cedula.getText().toString().trim(),new Direccion(ciudad.getText().toString().trim(),calle.getText().toString().trim(),Integer.parseInt(numero.getText().toString().trim())));
                                                archivoPaciente.añadirBinario("pacientes",paciente);   
                                                JOptionPane.showMessageDialog(null, "SE HA CREADO CORRECTAMENE");
                                            }
                                    }else{
                                        Consulta consulta=new Consulta(listaConsulta.size()+1,tiempo,consultorio.getText().toString().trim(),diagnostico.getText().toString().trim(),receta.getText().toString().trim(),new Paciente(historialId,nombre.getText().toString().trim(),apellidos.getText().toString().trim(),telefono.getText().toString().trim(),cedula.getText().toString().trim(),new Direccion(ciudad.getText().toString().trim(),calle.getText().toString().trim(),Integer.parseInt(numero.getText().toString().trim()))),new Medico(medicoCarnet, medicoEspecialidad, medicoNombre, medicoApellido, medicoTelefono, medicoCedula, medicoDireccion));
                                        archivo.añadirBinario("consulta", consulta);
                                            if(archivo.validarArchivo("pacientes")){
                                                Paciente paciente=new Paciente(historialId,nombre.getText().toString().trim(),apellidos.getText().toString().trim(),telefono.getText().toString().trim(),cedula.getText().toString().trim(),new Direccion(ciudad.getText().toString().trim(),calle.getText().toString().trim(),Integer.parseInt(numero.getText().toString().trim())));
                                                archivoPaciente.escribirBinario("pacientes",paciente);  
                                                JOptionPane.showMessageDialog(null, "SE HA CREADO CORRECTAMENE");
                                            }else{
                                                Paciente paciente=new Paciente(historialId,nombre.getText().toString().trim(),apellidos.getText().toString().trim(),telefono.getText().toString().trim(),cedula.getText().toString().trim(),new Direccion(ciudad.getText().toString().trim(),calle.getText().toString().trim(),Integer.parseInt(numero.getText().toString().trim())));
                                                archivoPaciente.añadirBinario("pacientes",paciente);  
                                                JOptionPane.showMessageDialog(null, "SE HA CREADO CORRECTAMENE");
                                            }
                                    }
                                }

                            }catch(Exception a){
                                System.err.println(a);
                            }

                            System.out.println(tiempo);                                
                    }else{
                         JOptionPane.showMessageDialog(null, "EL APELLIDO DEBE TENER ESTE ESTILO 'Apellido Apellido'");
                    }
           
                }else{
                    JOptionPane.showMessageDialog(null, "CEDULA Y TELEFONO DEBE TENER 10 NUMEROS");
                }

            }else{
                 JOptionPane.showMessageDialog(null,"LOS CAMPOS NO PUEDE ESTAR VACIOS");
            }

	}
}
