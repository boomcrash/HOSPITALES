/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author GAMER
 */
public class Paciente extends Persona{
    private String id_Historial;

    public Paciente(String id_Historial, String nombre, String apellidos, String telefono, String cedula, Direccion direcciones) {
        super(nombre, apellidos, telefono, cedula, direcciones);
        this.id_Historial = id_Historial;
    }

    public Direccion getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(Direccion direcciones) {
        this.direcciones = direcciones;
    }
    
    public String getId_Historial() {
        return id_Historial;
    }

    public void setId_Historial(String id_Historial) {
        this.id_Historial = id_Historial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

}
