package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Vista.VistaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorCliente implements ActionListener {

    ClienteDAO dao = new ClienteDAO();  
    Cliente c = new Cliente(); 
    VistaCliente vista = new VistaCliente();  
    
    // Modelo de la tabla que maneja los datos a mostrar en la vista
    DefaultTableModel modelo = new DefaultTableModel(); 

    
    public ControladorCliente(VistaCliente vc) {
        this.vista = vc;
        this.vista.btnModificarCliente.addActionListener(this);  
        this.vista.btnOkCliente.addActionListener(this);  
        this.vista.btnEliminarCliente.addActionListener(this); 
        this.vista.btnListarCliente.addActionListener(this);  
        listar(vista.jTableCliente);  
    }

    
    public void actionPerformed(ActionEvent e) {
        // Acción para listar los clientes
        if (e.getSource() == vista.btnListarCliente) {
            limpiarTabla();
            listar(vista.jTableCliente);
        }

        // Acción para modificar un cliente
        if (e.getSource() == vista.btnModificarCliente) {
            int fila = vista.jTableCliente.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showConfirmDialog(vista, "Debe seleccionar una fila");
            } else {
                // Obtener los datos de la fila seleccionada
                int id_cliente = Integer.parseInt((String) vista.jTableCliente.getValueAt(fila, 0).toString());
                String nombreCompleto = (String) vista.jTableCliente.getValueAt(fila, 1);
                int edad = Integer.parseInt((String) vista.jTableCliente.getValueAt(fila, 2).toString());
                String telefono = (String) vista.jTableCliente.getValueAt(fila, 3);
                String domicilio = (String) vista.jTableCliente.getValueAt(fila, 4);
                String correo = (String) vista.jTableCliente.getValueAt(fila, 5);
                int id_administrador = Integer.parseInt((String) vista.jTableCliente.getValueAt(fila, 6).toString());

                // Rellenar los campos de texto con los datos de la fila seleccionada
                vista.txtIdCliente.setText("" + id_cliente);
                vista.txtNombreCompletoCliente.setText(nombreCompleto);
                vista.txtEdadCliente.setText("" + edad);
                vista.txtTelefonoCliente.setText(telefono);
                vista.txtDomicilioCliente.setText(domicilio);
                vista.txtCorreCliente.setText(correo);
                vista.txtIdAdministadorCliente.setText("" + id_administrador);
            }
        }

        // Acción para guardar la modificación del cliente
        if (e.getSource() == vista.btnOkCliente) {
            actualizar();
            limpiarTabla();
            listar(vista.jTableCliente);
        }

        // Acción para eliminar un cliente
        if (e.getSource() == vista.btnEliminarCliente) {
            int fila = vista.jTableCliente.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showConfirmDialog(vista, "Debe seleccionar un usuario");
            } else {
                int id = Integer.parseInt((String) vista.jTableCliente.getValueAt(fila, 0).toString());
                dao.eliminar(id);
                limpiarTabla();
                listar(vista.jTableCliente);
            }
        }
    }

    public void listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<Cliente> lista = dao.listar();  
        Object[] object = new Object[7];  
        for (int i = 0; i < lista.size(); i++) {
            // Rellenar el array con los datos del cliente
            object[0] = lista.get(i).getId_cliente();
            object[1] = lista.get(i).getNombreCompleto();
            object[2] = lista.get(i).getEdad();
            object[3] = lista.get(i).getTelefono();
            object[4] = lista.get(i).getDomicilio();
            object[5] = lista.get(i).getCorreo();
            object[6] = lista.get(i).getId_administrador();
            modelo.addRow(object);  // Añadir la fila a la tabla
        }
        vista.jTableCliente.setModel(modelo);  // Establecer el modelo de la tabla con los datos
    }

    /**
     * Método que actualiza la información de un cliente en la base de datos.
     */
    public void actualizar() {
        String id_clienteStr = vista.txtIdCliente.getText();
        int id_cliente = Integer.parseInt(id_clienteStr);
        String nombreCompleto = vista.txtNombreCompletoCliente.getText();
        String edadStr = vista.txtEdadCliente.getText();
        int edad = Integer.parseInt(edadStr);
        String telefono = vista.txtTelefonoCliente.getText();
        String domicilio = vista.txtDomicilioCliente.getText();
        String correo = vista.txtCorreCliente.getText();
        String id_administradorStr = vista.txtIdAdministadorCliente.getText();
        int id_administrador = Integer.parseInt(id_administradorStr);

        // Establecer los valores del cliente en el objeto cliente
        c.setId_cliente(id_cliente);
        c.setNombreCompleto(nombreCompleto);
        c.setEdad(edad);
        c.setTelefono(telefono);
        c.setDomicilio(domicilio);
        c.setCorreo(correo);
        c.setId_administrador(id_administrador);

        // Actualizar el cliente en la base de datos
        int r = dao.Actualizar(c);
        if (r == 1) {
            JOptionPane.showConfirmDialog(vista, "El Cliente ha sido actualizado con exito");
        } else {
            JOptionPane.showConfirmDialog(vista, "Error al actualizar el Cliente");
        }
    }

    /**
     * Método que limpia todas las filas de la tabla de clientes.
     */
    void limpiarTabla() {
        for (int i = 0; i < vista.jTableCliente.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;  // Decrementar el índice para evitar problemas al eliminar filas
        }
    }
}
