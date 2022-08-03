/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.TextField;
import static java.lang.System.in;
import java.util.regex.Pattern;

public class Validacion {
    /* Metodo que permite validar la estructura indicada de los apellidos en disntintas seccones
*
* Creado el 15 de Marzo, 2022, 20:00 horas
*
* @authores: Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/
    public boolean validarApellido(String apellidos){
        return apellidos.matches("^([A-Za-zÁÉÍÓÚñáéíóúÑ]+[\\s]+[A-Za-zÁÉÍÓÚñáéíóúÑ]{1,15})");
    }  
}
