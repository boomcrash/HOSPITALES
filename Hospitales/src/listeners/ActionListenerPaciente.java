package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.InternalMedico;
import gui.InternalPaciente;
import javax.swing.JDesktopPane;

public class ActionListenerPaciente implements ActionListener {
	
        private JDesktopPane pantalla;
	
	public ActionListenerPaciente(JDesktopPane pantalla) {
                this.pantalla=pantalla;
	}
	     /**
*genera ventana de paciente
*
* Creado el 04 de Marzo, 2022, 02:30 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/   
	@Override
	public void actionPerformed(ActionEvent e) {
            pantalla.removeAll();
            pantalla.repaint();
            pantalla.add(new InternalPaciente());

	}
}
