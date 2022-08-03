package listeners;

import clases.Archivo;
import clases.Direccion;
import gui.InternalConsulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.InternalMedico;
import static gui.JfPrincipal.listaMedico;
import javax.swing.JDesktopPane;
import static listeners.ActionListenerConsultaBuscarPaciente.historial;

public class ActionListenerConsulta implements ActionListener {
	
        private JDesktopPane pantalla;
	public static String carnetMedicoActual;
        public static String medicoCarnet,medicoNombre,medicoApellido,medicoTelefono,medicoCedula,medicoEspecialidad ;
        static Direccion medicoDireccion;
	public ActionListenerConsulta(JDesktopPane pantalla) {
                this.pantalla=pantalla;
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
            if(existeMedico()){
            pantalla.removeAll();
            pantalla.repaint();
            historial=null;
            pantalla.add(new InternalConsulta());
            }else{
            JOptionPane.showMessageDialog(pantalla, "carnet no encontrado en la base de datos");
	}
        }
    /**
* permite validar el carnet del medico que creara la consulta
*
* Creado el 10 de Marzo, 2022, 13:00 horas
*
* @authores: Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/             
        private boolean existeMedico(){
            boolean boleano=false;
            Archivo archivo=new Archivo();
            if(archivo.validarArchivo("medicos")){
                JOptionPane.showMessageDialog(null, "Error: No existe registros de medico");
                boleano=false;
            }else{
                archivo.leerBinario("medicos");
                carnetMedicoActual=JOptionPane.showInputDialog("Ingrese su carnet de Medico");
                for(int i=0;i<listaMedico.size();i++){
                    if(listaMedico.get(i).getCarnet().equalsIgnoreCase(carnetMedicoActual)){
                        boleano=true;
                        medicoCarnet=listaMedico.get(i).getCarnet();
                        medicoEspecialidad=listaMedico.get(i).getEspecialidad();
                        medicoNombre=listaMedico.get(i).getNombre();
                        medicoApellido=listaMedico.get(i).getApellidos();
                        medicoTelefono=listaMedico.get(i).getTelefono();
                        medicoCedula=listaMedico.get(i).getCedula();
                        medicoDireccion=listaMedico.get(i).getDirecciones();
                    }
                }
            }
            return  boleano;
        }
}
