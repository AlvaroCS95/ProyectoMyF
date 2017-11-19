package LogicaDeNegocios;

import static LogicaDeNegocios.CoordinarDeImpresion.date;
import static LogicaDeNegocios.CoordinarDeImpresion.hourdateFormat;
import br.com.adilson.util.Extenso;

import br.com.adilson.util.PrinterMatrix;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laura
 */
public class IMPRIMIR {

  static String texto;
  static int Filas=0, Palabras=0;
    public IMPRIMIR(String txt,int filas, int palabras) {
        this.texto=txt;
        this.Filas=filas;
        this.Palabras=palabras;
        imprimirFactura();
    }



    public static void imprimirFactura() {

        PrinterMatrix printer = new PrinterMatrix();
      
      String Encabezado
            = "\n\t        Distribuidora MyF\n"
            + "\t  Aramed de Jesus Sequeira Vega\n"
             + "\t\t      Cedula: 5-256-190\n"
            + "\t   Tels: 83031359 / 88197499\n"
            + "\t  Email: aramedsequeira@yahoo.es\n"
            + "\t\t\t       Nicoya, Guanacaste\n"
            + "--------------------------------\n";
            


        
        // Extenso e = new Extenso();

//        Fecha = ("" + dia + "/" + (mes + 1) + "/" + año);
//        Hora = ("" + hora + ":" + minuto + ":" + segundo);
        Extenso e = new Extenso();

        e.setNumber(101.85);

        //Definir el tamanho del papel para la impresion  aca 25 lineas y 80 columnas
        printer.setOutSize(5, Filas+20);
        //Imprimir * de la 2da linea a 25 en la columna 1;
        // printer.printCharAtLin(2, 25, 1, "*");
        //Imprimir * 1ra linea de la columa de 1 a 80
        printer.printCharAtCol(1, 1, 1, Encabezado);
        //Imprimir Encabezado nombre del La EMpresa
    
        //printer.printTextWrap(linI, linE, colI, colE, null);
        printer.printTextWrap(1, 1, 1, Palabras+20, texto);
     

      

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

        //inputStream.close();
    }
}
