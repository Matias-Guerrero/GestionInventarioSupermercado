/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gestorsupermercadoinventario.ventanas;

import gestorsupermercadoinventario.Gestor;
import gestorsupermercadoinventario.Producto;
import gestorsupermercadoinventario.Proveedor;
import gestorsupermercadoinventario.excepciones.StockNegativoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class VentanaModificarProducto extends javax.swing.JFrame {
    private Gestor gestor; 
    /**
     * Creates new form ModificarProducto
     */
    public VentanaModificarProducto(Gestor gestor) {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        backToMenu = new javax.swing.JButton();
        msj1 = new javax.swing.JLabel();
        modificar = new javax.swing.JButton();
        nombreProv = new javax.swing.JTextField();
        msj2 = new javax.swing.JLabel();
        nomPmodificar = new javax.swing.JTextField();
        msj3 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        msj4 = new javax.swing.JLabel();
        newPrice = new javax.swing.JTextField();
        msj5 = new javax.swing.JLabel();
        newStock = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/superLogo (1) (1).png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Noteworthy", 0, 18)); // NOI18N
        jLabel3.setText("Modoficar Producto a Proveedor");

        backToMenu.setText("Volver a Menú");
        backToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMenuActionPerformed(evt);
            }
        });

        msj1.setText("Ingrese nombre del Proveedor : ");

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        msj2.setText("Ingrese nombre del producto a modificar: ");

        msj3.setText("Ingrese nuevo nombre del producto : ");

        msj4.setText("Ingrece nuevo precio del producto : ");

        msj5.setText("Ingrese nueva cantidad de stock del producto :");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backToMenu))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(73, 73, 73)
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel3))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(111, 111, 111)
                                    .addComponent(msj1)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(msj5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(newPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                    .addComponent(nombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(msj4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(msj3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(msj2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombreProv, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomPmodificar, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                    .addComponent(newStock, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGap(0, 135, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)))
                .addGap(45, 45, 45)
                .addComponent(msj1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(msj2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nomPmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(msj3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(msj4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(msj5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backToMenu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
    * Este método se llama cuando se hace clic en el botón "modificar".
    * Realiza la modificación de un producto suministrado por un proveedor, actualizando su nombre,
    * precio y cantidad de stock en función de los valores ingresados por el usuario.
    * Muestra la información modificada y un mensaje de éxito o error en un área de texto.
    *
    * @param evt El evento de acción que desencadena este método.
    */
    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        try {                                     
            jTextArea1.setText(""); 
            // TODO add your handling code here:
            String nombreProveedor = nombreProv.getText();
            String nombreProducto = nomPmodificar.getText();
            String name = nombre.getText();
            double price;
            int stock;
            
            if (nombreProveedor == null || (!nombreProveedor.equals("Proveedor A") && !nombreProveedor.equals("Proveedor B") && !nombreProveedor.equals("Proveedor C"))) {
                JOptionPane.showMessageDialog(null, "Error: El proveedor debe ser 'Proveedor A', 'Proveedor B' o 'Proveedor C'.");
                return; // Sale del método si ocurre un error
            }
            Proveedor proveedor = gestor.buscarProveedor(nombreProveedor);
            Producto productoEditar = proveedor.buscarProductoSuministrado(nombreProducto, nombreProveedor);
            
            if (nombreProducto == null || nombreProducto.isEmpty() && productoEditar ==null) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un nombre de producto válido.");
                return; // Sale del método si ocurre un error
            }
            
            
            if (name == null || name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un nombre de producto válido.");
                return; // Sale del método si ocurre un error
            }
            
            try {
                price = Double.parseDouble(newPrice.getText());
                if (price < 0) {
                    JOptionPane.showMessageDialog(null, "Error: El precio debe ser un número válido y mayor que 0.");
                    return;
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Error: El precio debe ser un número válido.");
                return;
            }
            
            try {
                stock = Integer.parseInt(newStock.getText());
                if (stock < 0) {
                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número entero válido y mayor que 0.");
                    return;
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número entero válido.");
                return;
            }
            
            String datos = "Nombre Proveedor : " + nombreProveedor + "\n "+ "Nombre Producto a Modificar : " + nombreProducto + "\n" + "Nuevo nombre Producto :" + name + "\n"+ "Precio :" + price + "\n"+ "Cantidad de Stock : " + stock ;             
            jTextArea1.setText(datos);
                 
            
            if(gestor.modificarProducto(nombreProveedor,nombreProducto, name, price, stock)) {
                JOptionPane.showMessageDialog(null,"El producto fue modificado con éxito");
            } else {
                JOptionPane.showMessageDialog(null,"No se pudo modificar el producto.");
            }
            
        } catch (StockNegativoException ex) {
            Logger.getLogger(VentanaModificarProducto.class.getName()).log(Level.SEVERE,null, ex);
        }
     
    }//GEN-LAST:event_modificarActionPerformed

    /**
    * Este método se llama cuando se hace clic en el botón "Volver a Inicio".
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
            java.util.logging.Logger.getLogger(VentanaModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Gestor gestor = null; 
                new VentanaModificarProducto(gestor).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton modificar;
    private javax.swing.JLabel msj1;
    private javax.swing.JLabel msj2;
    private javax.swing.JLabel msj3;
    private javax.swing.JLabel msj4;
    private javax.swing.JLabel msj5;
    private javax.swing.JTextField newPrice;
    private javax.swing.JTextField newStock;
    private javax.swing.JTextField nomPmodificar;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField nombreProv;
    // End of variables declaration//GEN-END:variables
}
