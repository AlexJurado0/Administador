package Controlador;

import Modelo.Login;
import Modelo.LoginDAO;
import Vista.VistaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorLogin implements ActionListener {

    LoginDAO dao = new LoginDAO();
    
    Login p = new Login();

    VistaLogin vista = new VistaLogin();

    public ControladorLogin(VistaLogin vl) {
        
        this.vista = vl;     
        
        // Agregar los ActionListeners a los botones de la vista
        this.vista.btnEditarLogin.addActionListener(this);
        this.vista.btnOkLogin.addActionListener(this);
        this.vista.btnEliminarLogin.addActionListener(this);
        this.vista.btnGuardarLogin.addActionListener(this); 
        
        // Listar los usuarios en la tabla al iniciar
        listar(vista.tabla);
    }
    
    DefaultTableModel modelo = new DefaultTableModel();

    public void actionPerformed(ActionEvent e) {
        
        // Si el usuario presiona el botón de guardar usuario
        if (e.getSource() == vista.btnGuardarLogin) {
            agregar();  
            limpiarTabla();  // Limpiar la tabla
            listar(vista.tabla);  // Volver a listar los usuarios
        }

        // Si el usuario presiona el botón de editar usuario
        if (e.getSource() == vista.btnEditarLogin) {
            int fila = vista.tabla.getSelectedRow(); 
            if (fila == -1) {
                JOptionPane.showConfirmDialog(vista, "Debe seleccionar una fila");
            } else {
                // Obtener los datos del usuario seleccionado en la tabla
                int id_usuario = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
                String usuario = (String) vista.tabla.getValueAt(fila, 1);
                String contraseña = (String) vista.tabla.getValueAt(fila, 2);
                int rol = Integer.parseInt((String) vista.tabla.getValueAt(fila, 3).toString());
                
                // Llenar los campos de la vista con los datos del usuario seleccionado
                vista.txtIdLogin.setText("" + id_usuario);
                vista.txtUsuarioLogin.setText(usuario); 
                vista.txtContraseñaLogin.setText(contraseña); 
                vista.txtRolLogin.setText("" + rol);   
            }
        }
        
        // Si el usuario presiona el botón de confirmar (Ok) para actualizar
        if (e.getSource() == vista.btnOkLogin) {
            actualizar(); 
            limpiarTabla();  // Limpiar la tabla
            listar(vista.tabla);  // Volver a listar los usuarios
        }
        
        // Si el usuario presiona el botón de eliminar usuario
        if (e.getSource() == vista.btnEliminarLogin) {
            int fila = vista.tabla.getSelectedRow();  
            if (fila == -1) {
                JOptionPane.showConfirmDialog(vista, "Debe seleccionar un usuario");
            } else {
                // Obtener el id del usuario a eliminar
                int id = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
                dao.eliminar(id);  // Eliminar el usuario de la base de datos
                limpiarTabla();  // Limpiar la tabla
                listar(vista.tabla);  // Volver a listar los usuarios
                JOptionPane.showMessageDialog(vista, "El usuario ha sido eliminado con éxito");
            }
        }
    }

    public void agregar() {
        // Obtener los datos ingresados por el usuario desde la vista
        String usuario = vista.txtUsuarioLogin.getText();
        String contraseña = vista.txtContraseñaLogin.getText();
        int rol = Integer.parseInt(vista.txtRolLogin.getText());

        // Establecer los valores en el objeto Login
        p.setUsuario(usuario);
        p.setContraseña(contraseña);
        p.setRol(rol);

        // Llamar al método del DAO para agregar el usuario a la base de datos
        int r = dao.agregar(p);  

        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Usuario agregado correctamente.");
        } else {
            JOptionPane.showMessageDialog(vista, "El usuario ya existe, no se puede agregar.");
        }
    }

    public void listar(JTable tabla) {
        // Obtener el modelo de la tabla
        modelo = (DefaultTableModel) tabla.getModel();
        
        List<Login> lista = dao.listar();
        Object[] object = new Object[4];

        for (int i = 0; i < lista.size(); i++) { 
            object[0] = lista.get(i).getId_usuario();
            object[1] = lista.get(i).getUsuario();
            object[2] = lista.get(i).getContraseña();
            object[3] = lista.get(i).getRol();
            modelo.addRow(object);  // Añadir los datos del usuario a la tabla
        }
        
        // Actualizar el modelo de la tabla
        vista.tabla.setModel(modelo);  
    }

    public void actualizar() {
        // Obtener los datos del usuario desde los campos de la vista
        int id_usuario = Integer.parseInt(vista.txtIdLogin.getText()); 
        String usuario = vista.txtUsuarioLogin.getText();
        String contraseña = vista.txtContraseñaLogin.getText();
        int rol = Integer.parseInt(vista.txtRolLogin.getText());
        
        // Establecer los valores en el objeto Login
        p.setId_usuario(id_usuario);
        p.setUsuario(usuario);
        p.setContraseña(contraseña);
        p.setRol(rol);
        
        // Llamar al método del DAO para actualizar el usuario en la base de datos
        int r = dao.Actualizar(p); 
        
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "El usuario ha sido actualizado con éxito"); 
        } else {
            JOptionPane.showMessageDialog(vista, "Error al actualizar el usuario"); 
        }
    }

    void limpiarTabla() {
        // Eliminar todas las filas de la tabla
        for (int i = 0; i < vista.tabla.getRowCount(); i++) {
            modelo.removeRow(i); 
            i = i - 1; 
        }
    }
}
