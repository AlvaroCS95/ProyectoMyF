
package UI;

import javax.swing.JOptionPane;

/**
 *
 * @author Laura
 */
public class EditarRutas extends javax.swing.JDialog {

    int IdRutas;
    String NombreRuta,DescripcionRuta;
    public EditarRutas(java.awt.Frame parent, boolean modal,int Id,String Nombre,String Descripcion) {
        super(parent, modal);
        initComponents();
        this.IdRutas=Id;
        this.NombreRuta=Nombre;
        this.DescripcionRuta=Descripcion;
        txtNombreRuta_GestorRuta.setText(NombreRuta);
        txtDescripcion_GestorRuta.setText(DescripcionRuta);
        setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        btnAceptar_GestorRutas = new javax.swing.JButton();
        txtNombreRuta_GestorRuta = new javax.swing.JTextField();
        btnCancelar_GestorRutas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLimpiar_GestorRutas1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion_GestorRuta = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Descripcion");

        btnAceptar_GestorRutas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btnAceptar_GestorRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar_GestorRutasingresarRutas(evt);
            }
        });

        btnCancelar_GestorRutas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete_Icon_32.png"))); // NOI18N
        btnCancelar_GestorRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar_GestorRutasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Editar ruta");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Nombre ");

        btnLimpiar_GestorRutas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom_icon-icons.com_60872.png"))); // NOI18N
        btnLimpiar_GestorRutas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar_GestorRutas1ActionPerformed(evt);
            }
        });

        txtDescripcion_GestorRuta.setColumns(20);
        txtDescripcion_GestorRuta.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion_GestorRuta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                            .addComponent(txtNombreRuta_GestorRuta))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar_GestorRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar_GestorRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar_GestorRutas1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel2)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNombreRuta_GestorRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnAceptar_GestorRutas)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar_GestorRutas1)
                        .addGap(21, 21, 21)
                        .addComponent(btnCancelar_GestorRutas)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptar_GestorRutasingresarRutas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar_GestorRutasingresarRutas
       
    }//GEN-LAST:event_btnAceptar_GestorRutasingresarRutas

    private void btnLimpiar_GestorRutas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar_GestorRutas1ActionPerformed
       txtDescripcion_GestorRuta.setText("");
       txtNombreRuta_GestorRuta.setText("");
    }//GEN-LAST:event_btnLimpiar_GestorRutas1ActionPerformed

    private void btnCancelar_GestorRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar_GestorRutasActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog (null, "Desea cancelar la operación");
if(dialogResult == JOptionPane.YES_OPTION){
  dispose();
}
    }//GEN-LAST:event_btnCancelar_GestorRutasActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAceptar_GestorRutas;
    public static javax.swing.JButton btnCancelar_GestorRutas;
    public static javax.swing.JButton btnLimpiar_GestorRutas1;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea txtDescripcion_GestorRuta;
    public static javax.swing.JTextField txtNombreRuta_GestorRuta;
    // End of variables declaration//GEN-END:variables
}
