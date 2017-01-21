/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedbean;

import com.model.Essen;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Schulung
 */
@Named
@RequestScoped
public class MyDialog {
    @Inject 
    MyController myController;
    
    public void viewDisplay() {
        myController.setBestell(new Essen());
        RequestContext.getCurrentInstance().openDialog("dialog");
    }
     
    public void viewCarsCustomized() {
//        Map<String,Object> options = new HashMap<String, Object>();
//        options.put("modal", true);
//        options.put("draggable", false);
//        options.put("resizable", false);
//        options.put("contentHeight", 320);
         
       // RequestContext.getCurrentInstance().openDialog("viewCars", options, null);
    }
}