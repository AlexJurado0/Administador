package Principal;

import Controlador.ControladorPrincipal;
import Vista.*;

public class Main {
    public static void main(String[] args) {
        // Instanciamos todas las vistas
        VistaMenu menu = new VistaMenu();
        VistaLogin VistaLogin = new VistaLogin();
        VistaDatosPersonales VistaDatosPersonales = new VistaDatosPersonales();
        VistaCliente VistaCliente = new VistaCliente();
        VistaAdministrador VistaAdministrador = new VistaAdministrador();

        // Creamos el controlador pasándole las vistas
        ControladorPrincipal ControladorPrincipal = new ControladorPrincipal(menu, VistaLogin, VistaDatosPersonales, VistaAdministrador, VistaCliente);

        // Hacemos visible el menú principal
        menu.setVisible(true);
    }
}