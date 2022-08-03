package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.InternalHospital;
import javax.swing.JDesktopPane;

public class ActionListenerHospital implements ActionListener {
	
        private JDesktopPane pantalla;
	
	public ActionListenerHospital(JDesktopPane pantalla) {
                this.pantalla=pantalla;
	}
	     /**
*genera ventana de hospital
*
* Creado el 03 de Marzo, 2022, 23:00 horas
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
            pantalla.add(new InternalHospital());
	}
}
