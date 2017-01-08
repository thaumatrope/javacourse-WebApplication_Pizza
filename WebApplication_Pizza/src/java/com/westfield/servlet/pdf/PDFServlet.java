/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.westfield.servlet.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.westfield.pizza.Bestellung;
import com.westfield.pizza.Lieferung;
import com.westfield.pizza.Kunde;

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
        
        try {
            resp.setContentType("application/pdf");
            //benötigter Zugriff auf die im Sessionscope abgelegte Bean
            
            if (mySession.getAttribute("myLieferung") != null) {
                myLieferung = (Lieferung) mySession.getAttribute("myLieferung");
                Kunde myKunde = new Kunde(myLieferung.getKundennummer());
                        
                PdfWriter.getInstance(document, bos);
                
                document.open();
                
                document.add(new Paragraph("Pizza World - Lieferung: " + myLieferung.getBestellnummer() + " / Datum: " + myLieferung.getDatum()));
                document.add(new Paragraph(""));
                document.add(new Paragraph(""));
                document.add(new Paragraph("--------------------------------------------------------------------------"));
                document.add(new Paragraph(""));
                document.add(new Paragraph(""));
                document.add(new Paragraph("Lieferanschrift:"));
                table1 = new PdfPTable(1);
                table1.addCell("Name: " + myKunde.getVorname() + " " + myKunde.getNachname());
                table1.addCell("Strasse: " + myKunde.getStrasse());
                table1.addCell("Ort: " + myKunde.getPlz() + " " + myKunde.getOrt());
                document.add(table1);
                
                document.add(new Paragraph(""));
                document.add(new Paragraph("--------------------------------------------------------------------------"));
                document.add(new Paragraph(""));
                
                table2 = new PdfPTable(5);
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
                    table2.addCell(myBestellung.getPreis());
                    table2.addCell(myLieferung.printPreisFormatted(myLieferung.getGesamtsumme(myBestellung.getPosition())));
      
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
