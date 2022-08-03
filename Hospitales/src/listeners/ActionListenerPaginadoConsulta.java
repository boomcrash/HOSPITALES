package listeners;

import clases.Consulta;
import clases.Medico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.InternalPaciente;
import static gui.JfPrincipal.listaConsulta;
import static gui.JfPrincipal.listaMedico;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ActionListenerPaginadoConsulta implements ActionListener {
	
        DefaultTableModel modelo;
        JTable tabla;
        int base=25;
        int maximo,minimo;
        JInternalFrame frame;
        JButton boton;
        int indiceUltimaFila ;
        Object valor;
        JLabel paginaActual;
        int actual=1;
        
	public ActionListenerPaginadoConsulta(JInternalFrame frame,JTable tabla,DefaultTableModel modelo,JButton boton,JLabel paginaActual) {
            this.frame=frame; 
            this.tabla=tabla;   
            this.modelo=modelo; 
           this.boton=boton;
            this.paginaActual=paginaActual;
	}
	     /**
*Evento que permitirá realizar el paginado del listado correspondiente 
*
* Creado el 06 de Marzo, 2022, 12:30 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/   
	@Override
	public void actionPerformed(ActionEvent e) {
            try{
                            if(boton.getText().toString().equalsIgnoreCase("<<<")){
                 indiceUltimaFila = tabla.getRowCount() - 1;
                valor = tabla.getValueAt(indiceUltimaFila, 7);
                
                base=(int) valor;
                    try {
                      int filas=tabla.getRowCount();
                      for (int i = 0;filas>i; i++) {
                          modelo.removeRow(0);
                      }
                    } catch (Exception a) {
                      JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
                    }
                    if(base==25){
                       JOptionPane.showMessageDialog(frame, "AHORA ESTAS EN LA PRIMERA PAGINA"+String.valueOf(base));
                       minimo=0;
                       maximo=25;
                       base=25;
                       paginaActual.setText("1");
                       actual=1;
                       for(int i=0;i<listaConsulta.size();i++){
                            if(i>=minimo&&i<maximo){
                                Object [] fila=new Object[8]; 

                                fila[0]=listaConsulta.get(i).getId(); 
                               fila[1]=listaConsulta.get(i).getFecha(); 
                               fila[2]=listaConsulta.get(i).getConsultorio(); 
                               fila[3]=listaConsulta.get(i).getDiagnostico(); 
                               fila[4]=listaConsulta.get(i).getReceta(); 
                               fila[5]=listaConsulta.get(i).getMedico().getNombre()+" "+listaConsulta.get(i).getMedico().getApellidos(); 
                               fila[6]=listaConsulta.get(i).getPaciente().getNombre()+" "+listaConsulta.get(i).getPaciente().getApellidos(); 
                               fila[7]=i+1; 
                                modelo.addRow(fila); 
                            }
                        }     
                    }
                    else if ((base-25)<=25 && (base-25)>0){
                        System.out.println(base);
                        maximo=25;
                        minimo=0;
                        base=25; 
                        paginaActual.setText("1");
                        actual=1;
                         for(int i=0;i<listaConsulta.size();i++){
                            if(i>=minimo&&i<maximo){
                                Object [] fila=new Object[8]; 

                                fila[0]=listaConsulta.get(i).getId(); 
                               fila[1]=listaConsulta.get(i).getFecha(); 
                               fila[2]=listaConsulta.get(i).getConsultorio(); 
                               fila[3]=listaConsulta.get(i).getDiagnostico(); 
                               fila[4]=listaConsulta.get(i).getReceta(); 
                               fila[5]=listaConsulta.get(i).getMedico().getNombre()+" "+listaConsulta.get(i).getMedico().getApellidos(); 
                               fila[6]=listaConsulta.get(i).getPaciente().getNombre()+" "+listaConsulta.get(i).getPaciente().getApellidos(); 
                               fila[7]=i+1; 
                                modelo.addRow(fila); 
                            }
                        }     
           /* rec[i][]={"id", "fecha", "consultorio","diagnostico","receta","medico","paciente"}*/
                    }
                    else if((base-25)>25){
                        System.out.println(base);
                        for(int i=base;i>0;i--){
                            if(i%25==0){
                                maximo=i;
                                break;
                            }
                        }
                        minimo=maximo-25;
                        base=base-25;
                        
                        actual=Integer.parseInt(paginaActual.getText().toString().trim())-1;
                        paginaActual.setText(String.valueOf(actual));
                         for(int i=0;i<listaConsulta.size();i++){
                            if(i>=minimo&&i<maximo){
                                Object [] fila=new Object[8]; 

                                fila[0]=listaConsulta.get(i).getId(); 
                               fila[1]=listaConsulta.get(i).getFecha(); 
                               fila[2]=listaConsulta.get(i).getConsultorio(); 
                               fila[3]=listaConsulta.get(i).getDiagnostico(); 
                               fila[4]=listaConsulta.get(i).getReceta(); 
                               fila[5]=listaConsulta.get(i).getMedico().getNombre()+" "+listaConsulta.get(i).getMedico().getApellidos(); 
                               fila[6]=listaConsulta.get(i).getPaciente().getNombre()+" "+listaConsulta.get(i).getPaciente().getApellidos(); 
                               fila[7]=i+1; 
                                modelo.addRow(fila); 
                            }
                        }     
           /* rec[i][]={"id", "fecha", "consultorio","diagnostico","receta","medico","paciente"}*/
                    }else if((base-25)<0){
                        minimo=0;
                        maximo=25;
                        
                        JOptionPane.showMessageDialog(null, "YA ESTAS EN LA PRIMERA PAGINA");
                        
                                                 for(int i=0;i<listaConsulta.size();i++){
                            if(i>=minimo&&i<maximo){
                                Object [] fila=new Object[8]; 

                                fila[0]=listaConsulta.get(i).getId(); 
                               fila[1]=listaConsulta.get(i).getFecha(); 
                               fila[2]=listaConsulta.get(i).getConsultorio(); 
                               fila[3]=listaConsulta.get(i).getDiagnostico(); 
                               fila[4]=listaConsulta.get(i).getReceta(); 
                               fila[5]=listaConsulta.get(i).getMedico().getNombre()+" "+listaConsulta.get(i).getMedico().getApellidos(); 
                               fila[6]=listaConsulta.get(i).getPaciente().getNombre()+" "+listaConsulta.get(i).getPaciente().getApellidos(); 
                               fila[7]=i+1; 
                                modelo.addRow(fila); 
                            }
                        }
                    }

                          
                   
                    tabla.setModel(modelo);
                    tabla.setVisible(true);
                    System.out.println("retroceder:"+base);
            }else if(boton.getText().toString().equalsIgnoreCase(">>>")){
                indiceUltimaFila = tabla.getRowCount() - 1;
                valor = tabla.getValueAt(indiceUltimaFila, 7);
                System.out.println(valor); 
                base=(int) valor;
                if(base==listaConsulta.size()){
                     System.out.println(base);
                    JOptionPane.showMessageDialog(frame, "AHORA ESTAS EN LA ULTIMA PAGINA"+String.valueOf(base));
                    
                }
                if((base+25)<listaConsulta.size()){
                 System.out.println(base);
                 minimo=base;
                 maximo=base+25;
                 base=base+25;
                 actual=Integer.parseInt(paginaActual.getText().toString().trim())+1;
                 paginaActual.setText(String.valueOf(actual));
                                
                try {
                  int filas=tabla.getRowCount();
                  for (int i = 0;filas>i; i++) {
                      modelo.removeRow(0);
                  }
                } catch (Exception a) {
                  JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
                }
                for(int i=0;i<listaConsulta.size();i++){
                    if(i>=minimo && i<maximo){
                        Object [] fila=new Object[8]; 
                            fila[0]=listaConsulta.get(i).getId(); 
                            fila[1]=listaConsulta.get(i).getFecha(); 
                            fila[2]=listaConsulta.get(i).getConsultorio(); 
                            fila[3]=listaConsulta.get(i).getDiagnostico(); 
                            fila[4]=listaConsulta.get(i).getReceta(); 
                            fila[5]=listaConsulta.get(i).getMedico().getNombre()+" "+listaConsulta.get(i).getMedico().getApellidos(); 
                            fila[6]=listaConsulta.get(i).getPaciente().getNombre()+" "+listaConsulta.get(i).getPaciente().getApellidos(); 
                            fila[7]=i+1; 
                        modelo.addRow(fila); 
                    }
           /* rec[i][]={"id", "fecha", "consultorio","diagnostico","receta","medico","paciente"}*/
                }
                }else if(base+25>listaConsulta.size()&&base!=listaConsulta.size()){
                     System.out.println(base);
                 maximo=listaConsulta.size();
                 minimo=base;
                 base=listaConsulta.size();
                 actual=Integer.parseInt(paginaActual.getText().toString().trim())+1;
                 paginaActual.setText(String.valueOf(actual));
                                
                try {
                  int filas=tabla.getRowCount();
                  for (int i = 0;filas>i; i++) {
                      modelo.removeRow(0);
                  }
                } catch (Exception a) {
                  JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
                }
                for(int i=0;i<listaConsulta.size();i++){
                    if(i>=minimo && i<maximo){
                        Object [] fila=new Object[8]; 
                            fila[0]=listaConsulta.get(i).getId(); 
                            fila[1]=listaConsulta.get(i).getFecha(); 
                            fila[2]=listaConsulta.get(i).getConsultorio(); 
                            fila[3]=listaConsulta.get(i).getDiagnostico(); 
                            fila[4]=listaConsulta.get(i).getReceta(); 
                            fila[5]=listaConsulta.get(i).getMedico().getNombre()+" "+listaConsulta.get(i).getMedico().getApellidos(); 
                            fila[6]=listaConsulta.get(i).getPaciente().getNombre()+" "+listaConsulta.get(i).getPaciente().getApellidos(); 
                            fila[7]=i+1; 
                        modelo.addRow(fila); 
                    }
           /* rec[i][]={"id", "fecha", "consultorio","diagnostico","receta","medico","paciente"}*/
                }
                }

                tabla.setModel(modelo);
                tabla.setVisible(true);
            }
             System.out.println("avanzar"+base);
            }catch(Exception A){
                JOptionPane.showMessageDialog(null, "Asegurate que existan registros de esta entidad !");
            }

            
             
        }
}
