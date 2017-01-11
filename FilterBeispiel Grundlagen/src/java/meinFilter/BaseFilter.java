/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package meinFilter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Schulung
 */
//@WebFilter(urlPatterns = "/*")
public class BaseFilter implements Filter {
   /**
    * Die Konfiguration des Filters
    */
   protected FilterConfig filterConfig;

   /**
    * Speichert die Konfiguration des Filters
    */
   public void init(FilterConfig aConfig) {
      filterConfig = aConfig;
   }

   /**
    * Leitet Request und Response weiter
    */
   public void doFilter(ServletRequest request,
                        ServletResponse response,
                        FilterChain chain)
      throws IOException, ServletException {

      // Leitet den Request mit Manipulationenauf das CharacterEncoding weiter
       request.setCharacterEncoding("UTF-8");
       response.setCharacterEncoding("UTF-8");
      chain.doFilter(request, response);
   }

   /* Der Filter belegt prinzipiell keine Ressourcen */
   public void destroy() {
      filterConfig = null;
   }

}
