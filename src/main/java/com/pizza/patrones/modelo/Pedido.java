package com.pizza.patrones.modelo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Pedido {

    private String id;
    private String fecha;
    private List<Pizza> pizzas;
    private boolean personalizable;
    private float costo;
    private float descuento;
    private float total;
    private String estado;

    public void addPizza( Pizza pizza ){
        if ( pizzas == null )
            pizzas = new ArrayList<>();
        pizzas.add( pizza );
    }

}
