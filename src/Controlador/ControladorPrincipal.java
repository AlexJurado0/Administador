
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.*;

public class ControladorPrincipal implements ActionListener{
    
         private VistaMenu vistaMenu;
         private ControladorLogin controladorLogin;
         private ControladorDatosPersonales controladorDatosPersonales;
         private ControladorCliente ControladorCliente;
         
         private VistaLogin vistaLogin;  
         private VistaDatosPersonales vistaDatosPersonales;
         private VistaAdministrador vistaAdministrador;
         private VistaCliente vistaCliente;

    public ControladorPrincipal(VistaMenu vistaMenu, VistaLogin vistaLogin, VistaDatosPersonales vistaDatosPersonales, VistaAdministrador vistaAdministrador, VistaCliente vistaCliente) {
        this.vistaMenu = vistaMenu;
        this.vistaLogin = vistaLogin;
        this.vistaDatosPersonales = vistaDatosPersonales;
        this.vistaAdministrador = vistaAdministrador;
        this.vistaCliente = vistaCliente;
        
        
        this.controladorLogin = new ControladorLogin(vistaLogin);
        this.controladorDatosPersonales = new ControladorDatosPersonales(vistaDatosPersonales);
        this.ControladorCliente = new ControladorCliente(vistaCliente);
        
        
        this.vistaMenu.btnLogin.addActionListener(this);
        this.vistaMenu.btnCliente.addActionListener(this);
        this.vistaMenu.btnAdministrador.addActionListener(this);
        this.vistaLogin.btnGuardarLogin.addActionListener(this);
        this.vistaDatosPersonales.btnGurdarDatosPersonales.addActionListener(this);
    }
          
    private void asignarEventos(VistaMenu me, VistaLogin vl, VistaDatosPersonales vdp, VistaCliente vc, VistaAdministrador va) {
        this.vistaMenu = me;
        this.vistaLogin = vl;
        this.vistaDatosPersonales = vdp;
        this.vistaCliente = vc;
        this.vistaAdministrador = va;
         
        
        
    }
    
    
    public void actionPerformed(ActionEvent e) {
    
        Object source = e.getSource();
        
        if (source == vistaMenu.btnLogin) {
            vistaMenu.setVisible(false);
            vistaLogin.setVisible(true);
        }
       
        if (source == vistaLogin.btnGuardarLogin) {
            vistaLogin.setVisible(false);
            vistaDatosPersonales.setVisible(true);
        }
        if (source == vistaDatosPersonales.btnGurdarDatosPersonales) {
            vistaDatosPersonales.setVisible(false);
            vistaLogin.setVisible(true);
        }
        
        if (source == vistaMenu.btnCliente) {
            vistaMenu.setVisible(false);
            vistaCliente.setVisible(true);
        }
        if (source == vistaMenu.btnAdministrador) {
            vistaMenu.setVisible(false);
            vistaAdministrador.setVisible(true);
        }   
    }
}
