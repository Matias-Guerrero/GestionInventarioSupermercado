package gestorsupermercadoinventario.ventanas;

import gestorsupermercadoinventario.Gestor;
import gestorsupermercadoinventario.Producto;
import gestorsupermercadoinventario.Proveedor;
import javax.swing.JOptionPane;

/**
 * La clase `VentanaListaProducto` representa la ventana para listar productos de un proveedor.
 */
public class VentanaListaProducto extends javax.swing.JFrame {
    private Gestor gestor;
    
    /**
     * El constructor de la clase `VentanaListaProducto`.
     *
     * @param gestor El gestor que controla las operaciones del sistema.
     */
    public VentanaListaProducto(Gestor gestor ) {
        initComponents();
        this.gestor = gestor;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomProveedor = new javax.swing.JTextField();
        enter = new javax.swing.JButton();
        backToMenu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/superLogo (1) (1).png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Noteworthy", 0, 18)); // NOI18N
        jLabel1.setText("Lista de productos de proveedor");

        jLabel2.setText("Ingrese el nombre del proveedor : ");

        enter.setText("Enter");
        enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterActionPerformed(evt);
            }
        });

        backToMenu.setText("Volver a Menú");
        backToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMenuActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backToMenu)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(logo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                            .addComponent(nomProveedor)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(enter, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(logo))
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(nomProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(enter, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(backToMenu)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterActionPerformed
        // TODO add your handling code here:
        
                                             
    // TODO add your handling code here:
    
    String nombreProveedor = nomProveedor.getText();

    if (nombreProveedor == null || (!nombreProveedor.equals("Proveedor A") && !nombreProveedor.equals("Proveedor B") && !nombreProveedor.equals("Proveedor C"))) {
        JOptionPane.showMessageDialog(null, "Error: El proveedor debe ser 'Proveedor A', 'Proveedor B' o 'Proveedor C'.");
        return; // Sale del método si ocurre un error
    }
    
    Proveedor proveedor = gestor.buscarProveedor(nombreProveedor);
    if (proveedor == null) {
        JOptionPane.showMessageDialog(null, "No se encontró el proveedor");
    }
    
    StringBuilder productosSuministradosText = new StringBuilder();
    productosSuministradosText.append("Productos suministrados por ").append(nombreProveedor).append(":\n");
    productosSuministradosText.append("========================================\n");

    for (Producto producto : proveedor.getProductosSuministrados()) {
        productosSuministradosText.append("Nombre: ").append(producto.getNombre()).append("\n");
        productosSuministradosText.append("Código de Barra: ").append(producto.getCodigoBarra()).append("\n");
        productosSuministradosText.append("Precio: ").append(producto.getPrecio()).append("\n");
        productosSuministradosText.append("Cantidad en Stock: ").append(producto.getCantidadStock()).append("\n");
        productosSuministradosText.append("========================================\n");
    }
    
    jTextArea1.setText(productosSuministradosText.toString());

        //gestor.mostrarProductosSuministrados(nombreProveedor);
                    
        
        
    }//GEN-LAST:event_enterActionPerformed

    private void backToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMenuActionPerformed
        // TODO add your handling code here:
        VentanaProveedor newMenu = new VentanaProveedor(this.gestor); 
        newMenu.setLocationRelativeTo(null);
        newMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backToMenuActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaListaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaListaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaListaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaListaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Gestor gestor = null;
                new VentanaListaProducto(gestor).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToMenu;
    private javax.swing.JButton enter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField nomProveedor;
    // End of variables declaration//GEN-END:variables
}
