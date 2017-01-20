package com.westfield.pizza.validator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;
import javax.faces.application.FacesMessage;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Validiert eMail-Adressen auf syntaktische Korrektheit
 */
 @FacesValidator(value = "emailValidator")
public class PlzValidator implements Validator {

   /**
    * Validiert den Wert des übergebenen Objekt object
     * @param ctx
     * @param component
     * @param obj
    */
  
   @Override
   public void validate(FacesContext ctx, UIComponent component, Object obj)
      throws ValidatorException {

      // Ressourcen-Bundle laden
      ResourceBundle bundle = ResourceBundle.getBundle("messages", ctx.getViewRoot().getLocale());

      // Fehlermeldung auslesen
      String errorKey = "errorlabelEmail";
      String errorMsg = bundle.getString(errorKey);

      // Fehlermeldung im Kontext speichern, damit diese ggf. auch in der JSP zur Verf�gung steht
      FacesMessage msg = new FacesMessage(errorMsg);

      // 'null' ist ebenfalls ein ung�ltiger Wert
      if (obj == null) {
         throw new ValidatorException(msg);
      }

      // Muster g�ltiger eMail-Adressen als Regular Expression
      String pattern =
         "^[\\w-]+(?:\\.[\\w-]+)*@(?:[\\w-]+\\.)+[a-zA-Z]{2,7}$";

      // Pattern-Instanz erzeugen
      Pattern p = Pattern.compile(pattern);

      // Auf Gültigkeit Überprüfen
      Matcher m = p.matcher(obj.toString());
      if (!m.matches()) {
         // Wert nicht gültig
         throw new ValidatorException(msg);
      }
   }
}

