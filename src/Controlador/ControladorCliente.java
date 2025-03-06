/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Login;
import Vista.VistaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author coco
 */
public class ControladorCliente implements ActionListener {
    
    ClienteDAO dao = new ClienteDAO();
    Cliente c = new Cliente();
    VistaCliente vista = new VistaCliente();

    public ControladorCliente() {
    }
    
    DefaultTableModel modelo=new DefaultTableModel();
    public void actionPerformed(ActionEvent e) {
    }
    
    public void listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel(); // Obtiene el modelo de la tabla
        List<Cliente> lista = dao.listar(); // Llama al método listar del DAO para obtener la lista de personas
        Object[] object = new Object[4]; // Crea un arreglo de objetos para almacenar los datos de una persona
        for (int i = 0; i < lista.size(); i++) { // Itera sobre la lista de personas
            // Agrega los datos de la persona a la tabla
            object[0] = lista.get(i).getId_usuario();
            object[1] = lista.get(i).getUsuario();
            object[2] = lista.get(i).getContraseña();
            object[3] = lista.get(i).getRol();
            modelo.addRow(object); // Agrega la fila al modelo de la tabla
        }
        vista.tabla.setModel(modelo); // Establece el modelo actualizado en la vista
    }
    
    // Método para agregar una nueva persona
    public void agregar() {
        String usuario = vista.txtUsuarioLogin.getText(); // Obtiene el nombre desde el campo de texto
        String contraseña = vista.txtContraseñaLogin.getText(); // Obtiene el correo desde el campo de texto
        String rolStr = vista.txtRolLogin.getText(); 
        int rol = Integer.parseInt(rolStr); // Obtiene el teléfono desde el campo de texto
        p.setUsuario(usuario); // Establece el nombre en el objeto persona
        p.setContraseña(contraseña); // Establece el correo en el objeto persona
        p.setRol(rol); // Establece el teléfono en el objeto persona
        int r = dao.agregar(p); // Llama al método agregar del DAO para guardar la persona
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Usuario agregado con Exito!"); // Muestra un mensaje de éxito
        } else {
            JOptionPane.showMessageDialog(vista, "Error al agregar usuario!"); // Muestra un mensaje de error
        }
    }
    
    // Método para actualizar una persona
    public void actualizar() {
        int id = Integer.parseInt(vista.txtIdLogin.getText()); // Obtiene el ID desde el campo de texto
        String usuario = vista.txtUsuarioLogin.getText(); // Obtiene el nombre desde el campo de texto
        String contraseña = vista.txtContraseñaLogin.getText(); // Obtiene el correo desde el campo de texto
        String rolStr = vista.txtRolLogin.getText(); 
        int rol = Integer.parseInt(rolStr); // Obtiene el teléfono desde el campo de texto
        p.setId_usuario(id); // Establece el ID en el objeto persona
        p.setUsuario(usuario); // Establece el nombre en el objeto persona
        p.setContraseña(contraseña); // Establece el correo en el objeto persona
        p.setRol(rol); // Establece el teléfono en el objeto persona
        int r = dao.Actualizar(p); // Llama al método Actualizar del DAO para actualizar la persona
        if (r == 1) {
            JOptionPane.showConfirmDialog(vista, "El usuario ha sido actualizado con exito"); // Muestra un mensaje de éxito
        } else {
            JOptionPane.showConfirmDialog(vista, "Error al actualizar el usuario"); // Muestra un mensaje de error
        }
    }
    
    // Método para limpiar la tabla antes de mostrar los nuevos datos
    void limpiarTabla() {
        for (int i = 0; i < vista.tabla.getRowCount(); i++) {
            modelo.removeRow(i); // Elimina las filas de la tabla
            i = i - 1; // Ajusta el índice para no saltar filas
        }
    }
}
