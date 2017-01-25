package com.westfield.pizza.validator;

import com.westfield.pizza.controller.PizzaLogin;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ResourceBundle;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;
import javax.faces.application.FacesMessage;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Validiert eMail-Adressen auf syntaktische Korrektheit
 */
@FacesValidator(value = "emailValidator")
public class EmailValidator implements Validator {

   /**
    * Validiert den Wert des übergebenen Objekt object
     * @param ctx
     * @param component
     * @param obj
    */
  
   @Override
    public void validate(FacesContext ctx, UIComponent component, Object obj) throws ValidatorException {

        // Ressourcen-Bundle laden
        ResourceBundle bundle = ResourceBundle.getBundle("com.westfield.pizza.util.messages", ctx.getViewRoot().getLocale());

        // 'null' ist ebenfalls ein ungültiger Wert
        if (obj == null) {

            // Fehlermeldung auslesen
            String errorKey = "errorlabelEmailisNull";
            String errorMsg = bundle.getString(errorKey);

            // Fehlermeldung im Kontext speichern, damit diese ggf. auch in der JSP zur Verf�gung steht
            FacesMessage msg = new FacesMessage( FacesMessage.SEVERITY_ERROR, errorMsg, null);
            throw new ValidatorException(msg);
        }

        // Muster gültiger eMail-Adressen als Regular Expression
        String pattern = "^[\\w-]+(?:\\.[\\w-]+)*@(?:[\\w-]+\\.)+[a-zA-Z]{2,7}$";

        // Pattern-Instanz erzeugen
        Pattern p = Pattern.compile(pattern);

        // Auf Gültigkeit Überprüfen
        Matcher m = p.matcher(obj.toString());
        if (!m.matches()) {
           // Wert nicht gültig
           // Fehlermeldung auslesen
            String errorKey = "errorlabelEmailnotValid";
            String errorMsg = bundle.getString(errorKey);

            // Fehlermeldung im Kontext speichern, damit diese ggf. auch in der JSP zur Verf�gung steht
            FacesMessage msg = new FacesMessage( FacesMessage.SEVERITY_ERROR, errorMsg, null);
            throw new ValidatorException(msg);
        }
        
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession mySession = request.getSession();
        PizzaLogin myService = (PizzaLogin) mySession.getAttribute("pizzaLogin");
        if (myService.getMyKunde().checkEmail(obj.toString())){
            
            // email bereits vergeben
            // Fehlermeldung auslesen
            String errorKey = "errorlabelEmailalreadyExists";
            String errorMsg = bundle.getString(errorKey);

            // Fehlermeldung im Kontext speichern, damit diese ggf. auch in der JSP zur Verf�gung steht
            FacesMessage msg = new FacesMessage( FacesMessage.SEVERITY_ERROR, errorMsg, null);
            throw new ValidatorException(msg);
            
        }        
        
    }
}

