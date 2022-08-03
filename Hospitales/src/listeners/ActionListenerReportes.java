package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import gui.InternalReporte;
import javax.swing.JDesktopPane;

public class ActionListenerReportes implements ActionListener {
	
        private JDesktopPane pantalla;
	
	public ActionListenerReportes(JDesktopPane pantalla) {
                this.pantalla=pantalla;
	}
	     /**
*Evento que permite el reemplazo de pantalla dentro del internal frame 
*
* Creado el 05 de Marzo, 2022, 10:00 horas
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
            pantalla.add(new InternalReporte());
	}
}
