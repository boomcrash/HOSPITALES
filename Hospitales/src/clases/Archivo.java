/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static gui.JfPrincipal.listaConsulta;
import static gui.JfPrincipal.listaHospital;
import static gui.JfPrincipal.listaMedico;
import static gui.JfPrincipal.listaPaciente;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author GAMER
 */
public class Archivo {
    

    public Archivo() {

    }

    /**
* permite escribir en el archivo binario  de tipo persna
*
* Creado el 10 de Marzo, 2022, 13:00 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @param nombre (pasa el nombre del archivo)
* 
* @param persona (pasa el objeto persona)
* 
* @version POO - 2022
*
*/
    public void escribirBinario(String nombre,Persona persona){
        FileOutputStream archivo=null;
        try {
            archivo = new FileOutputStream(nombre+".bin");
            ObjectOutputStream escritura=new ObjectOutputStream(archivo);
            escritura.writeObject(persona);
            escritura.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                archivo.close();
            } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
* permite añadir en el archivo binario de persona
*
* Creado el 10 de Marzo, 2022, 13:00 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @param nombre (pasa el nombre del archivo)
* 
* @param persona (pasa el objeto persona)
* 
* @version POO - 2022
*
*/
     public void añadirBinario(String nombre,Persona persona){
        FileOutputStream archivo=null;
        try {
            archivo = new FileOutputStream(nombre+".bin",true);
            AñadirContenido escritura=new AñadirContenido(archivo);
            escritura.writeObject(persona);
            escritura.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                archivo.close();
            } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     
    /**
* permite eliminar un archivo
*
* Creado el 10 de Marzo, 2022, 13:00 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
*  @param nombre (pasa el nombre del archivo)
* 
* @version POO - 2022
*
*/     
    public static void eliminarFichero(String nombre) {
        File archivo=new File(nombre+".bin");
        if(archivo.exists()){
            archivo.delete();
            System.out.println("El archivo fue eliminado.");
        }else{
            System.out.println("El archivo no existe.");
        }
    } 

     /**
* permite leer en el archivo binario de persona,hospital y consultas
*
* Creado el 10 de Marzo, 2022, 13:00 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
* 
* @param nombre (pasa el nombre del archivo)
* 

*
* @version POO - 2022
*
*/         
    public void leerBinario(String nombre){
       Medico medico;
       Paciente paciente;
       Hospital hospitales;
       Consulta consultas;
       File archivoBin=new File(nombre+".bin");
       try{
           FileInputStream archivo=new FileInputStream(nombre+".bin");
           ObjectInputStream lectura =new ObjectInputStream(archivo);
           if(nombre.equalsIgnoreCase("medicos")){
                if(listaMedico.size()>0){
                    listaMedico.clear();
                }
                while(true){
                   medico=(Medico)lectura.readObject();
                   System.out.println(medico.getEspecialidad());

                   listaMedico.add(medico);
                } 
           }else if(nombre.equalsIgnoreCase("pacientes")){
                   if(listaPaciente.size()>0){
                       listaPaciente.clear();
                   } 
                while(true){
                   paciente=(Paciente)lectura.readObject();
                  
                   listaPaciente.add(paciente);
                } 
           }else if(nombre.equalsIgnoreCase("hospitales")){
                   if(listaHospital.size()>0){
                       listaHospital.clear();
                   }
                while(true){
                   hospitales=(Hospital)lectura.readObject();
                   System.out.println(hospitales.getRuc());

                   listaHospital.add(hospitales);
                } 
           }else if(nombre.equalsIgnoreCase("consulta")){
                   if(listaConsulta.size()>0){
                       listaConsulta.clear();
                   }
                while(true){
                   consultas=(Consulta)lectura.readObject();

                   listaConsulta.add(consultas);
                } 
           }

       }catch(Exception a){
           if(!archivoBin.exists()){
               JOptionPane.showMessageDialog(null,"Asegurate que existan registros de la entidad");
           }
           
       }
    } 
    /**
* permite añadir en el archivo binario de hospital
*
* Creado el 10 de Marzo, 2022, 13:00 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @param nombre (pasa el nombre del archivo)
* 
* @param hospital (pasa el objeto hospital)
* 
* @version POO - 2022
*
*/     
    public void añadirBinario(String nombre,Hospital hospital){
        FileOutputStream archivo=null;
        try {
            archivo = new FileOutputStream(nombre+".bin",true);
            AñadirContenido escritura=new AñadirContenido(archivo);
            escritura.writeObject(hospital);
            escritura.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                archivo.close();
            } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
    
    
    /**
* permite escribir en el archivo binario de hospital
*
* Creado el 10 de Marzo, 2022, 13:00 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @param nombre (pasa el nombre del archivo)
* 
* @param persona (pasa el objeto hospital)
* 
* @version POO - 2022
*
*/         
    public void escribirBinario(String nombre,Hospital persona){
        FileOutputStream archivo=null;
        try {
            archivo = new FileOutputStream(nombre+".bin");
            ObjectOutputStream escritura=new ObjectOutputStream(archivo);
            escritura.writeObject(persona);
            escritura.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                archivo.close();
            } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //cosnulta
    /**
* permite escribir en el archivo binario de consulta
*
* Creado el 10 de Marzo, 2022, 13:00 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @param nombre (pasa el nombre del archivo)
* 
* @param consulta (pasa el objeto consulta)
* 
* @version POO - 2022
*
*/     
    public void escribirBinario(String nombre,Consulta consulta){
        FileOutputStream archivo=null;
        try {
            archivo = new FileOutputStream(nombre+".bin");
            ObjectOutputStream escritura=new ObjectOutputStream(archivo);
            escritura.writeObject(consulta);
            escritura.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                archivo.close();
            } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
* permite añadir en el archivo binario de consulta
*
* Creado el 10 de Marzo, 2022, 13:00 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @param nombre (pasa el nombre del archivo)
* 
* @param consulta (pasa el objeto consulta)
* 
* @version POO - 2022
*
*/         
    public void añadirBinario(String nombre,Consulta consulta){
        FileOutputStream archivo=null;
        try {
            archivo = new FileOutputStream(nombre+".bin",true);
            AñadirContenido escritura=new AñadirContenido(archivo);
            escritura.writeObject(consulta);
            escritura.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                archivo.close();
            } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
    
    //pacientes
    
    /**
* permite escribir en el archivo binario de paciente
*
* Creado el 10 de Marzo, 2022, 13:00 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @param nombre (pasa el nombre del archivo)
* 
* @param paciente (pasa el objeto paciente)
* 
* @version POO - 2022
*
*/     
    public void escribirBinario(String nombre,Paciente paciente){
        FileOutputStream archivo=null;
        try {
            archivo = new FileOutputStream(nombre+".bin");
            ObjectOutputStream escritura=new ObjectOutputStream(archivo);
            escritura.writeObject(paciente);
            escritura.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                archivo.close();
            } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
    
    /**
* permite añadir en el archivo binario de paciente
*
* Creado el 10 de Marzo, 2022, 13:00 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @param nombre (pasa el nombre del archivo)
* 
* @param paciente (pasa el objeto paciente)
* 
* @version POO - 2022
*
*/         
    public void añadirBinario(String nombre,Paciente paciente){
        FileOutputStream archivo=null;
        try {
            archivo = new FileOutputStream(nombre+".bin",true);
            AñadirContenido escritura=new AñadirContenido(archivo);
            escritura.writeObject(paciente);
            escritura.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                archivo.close();
            } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
    /**
* permite validar si existe el archivo
*
* Creado el 10 de Marzo, 2022, 13:00 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @param nombre (pasa el nombre del archivo)
* 
* @version POO - 2022
*
*/         
    public Boolean validarArchivo(String nombre){
        boolean retorno=true;
        File archivo=new File(nombre+".bin");
        if(archivo.exists()){
            retorno= false;
        }else{
            retorno= true;
        }
        return retorno;
    }
}
