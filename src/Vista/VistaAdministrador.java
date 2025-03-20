package Vista;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author coco
 */
public class VistaAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form VistaAdministrador1
     */
    public VistaAdministrador() {
    initComponents(); // Inicializa los componentes de la interfaz

    // Configurar el renderizador personalizado para la tabla
    jTableAdministrador.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // Llama al método de la clase padre para mantener el comportamiento predeterminado
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Obtener el índice de la columna "Pago" (suponiendo que es la columna 7)
            int columnaPago = 7;

            // Verificar si la columna actual es la columna "Pago"
            if (column == columnaPago) {
                // Obtener el valor de la columna "Pago"
                Object valorPago = table.getModel().getValueAt(row, columnaPago);

                // Verificar si el valor es null
                if (valorPago != null) {
                    int pago = Integer.parseInt(valorPago.toString());

                    // Cambiar el color de fondo solo para la celda de "Pago"
                    if (pago == 1) {
                        c.setBackground(Color.GREEN); // Verde si el pago es 1 (true)
                        c.setForeground(Color.BLACK); // Color del texto
                    } else {
                        c.setBackground(Color.RED); // Rojo si el pago es 0 (false)
                        c.setForeground(Color.WHITE); // Color del texto
                    }
                } else {
                    // Si el valor es null, usar un color predeterminado
                    c.setBackground(table.getBackground());
                    c.setForeground(table.getForeground());
                }
            } else {
                // Restablecer el color de fondo para las otras celdas
                c.setBackground(table.getBackground());
                c.setForeground(table.getForeground());
            }

            return c;
        }
    });
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtIdAdministrador = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombreCompletoAdministrador = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEdadAdministrador = new javax.swing.JTextField();
        txtCorreAdministrador = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDomicilioAdministrador = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelefonoAdministrador = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtIdUsuarioAdministrador = new javax.swing.JTextField();
        btnEliminarAdministrador = new javax.swing.JButton();
        btnOkAdministrador = new javax.swing.JButton();
        btnModificarAdministrador = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAdministrador = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        txtPagoAdministrador = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnListarAdministrador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Id_administrador");

        txtIdAdministrador.setEditable(false);
        txtIdAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdAdministradorActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre Completo");

        txtNombreCompletoAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCompletoAdministradorActionPerformed(evt);
            }
        });

        jLabel2.setText("Edad");

        txtEdadAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadAdministradorActionPerformed(evt);
            }
        });

        txtCorreAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreAdministradorActionPerformed(evt);
            }
        });

        jLabel5.setText("Correo");

        txtDomicilioAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDomicilioAdministradorActionPerformed(evt);
            }
        });

        jLabel6.setText("Domicilio");

        txtTelefonoAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoAdministradorActionPerformed(evt);
            }
        });

        jLabel7.setText("Id_usuario");

        txtIdUsuarioAdministrador.setEditable(false);
        txtIdUsuarioAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdUsuarioAdministradorActionPerformed(evt);
            }
        });

        btnEliminarAdministrador.setText("Eliminar");

        btnOkAdministrador.setText("Ok");

        btnModificarAdministrador.setText("Modificar");

        jTableAdministrador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_Administrador", "Nombre Completo", "Edad", "Telefono", "Domicilio", "Correo", "Id_usuario", "Pago"
            }
        ));
        jScrollPane1.setViewportView(jTableAdministrador);

        btnVolver.setText("Volver");

        txtPagoAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagoAdministradorActionPerformed(evt);
            }
        });

        jLabel8.setText("Pago");

        btnListarAdministrador.setText("Listar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVolver))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefonoAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 39, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombreCompletoAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDomicilioAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEdadAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(txtPagoAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel7)
                        .addGap(55, 55, 55)
                        .addComponent(txtIdUsuarioAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(btnListarAdministrador)
                .addGap(18, 18, 18)
                .addComponent(btnModificarAdministrador)
                .addGap(18, 18, 18)
                .addComponent(btnOkAdministrador)
                .addGap(24, 24, 24)
                .addComponent(btnEliminarAdministrador)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreCompletoAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtEdadAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(jLabel4)
                    .addComponent(txtIdAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefonoAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCorreAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addComponent(txtDomicilioAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdUsuarioAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPagoAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOkAdministrador)
                    .addComponent(btnEliminarAdministrador)
                    .addComponent(btnListarAdministrador)
                    .addComponent(btnModificarAdministrador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void txtIdAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdAdministradorActionPerformed

    private void txtNombreCompletoAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCompletoAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCompletoAdministradorActionPerformed

    private void txtEdadAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadAdministradorActionPerformed

    private void txtCorreAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreAdministradorActionPerformed

    private void txtDomicilioAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDomicilioAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomicilioAdministradorActionPerformed

    private void txtTelefonoAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoAdministradorActionPerformed

    private void txtIdUsuarioAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdUsuarioAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdUsuarioAdministradorActionPerformed

    private void txtPagoAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagoAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagoAdministradorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEliminarAdministrador;
    public javax.swing.JButton btnListarAdministrador;
    public javax.swing.JButton btnModificarAdministrador;
    public javax.swing.JButton btnOkAdministrador;
    public javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableAdministrador;
    public javax.swing.JTextField txtCorreAdministrador;
    public javax.swing.JTextField txtDomicilioAdministrador;
    public javax.swing.JTextField txtEdadAdministrador;
    public javax.swing.JTextField txtIdAdministrador;
    public javax.swing.JTextField txtIdUsuarioAdministrador;
    public javax.swing.JTextField txtNombreCompletoAdministrador;
    public javax.swing.JTextField txtPagoAdministrador;
    public javax.swing.JTextField txtTelefonoAdministrador;
    // End of variables declaration//GEN-END:variables
}
