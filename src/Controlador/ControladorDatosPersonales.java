package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorDatosPersonales implements ActionListener {


    DatosPersonalesDao datosPersonalesDAO = new DatosPersonalesDao();

    DatosPersonales p = new DatosPersonales();

    VistaDatosPersonales VistaDatosPersonales = new VistaDatosPersonales();

    public ControladorDatosPersonales(VistaDatosPersonales dp) {
        this.VistaDatosPersonales = dp;
        
        this.VistaDatosPersonales.btnGurdarDatosPersonales.addActionListener(this);
    }

   
    public void actionPerformed(ActionEvent e) {
    

        if (e.getSource() == VistaDatosPersonales.btnGurdarDatosPersonales) {
            agregar();  // Llama al método para agregar los datos a la base de datos
        }
    }
    

    public void agregar() {
        // Obtener los datos ingresados por el usuario desde los campos de texto
        String nombreCompleto = VistaDatosPersonales.txtNombreCompletoLogin.getText();
        int edad = Integer.parseInt(VistaDatosPersonales.txtEdadLogin.getText());
        String telefono = VistaDatosPersonales.txtTelefonoLogin.getText();
        String domicilio = VistaDatosPersonales.txtDomicilioLogin.getText();
        String correo = VistaDatosPersonales.txtCorreoLogin.getText();
        
        // Establecer los valores en el objeto DatosPersonales
        p.setNombreCompleto(nombreCompleto);
        p.setEdad(edad);
        p.setTelefono(telefono);
        p.setDomicilio(domicilio);
        p.setCorreo(correo);

        // Llamar al método del DAO para agregar los datos a la base de datos
        int r = datosPersonalesDAO.agregar(p);
        if (r == 1) {
            JOptionPane.showMessageDialog(VistaDatosPersonales, "El usuario ha sido creado con exito");
        } else {
            JOptionPane.showMessageDialog(VistaDatosPersonales, "Error al crear el usuario");
        }
    }
}
