package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.InternalMedico;
import javax.swing.JDesktopPane;

public class ActionListenerMedico implements ActionListener {
	
        private JDesktopPane pantalla;
	
	public ActionListenerMedico(JDesktopPane pantalla) {
                this.pantalla=pantalla;
	}
	     /**
*genera ventana de medico
*
* Creado el 04 de Marzo, 2022, 00:30 horas
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
            pantalla.add(new InternalMedico());

	}
}
