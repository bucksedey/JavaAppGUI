/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appgui;

import java.io.File;

/**
 *
 * @author Marco Flores
 */
public class FiltroArchivoImagen extends javax.swing.filechooser.FileFilter
{
    @Override
    public boolean accept(File f)
    {
	String ext = (f.getName()).substring(f.getName().lastIndexOf(".")+1);
        ext = ext.toLowerCase();
        return (ext.equals("jpg") || ext.equals("png") || f.isDirectory());
    }
    
    @Override
    public String getDescription()
    {
    	return " Archivos de Imagen";
    }      
}
