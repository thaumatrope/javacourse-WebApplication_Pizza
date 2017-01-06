/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.westfield.pdf;

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
import javax.servlet.http.HttpSession;
import com.daa.ctrl.MyBean;

/**
 *
 * @author Schulung
 */
public class MyPDF {
    
    public ByteArrayOutputStream erstellePdf(HttpSession sess){ Document document = new Document();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PdfPTable table;
        MyBean sessBean;
        try {
           
            //benötigter Zugriff auf die im Sessionscope
            //abgelegte Bean
         //   HttpSession sess = req.getSession();
            if (sess.getAttribute("myBean") != null) {
                sessBean = (MyBean) sess.getAttribute("myBean");

                // document = new Document();
                //bos = new ByteArrayOutputStream();
                PdfWriter.getInstance(document, bos);
                document.open();

                //Schleife dient nur zur Demonstration des Dokument Objectes aus der Library iText
                for (int i = 1; i < 10; i++) {
                    document.add(new Paragraph("Das ist ein Absatz  " + i));
                    table = new PdfPTable(2);
                    table.addCell(sessBean.getMyKunde().getKunde_nachname());
                    table.addCell(sessBean.getMyKunde().getKunde_vorname());

                    // Code 3
                    table.addCell("3");
                    table.addCell("4");

                    // Code 4
                    table.addCell("5");
                    table.addCell("6");

                    // Code 5
                    document.add(table);
                    document.newPage();
                }
                //}
//            else{
//                 PdfWriter.getInstance(document, bos);
//                 document.open();
//               
//                document.add(new Paragraph("Session abgelaufen  " ));
            }
            document.close();
//            OutputStream os = resp.getOutputStream();
           //bos.writeTo();
//            os.flush();
          
            //for ( PrintService s : PrintServiceLookup.lookupPrintServices( null, null ) )System.out.println( s.getName() );

        } catch (DocumentException ex) {
            Logger.getLogger(PdfServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
          return bos;
    }
}
