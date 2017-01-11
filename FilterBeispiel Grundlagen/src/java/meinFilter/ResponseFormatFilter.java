/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package meinFilter;



import javax.servlet.http.HttpServletResponseWrapper;

/**
 *
 * @author Schulung
 */


import java.io.PrintWriter;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;




/**
 * Diese Filter formattiert die resultierende HTML Seite und
 * versieht den Begriff 'Masterclass' mit zusätzlichen Links
 */
//@WebFilter()
public class ResponseFormatFilter extends BaseFilter implements Filter {

   /**
    * Filtert die resultierende Seite
    */
   @Override
   public void doFilter(ServletRequest request,
                        ServletResponse response,
                        FilterChain chain)
      throws IOException, ServletException {

      // Erzeugen des Wrapper-Objektes
      ResponseWrapper wrapper =new ResponseWrapper((HttpServletResponse) response);

      // Weiterleiten und Verarbeiten des Requests
      chain.doFilter(request, wrapper);

      // Binden des PrintWriters 'out'
      PrintWriter out = response.getWriter();
      //HttpSession session= (HttpServletRequest) request.getSession(false);
      // Gespeichertes Dokument aus dem Wrapper extrahieren
      String content = wrapper.getContent();

      // StringTokenizer zur Zerlegung in Worte
      //String[] contentArray= content.split(" ");
      StringTokenizer st = new StringTokenizer(content, " \t\n\r,.;");
      while (st.hasMoreTokens()) {
         String word = st.nextToken();
         System.out.println("Token:::::::::"+ word);
         if (word.equals("Masterclass")) {
             //;
             
            // response.sendRedirect("http:/www.google.de");
           // word = "<a href=\"http://javaee.akdabas.de\">" + word + "</a>";
            //word = "+++";
            word="****************";
         }
         out.write(" " + word + " ");
      }

      // Flushen und Schließen der Ausgabe
      out.close();
   }
}

/**
 * Hilfklasse: Wrapper zur Pufferung der Ausgabe.
 * Nur zu verwenden bei zeichenorientierten Seiten
 */
class ResponseWrapper extends HttpServletResponseWrapper
   implements HttpServletResponse {

   /* Pufferspeicher für die Daten */
   private CharArrayWriter buffer;

   /**
    * Constructor
    */
   public ResponseWrapper(HttpServletResponse response) {

      // Superklasse initialisieren
      super(response);

      // Puffer initialisieren
      buffer = new CharArrayWriter();
   }

   /**
    * Umgeleitete Methode des Reponse - Objektes
    */
   public PrintWriter getWriter() {
      return new PrintWriter(buffer);
   }

   /**
    * Gibt die gepufferten Daten zurück
    */
   public String getContent() {
      return buffer.toString();
   }
}
