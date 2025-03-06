
package Controlador;

import Modelo.Login;
import Modelo.LoginDAO;
import Vista.VistaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JOptionPane;

//Controlador que implementa ActionListener
public class ControladorLogin implements ActionListener{

    // Crea un objeto dao de la clase PersonaDAO para interactuar con la base de datos
    LoginDAO dao=new LoginDAO();
    // Crea un objeto Persona 
    Login p=new Login();
    // Crea un objeto vista de la clase Vista que maneja la interfaz gráfica
    VistaLogin vista=new VistaLogin();
    // Crea un modelo para la tabla (para manejar los datos que se muestran en la tabla)
    DefaultTableModel modelo=new DefaultTableModel();
    
 // Constructor que inicializa la vista y agrega los listeners a los botones
    public ControladorLogin (VistaLogin v){
        this.vista = v; // Asocia la vista pasada como parámetro
        this.vista.btnListarLogin.addActionListener(this); // Agrega el listener al botón "Listar"
        this.vista.btnGuardarLogin.addActionListener(this); // Agrega el listener al botón "Guardar"
        this.vista.btnEditarLogin.addActionListener(this); // Agrega el listener al botón "Editar"
        this.vista.btnOkLogin.addActionListener(this); // Agrega el listener al botón "OK"
        this.vista.btnEliminarLogin.addActionListener(this); // Agrega el listener al botón "Eliminar"
        listar(vista.tabla); // Llama al método listar para llenar la tabla de la vista con los datos
        
    }
    
    // Método que maneja los eventos de acción (cuando se hace clic en los botones)
    public void actionPerformed(ActionEvent e) {
         // Si se hace clic en el botón "Listar"
        if(e.getSource()==vista.btnListarLogin){
            listar(vista.tabla); // Llama al método listar para mostrar los datos en la tabla
            limpiarTabla(); // Limpia la tabla antes de volver a mostrar los datos
            listar(vista.tabla); // Llama nuevamente al método listar para actualizar la tabla
        }
         // Si se hace clic en el botón "Guardar"
        if(e.getSource()==vista.btnGuardarLogin){
            agregar(); // Llama al método agregar para guardar una nueva persona
            limpiarTabla(); // Limpia la tabla
            listar(vista.tabla); // Vuelve a listar los datos en la tabla
        }
        if(e.getSource()==vista.btnEditarLogin){
           int fila=vista.tabla.getSelectedRow();  // Obtiene la fila seleccionada en la tabla
           if(fila==-1){
               JOptionPane.showConfirmDialog(vista, "Debe seleccionar una fila");// Muestra un mensaje si no se selecciona una fila
           }else{
                // Rellena los campos de texto con los datos de la fila seleccionada
               int id=Integer.parseInt((String)vista.tabla.getValueAt(fila, 0).toString());
               String nom=(String) vista.tabla.getValueAt(fila, 1);
               String correo=(String) vista.tabla.getValueAt(fila, 2);
               String telefono=(String) vista.tabla.getValueAt(fila, 3);
               vista.txtIdLogin.setText("" + id); // Establece el ID en el campo de texto
                vista.txtUsuarioLogin.setText(nom); // Establece el nombre en el campo de texto
                vista.txtContraseñaLogin.setText(correo); // Establece el correo en el campo de texto
                vista.txtRolLogin.setText(telefono); // Establece el teléfono en el campo de texto
           }
        }
      
        if(e.getSource()==vista.tabla){
            actualizar(); // Llama al método actualizar para guardar los cambios en la persona
            limpiarTabla(); // Limpia la tabla
            listar(vista.tabla); // Vuelve a listar los datos actualizados en la tabla
        }
        
        // Si se hace clic en el botón "Eliminar"
        if (e.getSource() == vista.btnEliminarLogin) {
            int fila = vista.tabla.getSelectedRow(); // Obtiene la fila seleccionada en la tabla
            if (fila == -1) {
                JOptionPane.showConfirmDialog(vista, "Debe seleccionar un usuario"); // Muestra un mensaje si no se selecciona un usuario
            } else {
                // Elimina el usuario de la base de datos
                int id = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
                dao.eliminar(id); // Llama al método eliminar del DAO para eliminar la persona
                limpiarTabla(); // Limpia la tabla
                listar(vista.tabla); // Vuelve a listar los datos actualizados en la tabla
            }
           
        }
    }
    
   // Método para listar las personas en la tabla
    public void listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel(); // Obtiene el modelo de la tabla
        List<Login> lista = dao.listar(); // Llama al método listar del DAO para obtener la lista de personas
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