/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.westfield.pizza.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.westfield.pizza.beans.Bestellung;
import com.westfield.pizza.beans.Lieferung;
import com.westfield.pizza.beans.Kunde;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Schulung_IBB
 */
@WebServlet(name = "pdf2http", urlPatterns = "/generate/do.pdf")
public class PDFServlet extends HttpServlet {

    /**
     *
     * @param req
     * @param resp
     */
    
    //MyBean sessBean;
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Document document = new Document();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PdfPTable table2;
        PdfPTable table1;
        HttpSession mySession = req.getSession();
        Lieferung myLieferung;
        PdfPCell pcell;
        Phrase p;
        
        try {
            resp.setContentType("application/pdf");
            //benötigter Zugriff auf die im Sessionscope abgelegte Bean
            
            if (mySession.getAttribute("myLieferung") != null) {
                myLieferung = (Lieferung) mySession.getAttribute("myLieferung");
                Kunde myKunde = new Kunde().snatch(myLieferung.getKundennummer());
                        
                PdfWriter.getInstance(document, bos);
                
                document.open();                
                
                document.add(new Paragraph("Pizza World"));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Liefernummer: " + myLieferung.getBestellnummer()));
                document.add(new Paragraph("Datum: " + myLieferung.getDatum()));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Lieferanschrift:"));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                table1 = new PdfPTable(1);
                table1.getDefaultCell().setBorder(Rectangle.NO_BORDER);
                table1.setWidthPercentage(100);
                table1.addCell(myKunde.getVorname() + " " + myKunde.getNachname());
                table1.addCell(myKunde.getStrasse());
                table1.addCell(myKunde.getPlz() + " " + myKunde.getOrt());
                document.add(table1);
                
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Bestellung:"));
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                
                table2 = new PdfPTable(5);
                table2.setWidthPercentage(100);
                //table2.setLockedWidth(true);                
                table2.setHorizontalAlignment(PdfPTable.ALIGN_RIGHT);
                table2.setWidths(new float[]{1, 1, 3, 1, 1});
                table2.addCell("Position"); 
                table2.addCell("Menge");
                table2.addCell("Sorte");               
                table2.addCell("Preis");
                table2.addCell("Gesamtpreis");
                              
                //Schleife dient nur zur Demonstration des Dokument Objectes aus der Library iText
                for (Bestellung myBestellung : myLieferung.getMyBestellungen()) {
                     
                    table2.addCell("" + myBestellung.getPosition()); 
                    table2.addCell("" + myBestellung.getMenge());
                    table2.addCell(myBestellung.getSorte());  
                    
                    p = new Phrase(myBestellung.getPreis()); 
                    pcell = new PdfPCell(p);
                    pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    pcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                
                    table2.addCell(pcell);

                    //table2.addCell(myBestellung.getPreis());
                    p = new Phrase(myLieferung.printPreisFormatted(myLieferung.getGesamtsumme(myBestellung.getPosition()))); 
                    pcell = new PdfPCell(p);
                    pcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    pcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                   
                    table2.addCell(pcell);
                    
                    
                    //table2.addCell(myLieferung.printPreisFormatted(myLieferung.getGesamtsumme(myBestellung.getPosition())));
      
                }
                
                 document.add(table2);
                 document.newPage();
                 
                }
           else{
                PdfWriter.getInstance(document, bos);
                document.open();
               
                document.add(new Paragraph("Session abgelaufen  " ));
            }
            document.close();
            OutputStream os = resp.getOutputStream();
            bos.writeTo(os);
            os.flush();
            os.close();
            //for ( PrintService s : PrintServiceLookup.lookupPrintServices( null, null ) )System.out.println( s.getName() );

        } catch (DocumentException ex) {
            Logger.getLogger(PDFServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PDFServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}
