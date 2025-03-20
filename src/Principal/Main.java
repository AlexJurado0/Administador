package Principal;

import Controlador.ControladorPrincipal;
import Vista.*;

public class Main {
    public static void main(String[] args) {
        
        VistaMenu menu = new VistaMenu();
        VistaLogin VistaLogin = new VistaLogin();
        VistaDatosPersonales VistaDatosPersonales = new VistaDatosPersonales();
        VistaCliente VistaCliente = new VistaCliente();
        VistaAdministrador VistaAdministrador = new VistaAdministrador();

       
        ControladorPrincipal ControladorPrincipal = new ControladorPrincipal(menu, VistaLogin, VistaDatosPersonales, VistaAdministrador, VistaCliente);

       
        menu.setVisible(true);
    }
}