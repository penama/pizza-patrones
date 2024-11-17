package com.pizza.patrones.modelo;

import lombok.Data;

@Data
public class Descuento {

    private String id;
    private String pizza;
    private float monto;
    private String concepto;

}
