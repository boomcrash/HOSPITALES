package listeners;

import clases.Especialidad;
import clases.Validacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.InternalHospital;
import static gui.InternalHospital.textoMedico;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class ActionListenerHospitalAgregarMedico implements ActionListener {
	
        private TextArea medicos;
	Button registrarMedico,agregarmedico;
        JComboBox<Especialidad> lista;
        Especialidad especialidades;
        TextField nombre, apellidos,telefono,cedula,ciudad,calle,numero;
        
	public ActionListenerHospitalAgregarMedico(TextArea medicos,Button agregarMedico) {
                this.medicos=medicos;
                this.agregarmedico=agregarMedico;
	}
	     /**
*Evento que permite generar un J dialog que permitirá ingresar medicos dentro del registro oficial 
*
* Creado el 06 de Marzo, 2022, 14:30 horas
*
* @author Joel fernando Obregon Guaman y Ángel Fernando Arriaga Mosquera
*
* @version POO - 2022
*
*/   
	@Override
	public void actionPerformed(ActionEvent e) {
            JDialog dialogo=new JDialog();
            dialogo.setSize(900,900);
            dialogo.setModal(true);
            JPanel panel=new JPanel();
            panel.setBackground(Color.white);
            panel.setLayout(null);
            //Crear los labels 
            Label lblNombre = new Label("NOMBRE :");
            lblNombre.setFont(new Font("Serif", Font.PLAIN, 30));
            lblNombre.setBounds(100, 40, 270, 50);

            Label lblApellidos = new Label("APELLIDOS :");
            lblApellidos.setFont(new Font("Serif", Font.PLAIN, 30));
            lblApellidos.setBounds(100, 160, 270, 50);

            Label lblTelefono = new Label("TELEFONO :");
            lblTelefono.setFont(new Font("Serif", Font.PLAIN, 30));
            lblTelefono.setBounds(100, 280, 270, 50);

            Label lblDireccion = new Label("DIRECCION :");
            lblDireccion.setFont(new Font("Serif", Font.PLAIN, 30));
            lblDireccion.setBounds(100, 400, 270, 50);

            Label lblCedula = new Label("CEDULA :");
            lblCedula.setFont(new Font("Serif", Font.PLAIN, 30));
            lblCedula.setBounds(100, 600, 270, 50);
            
            Label lblEspecialidad = new Label("ESPECIALIDAD :");
            lblEspecialidad.setFont(new Font("Serif", Font.PLAIN, 30));
            lblEspecialidad.setBounds(100, 670, 270, 50);
            
            //creo el Boton
            registrarMedico=new Button("REGISTRAR");
            registrarMedico.setFont(new Font("Serif", Font.BOLD, 40));
            registrarMedico.setBounds(400, 750, 270, 50);

            //creo los Texfield
            nombre=new TextField();
            nombre.setFont(new Font("Serif", Font.ITALIC, 20));
            nombre.setBounds(420, 50, 270, 30);

            apellidos=new TextField();
            apellidos.setFont(new Font("Serif", Font.ITALIC, 20));
            apellidos.setBounds(420, 170, 270, 30);

            telefono=new TextField();
            telefono.setFont(new Font("Serif", Font.ITALIC, 20));
            telefono.setBounds(420, 290, 270, 30);

            ciudad=new TextField();
            ciudad.setFont(new Font("Serif", Font.ITALIC, 20));
            ciudad.setBounds(420, 410, 270, 30);

            calle=new TextField();
            calle.setFont(new Font("Serif", Font.ITALIC, 20));
            calle.setBounds(420, 460, 270, 30);

            numero=new TextField();
            numero.setFont(new Font("Serif", Font.ITALIC, 20));
            numero.setBounds(420, 510, 270, 30);

            cedula=new TextField();
            cedula.setFont(new Font("Serif", Font.ITALIC, 20));
            cedula.setBounds(420, 610, 270, 30);

            lista=new JComboBox<>();
       
            lista.addItem(especialidades);
            lista.addItem(especialidades.CARDIOLOGO);
            lista.addItem(especialidades.DERMATOLOGO);
            lista.addItem(especialidades.GENERAL);
            lista.addItem(especialidades.GINECOLOGO);
            lista.addItem(especialidades.NEUROLOGO);
            lista.addItem(especialidades.OFTALMOLOGO);
            lista.addItem(especialidades.TRAUMATOLOGO);
            lista.addItem(especialidades.UROLOGO);
            lista.setBounds(420, 670, 270, 30);
            
            //Añado los labels al GridLayou
            panel.add(lblNombre);
            panel.add(nombre);
            panel.add(lblApellidos);
            panel.add(apellidos);
            panel.add(lblTelefono);
            panel.add(telefono);
            panel.add(lblDireccion);
            panel.add(ciudad);
            panel.add(calle);
            panel.add(numero);
            panel.add(lblCedula);
            panel.add(lblEspecialidad);
            panel.add(lista);
            panel.add(cedula);
            /*registro.add(new TextField("HOLA"));
            registro.add(new Label("RECUERDE LLENAR TODOS LOS CAMPOS ANTES DE REGISTAR!"));*/
            panel.add(registrarMedico);

            registrarMedico.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        if(nombre.getText().toString().trim().length()>0&&apellidos.getText().toString().trim().length()>0&&telefono.getText().toString().trim().length()>0&&cedula.getText().toString().trim().length()>0&&calle.getText().toString().trim().length()>0&&numero.getText().toString().trim().length()>0&&ciudad.getText().toString().trim().length()>0&&lista.getSelectedItem().toString().length()>0){
                             if(telefono.getText().toString().trim().length()==10&&cedula.getText().toString().trim().length()==10){
                                 Validacion validar=new Validacion();
                                if(validar.validarApellido(apellidos.getText().toString().trim())){
                                        try{
                                            Random random=new Random();
                                            String primerosNumeros=cedula.getText().toString().trim().substring(0, 2);
                                            String ultimosNumeros=cedula.getText().toString().trim().substring(8, 10);
                                            int tamanioNombre=nombre.getText().toString().trim().length();
                                            String apellido[]=apellidos.getText().toString().trim().split(" ");
                                            String carnet=primerosNumeros+ultimosNumeros+nombre.getText().toString().trim().substring(tamanioNombre-2,tamanioNombre)+apellido[0].substring(0, 2)+apellido[1].substring(0, 2)+String.valueOf(random.nextInt(10000)+10);
                                            String texto=carnet+"-"+medicos.getText().toString().trim()+"\n"+nombre.getText().toString().trim()+"-"+apellidos.getText().toString().trim()+"-"+cedula.getText().toString().trim()+"-"+telefono.getText().toString().trim()+"-"+ciudad.getText().toString().trim()+" "+calle.getText().toString().trim()+" "+numero.getText().toString().trim()+"-"+lista.getSelectedItem().toString().trim()+"\n";
                                            medicos.setText(texto);
                                            textoMedico=texto;
                                            agregarmedico.setEnabled(false);
                                            dialogo.dispose();
                                        }catch(Exception a){
                                            JOptionPane.showMessageDialog(null, "REVISE LOS DATOS INGRESADOS");
                                        }  
                                } else{
                                    JOptionPane.showMessageDialog(null, "EL APELLIDO DEBE TENER ESTE ESTILO 'Apellido Apellido'");
                                }
                                   
                             }else{
                                 JOptionPane.showMessageDialog(null, "CEDULA Y TELEFONO DEBE TENER 10 NUMEROS");
                             }
                                
                        }       
                    }catch(Exception a){
                        JOptionPane.showMessageDialog(null, "REVISE QUE ESTE SELECCIONADA UNA ESPECIALIDAD");
                    }
                }

            });
            nombre.addKeyListener(new KeyListenerLetras());
            apellidos.addKeyListener(new KeyListenerLetras());
            ciudad.addKeyListener(new KeyListenerLetras());
            calle.addKeyListener(new KeyListenerLetras());
            telefono.addKeyListener(new KeyListenerNumero());
            numero.addKeyListener(new KeyListenerNumero());
            cedula.addKeyListener(new KeyListenerNumero());
            dialogo.add(panel);
            dialogo.setVisible(true);
            
	}
}
