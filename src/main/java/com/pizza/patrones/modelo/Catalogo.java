package com.pizza.patrones.modelo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Catalogo {

    private String id;
    private List<Pizza> pizzas;

    public void addPizza( Pizza pizza ){
        if (pizzas == null )
            pizzas = new ArrayList<>();
        pizzas.add( pizza );
    }

}
