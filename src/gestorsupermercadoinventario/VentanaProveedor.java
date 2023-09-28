/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gestorsupermercadoinventario;

/**
 *
 * @author samirabecerra
 */
public class VentanaProveedor extends javax.swing.JFrame {

    /**
     * Creates new form VentanaProveedor
     */
    public VentanaProveedor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msj = new javax.swing.JLabel();
        agregarProd = new javax.swing.JButton();
        eliminarProd = new javax.swing.JButton();
        buscarProd = new javax.swing.JButton();
        listaProd = new javax.swing.JButton();
        mostrarPro = new javax.swing.JButton();
        modificarProd = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        logo = new javax.swing.JLabel();
        backToMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(550, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        msj.setFont(new java.awt.Font("Noteworthy", 0, 18)); // NOI18N
        msj.setText("Menú productos suministrados por proveedores");
        getContentPane().add(msj, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 191, -1, -1));

        agregarProd.setText(" Agregar producto a proveedor");
        agregarProd.setPreferredSize(new java.awt.Dimension(214, 23));
        agregarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarProdActionPerformed(evt);
            }
        });
        getContentPane().add(agregarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 232, 222, -1));

        eliminarProd.setText("Eliminar producto a proveedor");
        eliminarProd.setPreferredSize(new java.awt.Dimension(214, 23));
        eliminarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProdActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 273, 222, -1));

        buscarProd.setText("Buscar producto a proveedor");
        buscarProd.setPreferredSize(new java.awt.Dimension(214, 23));
        buscarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarProdActionPerformed(evt);
            }
        });
        getContentPane().add(buscarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 314, 222, -1));

        listaProd.setText("Lista de producto a proveedor");
        listaProd.setPreferredSize(new java.awt.Dimension(214, 23));
        listaProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaProdActionPerformed(evt);
            }
        });
        getContentPane().add(listaProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 355, 222, -1));

        mostrarPro.setText("Mostrar productos y su stock");
        mostrarPro.setPreferredSize(new java.awt.Dimension(214, 23));
        mostrarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarProActionPerformed(evt);
            }
        });
        getContentPane().add(mostrarPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 396, 222, -1));

        modificarProd.setText("Modificar producto a proveedor");
        modificarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarProdActionPerformed(evt);
            }
        });
        getContentPane().add(modificarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 437, 222, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 580, -1, 380));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/superLogo.png"))); // NOI18N
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 375, 185));

        backToMenu.setText("Volver a Inicio");
        backToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMenuActionPerformed(evt);
            }
        });
        getContentPane().add(backToMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 500, 120, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarProdActionPerformed
        // TODO add your handling code here:
        AgregarProducto aProd = new AgregarProducto();
        aProd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_agregarProdActionPerformed

    private void eliminarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProdActionPerformed
        // TODO add your handling code here:
        EliminarProducto eProd = new EliminarProducto(); 
        eProd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_eliminarProdActionPerformed

    private void buscarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarProdActionPerformed
        // TODO add your handling code here:
        BuscarProducto bProd = new BuscarProducto(); 
        bProd.setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_buscarProdActionPerformed

    private void listaProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaProdActionPerformed
        // TODO add your handling code here:
        ListaProducto lProd = new ListaProducto(); 
        lProd.setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_listaProdActionPerformed

    private void mostrarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarProActionPerformed
        // TODO add your handling code here:
        MostrarProducto mProd = new MostrarProducto(); 
        mProd.setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_mostrarProActionPerformed

    private void modificarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarProdActionPerformed
        // TODO add your handling code here:
        ModificarProducto modProd = new ModificarProducto(); 
        modProd.setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_modificarProdActionPerformed

    private void backToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMenuActionPerformed
        // TODO add your handling code here:
        VentanaInicio newVinicio = new VentanaInicio(); 
        newVinicio.setVisible(true);
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
            java.util.logging.Logger.getLogger(VentanaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarProd;
    private javax.swing.JButton backToMenu;
    private javax.swing.JButton buscarProd;
    private javax.swing.JButton eliminarProd;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton listaProd;
    private javax.swing.JLabel logo;
    private javax.swing.JButton modificarProd;
    private javax.swing.JButton mostrarPro;
    private javax.swing.JLabel msj;
    // End of variables declaration//GEN-END:variables
}
