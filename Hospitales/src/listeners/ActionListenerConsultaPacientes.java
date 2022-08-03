package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.InternalHospital;
import javax.swing.JPanel;

public class ActionListenerConsultaPacientes implements ActionListener {
	
        private JPanel base,reemplazo;
	
	public ActionListenerConsultaPacientes(JPanel base,JPanel reemplazo) {
                this.base=base;
                this.reemplazo=reemplazo;
	}
     /**
*Evento que permite el reemplazo de pantalla dentro del internal frame 
*
* Creado el 06 de Marzo, 2022, 15:30 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/   	
	@Override
	public void actionPerformed(ActionEvent e) {
            base.removeAll();
            base.updateUI();
            base.add(reemplazo);
	}
}
