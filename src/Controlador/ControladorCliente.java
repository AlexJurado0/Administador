/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author coco
 */
public class ControladorCliente implements ActionListener {
    
    ClienteDAO dao = new ClienteDAO();
    Cliente c = new Cliente();
    VistaCliente vista = new VistaCliente();

    public ControladorCliente(VistaCliente vc) {
        
        this.vista = vc;
        this.vista.btnListarCliente.addActionListener(this);
        this.vista.btnModificarCliente.addActionListener(this);
        this.vista.btnOkCliente.addActionListener(this);
        this.vista.btnEliminarCliente.addActionListener(this);
    }
    
    DefaultTableModel modelo=new DefaultTableModel();
    public void actionPerformed(ActionEvent e) {
        
        
       if(e.getSource()==vista.btnListarCliente){
            listar(vista.jTableCliente); 
            limpiarTabla(); 
            listar(vista.jTableCliente); 
        }
       
        if (e.getSource()==vista.btnModificarCliente) {
            int fila=vista.jTableCliente.getSelectedRow();  // Obtiene la fila seleccionada en la tabla
           if(fila==-1){
               JOptionPane.showConfirmDialog(vista, "Debe seleccionar una fila");// Muestra un mensaje si no se selecciona una fila
           }else{
                // Rellena los campos de texto con los datos de la fila seleccionada
               int id_cliente=Integer.parseInt((String)vista.jTableCliente.getValueAt(fila, 0).toString());
               String nombreCompleto=(String) vista.jTableCliente.getValueAt(fila, 1);
               int edad=Integer.parseInt((String)vista.jTableCliente.getValueAt(fila, 2).toString());
               String telefono=(String) vista.jTableCliente.getValueAt(fila, 3);
               String domicilio=(String) vista.jTableCliente.getValueAt(fila, 4);
               String correo=(String) vista.jTableCliente.getValueAt(fila, 5);
               int id_administrador=Integer.parseInt((String)vista.jTableCliente.getValueAt(fila, 6).toString());
               
               vista.txtIdCliente.setText("" + id_cliente);
               vista.txtNombreCompletoCliente.setText(nombreCompleto); 
               vista.txtEdadCliente.setText("" +edad); 
               vista.txtTelefonoCliente.setText(telefono);
               vista.txtDomicilioCliente.setText(domicilio); 
               vista.txtCorreCliente.setText(correo); 
               vista.txtIdAdministadorCliente.setText("" + id_administrador);   
           }
            
        }
        if(e.getSource()==vista.btnOkCliente){
            actualizar(); // Llama al método actualizar para guardar los cambios en la persona
            limpiarTabla(); // Limpia la tabla
            listar(vista.jTableCliente); // Vuelve a listar los datos actualizados en la tabla
        }
        
        if (e.getSource() == vista.btnEliminarCliente) {
            int fila = vista.jTableCliente.getSelectedRow(); // Obtiene la fila seleccionada en la tabla
            if (fila == -1) {
                JOptionPane.showConfirmDialog(vista, "Debe seleccionar un usuario"); // Muestra un mensaje si no se selecciona un usuario
            } else {
                // Elimina el usuario de la base de datos
                int id = Integer.parseInt((String) vista.jTableCliente.getValueAt(fila, 0).toString());
                dao.eliminar(id); // Llama al método eliminar del DAO para eliminar la persona
                limpiarTabla(); // Limpia la tabla
                listar(vista.jTableCliente); // Vuelve a listar los datos actualizados en la tabla
            }
           
        }
            
        
    }
    
    public void listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<Cliente> lista = dao.listar();
        Object[] object = new Object[7]; 
        for (int i = 0; i < lista.size(); i++) { 
          
            object[0] = lista.get(i).getId_cliente();
            object[1] = lista.get(i).getNombreCompleto();
            object[2] = lista.get(i).getEdad();
            object[3] = lista.get(i).getTelefono();
            object[4] = lista.get(i).getDomicilio();
            object[5] = lista.get(i).getCorreo();
            object[6] = lista.get(i).getId_administrador();
            modelo.addRow(object);
        }
        vista.jTableCliente.setModel(modelo); 
    }
    
    // Método para actualizar una persona
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
        
         c.setId_cliente(id_cliente);
        c.setNombreCompleto(nombreCompleto);
        c.setEdad(edad);
        c.setTelefono(telefono);
        c.setDomicilio(domicilio);
        c.setCorreo(correo);
        c.setId_administrador(id_administrador);
        
        
        int r = dao.Actualizar(c); 
        if (r == 1) {
            JOptionPane.showConfirmDialog(vista, "El Cliente ha sido actualizado con exito"); 
        } else {
            JOptionPane.showConfirmDialog(vista, "Error al actualizar el Cliente"); 
        }
    }
    
  
    void limpiarTabla() {
        for (int i = 0; i < vista.jTableCliente.getRowCount(); i++) {
            modelo.removeRow(i); 
            i = i - 1; 
        }
    }
}
