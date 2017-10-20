/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import AccesoDatos.GestorDeCamiones;
import LogicaDeNegocios.CoordinadorDeCamion;
import Modelos.Camion;
import static UI.BuscarCamiones.BuscarCamion;
import static UI.BuscarCamiones.VisualizarTodosLosCamion;
import static UI.BuscarCamiones.txtPlaca_BuscarCamion;

import static UI.ListarCamiones.TablaListarCamiones_ListarCamiones;
import static UI.ListarCamiones.VisualizarCamion;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Laura
 */
public class EditarCamion extends javax.swing.JDialog {

    String NumeroDePlaca;
    String Marca;
    String Modelo;
    String Estilo;
    String Color;
    Date FechaDeCompra;
    float Capacidad;

    public EditarCamion(java.awt.Frame parent, boolean modal, String numeroDePlaca, String marca, String modelo,
            String estilo, String color, Date fechaDeCompra, float capacidad) {
        super(parent, modal);
        this.NumeroDePlaca = numeroDePlaca;
        this.Marca = marca;
        this.Modelo = modelo;
        this.Estilo = estilo;
        this.Color = color;
        this.FechaDeCompra = fechaDeCompra;
        this.Capacidad = capacidad;
        initComponents();
        setLocationRelativeTo(null);
        cargarDatos();
        cerrar();
    }

    @SuppressWarnings("unchecked")
    public void cerrar(){
addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                 int Decision = JOptionPane.showConfirmDialog(
                null,
                "Desea salir de esta ventana",
                "Salir",
                JOptionPane.YES_NO_OPTION);

        if (Decision == JOptionPane.YES_OPTION) {
            ListarUsuarios.panel=false;
            dispose();
        }
            }
        });
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel23 = new javax.swing.JLabel();
        txtNumeroDePlaca_EditarCamion = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtMarca_EditarCamion = new javax.swing.JTextField();
        date_EditarCamion = new com.toedter.calendar.JDateChooser();
        txtEstilo_EditarCamion = new javax.swing.JTextField();
        YCModelo_EditarCamion = new com.toedter.calendar.JYearChooser();
        txtColor_EditarCamion = new javax.swing.JTextField();
        SpinnerCapacidad_EditarCamion = new javax.swing.JSpinner();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        btAceptar_EditarCamion = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        btLimpiar_EditarCamion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(732, 412));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel23.setText("Modelo");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, 20));

        txtNumeroDePlaca_EditarCamion.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNumeroDePlaca_EditarCamion.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(txtNumeroDePlaca_EditarCamion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 90, -1));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel25.setText("Capacidad");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, 20));

        txtMarca_EditarCamion.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtMarca_EditarCamion.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(txtMarca_EditarCamion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 90, -1));
        getContentPane().add(date_EditarCamion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 130, 30));

        txtEstilo_EditarCamion.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtEstilo_EditarCamion.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(txtEstilo_EditarCamion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 90, -1));
        getContentPane().add(YCModelo_EditarCamion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 80, 30));

        txtColor_EditarCamion.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtColor_EditarCamion.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(txtColor_EditarCamion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 90, -1));

        SpinnerCapacidad_EditarCamion.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        getContentPane().add(SpinnerCapacidad_EditarCamion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 80, 30));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel28.setText("Color");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel29.setText("Estilo");
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel27.setText("Marca");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel24.setText("Editar de camión");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel26.setText("Número de placa");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lorry_Green_icon-icons.com_54887 (1).png"))); // NOI18N
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        btAceptar_EditarCamion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Check_Icon_32.png"))); // NOI18N
        btAceptar_EditarCamion.setToolTipText("Oprimir para guardar datos de camión");
        btAceptar_EditarCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptar_EditarCamionActionPerformed(evt);
            }
        });
        getContentPane().add(btAceptar_EditarCamion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, -1, -1));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setAlignmentX(5.0F);
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, -1));

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel30.setText("Fecha de compra ");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, 20));

        btLimpiar_EditarCamion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/broom_icon-icons.com_60872.png"))); // NOI18N
        btLimpiar_EditarCamion.setToolTipText("Oprima para limpiar campos");
        btLimpiar_EditarCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiar_EditarCamionActionPerformed(evt);
            }
        });
        getContentPane().add(btLimpiar_EditarCamion, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void cargarDatos() {
        txtNumeroDePlaca_EditarCamion.setText(NumeroDePlaca);
        txtMarca_EditarCamion.setText(Marca);
        txtEstilo_EditarCamion.setText(Estilo);
        txtColor_EditarCamion.setText(Color);
        date_EditarCamion.setDate(FechaDeCompra);
        SpinnerCapacidad_EditarCamion.setValue(Capacidad);
        YCModelo_EditarCamion.setYear(Integer.parseInt(Modelo));

    }
  public boolean VerificarEspacios() {

        if (txtNumeroDePlaca_EditarCamion.getText().equals("")
                || txtMarca_EditarCamion.getText().equals("")
                || txtEstilo_EditarCamion.getText().equals("")
                || txtColor_EditarCamion.getText().equals("")
               
                ) {
            return true;
        } else {
            return false;
        }

    }
 public void LimpiarCampos(){
      txtColor_EditarCamion.setText("");
      txtEstilo_EditarCamion.setText("");
      txtMarca_EditarCamion.setText("");
      txtNumeroDePlaca_EditarCamion.setText("");
     }
public String ObtenerFechaDesde() {

        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
        return String.valueOf(formatoDeFecha.format(date_EditarCamion.getDate()));
    }
public void EditarCamion() throws ClassNotFoundException, SQLException{
     if (VerificarEspacios() == true) {
            JOptionPane.showMessageDialog(null, "Por favor rellene los compos");
        } else {
            NumeroDePlaca = txtNumeroDePlaca_EditarCamion.getText();
            Marca = txtMarca_EditarCamion.getText();
            Estilo = txtEstilo_EditarCamion.getText();
            Color = txtColor_EditarCamion.getText();
            Modelo= ""+YCModelo_EditarCamion.getYear();
            Capacidad= Float.parseFloat(SpinnerCapacidad_EditarCamion.getValue().toString());
           
     

            CoordinadorDeCamion elCoordinadorDeCamion = new CoordinadorDeCamion();
            Camion elCamion = new Camion(NumeroDePlaca, Marca, Modelo, Estilo, Color, ObtenerFechaDesde(), Capacidad);
            if (elCoordinadorDeCamion.EditarCamion(elCamion) == true) {
                JOptionPane.showMessageDialog(null, "El camion ha sido actualizado exitosamente");
               
                LimpiarCampos();
                dispose();
                 ListarCamiones.VisualizarCamion(TablaListarCamiones_ListarCamiones);
                    if (ListarCamiones.panelHabilitado == true) {

                        txtPlaca_BuscarCamion.setText("");
                        BuscarCamion();
                        VisualizarTodosLosCamion();

                    }
            } else {
                JOptionPane.showMessageDialog(null, "Error en la actualización");
            }

        }

}
    private void btAceptar_EditarCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptar_EditarCamionActionPerformed
        try {
            EditarCamion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarCamion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditarCamion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAceptar_EditarCamionActionPerformed

    private void btLimpiar_EditarCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiar_EditarCamionActionPerformed

    }//GEN-LAST:event_btLimpiar_EditarCamionActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JSpinner SpinnerCapacidad_EditarCamion;
    public static com.toedter.calendar.JYearChooser YCModelo_EditarCamion;
    public static javax.swing.JButton btAceptar_EditarCamion;
    public static javax.swing.JButton btLimpiar_EditarCamion;
    public static com.toedter.calendar.JDateChooser date_EditarCamion;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JSeparator jSeparator4;
    public static javax.swing.JTextField txtColor_EditarCamion;
    public static javax.swing.JTextField txtEstilo_EditarCamion;
    public static javax.swing.JTextField txtMarca_EditarCamion;
    public static javax.swing.JTextField txtNumeroDePlaca_EditarCamion;
    // End of variables declaration//GEN-END:variables
}
