/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaDeNegocios;

import Modelos.Impresion;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
/**
 *
 * @author Christian
 */
public class CoordinarDeImpresion implements Printable {

    public static Date date = new Date();
    public static DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

    public static String PieDePagina
            = "\t           Distribuidora MyF\n"
            + "\t      Aramed de Jesús Sequeira Vega\n"
            + "\t\t        Cédula: 5-256-190\n"
            + "\t       Tels: 83031359 / 88197499\n"
            + "\t     Email: aramedsequeira@yahoo.es\n"
            + "\t\t\t       Nicoya, Guanacaste\n"
            + "-----------------------------------------\n"
            + "  Hora y fecha: " + hourdateFormat.format(date);

    public static String TextoIngresado;
    public static String TextoAImprimir = PieDePagina + TextoIngresado;
    StringTokenizer lineasdetexto;
    int totallineas;
    int[] paginas;
    String[] textoLineas;

    public CoordinarDeImpresion(String Imprime) {
        TextoAImprimir = PieDePagina + "\n" + Imprime;

        lineasdetexto = new StringTokenizer(TextoAImprimir, "\n", true);
        //Se obtiene el total de lineas de texto
        totallineas = lineasdetexto.countTokens();
        //Lineas de texto que se imprimiran en cada hoja
        Imprimir();
    }

//Se obtienen las lineas de texto del JTextArea, la linea de texto finaliza cuando se encuentra el caracter de nueva linea \n
    //Metodo que se crea por default cuando una clase implementa a Printable
    public int print(Graphics g, PageFormat pf, int pageIndex)
            throws PrinterException {
        //Se establece la fuente, el tipo, el tamaÃ±o, la metrica segÃºn la fuente asignada, 
        //obtiene la altura de cada linea de texto para que todas queden iguales
        Font font = new Font("Serif", Font.PLAIN, 8);
        FontMetrics metrics = g.getFontMetrics(font);
        int altodelinea = metrics.getHeight();
        //Calcula el nÃºmero de lineas por pagina y el total de paginas
        if (paginas == null) {
            initTextoLineas();
            //Calcula las lineas que le caben a cada pÃ¡gina dividiendo la altura imprimible entre la altura de la linea de texto
            int lineasPorPagina = (int) (pf.getImageableHeight() / altodelinea);
            //Calcula el numero de pÃ¡ginas dividiendo el total de lineas entre el numero de lineas por pÃ¡gina
            int numeroPaginas = (textoLineas.length - 1) / lineasPorPagina;
            paginas = new int[numeroPaginas];
            for (int b = 0; b < numeroPaginas; b++) {
                paginas[b] = (b + 1) * lineasPorPagina;
            }
        }
        //Si se recibe un indice de pÃ¡gina mayor que el total de pÃ¡ginas calculadas entonces 
        //retorna NO_SUCH_PAGE para indicar que tal pagina no existe 
        if (pageIndex > paginas.length) {
            return NO_SUCH_PAGE;
        }
        /*Por lo regular cuando dibujamos algun objeto lo coloca en la coordenada (0,0), esta coordenada 
         * se encuentra fuera del Ã¡rea imprimible, por tal motivo se debe trasladar la posicion de las lineas de texto
         * segÃºn el Ã¡rea imprimible del eje X y el eje Y 
         */

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        /*Dibujamos cada lÃ­nea de texto en cada pÃ¡gina,
         * se aumenta a la posiciÃ³n 'y' la altura de la lÃ­nea a cada lÃ­nea de texto para evitar la saturaciÃ³n de texto 
         */

        int y = 0;
        int start = (pageIndex == 0) ? 0 : paginas[pageIndex - 1];
        int end = (pageIndex == paginas.length) ? textoLineas.length : paginas[pageIndex];
        for (int line = start; line < end; line++) {
            y += altodelinea;
            g.drawString(textoLineas[line], 0, y);
        }
        /* Retorna PAGE_EXISTS para indicar al invocador que esta pÃ¡gina es parte del documento impreso
         */
        return PAGE_EXISTS;
    }

    /* Agrega las lineas de texto al arreglo */
    public void initTextoLineas() {
        if (textoLineas == null) {
            int numLineas = totallineas;
            textoLineas = new String[numLineas];
            //Se llena el arreglo que contiene todas las lineas de texto
            while (lineasdetexto.hasMoreTokens()) {
                for (int i = 0; i < numLineas; i++) {
                    textoLineas[i] = lineasdetexto.nextToken();
                }
            }
        }
    }

    //Este metodo crea un objeto Printerjob el cual es inicializado y asociado con la impresora por default
    public void Imprimir() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
         //Si el usuario presiona imprimir en el dialogo de impresiÃ³n, 
        //entonces intenta imprimir todas las lineas de texto
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
                /* The job did not successfully complete */
            }
        }
    }
}
