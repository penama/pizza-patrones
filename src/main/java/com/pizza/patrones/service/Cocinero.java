package com.pizza.patrones.service;

import com.pizza.patrones.interfaces.Builder;

public class Cocinero {


    public void crearPizzaClasica(Builder builder){
        builder.reset();
        builder.agregarMasa();
        builder.agregarSaltaTomate();
        builder.agregarQueso();
        builder.agregarJamon();
        builder.agregarChoclo();
    }
    public void crearPizzaPollo(Builder builder){
        builder.reset();
        builder.agregarMasa();
        builder.agregarSaltaTomate();
        builder.agregarQueso();
        builder.agregarPollo();
    }

    public void crearPizzaCarne(Builder builder){
        builder.reset();
        builder.agregarMasa();
        builder.agregarSaltaTomate();
        builder.agregarQueso();
        builder.agregarCarne();
    }

    public void crearPizzaChorizo(Builder builder){
        builder.reset();
        builder.agregarMasa();
        builder.agregarSaltaTomate();
        builder.agregarQueso();
        builder.agregarChorizo();
    }

}
