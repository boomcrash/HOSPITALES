/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author GAMER
 */
public class Medico extends Persona implements Serializable{
    private String carnet;
    private String especialidad;
    

    public Medico(String carnet, String especialidad, String nombre, String apellidos, String telefono, String cedula, Direccion direcciones) {
        super(nombre, apellidos, telefono, cedula, direcciones);
        this.carnet = carnet;
        this.especialidad = especialidad;
    }

    @Override
    public Direccion getDirecciones() {
        return direcciones;
    }

    @Override
    public void setDirecciones(Direccion direcciones) {
        this.direcciones = direcciones;
    }


    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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
