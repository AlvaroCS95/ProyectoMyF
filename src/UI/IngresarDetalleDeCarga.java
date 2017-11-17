/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Modelos.Producto;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class IngresarDetalleDeCarga extends javax.swing.JFrame {

    String codigo;
    float existencias;
    String nombre;
    public IngresarDetalleDeCarga(Producto producto) {
        initComponents();
        codigo=producto.getCodigo();
        existencias=producto.getExistencias();
        nombre=producto.getNombre();
        lbProducto_IngresarDetalleCarga.setText(producto.getNombre());
        lbExistencias_IngresarDetalleCarga.setText(""+existencias);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbProducto_IngresarDetalleCarga = new javax.swing.JLabel();
        lbExistencias_IngresarDetalleCarga = new javax.swing.JLabel();
        btAceptar_IngresarDetalleCarga = new javax.swing.JButton();
        txtCantidad_IngresarDetalleCarga = new javax.swing.JTextField();
        btCancelar_IngresarDetalleCarga = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        jLabel1.setText("Producto:");

        jLabel2.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        jLabel2.setText("Existencias");

        jLabel3.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        jLabel3.setText("Cantidad:");

        lbProducto_IngresarDetalleCarga.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        lbProducto_IngresarDetalleCarga.setText("XXXXXXXXXXXXX");

        lbExistencias_IngresarDetalleCarga.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        lbExistencias_IngresarDetalleCarga.setText("XXXXXXXXXXXXX");

        btAceptar_IngresarDetalleCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_IngresarDetalleCarga.setToolTipText("Para ingresar un detalle de carga");
        btAceptar_IngresarDetalleCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_IngresarDetalleCargaActionPerformed(evt);
            }
        });

        txtCantidad_IngresarDetalleCarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidad_IngresarDetalleCargaKeyTyped(evt);
            }
        });

        btCancelar_IngresarDetalleCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete_Icon_32.png"))); // NOI18N
        btCancelar_IngresarDetalleCarga.setToolTipText("Para salir de la ventana");
        btCancelar_IngresarDetalleCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar_IngresarDetalleCargaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbProducto_IngresarDetalleCarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbExistencias_IngresarDetalleCarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtCantidad_IngresarDetalleCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAceptar_IngresarDetalleCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btCancelar_IngresarDetalleCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbProducto_IngresarDetalleCarga))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbExistencias_IngresarDetalleCarga))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidad_IngresarDetalleCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCancelar_IngresarDetalleCarga, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btAceptar_IngresarDetalleCarga, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void ValidarSoloNumeros(KeyEvent evt) {
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            getToolkit().beep();

            evt.consume();

        }
    }
    private void txtCantidad_IngresarDetalleCargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidad_IngresarDetalleCargaKeyTyped
         ValidarSoloNumeros(evt);
    }//GEN-LAST:event_txtCantidad_IngresarDetalleCargaKeyTyped

    private void btAceptar_IngresarDetalleCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_IngresarDetalleCargaActionPerformed
      
      if(!txtCantidad_IngresarDetalleCarga.getText().isEmpty()){
          float cantidad=Integer.parseInt(txtCantidad_IngresarDetalleCarga.getText());
        if(cantidad>0&&cantidad<=existencias){
        setVisible(false);
        IngresarCarga.cargarProducto(cantidad,existencias,codigo,nombre);
        }}else{
      JOptionPane.showMessageDialog(null, "Recuerde que para agregar un producto a la carga del camión debe "
                                       + "\n  ingresar la cantidad del producto a cargar", "ERROR", JOptionPane.ERROR_MESSAGE);
      }
      
    }//GEN-LAST:event_btAceptar_IngresarDetalleCargaActionPerformed

    private void btCancelar_IngresarDetalleCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar_IngresarDetalleCargaActionPerformed
       setVisible(false);
    }//GEN-LAST:event_btCancelar_IngresarDetalleCargaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar_IngresarDetalleCarga;
    private javax.swing.JButton btCancelar_IngresarDetalleCarga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbExistencias_IngresarDetalleCarga;
    private javax.swing.JLabel lbProducto_IngresarDetalleCarga;
    private javax.swing.JTextField txtCantidad_IngresarDetalleCarga;
    // End of variables declaration//GEN-END:variables
}
