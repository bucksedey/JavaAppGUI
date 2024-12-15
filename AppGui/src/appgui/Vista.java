/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appgui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author Marco Flores
 */
public class Vista extends JFrame {
    
    // DECLARACION DE CAMPOS Y BOTONES
    
    private final JTextField jTextName = new JTextField();
    private final JTextField jTextEmail = new JTextField();
    private final JTextField jTextPhone = new JTextField();
    private final JTextField tImagen = new JTextField();
    private final JPasswordField jTextPassword = new JPasswordField();
    private final JPasswordField jTextConfirm = new JPasswordField();
    
    // Cuadro Imagen
    private final JLabel jLabelFotografia = new JLabel();
    
    // Botones
    private final JButton jButtonProcesar = new JButton("Process");
    private final JButton jButtonLimpiar  = new JButton("Clear");
    private final JButton jButtonImagen   = new JButton(new ImageIcon("img/load.jpg"));
        
    public Vista() // Constructor
    {
        this.setTitle("User Registration");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setBounds(50,50,640,480);
        
        
        initComponents();  

    }
    
    public final void initComponents()
    {
        // Declaración de etiquetas
        JLabel etiquetaName     = new JLabel("Name:");
        JLabel etiquetaEmail    = new JLabel("E-Mail:");
        JLabel etiquetaPhone    = new JLabel("Mobile Number:");
        JLabel etiquetaPhoto    = new JLabel("Photo:");
        JLabel etiquetaPassword = new JLabel("Password:");
        JLabel etiquetaConfirm  = new JLabel("Confirm Password:");
        
        
        // Diseña menú
        JMenuBar barraMenus = new JMenuBar();
	JMenu archivo 	  = new JMenu("File");
	JMenuItem salir   = new JMenuItem("Exit");
        this.setJMenuBar(barraMenus);
        barraMenus.add(archivo);
        archivo.add(salir);
            
        // Posiciones de los componentes
        this.setLayout(null); // El programador indica coordenadas y tamaño
        
        etiquetaName.setBounds(100,50,100,30);
        jTextName.setBounds(200,50,200,30);
        
        etiquetaEmail.setBounds(100,100,100,30);
        jTextEmail.setBounds(200,100,200,30);
        
        etiquetaPhone.setBounds(100,150,100,30);
        jTextPhone.setBounds(200,150,200,30);
       
        etiquetaPhoto.setBounds(100,200,100,30);
        tImagen.setBounds(200,150,200,30);
        
        jButtonImagen.setBounds(350,200,40,40);
        
        etiquetaPassword.setBounds(100,250,100,30);
        jTextPassword.setBounds(200,250,200,30);
        
        etiquetaConfirm.setBounds(100,300,100,30);
        jTextConfirm.setBounds(200,300,200,30);
        
        jLabelFotografia.setBounds(450,50,100,150);
        
        
        jButtonProcesar.setBounds(200,350,100,40);
        jButtonLimpiar.setBounds(320,350,100,40);
        
        // Propiedades de los componentes
        
        jLabelFotografia.setBorder(BorderFactory.createLineBorder(Color.black));
        jLabelFotografia.setIcon(new ImageIcon("img/saiki.png"));
        tImagen.setEditable(false);
         
        
        // Agrega los componentes al Frame (y se mostrarán en el Frame)
        
        this.add(jLabelFotografia);
        
        this.add(etiquetaName);
        this.add(jTextName);
        
        this.add(etiquetaEmail);
        this.add(jTextEmail);
        
        this.add(etiquetaPhone);
        this.add(jTextPhone);
        
        this.add(etiquetaPhoto);
        this.add(jButtonImagen);
        
        this.add(tImagen);
        
        this.add(etiquetaPassword);
        this.add(jTextPassword);
      
        this.add(etiquetaConfirm);
        this.add(jTextConfirm);
        
        this.add(jButtonProcesar);
        this.add(jButtonLimpiar);
        
        // GESTION DE EVENTOS
        
        // Lo que se debe hacer cuando el usuario elija la opción "Salir" 
        salir.addActionListener(evt -> gestionaSalir(evt));
            
        // Lo que se debe hacer cuando el usuario elija el botón "Procesar"
        jButtonProcesar.addActionListener(evt -> gestionaProcesar(evt));
        
        // Lo que se debe hacer cuando el usuario elija la opción "Limpiar"
        jButtonLimpiar.addActionListener(evt -> gestionaLimpiar(evt));
                
        // Lo que debe hacer cuando el usuario elija el boton para abrir imagen
        jButtonImagen.addActionListener(evt -> gestionaCargar(evt));
        
        // Lo que se debe hacer cuando e usurio elija la "X" de la ventana para salir      
        class MyWindowAdapter extends WindowAdapter
	{
            @Override
            public void windowClosing(WindowEvent e)
            {
		exit(); 
            }
	}
        addWindowListener(new MyWindowAdapter());
        
    }
    
    public void gestionaSalir(java.awt.event.ActionEvent evt)
    {
        exit();
    }

    public void exit()
    {
        int respuesta = JOptionPane.showConfirmDialog(rootPane, "Desea salir?","Aviso",JOptionPane.YES_NO_OPTION);
        if(respuesta==JOptionPane.YES_OPTION) System.exit(0);
    }
    
    public void gestionaProcesar(java.awt.event.ActionEvent evt)
    {
        // Escriba aqui el código para recuperar los datos desde las cajas de texto 
        // y crear con ellos un objeto Usuario (y mostrar la fotografía)     
        
        String datosCaptados;
        String nombreCapturada = jTextName.getText().toUpperCase();
        String emailCapturado = jTextEmail.getText().toUpperCase();
        String phoneCapturado = jTextPhone.getText().toUpperCase();
        String imagenCapturada = tImagen.getText();
        
        boolean hayError = false;
       //datosCapturados = nuevoUsuario.getData();
            
        // Validaciones
        
        if(nombreCapturada.length() == 0)
        {    
            JOptionPane.showConfirmDialog(rootPane, "Error!! El nombre no puede ser vacía", "Aviso" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            hayError = true;
        }
         
        if(emailCapturado.length() == 0)
        {    
            JOptionPane.showConfirmDialog(rootPane, "Error!! El email no puede ser vacío", "Aviso" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            hayError = true;
        }
                   
        if(phoneCapturado.length() == 0)
        {   
            JOptionPane.showConfirmDialog(rootPane, "Error!! El telefono no puede ser vacío", "Aviso" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            hayError = true;
        }
                
        if(imagenCapturada.length() == 0)
        {    
            JOptionPane.showConfirmDialog(rootPane, "Error!! El nombre del archivo de magen no puede ser vacío", "Aviso" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            hayError = true;
        }   
        
        if(!(jTextPassword.getText()).equals(jTextConfirm.getText()))
        {
            JOptionPane.showConfirmDialog(rootPane, "Error!! La contrasena no coincide", "Aviso" ,JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            hayError = true;
        }
        if(!hayError)
        {
            datosCaptados = "DATOS DEL USUARIO";
            datosCaptados = datosCaptados.concat( "\nUser Name: " + (jTextName.getText()) + "\n" + "Email Addres: " +(jTextEmail.getText()) + "\n" + "Phone Number: " + (jTextPhone.getText()) + "\n");
         
            JOptionPane.showMessageDialog(rootPane, datosCaptados);
        }
    }
    
    public void gestionaLimpiar(java.awt.event.ActionEvent evt)
    { // Escriba aquí el código para limpiar la caja de texto y la foto
        jTextName.setText("");
        jTextEmail.setText("");
        jTextPhone.setText("");
        tImagen.setText("");
        jTextPassword.setText("");
        jTextConfirm.setText("");
        
        jLabelFotografia.setIcon(null);
    }
    
    public void gestionaCargar(java.awt.event.ActionEvent evt)
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FiltroArchivoImagen());
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")+"/img"));
        chooser.showOpenDialog(this);
        File archivoImagen = chooser.getSelectedFile();
        if(archivoImagen != null && !archivoImagen.isDirectory())
        {
            String fileName = archivoImagen.getName();
            
            // Mostrar la imagen            
            jLabelFotografia.setIcon(new ImageIcon("img/"+fileName));
            tImagen.setText(fileName);      
        }
    }
}
