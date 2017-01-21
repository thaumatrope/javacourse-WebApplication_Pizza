package com.model;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;



@FacesConverter(forClass = com.model.Student.class,value="student")
public class StudentConverter implements Converter{
	 public static List<Student> studentDB;

	    static {
	    	studentDB = new ArrayList<Student>();
	    	studentDB.add(new Student("William", "Wong", 1));
	    	studentDB.add(new Student("John", "Smith", 2));
	    	studentDB.add(new Student("Mari", "Beckley", 3));
	    	studentDB.add(new Student("Messi", "Leonardo",4));}
	    
	    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
	        if (submittedValue.trim().equals("")) {
	            return null;
	        } else {
	            try {
	                int number = Integer.parseInt(submittedValue);

	                for (Student s : studentDB) {
	                    if (s.getId() == number) {
	                        return s;
	                    }
	                }
	               
	            } catch(NumberFormatException exception) {
	                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));
	            }
	        }

	        return null;
	    }

	    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
	        if (value == null || value.equals("")) {
	            return "";
	        } else {
	            return String.valueOf(((Student) value).getId());
	        }
	    }
	}





