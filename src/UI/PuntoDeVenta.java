package UI;

import LogicaDeNegocios.CoordinadorDeFacturaVenta;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.table.DefaultTableModel;

public class PuntoDeVenta extends javax.swing.JPanel {

    DefaultTableModel modelo;
    boolean imprimirFactura;
    ArrayList<Object> lista = new ArrayList<>();
    ArrayList<Object> listaParaMostrar = new ArrayList<>();
    int fila, tipoDeVenta = 2;
    DecimalFormat formato = new DecimalFormat("#.00");

    public PuntoDeVenta() {
        initComponents();
        ListarTiposDePago();
        ((DefaultEditor) jSDiasPlazo_PuntoDeVenta.getEditor()).getTextField().setEditable(false);
        jSDiasPlazo_PuntoDeVenta.setEnabled(false);

    }

    public void FacturarNuevaVenta() {
        if (ObtenerCantidadDeArticulosVendidos() > 0) {
            if (VerificarCliente()) {
                switch (tipoDeVenta) {
                    case 0: // venta a credito
                        if (AplicarAbono()) {
                            CrearFacturaVentaCreditoConAbono();
                            AgregarDetalleAFactura();
                            ResumenVentaCreditoConAbono();
                            LimpiarDatos();
                        } else {
                            CrearFacturaVentaCreditoSinAbono();
                            AgregarDetalleAFactura();
                            ResumenVentaCreditoSinAbono();
                            LimpiarDatos();
                        }
                        break;
                    case 1: // venta a contado
                        if (cmbxFormaDePago_PuntoDeVenta.getSelectedItem().toString().equals("Efectivo")) {// pago en efectivo
                            if (ValidarPagoEfectivo()) {
                                CrearFacturaDeVentaContado();
                                AgregarDetalleAFactura();
                                CalcularVuelto(true);
                                LimpiarDatos();
                            }
                        } else if (cmbxFormaDePago_PuntoDeVenta.getSelectedItem().toString().equals("Seleccione...")) {
                            JOptionPane.showMessageDialog(null, "!Debe selecionar una forma de pago!",
                                    "¡Faltan datos requeridos!", JOptionPane.ERROR_MESSAGE);
                        } else {
                            if (ValidarPagoNOEfectivo()) {// pago diferente de efectivo
                                CrearFacturaDeVentaContado();
                                AgregarDetalleAFactura();
                                CalcularVuelto(false);
                                LimpiarDatos();
                            } else {
                                JOptionPane.showMessageDialog(null, "Debe indicar el numero de referencia con el cual canceló\n"
                                        + "la venta realizada.", "¡Faltan datos requeridos!", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        break;
                    case 2:  // opcion nula
                        JOptionPane.showMessageDialog(null, "!Debe seleccionar un tipo de venta!", "¡Error en selección!",
                                JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡Verfique los datos del cliente!, ya que el numero de cédula\n"
                        + "proporcionado no coincide con los clientes registrados o no se digitó ningún numero de cédula.",
                        "¡Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡Primero debe ingresar algun articulo a la lista de venta!",
                    "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public float ObtenerCantidadDeArticulosVendidos() {
        int filas = TablaFacturacion_PuntoDeVenta.getRowCount();
        float cantidad = 0;

        if (filas != 0) {
            for (int i = 0; i < filas; i++) {
                cantidad += Float.parseFloat(TablaFacturacion_PuntoDeVenta.getValueAt(i, 3).toString());
            }
        } else {
            return filas;
        }
        return cantidad;
    }

    public boolean VerificarCliente() {
        if (!txtCedulaCliente_PuntoDeVenta.getText().isEmpty()) {
            CoordinadorDeFacturaVenta coordinador = new CoordinadorDeFacturaVenta();
            int resultado = coordinador.ObtenerIdClientePorNumeroCedula(txtCedulaCliente_PuntoDeVenta.getText());
            if (resultado != -1) {
                return true;
            }
        }
        return false;
    }

    public boolean ValidarPagoNOEfectivo() {
        if (!cmbxFormaDePago_PuntoDeVenta.getSelectedItem().toString().equals("Efectivo")
                && !cmbxFormaDePago_PuntoDeVenta.getSelectedItem().toString().equals("Seleccione...")) {
            if (!txtNDeReferencia.getText().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean ValidarPagoEfectivo() {
        if (!txtMontoDePago_PuntoDeVenta.getText().isEmpty() && !txtTotalAPagar_PuntoDeVenta.getText().isEmpty()) {
            float totalAPagar = Float.parseFloat(txtTotalAPagar_PuntoDeVenta.getText());
            float montoDePago = Float.parseFloat(txtMontoDePago_PuntoDeVenta.getText());
            if (montoDePago >= totalAPagar) {
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡Debe ingresar un monto de pago que sea mayor o igual al total a pagar!",
                    "¡Error!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean ExigirAbono() {
        String formaPago = cmbxFormaDePago_PuntoDeVenta.getSelectedItem().toString();
        if (formaPago.equals("Efectivo")) {
            if (!txtMontoDePago_PuntoDeVenta.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "¡Debe ingresar el monto que desea abonar!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return true;
            }
        } else if (formaPago.equals("Seleccione...")) {
            JOptionPane.showMessageDialog(null, "¡Debe selecionar una forma de pago!",
                    "¡Advertencia!", JOptionPane.WARNING_MESSAGE);
        } else {
            if (!txtNDeReferencia.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "¡Debe ingresar el N° de referencia con el cual realizó el abono!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }
        return false;
    }

    public boolean AplicarAbono() {
        try {
            int plazoDias = Integer.parseInt(jSDiasPlazo_PuntoDeVenta.getValue().toString());
            if (jCAbonar_PuntoVenta.isSelected()) {
                if (ExigirAbono()) {
                    return true;
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        return false;
    }

    public void EstablecerTipoDeVenta() {
        switch (cmbxTipoVenta_PuntoDeVenta.getSelectedItem().toString()) {
            case "Seleccione...":
                tipoDeVenta = 2;
                jSDiasPlazo_PuntoDeVenta.setEnabled(false);
                jCAbonar_PuntoVenta.setEnabled(false);
                break;
            case "Contado":
                tipoDeVenta = 1;
                jSDiasPlazo_PuntoDeVenta.setEnabled(false);
                jCAbonar_PuntoVenta.setEnabled(false);
                break;
            case "Credito":
                tipoDeVenta = 0;
                jCAbonar_PuntoVenta.setEnabled(true);
                jSDiasPlazo_PuntoDeVenta.setEnabled(true);
                break;
        }
    }

    public void ValidacionesDePago() {
        if (cmbxFormaDePago_PuntoDeVenta.getSelectedItem() != null) {
            String formaDePago = cmbxFormaDePago_PuntoDeVenta.getSelectedItem().toString();

            switch (formaDePago) {
                case "Seleccione...":
                    txtNDeReferencia.setEnabled(false);
                    txtMontoDePago_PuntoDeVenta.setEnabled(false);
                    break;
                case "Cheque":
                    txtNDeReferencia.setEnabled(true);
                    txtNDeReferencia.setText("");
                    txtMontoDePago_PuntoDeVenta.setEnabled(false);
                    break;
                case "Transacción bancaria":
                    txtNDeReferencia.setEnabled(true);
                    txtNDeReferencia.setText("");
                    txtMontoDePago_PuntoDeVenta.setEnabled(false);
                    break;
                case "Efectivo":
                    txtNDeReferencia.setEnabled(false);
                    txtMontoDePago_PuntoDeVenta.setEnabled(true);
                    txtNDeReferencia.setText("0");
                    break;
                case "Tarjeta de crédito":
                    txtNDeReferencia.setEnabled(true);
                    txtNDeReferencia.setText("");
                    txtMontoDePago_PuntoDeVenta.setEnabled(false);
                    break;
            }
        }
    }

    public void CalcularTotalAPagar() {
        float total = 0;
        for (int i = 0; i < TablaFacturacion_PuntoDeVenta.getRowCount(); i++) {
            total += Float.parseFloat(TablaFacturacion_PuntoDeVenta.getValueAt(i, 7).toString());
        }
        txtTotalAPagar_PuntoDeVenta.setText("" + formato.format(total));
    }

    public void VerificarDatosParaAgregarAlaLista() {
        try {
            if (!txtCantidadDeProducto_PuntoDeVenta.getText().isEmpty()
                    && !txtCodigoDelProducto_PuntoDeVenta.getText().isEmpty()) {
                if (Integer.parseInt(txtCantidadDeProducto_PuntoDeVenta.getText()) > 0) {
                    BuscarProductoParaVender();
                    CalcularTotalAPagar();
                } else {
                    JOptionPane.showMessageDialog(null, "La cantidad de articulos debe ser mayor a 0 para\n"
                            + "poder agregar el producto a la lista de venta.", "¡Verifique los datos!",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar un codigo y una cantidad de articulos deseados para\n"
                        + "poder agregar el producto a la lista de venta.", "¡Verifique los datos!",
                        JOptionPane.ERROR_MESSAGE);

            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La cantidad de articulos debe ser númerica.",
                    "¡Verifique los datos!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void BuscarProductoParaVender() {
        try {
            String codigo = txtCodigoDelProducto_PuntoDeVenta.getText();
            float cantidadSolicitada = Float.parseFloat(txtCantidadDeProducto_PuntoDeVenta.getText());
            CoordinadorDeFacturaVenta coordinador = new CoordinadorDeFacturaVenta();
            if (TablaFacturacion_PuntoDeVenta.getRowCount() == 0) {
                EstablecerModelo(coordinador.BuscarProducto(codigo, cantidadSolicitada, 0, 0));
            } else if (ConsultarSiYaTieneDescuento(codigo)) {
                float cantidadAcumulada = VerificarSiYaExiste(codigo);
                EstablecerModelo(coordinador.BuscarProducto(codigo, cantidadAcumulada, ObtnerPrecioAcumulado(codigo),
                        cantidadSolicitada));
            } else {
                EstablecerModelo(coordinador.BuscarProducto(codigo, VerificarSiYaExiste(codigo), 0, 0));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "¡Error!   '" + txtCantidadDeProducto_PuntoDeVenta.getText() + "'    "
                    + "no es una cantidad valida.\nCorrija los datos y vuelva a intentarlo", "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean ConsultarSiYaTieneDescuento(String codigo) {
        boolean tieneDescuento = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(codigo)) {
                tieneDescuento = true;
            }
        }
        return tieneDescuento;
    }

    public float ObtnerPrecioAcumulado(String codigo) {
        float precioAcumulado = 0;
        for (int i = 0; i < TablaFacturacion_PuntoDeVenta.getRowCount(); i++) {
            if (TablaFacturacion_PuntoDeVenta.getValueAt(i, 0).toString().equals(codigo)) {
                precioAcumulado += Float.parseFloat(TablaFacturacion_PuntoDeVenta.getValueAt(i, 6).toString());
            }
        }
        return precioAcumulado;
    }

    public float VerificarSiYaExiste(String codigo) {
        float cantidadAcumulada;
        cantidadAcumulada = Float.parseFloat(txtCantidadDeProducto_PuntoDeVenta.getText());
        for (int i = 0; i < TablaFacturacion_PuntoDeVenta.getRowCount(); i++) {
            if (TablaFacturacion_PuntoDeVenta.getValueAt(i, 0).toString().equals(codigo)) {
                cantidadAcumulada += Float.parseFloat(TablaFacturacion_PuntoDeVenta.getValueAt(i, 3).toString());
            }
        }
        return cantidadAcumulada;
    }

    public void EstablecerModelo(Object[] lista) {
        if (lista == null) {
            JOptionPane.showMessageDialog(null, "<html>No se pueden vender <b><FONT SIZE=5>"
                    + (int) VerificarSiYaExiste(txtCodigoDelProducto_PuntoDeVenta.getText())
                    + "</FONT></b> articulos con el codigo <b><FONT SIZE=5>" + txtCodigoDelProducto_PuntoDeVenta.getText()
                    + "</FONT></b></html>\nya que no se cuenta con esa cantidad en el inventario o este no existe.\n"
                    + "Para obtener más información dirijase al gestor de inventario y verifique los datos.",
                    "Error en el ingreso de los datos", JOptionPane.ERROR_MESSAGE);
        } else {
            modelo = (DefaultTableModel) TablaFacturacion_PuntoDeVenta.getModel();
            String nuevoCodigo = lista[0].toString();
            QuitarArticulosRepetidos(nuevoCodigo);
            modelo.addRow(lista);
            TablaFacturacion_PuntoDeVenta.setModel(modelo);
        }
    }

    public void QuitarArticulosRepetidos(String codigoAEliminar) {
        int cantidadFilas = TablaFacturacion_PuntoDeVenta.getRowCount();
        String codigoActual;

        for (int i = 0; i < cantidadFilas; i++) {
            codigoActual = TablaFacturacion_PuntoDeVenta.getValueAt(i, 0).toString();
            if (codigoActual.equals(codigoAEliminar)) {
                modelo.removeRow(i);
                i--;
                cantidadFilas--;
            }
        }
    }

    public void DecideImprimirFactura() {
        switch (cbxImprime_PuntoDeVenta.getSelectedItem().toString()) {
            case "Si":
                imprimirFactura = true;
                break;
            case "No":
                imprimirFactura = false;
                break;
        }
    }

    public void AgregarCodigoAListaDeDescuentos(int fila) {
        lista.add(TablaFacturacion_PuntoDeVenta.getValueAt(fila, 0).toString());
    }

    public void ActualizarDescuentoFinal() {

        float totalDescuento = 0;
        for (int i = 0; i < TablaFacturacion_PuntoDeVenta.getRowCount(); i++) {
            totalDescuento += Float.parseFloat(TablaFacturacion_PuntoDeVenta.getValueAt(i, 6).toString());
        }
        txtDescuento_PuntoDeVenta.setText("" + formato.format(totalDescuento));
    }

    public void AplicarDescuento() {
        float cantidadDescuento = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el descuento que desea "
                + "aplicar al producto " + ObtenerNombreProducto() + "."));
        if (cantidadDescuento <= 100) {
            cantidadDescuento = (cantidadDescuento / 100);

            AgregarCodigoAListaDeDescuentos(fila);
            float subtotal = Float.parseFloat(TablaFacturacion_PuntoDeVenta.getValueAt(fila, 7).toString());
            float descuentoAcumulado = Float.parseFloat(TablaFacturacion_PuntoDeVenta.getValueAt(fila, 6).toString());

            float nuevoTotal = subtotal - (subtotal * cantidadDescuento);
            float descuento = (subtotal * cantidadDescuento) + descuentoAcumulado;
            TablaFacturacion_PuntoDeVenta.setValueAt(descuento, fila, 6);
            TablaFacturacion_PuntoDeVenta.setValueAt(nuevoTotal, fila, 7);
            ActualizarDescuentoFinal();
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar un porcentaje de descuento que este entre 0 y 100.",
                    "Error en el ingreso de los datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void AgregarDescuento() {
        try {
            if (ConsultarSiYaTieneDescuento(TablaFacturacion_PuntoDeVenta.getValueAt(fila, 0).toString())) {

                int respuesta = JOptionPane.showConfirmDialog(null, "Ya se aplicó un descuento a este árticulo"
                        + "\n¿Desea aplicar otro descuento?", "¡Agregar nuevo descuento!", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION) {
                    AplicarDescuento();
                } else if (respuesta == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Descuento cancelado!");
                }

            } else {
                AplicarDescuento();
            }
        } catch (NumberFormatException s) {
            JOptionPane.showMessageDialog(null, "Error el porcentaje de descuento debe ser numerico.",
                    "¡Error de ingreso!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String ObtenerNombreProducto() {

        String nombre = "";
        try {
            nombre = TablaFacturacion_PuntoDeVenta.getValueAt(fila, 1).toString();

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Primero debe selecionar un articulo para poder aplicar el descuento.",
                    "¡Error de selección!", JOptionPane.ERROR_MESSAGE);
        }
        return nombre;
    }

    public void ObtenerListaDeProductosVendidos() {
        lista.clear();
        int filas = TablaFacturacion_PuntoDeVenta.getRowCount();
        for (int i = 0; i < filas; i++) {

        }
    }

    public void ListarTiposDePago() {

        listaParaMostrar.clear();

        cmbxFormaDePago_PuntoDeVenta.removeAllItems();
        CoordinadorDeFacturaVenta coordinador = new CoordinadorDeFacturaVenta();
        listaParaMostrar = coordinador.ListarTiposDePago();
        cmbxFormaDePago_PuntoDeVenta.addItem("Seleccione...");
        for (int i = 0; i < listaParaMostrar.size(); i++) {

            cmbxFormaDePago_PuntoDeVenta.addItem(listaParaMostrar.get(i));
        }
        cmbxFormaDePago_PuntoDeVenta.setSelectedIndex(0);
    }

    public void CrearFacturaDeVentaContado() {
        // totalVendido;
        int idCliente, idTipoPago;
        String nuReferencia;
        CoordinadorDeFacturaVenta facturaVenta = new CoordinadorDeFacturaVenta();
        String totalParaCambiar=txtTotalAPagar_PuntoDeVenta.getText();
        totalParaCambiar=totalParaCambiar.replace(",", ".");       
        float totalVendido = Float.parseFloat(totalParaCambiar);
        idCliente = facturaVenta.ObtenerIdClientePorNumeroCedula(txtCedulaCliente_PuntoDeVenta.getText());
        idTipoPago = facturaVenta.ObtenerIdTipoPago(cmbxFormaDePago_PuntoDeVenta.getSelectedItem().toString());
        nuReferencia = txtNDeReferencia.getText();

        facturaVenta.CrearFacturaVentaContado(totalVendido, idCliente, idTipoPago, nuReferencia);
    }

    public void CrearFacturaVentaCreditoConAbono() {
        float totalVendido, montoAbonado;
        int idCliente, idTipoPago, plazoDias;
        String nuReferencia;

        CoordinadorDeFacturaVenta facturaVenta = new CoordinadorDeFacturaVenta();

        totalVendido = Float.parseFloat(txtTotalAPagar_PuntoDeVenta.getText());
        idCliente = facturaVenta.ObtenerIdClientePorNumeroCedula(txtCedulaCliente_PuntoDeVenta.getText());
        idTipoPago = facturaVenta.ObtenerIdTipoPago(cmbxFormaDePago_PuntoDeVenta.getSelectedItem().toString());
        nuReferencia = txtNDeReferencia.getText();
        montoAbonado = Float.parseFloat(txtMontoDePago_PuntoDeVenta.getText());
        plazoDias = Integer.parseInt(jSDiasPlazo_PuntoDeVenta.getValue().toString());
        facturaVenta.CrearFacturaVentaCredito(totalVendido, idCliente, idTipoPago, nuReferencia, plazoDias, montoAbonado);
    }

    public void CrearFacturaVentaCreditoSinAbono() {
        float totalVendido, montoAbonado;
        int idCliente, idTipoPago, plazoDias;
        String nuReferencia;
        CoordinadorDeFacturaVenta facturaVenta = new CoordinadorDeFacturaVenta();
        totalVendido = Float.parseFloat(txtTotalAPagar_PuntoDeVenta.getText());
        idCliente = facturaVenta.ObtenerIdClientePorNumeroCedula(txtCedulaCliente_PuntoDeVenta.getText());
        idTipoPago = 1;
        nuReferencia = txtNDeReferencia.getText();
        montoAbonado = 0;
        plazoDias = Integer.parseInt(jSDiasPlazo_PuntoDeVenta.getValue().toString());
        facturaVenta.CrearFacturaVentaCredito(totalVendido, idCliente, idTipoPago, nuReferencia, plazoDias, montoAbonado);
    }

    public void AgregarDetalleAFactura() {
        String codigo;
        float cantidadVendida, descuentoAplicado, precioVendido;
        CoordinadorDeFacturaVenta facturaVenta = new CoordinadorDeFacturaVenta();

        for (int i = 0; i < TablaFacturacion_PuntoDeVenta.getRowCount(); i++) {
            codigo = TablaFacturacion_PuntoDeVenta.getValueAt(i, 0).toString();
            cantidadVendida = Float.parseFloat(TablaFacturacion_PuntoDeVenta.getValueAt(i, 3).toString());
            descuentoAplicado = Float.parseFloat(TablaFacturacion_PuntoDeVenta.getValueAt(i, 6).toString());
            precioVendido = Float.parseFloat(TablaFacturacion_PuntoDeVenta.getValueAt(i, 7).toString());

            facturaVenta.AgregarDetalleFacturaVentaContado(codigo, cantidadVendida, descuentoAplicado, precioVendido);
        }
    }

    public void LimpiarDatos() {
        modelo.setRowCount(0);
        lista.clear();
        cmbxFormaDePago_PuntoDeVenta.setSelectedIndex(0);
        cmbxTipoVenta_PuntoDeVenta.setSelectedIndex(0);
        txtCantidadDeProducto_PuntoDeVenta.setText("");
        txtCedulaCliente_PuntoDeVenta.setText("");
        txtCodigoDelProducto_PuntoDeVenta.setText("");
        txtDescuento_PuntoDeVenta.setText("0");
        txtMontoDePago_PuntoDeVenta.setText("");
        txtNDeReferencia.setText("0");
        txtTotalAPagar_PuntoDeVenta.setText("");
    }

    public void CalcularVuelto(boolean tipoPago) {
        CoordinadorDeFacturaVenta coordinador = new CoordinadorDeFacturaVenta();
        if (tipoPago) {
            coordinador.CalcularVuelto(tipoPago, txtTotalAPagar_PuntoDeVenta.getText(),
                    txtMontoDePago_PuntoDeVenta.getText());
        } else {
            coordinador.CalcularVuelto(tipoPago, txtTotalAPagar_PuntoDeVenta.getText(),
                    cmbxFormaDePago_PuntoDeVenta.getSelectedItem().toString());
        }
    }

    public void ResumenVentaCreditoConAbono() {
        CoordinadorDeFacturaVenta coordinador = new CoordinadorDeFacturaVenta();
        coordinador.ResumenVentaCredito(txtTotalAPagar_PuntoDeVenta.getText(),
                cmbxFormaDePago_PuntoDeVenta.getSelectedItem().toString(),
                jSDiasPlazo_PuntoDeVenta.getValue().toString());
    }

    public void ResumenVentaCreditoSinAbono() {
        CoordinadorDeFacturaVenta coordinador = new CoordinadorDeFacturaVenta();
        coordinador.ResumenVentaCredito(txtTotalAPagar_PuntoDeVenta.getText(),
                "No abona nada.", jSDiasPlazo_PuntoDeVenta.getValue().toString());
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jppPuntoVenta = new javax.swing.JPopupMenu();
        jmIAgregarDescuento = new javax.swing.JMenuItem();
        jmIQuitarDescuento = new javax.swing.JMenuItem();
        jmIEliminarDeLaLista = new javax.swing.JMenuItem();
        jppMontoPagoPuntoDeVenta = new javax.swing.JPopupMenu();
        jmICompleto = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        Fecha = new javax.swing.JLabel();
        EtiquetaHora = new javax.swing.JLabel();
        Hora = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDescuento_PuntoDeVenta = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaFacturacion_PuntoDeVenta = new javax.swing.JTable();
        jLabel89 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        txtCodigoDelProducto_PuntoDeVenta = new javax.swing.JTextField();
        txtCantidadDeProducto_PuntoDeVenta = new javax.swing.JTextField();
        jButtonAgregarAlaLista = new javax.swing.JButton();
        jLabel92 = new javax.swing.JLabel();
        txtTotalAPagar_PuntoDeVenta = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        txtMontoDePago_PuntoDeVenta = new javax.swing.JTextField();
        jLabelImprime = new javax.swing.JLabel();
        cbxImprime_PuntoDeVenta = new javax.swing.JComboBox<String>();
        FacturarVenta_PuntoDeVEnta = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbxTipoVenta_PuntoDeVenta = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cmbxFormaDePago_PuntoDeVenta = new javax.swing.JComboBox();
        jLNReferencia = new javax.swing.JLabel();
        txtNDeReferencia = new javax.swing.JTextField();
        jLCliente_PuntoDeVenta = new javax.swing.JLabel();
        txtCedulaCliente_PuntoDeVenta = new javax.swing.JTextField();
        jLPlazoDias = new javax.swing.JLabel();
        jSDiasPlazo_PuntoDeVenta = new javax.swing.JSpinner();
        jCAbonar_PuntoVenta = new javax.swing.JCheckBox();

        jmIAgregarDescuento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anadir.png"))); // NOI18N
        jmIAgregarDescuento.setText("Agregar descuento");
        jmIAgregarDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmIAgregarDescuentoActionPerformed(evt);
            }
        });
        jppPuntoVenta.add(jmIAgregarDescuento);

        jmIQuitarDescuento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menos.png"))); // NOI18N
        jmIQuitarDescuento.setText("Quitar descuento");
        jppPuntoVenta.add(jmIQuitarDescuento);

        jmIEliminarDeLaLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carro.png"))); // NOI18N
        jmIEliminarDeLaLista.setText("Quitar de la lista");
        jppPuntoVenta.add(jmIEliminarDeLaLista);

        jmICompleto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/efectivo.png"))); // NOI18N
        jmICompleto.setText("Completo");
        jmICompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmICompletoActionPerformed(evt);
            }
        });
        jppMontoPagoPuntoDeVenta.add(jmICompleto);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Facturación de productos");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 330, 48));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 185, 1020, 0));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cash_register_Icon_128.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 20, -1, 100));

        jLabel85.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(51, 51, 0));
        jLabel85.setText("Fecha");
        add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 51, 24));

        Fecha.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        Fecha.setForeground(new java.awt.Color(51, 51, 0));
        Fecha.setText("FechaActual");
        add(Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 100, 24));

        EtiquetaHora.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        EtiquetaHora.setForeground(new java.awt.Color(51, 51, 0));
        EtiquetaHora.setText("Hora :");
        add(EtiquetaHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 51, -1));

        Hora.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        Hora.setForeground(new java.awt.Color(51, 51, 0));
        Hora.setText("HoraActual");
        add(Hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 78, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setText("Descuento:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 500, 90, 30));

        txtDescuento_PuntoDeVenta.setEditable(false);
        txtDescuento_PuntoDeVenta.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtDescuento_PuntoDeVenta.setText("0");
        add(txtDescuento_PuntoDeVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 500, 180, 30));

        TablaFacturacion_PuntoDeVenta.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TablaFacturacion_PuntoDeVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código ", "Nombre del producto", "Precio", "Cantidad", "UME", "IV/U", "Descuento", "Sub total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaFacturacion_PuntoDeVenta.setComponentPopupMenu(jppPuntoVenta);
        TablaFacturacion_PuntoDeVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TablaFacturacion_PuntoDeVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaFacturacion_PuntoDeVentaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TablaFacturacion_PuntoDeVenta);
        if (TablaFacturacion_PuntoDeVenta.getColumnModel().getColumnCount() > 0) {
            TablaFacturacion_PuntoDeVenta.getColumnModel().getColumn(0).setResizable(false);
            TablaFacturacion_PuntoDeVenta.getColumnModel().getColumn(1).setResizable(false);
            TablaFacturacion_PuntoDeVenta.getColumnModel().getColumn(2).setResizable(false);
            TablaFacturacion_PuntoDeVenta.getColumnModel().getColumn(3).setResizable(false);
            TablaFacturacion_PuntoDeVenta.getColumnModel().getColumn(4).setResizable(false);
            TablaFacturacion_PuntoDeVenta.getColumnModel().getColumn(5).setResizable(false);
            TablaFacturacion_PuntoDeVenta.getColumnModel().getColumn(6).setResizable(false);
            TablaFacturacion_PuntoDeVenta.getColumnModel().getColumn(7).setResizable(false);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 970, 179));

        jLabel89.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel89.setText("Codigo de producto:");
        add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 166, -1));

        jLabel93.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel93.setText("Cantidad:");
        add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 115, 20));

        txtCodigoDelProducto_PuntoDeVenta.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        add(txtCodigoDelProducto_PuntoDeVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 191, 31));

        txtCantidadDeProducto_PuntoDeVenta.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        add(txtCantidadDeProducto_PuntoDeVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, 120, 31));

        jButtonAgregarAlaLista.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButtonAgregarAlaLista.setMnemonic('A');
        jButtonAgregarAlaLista.setText("Agregar a la lista");
        jButtonAgregarAlaLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarAlaListaAgregarProductoALaLista(evt);
            }
        });
        add(jButtonAgregarAlaLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, -1, 30));

        jLabel92.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel92.setText("Total a pagar ‎₡");
        add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 350, 123, 30));

        txtTotalAPagar_PuntoDeVenta.setEditable(false);
        txtTotalAPagar_PuntoDeVenta.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtTotalAPagar_PuntoDeVenta.setText("0");
        add(txtTotalAPagar_PuntoDeVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 350, 180, 31));

        jLabel98.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel98.setText("Monto de pago:");
        add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 400, 130, 30));

        txtMontoDePago_PuntoDeVenta.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtMontoDePago_PuntoDeVenta.setComponentPopupMenu(jppMontoPagoPuntoDeVenta);
        add(txtMontoDePago_PuntoDeVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 400, 180, 30));

        jLabelImprime.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabelImprime.setText("Imprimir factura:");
        add(jLabelImprime, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 500, 150, 30));

        cbxImprime_PuntoDeVenta.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        cbxImprime_PuntoDeVenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Si" }));
        cbxImprime_PuntoDeVenta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxImprime_PuntoDeVentaSeleccionarImprimirFactura(evt);
            }
        });
        add(cbxImprime_PuntoDeVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 500, 70, -1));

        FacturarVenta_PuntoDeVEnta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fullshopping.png"))); // NOI18N
        FacturarVenta_PuntoDeVEnta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacturarVenta_PuntoDeVEntaActionPerformed(evt);
            }
        });
        add(FacturarVenta_PuntoDeVEnta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 540, 90, 80));

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 380, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setText("Tipo de venta:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, -1, -1));

        cmbxTipoVenta_PuntoDeVenta.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        cmbxTipoVenta_PuntoDeVenta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Contado", "Credito" }));
        cmbxTipoVenta_PuntoDeVenta.setPreferredSize(new java.awt.Dimension(110, 23));
        cmbxTipoVenta_PuntoDeVenta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbxTipoVenta_PuntoDeVentaItemStateChanged(evt);
            }
        });
        add(cmbxTipoVenta_PuntoDeVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 150, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel5.setText("Forma de pago:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, -1, -1));

        cmbxFormaDePago_PuntoDeVenta.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        cmbxFormaDePago_PuntoDeVenta.setPreferredSize(new java.awt.Dimension(110, 23));
        cmbxFormaDePago_PuntoDeVenta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbxFormaDePago_PuntoDeVentaItemStateChanged(evt);
            }
        });
        add(cmbxFormaDePago_PuntoDeVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 440, 170, 30));

        jLNReferencia.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLNReferencia.setText("N° de referencia:");
        add(jLNReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 460, -1, -1));

        txtNDeReferencia.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNDeReferencia.setText("0");
        txtNDeReferencia.setPreferredSize(new java.awt.Dimension(6, 30));
        add(txtNDeReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 450, 180, -1));

        jLCliente_PuntoDeVenta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLCliente_PuntoDeVenta.setText("Cliente:");
        add(jLCliente_PuntoDeVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 500, -1, -1));
        add(txtCedulaCliente_PuntoDeVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, 150, 30));

        jLPlazoDias.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLPlazoDias.setText("Plazo de días para pagar:");
        add(jLPlazoDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 570, -1, -1));

        jSDiasPlazo_PuntoDeVenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jSDiasPlazo_PuntoDeVenta.setModel(new javax.swing.SpinnerNumberModel(1, 1, 30, 1));
        jSDiasPlazo_PuntoDeVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(jSDiasPlazo_PuntoDeVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 570, 80, -1));

        jCAbonar_PuntoVenta.setText("Abonar a esta venta.");
        jCAbonar_PuntoVenta.setEnabled(false);
        add(jCAbonar_PuntoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 570, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarAlaListaAgregarProductoALaLista(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarAlaListaAgregarProductoALaLista
        VerificarDatosParaAgregarAlaLista();

    }//GEN-LAST:event_jButtonAgregarAlaListaAgregarProductoALaLista

    private void cbxImprime_PuntoDeVentaSeleccionarImprimirFactura(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxImprime_PuntoDeVentaSeleccionarImprimirFactura
//        JOptionPane.showMessageDialog(null, "Hola");
    }//GEN-LAST:event_cbxImprime_PuntoDeVentaSeleccionarImprimirFactura

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LimpiarDatos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jmIAgregarDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmIAgregarDescuentoActionPerformed
        AgregarDescuento();
        CalcularTotalAPagar();
    }//GEN-LAST:event_jmIAgregarDescuentoActionPerformed

    private void TablaFacturacion_PuntoDeVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaFacturacion_PuntoDeVentaMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {
            fila = TablaFacturacion_PuntoDeVenta.getSelectedRow();
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            fila = TablaFacturacion_PuntoDeVenta.getSelectedRow();
        }
    }//GEN-LAST:event_TablaFacturacion_PuntoDeVentaMouseClicked

    private void jmICompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmICompletoActionPerformed
        txtMontoDePago_PuntoDeVenta.setText(txtTotalAPagar_PuntoDeVenta.getText());
    }//GEN-LAST:event_jmICompletoActionPerformed

    private void cmbxTipoVenta_PuntoDeVentaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbxTipoVenta_PuntoDeVentaItemStateChanged
        EstablecerTipoDeVenta();
    }//GEN-LAST:event_cmbxTipoVenta_PuntoDeVentaItemStateChanged

    private void cmbxFormaDePago_PuntoDeVentaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbxFormaDePago_PuntoDeVentaItemStateChanged
        ValidacionesDePago();
    }//GEN-LAST:event_cmbxFormaDePago_PuntoDeVentaItemStateChanged

    private void FacturarVenta_PuntoDeVEntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacturarVenta_PuntoDeVEntaActionPerformed
        FacturarNuevaVenta();
    }//GEN-LAST:event_FacturarVenta_PuntoDeVEntaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel EtiquetaHora;
    private javax.swing.JButton FacturarVenta_PuntoDeVEnta;
    public static javax.swing.JLabel Fecha;
    public static javax.swing.JLabel Hora;
    public static javax.swing.JTable TablaFacturacion_PuntoDeVenta;
    public static javax.swing.JComboBox<String> cbxImprime_PuntoDeVenta;
    private javax.swing.JComboBox cmbxFormaDePago_PuntoDeVenta;
    private javax.swing.JComboBox cmbxTipoVenta_PuntoDeVenta;
    private javax.swing.JButton jButton2;
    public static javax.swing.JButton jButtonAgregarAlaLista;
    private javax.swing.JCheckBox jCAbonar_PuntoVenta;
    private javax.swing.JLabel jLCliente_PuntoDeVenta;
    private javax.swing.JLabel jLNReferencia;
    private javax.swing.JLabel jLPlazoDias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel98;
    public static javax.swing.JLabel jLabelImprime;
    private javax.swing.JSpinner jSDiasPlazo_PuntoDeVenta;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem jmIAgregarDescuento;
    private javax.swing.JMenuItem jmICompleto;
    private javax.swing.JMenuItem jmIEliminarDeLaLista;
    private javax.swing.JMenuItem jmIQuitarDescuento;
    private javax.swing.JPopupMenu jppMontoPagoPuntoDeVenta;
    private javax.swing.JPopupMenu jppPuntoVenta;
    public static javax.swing.JTextField txtCantidadDeProducto_PuntoDeVenta;
    private javax.swing.JTextField txtCedulaCliente_PuntoDeVenta;
    public static javax.swing.JTextField txtCodigoDelProducto_PuntoDeVenta;
    public static javax.swing.JTextField txtDescuento_PuntoDeVenta;
    public static javax.swing.JTextField txtMontoDePago_PuntoDeVenta;
    private javax.swing.JTextField txtNDeReferencia;
    public static javax.swing.JTextField txtTotalAPagar_PuntoDeVenta;
    // End of variables declaration//GEN-END:variables
}
