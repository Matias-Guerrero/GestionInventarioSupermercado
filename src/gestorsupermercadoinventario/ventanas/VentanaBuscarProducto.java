/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gestorsupermercadoinventario.ventanas;

import gestorsupermercadoinventario.Gestor;
import gestorsupermercadoinventario.Producto;
import gestorsupermercadoinventario.Proveedor;
import javax.swing.JOptionPane;


public class VentanaBuscarProducto extends javax.swing.JFrame {
    private Gestor gestor;
    /**
     * Creates new form BuscarProducto
     */
    public VentanaBuscarProducto(Gestor gestor) {
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

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Tittle = new javax.swing.JLabel();
        ms1 = new javax.swing.JLabel();
        textProveedor = new javax.swing.JTextField();
        msj2 = new javax.swing.JLabel();
        textProducto = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        backToMenu = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/superLogo (1) (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 42, -1, -1));

        Tittle.setFont(new java.awt.Font("Noteworthy", 0, 18)); // NOI18N
        Tittle.setText("Buscar producto de proveedor ");
        getContentPane().add(Tittle, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 59, -1, -1));

        ms1.setText("Imgrese el nombre del proveedor :");
        getContentPane().add(ms1, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 126, -1, -1));
        getContentPane().add(textProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 155, 250, -1));

        msj2.setText("Ingrese nombre del producto : ");
        getContentPane().add(msj2, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 204, -1, -1));
        getContentPane().add(textProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 233, 250, -1));

        search.setText("Buscar");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 297, 84, 33));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 372, 250, -1));

        backToMenu.setText("Volver a Menú");
        backToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMenuActionPerformed(evt);
            }
        });
        getContentPane().add(backToMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Este método se llama cuando se hace clic en el botón "buscar".
    * Realiza una búsqueda de un producto suministrado por un proveedor en función de los datos ingresados por el usuario.
    * Muestra los resultados de la búsqueda en un cuadro de diálogo y en un área de texto.
    *
    * @param evt El evento de acción que desencadena este método.
    */
    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        String nombreProveedor = textProveedor.getText();
         
        
        if (nombreProveedor == null || (!nombreProveedor.equals("Proveedor A") && !nombreProveedor.equals("Proveedor B") && !nombreProveedor.equals("Proveedor C"))) {
            JOptionPane.showMessageDialog(null, "Error: El proveedor debe ser 'Proveedor A', 'Proveedor B' o 'Proveedor C'.");
            return; // Sale del método si ocurre un error
        }
        String nombreProducto = textProducto.getText();
        
        if (nombreProducto == null || nombreProducto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un nombre de producto válido.");
            return; // Sale del método si ocurre un error
        }
        
        String datos = "Nombre del proveedor: " + nombreProveedor + "\n" + "Nombre del producto: " + nombreProducto ;
        
        //JOptionPane.showMessageDialog(null,datos);
        //jTextArea1.setText(datos);
        Proveedor proveedor = gestor.buscarProveedor(nombreProveedor);
        Producto productoBuscado = proveedor.buscarProductoSuministrado(nombreProducto, nombreProveedor);
        JOptionPane.showMessageDialog(null,datos);
        jTextArea1.setText(datos);
            
        if (productoBuscado == null) {
            JOptionPane.showMessageDialog(null,"No se encontró el producto.");
            
        }
        else{
            //JOptionPane.showMessageDialog(null,"El producto fue encontrado");
            String datosProducto = "Nombre del proveedor: " + nombreProveedor + "\n" + "Nombre del producto: " + nombreProducto + "\n" + "Precio: " + productoBuscado.getPrecio() + "\n" + "Cantidad en stock: " + productoBuscado.getCantidadStock();

        jTextArea1.setText(datosProducto);
        JOptionPane.showMessageDialog(null, datosProducto);
        }
        
        
        
        
    }//GEN-LAST:event_searchActionPerformed
    
    /**
    * Este método se llama cuando se hace clic en el botón "Volver a Menú".
    * Crea una nueva instancia de la ventana del menú de proveedores, la centra en la pantalla,
    * la muestra y cierra la ventana actual.
    *
    * @param evt El evento de acción que desencadena este método.
    */
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
            java.util.logging.Logger.getLogger(VentanaBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Gestor gestor = null;
                new VentanaBuscarProducto(gestor).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Tittle;
    private javax.swing.JButton backToMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel ms1;
    private javax.swing.JLabel msj2;
    private javax.swing.JButton search;
    private javax.swing.JTextField textProducto;
    private javax.swing.JTextField textProveedor;
    // End of variables declaration//GEN-END:variables
}
