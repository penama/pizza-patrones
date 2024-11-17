package com.pizza.patrones.interfaces;

import com.pizza.patrones.modelo.Descuento;
import com.pizza.patrones.modelo.Pizza;

import java.util.List;

public interface IPromo {
    public List<Descuento> descuentos(List<Pizza> pizzas );

}
