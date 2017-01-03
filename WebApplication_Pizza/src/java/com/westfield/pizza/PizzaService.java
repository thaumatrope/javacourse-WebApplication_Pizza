package com.westfield.pizza;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User704
 */
public class PizzaService {
    
    private List<Pizza> pizzaAngebot;

    public List<Pizza> getPizzaAngebot() {
        return pizzaAngebot;
    }

    public void setPizzaAngebot(List<Pizza> pizzaAngebot) {
        this.pizzaAngebot = pizzaAngebot;
    }
    
    public PizzaService(){
        pizzaAngebot = new ArrayList();
        pizzaAngebot.add(new Pizza("Pizza Tonno", 13.50));
        pizzaAngebot.add(new Pizza("Pizza Diavolo", 6.66));
        pizzaAngebot.add(new Pizza("Pizza Hawaii", 14.00));
        pizzaAngebot.add(new Pizza("Pizza Calzone", 14.00));
        pizzaAngebot.add(new Pizza("Pizza Quattro Stagioni", 14.00));        
    }
    
   
    
    
    
}
