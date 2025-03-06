/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author coco
 */
public class ControladorDatosPersonales implements ActionListener {

    
    DatosPersonalesDao datosPersonalesDAO = new DatosPersonalesDao();
    DatosPersonales p = new DatosPersonales();
    VistaDatosPersonales VistaDatosPersonales = new VistaDatosPersonales();
    DefaultTableModel modelo = new DefaultTableModel();
    
    
    
    
    
    public ControladorDatosPersonales( VistaDatosPersonales dp) {
        this.VistaDatosPersonales = dp;
        
        this.VistaDatosPersonales.btnGurdarDatosPersonales.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
    
        if (e.getSource() == VistaDatosPersonales.btnGurdarDatosPersonales) {
            agregar();
        }
    }
    
    public void agregar(){
        String nombreCompleto = VistaDatosPersonales.txtNombreCompletoLogin.getText();
        int edad = Integer.parseInt(VistaDatosPersonales.txtEdadLogin.getText());
        String telefono = VistaDatosPersonales.txtTelefonoLogin.getText();
        String domicilio = VistaDatosPersonales.txtDomicilioLogin.getText();
        String correo = VistaDatosPersonales.txtCorreoLogin.getText();
        
        p.setNombreCompleto(nombreCompleto);
        p.setEdad(edad);
        p.setTelefono(telefono);
        p.setDomicilio(domicilio);
        p.setCorreo(correo);

        int r = datosPersonalesDAO.agregar(p);
        if (r == 1) {
            JOptionPane.showMessageDialog(VistaDatosPersonales, "El usuario ha sido actualizado con éxito");
        } else {
            JOptionPane.showMessageDialog(VistaDatosPersonales, "Error al actualizar el usuario");
        }
        
}
}