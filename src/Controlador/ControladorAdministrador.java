package Controlador;

import Modelo.Administrador;
import Modelo.AdministradorDAO;
import Vista.VistaAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorAdministrador implements ActionListener {
    AdministradorDAO dao = new AdministradorDAO();
    
    Administrador admin = new Administrador();

    VistaAdministrador vista;
  
    // Modelo de la tabla que maneja los datos que se mostrarán en la vista
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorAdministrador(VistaAdministrador va) {
        this.vista = va;

        // Asignar ActionListener a los botones de la vista
        this.vista.btnModificarAdministrador.addActionListener(this);
        this.vista.btnOkAdministrador.addActionListener(this);
        this.vista.btnEliminarAdministrador.addActionListener(this);
        this.vista.btnListarAdministrador.addActionListener(this);

        // Llenar la tabla con los datos de los administradores al iniciar
        listar(vista.jTableAdministrador);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Acción para listar los administradores
        if (e.getSource() == vista.btnListarAdministrador) {
            limpiarTabla(); 
            listar(vista.jTableAdministrador); 
        }

        // Acción para modificar un administrador
        if (e.getSource() == vista.btnModificarAdministrador) {
            int fila = vista.jTableAdministrador.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
            } else {
                // Obtener los valores de la fila seleccionada
                int id_administrador = Integer.parseInt(vista.jTableAdministrador.getValueAt(fila, 0).toString());
                String nombreCompleto = vista.jTableAdministrador.getValueAt(fila, 1).toString();
                int edad = Integer.parseInt(vista.jTableAdministrador.getValueAt(fila, 2).toString());
                String telefono = vista.jTableAdministrador.getValueAt(fila, 3).toString();
                String domicilio = vista.jTableAdministrador.getValueAt(fila, 4).toString();
                String correo = vista.jTableAdministrador.getValueAt(fila, 5).toString();
                int id_usuario = Integer.parseInt(vista.jTableAdministrador.getValueAt(fila, 6).toString());
                int pago = Integer.parseInt(vista.jTableAdministrador.getValueAt(fila, 7).toString());

                // Colocar los valores obtenidos en los campos de texto de la vista
                vista.txtIdAdministrador.setText(String.valueOf(id_administrador));
                vista.txtNombreCompletoAdministrador.setText(nombreCompleto);
                vista.txtEdadAdministrador.setText(String.valueOf(edad));
                vista.txtTelefonoAdministrador.setText(telefono);
                vista.txtDomicilioAdministrador.setText(domicilio);
                vista.txtCorreAdministrador.setText(correo);
                vista.txtIdUsuarioAdministrador.setText(String.valueOf(id_usuario));
                vista.txtPagoAdministrador.setText(String.valueOf(pago));
            }
        }

        // Acción para guardar la modificación del administrador
        if (e.getSource() == vista.btnOkAdministrador) {
            actualizar();
            limpiarTabla();
            listar(vista.jTableAdministrador);
        }

        // Acción para eliminar un administrador
        if (e.getSource() == vista.btnEliminarAdministrador) {
            int fila = vista.jTableAdministrador.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar un administrador");
            } else {
                // Obtener el id del administrador seleccionado
                int id = Integer.parseInt(vista.jTableAdministrador.getValueAt(fila, 0).toString());
                dao.eliminar(id);
                limpiarTabla();
                listar(vista.jTableAdministrador);
            }
        }
    }

    public void listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<Administrador> lista = dao.listar();
        Object[] object = new Object[8]; 
        for (Administrador a : lista) {
            object[0] = a.getId_administrador();
            object[1] = a.getNombreCompleto();
            object[2] = a.getEdad();
            object[3] = a.getTelefono();
            object[4] = a.getDomicilio();
            object[5] = a.getCorreo();
            object[6] = a.getId_usuario();
            object[7] = a.getPago(); 
            modelo.addRow(object);
        }
        vista.jTableAdministrador.setModel(modelo);
    }

    public void actualizar() {
        // Obtener los valores de los campos de texto en la vista
        int id_administrador = Integer.parseInt(vista.txtIdAdministrador.getText());
        String nombreCompleto = vista.txtNombreCompletoAdministrador.getText();
        int edad = Integer.parseInt(vista.txtEdadAdministrador.getText());
        String telefono = vista.txtTelefonoAdministrador.getText();
        String domicilio = vista.txtDomicilioAdministrador.getText();
        String correo = vista.txtCorreAdministrador.getText();
        int id_usuario = Integer.parseInt(vista.txtIdUsuarioAdministrador.getText());
        int pago = Integer.parseInt(vista.txtPagoAdministrador.getText());

        // Asignar los valores obtenidos al objeto Administrador
        admin.setId_administrador(id_administrador);
        admin.setNombreCompleto(nombreCompleto);
        admin.setEdad(edad);
        admin.setTelefono(telefono);
        admin.setDomicilio(domicilio);
        admin.setCorreo(correo);
        admin.setId_usuario(id_usuario);
        admin.setPago(pago);

        // Actualizar el administrador en la base de datos
        int r = dao.actualizar(admin);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "El administrador ha sido actualizado con éxito");
        } else {
            JOptionPane.showMessageDialog(vista, "Error al actualizar el administrador");
        }
    }

    /**
     * Método que limpia todas las filas de la tabla.
     */
    void limpiarTabla() {
        for (int i = 0; i < vista.jTableAdministrador.getRowCount(); i++) {
            modelo.removeRow(i);
            i--;
        }
    }
}
