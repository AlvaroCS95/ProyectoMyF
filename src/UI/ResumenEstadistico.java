package UI;

import LogicaDeNegocios.CoordinadorEstadistico;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ResumenEstadistico extends javax.swing.JPanel {

    DefaultTableModel modelo;
    SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");

    public ResumenEstadistico() {
        initComponents();

    }

    public void ConsultarDatos() {
        if (ObtenerFechaDesde().equals("") && ObtenerFechaHasta().equals("")) {
            JOptionPane.showMessageDialog(null, "¡Debe indicar un rango de fechas valido!", "¡Error!", JOptionPane.ERROR_MESSAGE);

        } else {
            if (ValidarRangoDeFechas()) {
                modelo = (DefaultTableModel) jt_Estadistica.getModel();
                modelo.setRowCount(0);
                CoordinadorEstadistico coordinador = new CoordinadorEstadistico();
                modelo = coordinador.MontarListaDetalles(modelo, ObtenerFechaDesde(), ObtenerFechaHasta());
                jt_Estadistica.setModel(modelo);
                EstablecerNotaDeValance();
            } else {
                JOptionPane.showMessageDialog(null, "<html>El campo <b>Fecha desde</b> debe ser menor a <b>Fecha hasta.</b>"
                        + "\n<html>Así mismo, el campo <b>Fecha hasta</b> debe ser menor o igual a la fecha actual.");
            }
        }
    }

    public float ObtenerResultadoBalance() {
        float valance = 0;
        for (int i = 0; i < jt_Estadistica.getRowCount(); i++) {
            valance += Float.parseFloat(jt_Estadistica.getValueAt(i, 6).toString());
        }
        return valance;
    }

    public void EstablecerNotaDeValance() {
        String textoParaMostrar = "El balance de inversión respecto a ganancia para el periodo";
        textoParaMostrar += " " + ObtenerFechaDesde() + " hasta " + ObtenerFechaHasta() + " es de " + ObtenerResultadoBalance() + ".";
        Jl_TituloBalance.setText(textoParaMostrar);
    }

    public String ObtenerFechaDesde() {
        String fechaDesde = "";
        try {
            fechaDesde = String.valueOf(formatoDeFecha.format(jdc_FechaDesde.getDate()));
        } catch (NullPointerException e) {
            return "";
        }
        return fechaDesde;
    }

    public String ObtenerFechaHasta() {
        String fechaHasta = "";
        try {
            fechaHasta = String.valueOf(formatoDeFecha.format(jdc_FechaHasta.getDate()));
        } catch (NullPointerException e) {
            return "";
        }
        return fechaHasta;
    }

    public boolean ValidarRangoDeFechas() {
        if (jdc_FechaDesde.getDate().compareTo(jdc_FechaHasta.getDate()) == -1) {
            Date fechaActual = new Date();
            if (jdc_FechaHasta.getDate().before(fechaActual)) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    public void GraficarDatos() {
        if (jt_Estadistica.getRowCount() > 0) {
            JFreeChart grafica;
            DefaultCategoryDataset Datos = new DefaultCategoryDataset();
            float cantComprado = 0, cantVendido = 0;
            String nombre = "";
            for (int i = 0; i < jt_Estadistica.getRowCount(); i++) {
                nombre = jt_Estadistica.getValueAt(i, 1).toString();
                cantComprado = Float.parseFloat(jt_Estadistica.getValueAt(i, 2).toString());
                cantVendido = Float.parseFloat(jt_Estadistica.getValueAt(i, 4).toString());

                Datos.addValue(cantComprado, "Compra", nombre);
                Datos.addValue(cantVendido, "Venta", nombre);
            }
            grafica = ChartFactory.createBarChart("Productos Comprados/Vendidos",
                    "Productos", "Compras/Ventas", Datos,
                    PlotOrientation.VERTICAL, true, true, false);
            ChartPanel panelGrafica = new ChartPanel(grafica);
            JFrame ventanaGrafico = new JFrame("Grafico");
            ventanaGrafico.getContentPane().add(panelGrafica);
            ventanaGrafico.pack();
            ventanaGrafico.setVisible(true);
            ventanaGrafico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventanaGrafico.setLocationRelativeTo(this);
            ventanaGrafico.setAlwaysOnTop(true);
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos para graficar", "¡Tabla vacía!", JOptionPane.WARNING_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jdc_FechaDesde = new com.toedter.calendar.JDateChooser();
        jl_Desde = new javax.swing.JLabel();
        jl_Hasta = new javax.swing.JLabel();
        jdc_FechaHasta = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_Estadistica = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        Jl_TituloBalance = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Estadistica de productos");

        jdc_FechaDesde.setToolTipText("");

        jl_Desde.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jl_Desde.setText("Desde:");

        jl_Hasta.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jl_Hasta.setText("Hasta:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Ingrese el rango de fechas para filtrar:");

        jt_Estadistica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Cant. Comprada", "Tot. Comprado", "Cant. vendido", "Tot. Vendido", "GANANCIA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jt_Estadistica);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Jl_TituloBalance.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Grafico.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jl_TituloBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_Desde)
                                .addGap(16, 16, 16)
                                .addComponent(jdc_FechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_Hasta)
                                .addGap(18, 18, 18)
                                .addComponent(jdc_FechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47)
                        .addComponent(jButton1)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton2)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jdc_FechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jl_Desde))
                                            .addGap(9, 9, 9)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jl_Hasta)
                                                .addComponent(jdc_FechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(Jl_TituloBalance)
                .addContainerGap(106, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ConsultarDatos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        GraficarDatos();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jl_TituloBalance;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdc_FechaDesde;
    private com.toedter.calendar.JDateChooser jdc_FechaHasta;
    private javax.swing.JLabel jl_Desde;
    private javax.swing.JLabel jl_Hasta;
    public static javax.swing.JTable jt_Estadistica;
    // End of variables declaration//GEN-END:variables
}
