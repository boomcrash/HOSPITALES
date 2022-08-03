/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import com.sun.corba.se.impl.protocol.giopmsgheaders.KeyAddr;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author GAMER
 */
public class KeyListenerLetras implements KeyListener{

    public KeyListenerLetras() {

    }

    @Override
    public void keyTyped(KeyEvent e) {
            Character caracter = e.getKeyChar();
            if (Character.isDigit(caracter) && caracter != KeyEvent.VK_BACK_SPACE && caracter != KeyEvent.VK_DELETE ) {
                e.consume();
            }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    
   

}
