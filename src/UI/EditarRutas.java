package UI;

import LogicaDeNegocios.CoordinadorDeRutas;
import Modelos.Ruta;
import static UI.GestorDeRutas.VisualizarRutasActivas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Laura
 */
public class EditarRutas extends javax.swing.JDialog {

    int IdRutas;
    String NombreRuta, DescripcionRuta;

    public EditarRutas(java.awt.Frame parent, boolean modal, int Id, String Nombre, String Descripcion) {
        super(parent, modal);
        initComponents();
        this.IdRutas = Id;
        this.NombreRuta = Nombre;
        this.DescripcionRuta = Descripcion;
        txtNombreRuta_GestorRuta.setText(NombreRuta);
        txtDescripcion_GestorRuta.setText(DescripcionRuta);
        setLocationRelativeTo(null);
        cerrar();
    }

    public void editarRuta() throws SQLException, ClassNotFoundException {
        CoordinadorDeRutas elCordinador = new CoordinadorDeRutas();
        NombreRuta = txtNombreRuta_GestorRuta.getText();
        DescripcionRuta = txtDescripcion_GestorRuta.getText();
        Ruta laRuta = new Ruta(NombreRuta, DescripcionRuta);
        ResultSet respuesta = elCordinador.EditarRuta(IdRutas, laRuta);
        if (respuesta.next()) {
            if (respuesta.getString(1).equals("1")) {
                VisualizarRutasActivas();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, " Error al editar la ruta \n Es probable que en nombre de la nuta \n ya este en uso verifique sus datos.");
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        btnAceptar_GestorRutas = new javax.swing.JButton();
        txtNombreRuta_GestorRuta = new javax.swing.JTextField();
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
                    .addComponent(btnAceptar_GestorRutas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar_GestorRutas1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAceptar_GestorRutas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar_GestorRutas1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombreRuta_GestorRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptar_GestorRutasingresarRutas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar_GestorRutasingresarRutas
        try {
            editarRuta();
        } catch (SQLException ex) {
            Logger.getLogger(EditarRutas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarRutas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAceptar_GestorRutasingresarRutas
       public void limpiarCampos(){
       txtDescripcion_GestorRuta.setText("");
        txtNombreRuta_GestorRuta.setText("");
       }
    private void btnLimpiar_GestorRutas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar_GestorRutas1ActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiar_GestorRutas1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void cerrar() {
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                int Decision = JOptionPane.showConfirmDialog(
                        null,
                        "Desea salir de esta ventana",
                        "Salir",
                        JOptionPane.YES_NO_OPTION);

                if (Decision == JOptionPane.YES_OPTION) {
                    ListarUsuarios.panel = false;
                    dispose();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAceptar_GestorRutas;
    public static javax.swing.JButton btnLimpiar_GestorRutas1;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea txtDescripcion_GestorRuta;
    public static javax.swing.JTextField txtNombreRuta_GestorRuta;
    // End of variables declaration//GEN-END:variables
}
