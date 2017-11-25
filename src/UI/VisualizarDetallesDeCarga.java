/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import LogicaDeNegocios.CoordinadorDeCamion;
import LogicaDeNegocios.IMPRIMIR;
import static UI.PuntoDeVenta.date;
import static UI.PuntoDeVenta.hourdateFormat;
import static UI.VisualizaryEditarCargas.modelo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author usuario
 */
public class VisualizarDetallesDeCarga extends javax.swing.JFrame {

    private TableRowSorter trsFiltro;
    static Object[] filas;
    static DefaultTableModel modelo;
    int IDCarga;
    static String CuerpoDelTextoAImprimir = "", placa, usuarioResponsable;
    
    public static Date date = new Date();
    public static DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public VisualizarDetallesDeCarga(int IdCarga, String camion, String usuario, Date fecha) {
        initComponents();
        IDCarga = IdCarga;
        this.date = fecha;
        this.placa = camion;
        this.usuarioResponsable = usuario;
        Fecha.setText(hourdateFormat.format(date));
        Camion.setText(placa);
        Usuario.setText(usuarioResponsable);
        Carga.setText("" + IdCarga);
        setLocationRelativeTo(null);
        ListarDetalleDeCarga();
    }

    public void filtroPalabraClave(String busqueda) {
        int columnaABuscar = 0;
        if (cmbxFiltrar_VisualizarDetalleDeCarga.getSelectedItem() == "Por Id") {
            columnaABuscar = 0;
        }
        if (cmbxFiltrar_VisualizarDetalleDeCarga.getSelectedItem() == "Por Camión") {
            columnaABuscar = 1;
        }
        if (cmbxFiltrar_VisualizarDetalleDeCarga.getSelectedItem() == "Por Fecha") {
            columnaABuscar = 2;
        }

        trsFiltro.setRowFilter(RowFilter.regexFilter(busqueda, columnaABuscar));
    }

    public void txtBuscar() {

        txtBuscar_VisualizarDetalleDeCarga.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtBuscar_VisualizarDetalleDeCarga.getText());
                cadena = cadena.replace("a", "(a|á|A|Á)");
                cadena = cadena.replace("e", "(e|é|E|É)");
                cadena = cadena.replace("i", "(i|í|I|Í)");
                cadena = cadena.replace("o", "(o|ó|O|Ó)");
                cadena = cadena.replace("u", "(u|ú|U|Ú)");
                cadena = cadena.replace("A", "(a|á|A|Á)");
                cadena = cadena.replace("E", "(e|é|E|É)");
                cadena = cadena.replace("I", "(i|í|I|Í)");
                cadena = cadena.replace("O", "(o|ó|O|Ó)");
                cadena = cadena.replace("U", "(u|ú|U|Ú)");

                repaint();
                filtroPalabraClave("(?i).*" + cadena + ".*");
            }
        });
        trsFiltro = new TableRowSorter(Tabla_VisualizarDetalleDeCarga.getModel());
        Tabla_VisualizarDetalleDeCarga.setRowSorter(trsFiltro);
    }

    public void ListarDetalleDeCarga() {
        try {
            modelo = new DefaultTableModel() {
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };

            modelo.addColumn("Id de Detalle");
            modelo.addColumn("Producto");
            modelo.addColumn("Cantidad");

            filas = new Object[modelo.getColumnCount()];
            CoordinadorDeCamion elCoordinador = new CoordinadorDeCamion();
            ResultSet resultadoConsulta = null;

            resultadoConsulta = elCoordinador.ListarDetalleDeCarga(IDCarga);
            if (resultadoConsulta.next() && resultadoConsulta != null) {
                resultadoConsulta.beforeFirst();
                while (resultadoConsulta.next()) {
                    for (int i = 0; i < modelo.getColumnCount(); i++) {

                        filas[i] = resultadoConsulta.getObject(i + 1);

                    }
                    modelo.addRow(filas);

                }
            }
            Tabla_VisualizarDetalleDeCarga.setModel(modelo);
        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public void imprimir() {
        CuerpoDelTextoAImprimir="";
        CuerpoDelTextoAImprimir +="\n-----INFORMACION DE CARGA-----"
                +"\n\nN.Carga:" + IDCarga
                + "\nF.Creacion:" + hourdateFormat.format(date)
                + "\nU.Responsable:" + usuarioResponsable
                + "\nCamion:" + placa
                + "\n____________________________\n";
        CuerpoDelTextoAImprimir += "Cod   Cant      Descr";
        for (int i = 0; i < Tabla_VisualizarDetalleDeCarga.getRowCount(); i++) {
            String codigo = Tabla_VisualizarDetalleDeCarga.getValueAt(i, 0).toString();
            float cantidadVendida = Float.parseFloat(Tabla_VisualizarDetalleDeCarga.getValueAt(i, 2).toString());
            String Descripcion = Tabla_VisualizarDetalleDeCarga.getValueAt(i, 1).toString();
            String des = "";
            if (Descripcion.length() >= 10) {

                des = Descripcion.replaceAll(" ", "");
                des = des.substring(0, 10);
            } else {

                des = String.format("%1$-10s", Descripcion);

            }

            CuerpoDelTextoAImprimir += "\n" + codigo + "     " + cantidadVendida + "      " + des;
            
            

        }
          CuerpoDelTextoAImprimir+= "\n\n\n-------------Fin-------------";
        IMPRIMIR impresora = new IMPRIMIR(CuerpoDelTextoAImprimir, CantidadDeFilas(CuerpoDelTextoAImprimir), CuerpoDelTextoAImprimir.length());
          
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_VisualizarDetalleDeCarga = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cmbxFiltrar_VisualizarDetalleDeCarga = new javax.swing.JComboBox<String>();
        txtBuscar_VisualizarDetalleDeCarga = new javax.swing.JTextField();
        btCancelar_VisualizarDetalleDeCarga = new javax.swing.JButton();
        btActualizar_VisualizarDetalleDeCarga = new javax.swing.JButton();
        Imprimir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Carga = new javax.swing.JLabel();
        Camion = new javax.swing.JLabel();
        Usuario = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel1.setText("Visualizar detalle de carga");

        Tabla_VisualizarDetalleDeCarga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id de Detalle", "Producto", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(Tabla_VisualizarDetalleDeCarga);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Buscar:");

        cmbxFiltrar_VisualizarDetalleDeCarga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Por Id", "Por Producto", "Por Cantidad" }));

        btCancelar_VisualizarDetalleDeCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete_Icon_32.png"))); // NOI18N
        btCancelar_VisualizarDetalleDeCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar_VisualizarDetalleDeCargaActionPerformed(evt);
            }
        });

        btActualizar_VisualizarDetalleDeCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flechas-de-actualizacion.png"))); // NOI18N
        btActualizar_VisualizarDetalleDeCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizar_VisualizarDetalleDeCargaActionPerformed(evt);
            }
        });

        Imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/printer_78349.png"))); // NOI18N
        Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Numero de Carga :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Camion asignado :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Usuario responsable:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Fecha de creación:");

        Carga.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Carga.setForeground(new java.awt.Color(0, 102, 102));
        Carga.setText("Carga");

        Camion.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Camion.setForeground(new java.awt.Color(0, 102, 102));
        Camion.setText("Camion");

        Usuario.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Usuario.setForeground(new java.awt.Color(0, 102, 102));
        Usuario.setText("Usuario");

        Fecha.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Fecha.setForeground(new java.awt.Color(0, 102, 102));
        Fecha.setText("Fecha");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(cmbxFiltrar_VisualizarDetalleDeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtBuscar_VisualizarDetalleDeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btActualizar_VisualizarDetalleDeCarga)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btCancelar_VisualizarDetalleDeCarga)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Fecha)
                            .addComponent(Usuario)
                            .addComponent(Camion)
                            .addComponent(Carga))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Carga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Camion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Usuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Fecha))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btCancelar_VisualizarDetalleDeCarga, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btActualizar_VisualizarDetalleDeCarga, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Imprimir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbxFiltrar_VisualizarDetalleDeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscar_VisualizarDetalleDeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelar_VisualizarDetalleDeCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar_VisualizarDetalleDeCargaActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelar_VisualizarDetalleDeCargaActionPerformed

    private void btActualizar_VisualizarDetalleDeCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizar_VisualizarDetalleDeCargaActionPerformed
        ListarDetalleDeCarga();
    }//GEN-LAST:event_btActualizar_VisualizarDetalleDeCargaActionPerformed
    public static int CantidadDeFilas(String txt) {
        Matcher m = Pattern.compile("\r\n|\r|\n").matcher(txt);
        int lines = 1;
        while (m.find()) {
            lines++;
        }
        return lines;
    }
    private void ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirActionPerformed
        imprimir();
    }//GEN-LAST:event_ImprimirActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Camion;
    private javax.swing.JLabel Carga;
    private javax.swing.JLabel Fecha;
    public static javax.swing.JButton Imprimir;
    private javax.swing.JTable Tabla_VisualizarDetalleDeCarga;
    private javax.swing.JLabel Usuario;
    private javax.swing.JButton btActualizar_VisualizarDetalleDeCarga;
    private javax.swing.JButton btCancelar_VisualizarDetalleDeCarga;
    private javax.swing.JComboBox<String> cmbxFiltrar_VisualizarDetalleDeCarga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscar_VisualizarDetalleDeCarga;
    // End of variables declaration//GEN-END:variables
}
