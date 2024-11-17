package com.pizza.patrones.service;

import com.pizza.patrones.modelo.Descuento;
import com.pizza.patrones.modelo.Pedido;
import com.pizza.patrones.modelo.Promocion;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PedidosDto {

    private Pedido pedido;
    private Promocion promocion;
    private List<Descuento> descuentos = new ArrayList<>();


}
