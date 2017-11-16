package LogicaDeNegocios;

import static LogicaDeNegocios.CoordinarDeImpresion.date;
import static LogicaDeNegocios.CoordinarDeImpresion.hourdateFormat;

import br.com.adilson.util.PrinterMatrix;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

/**
 *
 * @author Laura
 */
public class IMPRIMIR {

    static String fecha = "";
    static String horas = "";
    static String codigo, descripcion;
    static float cantidad, precioUnitario, precioTotal;
    static int e = 6;

    public IMPRIMIR(String texto) {
        imprimirFactura(texto);
    }

    public static void imprimirFactura(String txt) {

        PrinterMatrix printer = new PrinterMatrix();

        printer.setOutSize(10, 90);

        printer.printTextWrap(1, 2, 10, 80, txt);

        String PieDePagina
                = "Distribuidora MyF\n"
                + "Aramed de Jesús Sequeira Vega\n"
                + "Cédula: 5-256-190\n"
                + "Tels: 83031359 / 88197499\n"
                + "Email: aramedsequeira@yahoo.es\n"
                + "Nicoya, Guanacaste\n"
                + "---------------------------\n"
                + "Hora y fecha:" + hourdateFormat.format(date);
        printer.printTextWrap(1, 3, 1, 80, PieDePagina);

        printer.toFile("impresion.txt");

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("impresion.txt");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        if (inputStream == null) {
            return;
        }

        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc document = new SimpleDoc(inputStream, docFormat, null);

        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();

        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

        if (defaultPrintService != null) {
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            try {
                printJob.print(document, attributeSet);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.err.println("No existen impresoras instaladas");
        }

       
    }
}
