/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daa.servlet;

import com.daa.ctrl.MyBean;
import com.daa.model.Kunde;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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
@WebServlet(name = "myPdf", urlPatterns = "/generate/myPdf.pdf")
public class PdfServlet extends HttpServlet {

    /**
     *
     * @param req
     * @param resp
     */
    
    //MyBean sessBean;
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Document document = new Document();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PdfPTable table1;
        PdfPTable table;
        MyBean sessBean=null;
        try {
            resp.setContentType("application/pdf");
            //benötigter Zugriff auf die im Sessionscope
            //abgelegte Bean
            HttpSession sess = req.getSession();
            if (sess.getAttribute("myBean") != null) {
                sessBean = (MyBean) sess.getAttribute("myBean");
            
                // document = new Document();
                //bos = new ByteArrayOutputStream();
                PdfWriter.getInstance(document, bos);
                
                document.open();
               
                //Schleife dient nur zur Demonstration des Dokument Objectes aus der Library iText
                for (int i = 1; i < 10; i++) {
                    document.add(new Paragraph("Das ist ein Absatz  " + i));
                    table1 = new PdfPTable(2);
                    table1.addCell("Spalte1");
                    
                    table1.addCell("Spalte2");

                    document.add(table1);
                    document.add(new Paragraph("neue Tabelle"));
                     document.add(new Paragraph(""));
                    table=new PdfPTable(3);
                    table.addCell("Nachname");
                    
                    table.addCell("Vorname");
                    table.addCell("Spaltenanzahl");
                    table.addCell(sessBean.getMyKunde().getKunde_nachname());
                    
                    table.addCell(sessBean.getMyKunde().getKunde_vorname());
                    table.addCell("3te Spalte");
                    table.addCell(sessBean.getMyKunde().getKunde_nachname());
                    
                    table.addCell(sessBean.getMyKunde().getKunde_vorname());
                    table.addCell("3te Spalte");
                    document.add(table);
                    document.newPage();
                }
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
            Logger.getLogger(PdfServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PdfServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}
