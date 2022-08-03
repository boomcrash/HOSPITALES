package listeners;

import clases.Archivo;
import static gui.JfPrincipal.listaHospital;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import static gui.JfPrincipal.listaPaciente;
import java.awt.TextArea;
import java.awt.TextField;

public class ActionListenerHospitalBuscarHospital implements ActionListener {
	
        private TextField nombre,ruc,telefono,ciudad,calle,numero,rucHospital;
        public static String rucHospitales=null;

    public ActionListenerHospitalBuscarHospital(TextField rucHospital,TextField nombre, TextField ruc, TextField telefono, TextField ciudad, TextField calle, TextField numero) {
        this.rucHospital=rucHospital;
        this.nombre = nombre;
        this.ruc = ruc;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
    }



/*
* Evento que permite buscar hospital 
*
* Creado el 04 de Marzo, 2022, 11:00 horas
*
* @authores: Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/   
    
    	@Override
	public void actionPerformed(ActionEvent e) {
            if(rucHospital.getText().toString().trim().length()>0){
                boolean bool=false;
                try{
                    Archivo archivo=new Archivo();
                    if(archivo.validarArchivo("Hospitales")){
                        JOptionPane.showMessageDialog(null,"El archivo Hospital no existe aun : (Agregue un registro Hispital)");
                    }else{
                         archivo.leerBinario("Hospitales");        
                         for(int i=0;i<listaHospital.size();i++){
                             if(rucHospital.getText().toString().equalsIgnoreCase(listaHospital.get(i).getRuc())){
                                rucHospitales=listaHospital.get(i).getRuc();
                                ruc.setText(listaHospital.get(i).getRuc());
                                nombre.setText(listaHospital.get(i).getNombre());

                                  telefono.setText(listaHospital.get(i).getTelefono());

                                 calle.setText(listaHospital.get(i).getDireccion().getCalle());

                                  numero.setText(String.valueOf(listaHospital.get(i).getDireccion().getNumero()));

                                  ciudad.setText(listaHospital.get(i).getDireccion().getCiudad());  

                                 bool=true;

                               }

                         }
                         if(bool==false){
                             JOptionPane.showMessageDialog(null,"NO EXISTE EL Hospital!");
                         }
                    }


                }catch(Exception a){
                    System.out.print("");
                }
                if(listaHospital.size()>0){
                    System.out.println("Existen hospitales");
                }else{
                    System.out.print("No Existen hosipitales");
                }     
            }else{
                    JOptionPane.showMessageDialog(null,"EL CAMPO DE A BUSCAR ESTA VACIO!");
                }
            
        }

}
