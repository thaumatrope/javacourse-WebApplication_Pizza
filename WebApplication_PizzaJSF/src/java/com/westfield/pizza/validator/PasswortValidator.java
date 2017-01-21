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
 @FacesValidator(value = "passwortValidator")
public class PasswortValidator implements Validator {

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
      ResourceBundle bundle = ResourceBundle.getBundle("com.westfield.pizza.util.messages", ctx.getViewRoot().getLocale());

      // Fehlermeldung auslesen
      String errorKey = "errorlabelPasswort";
      String errorMsg = bundle.getString(errorKey);

      // Fehlermeldung im Kontext speichern, damit diese ggf. auch in der JSP zur Verf�gung steht
      FacesMessage msg = new FacesMessage( FacesMessage.SEVERITY_ERROR, errorMsg, null);

      // 'null' ist ebenfalls ein ungültiger Wert
      if (obj == null) {
         throw new ValidatorException(msg);
      }

      // Muster gültiger eMail-Adressen als Regular Expression
      //String pattern = "^.*(?=.{6,})(?=.*[a-zA-Z])[a-zA-Z0-9]+$";  // min 6 chars, only numbers and letters, min 1 letter
      String pattern = "^[A-Za-z0-9]{4,10}$";  //only numbers and letters, min. 4 - max. 10
      

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

