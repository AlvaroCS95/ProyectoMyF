package UI;

import javax.swing.JOptionPane;

public class ResumenDeVenta extends javax.swing.JDialog {

    public ResumenDeVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocation(450, 250);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                JOptionPane.showMessageDialog(null, "Seguro que quiere salir?");
            }
        });

    }

    public void LlenarDatos(String Total, String PagaCon, String Vuelto) {
        jLTextoTotal.setText(Total);
        jLTextoPagaCon.setText(PagaCon);
        jLTextoVuelto.setText(Vuelto);
    }
    
    public void LlenarDatosVentaCredito(String Total, String PagaCon, String PlazoDias){
        jLTextoTotal.setText(Total);
        jLTextoPagaCon.setText(PagaCon);
        jLVuelto.setText("Plazo de días: ");
        jLTextoVuelto.setText(PlazoDias);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelResumen = new javax.swing.JPanel();
        jLTotal = new javax.swing.JLabel();
        jLPagaCon = new javax.swing.JLabel();
        jLVuelto = new javax.swing.JLabel();
        jLTextoTotal = new javax.swing.JLabel();
        jLTextoPagaCon = new javax.swing.JLabel();
        jLTextoVuelto = new javax.swing.JLabel();
        jBAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLTotal.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLTotal.setText("Total vendido:");

        jLPagaCon.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLPagaCon.setText("Paga con:");

        jLVuelto.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLVuelto.setText("Vuelto:");

        jLTextoTotal.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jLTextoPagaCon.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jLTextoVuelto.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jBAceptar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jBAceptar.setText("Aceptar");
        jBAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelResumenLayout = new javax.swing.GroupLayout(PanelResumen);
        PanelResumen.setLayout(PanelResumenLayout);
        PanelResumenLayout.setHorizontalGroup(
            PanelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelResumenLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(PanelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLVuelto)
                    .addComponent(jLPagaCon)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelResumenLayout.createSequentialGroup()
                        .addComponent(jLTotal)
                        .addGap(66, 66, 66)))
                .addGroup(PanelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLTextoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTextoPagaCon, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTextoVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(160, Short.MAX_VALUE))
            .addComponent(jBAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelResumenLayout.setVerticalGroup(
            PanelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelResumenLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(PanelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLTotal)
                    .addComponent(jLTextoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPagaCon)
                    .addComponent(jLTextoPagaCon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(PanelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLVuelto)
                    .addComponent(jLTextoVuelto, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jBAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(PanelResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAceptarActionPerformed
        dispose();
    }//GEN-LAST:event_jBAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelResumen;
    private javax.swing.JButton jBAceptar;
    private javax.swing.JLabel jLPagaCon;
    private javax.swing.JLabel jLTextoPagaCon;
    private javax.swing.JLabel jLTextoTotal;
    private javax.swing.JLabel jLTextoVuelto;
    private javax.swing.JLabel jLTotal;
    private javax.swing.JLabel jLVuelto;
    // End of variables declaration//GEN-END:variables
}
