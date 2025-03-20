package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.*;

public class ControladorPrincipal implements ActionListener {
    
   
    private VistaMenu vistaMenu; 
    private ControladorLogin controladorLogin; 
    private ControladorDatosPersonales controladorDatosPersonales; 
    private ControladorCliente controladorCliente; 
    private ControladorAdministrador controladorAdministrador; 
    
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
        
        // Inicialización de los controladores para cada vista
        this.controladorLogin = new ControladorLogin(vistaLogin);
        this.controladorDatosPersonales = new ControladorDatosPersonales(vistaDatosPersonales);
        this.controladorCliente = new ControladorCliente(vistaCliente);
        this.controladorAdministrador = new ControladorAdministrador(vistaAdministrador);
        
        // Asignar eventos a los botones de cada vista
        asignarEventos();
    }
   
    public void asignarEventos(){
        this.vistaMenu.btnLogin.addActionListener(this); 
        this.vistaMenu.btnCliente.addActionListener(this); 
        this.vistaMenu.btnAdministrador.addActionListener(this); 
        this.vistaLogin.btnGuardarLogin.addActionListener(this); 
        this.vistaDatosPersonales.btnGurdarDatosPersonales.addActionListener(this); 
        
        // Botones para volver en cada vista
        vistaLogin.btnVolver.addActionListener(this);
        vistaCliente.btnVolver.addActionListener(this);
        vistaAdministrador.btnVolver.addActionListener(this);
        vistaDatosPersonales.btnVolver.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource(); // Obtenemos el origen del evento
        
        // Si se presiona el botón Login en el menú
        if (source == vistaMenu.btnLogin) {
            vistaMenu.setVisible(false); 
            vistaLogin.setVisible(true);
        }
        
        // Si se presiona el botón Guardar en la vista Login
        if (source == vistaLogin.btnGuardarLogin) {
            vistaLogin.setVisible(false); 
            vistaDatosPersonales.setVisible(true);
        }
        
        // Si se presiona el botón Guardar Datos Personales
        if (source == vistaDatosPersonales.btnGurdarDatosPersonales) {
            vistaDatosPersonales.setVisible(false); 
            vistaLogin.setVisible(true); 
        }
        
        // Si se presiona el botón Cliente en el menú
        if (source == vistaMenu.btnCliente) {
            vistaMenu.setVisible(false); 
            vistaCliente.setVisible(true);
        }
        
        // Si se presiona el botón Administrador en el menú
        if (source == vistaMenu.btnAdministrador) {
            vistaMenu.setVisible(false); 
            vistaAdministrador.setVisible(true);
        }
        
        // Si se presiona el botón Volver en cualquier vista (Login, Cliente, Administrador)
        if (source == vistaLogin.btnVolver || source == vistaCliente.btnVolver || source == vistaAdministrador.btnVolver) {
            // Oculta las vistas de Login, Cliente y Administrador, y muestra el menú
            vistaLogin.setVisible(false);
            vistaCliente.setVisible(false);
            vistaAdministrador.setVisible(false);
            vistaMenu.setVisible(true);
        }
        
        // Si se presiona el botón Volver en la vista de Datos Personales
        if (source == vistaDatosPersonales.btnVolver) {
            vistaDatosPersonales.setVisible(false);
            vistaLogin.setVisible(true);
        }
    }
}
