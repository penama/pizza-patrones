package com.pizza.patrones.interfaces;

import com.pizza.patrones.modelo.Pedido;
import com.pizza.patrones.modelo.Pizza;

import java.util.List;

public interface IPedidosService {

    public List<Pedido> getPedidos(List<String> idPedidos );
    public void actualizarEstado( String idPedido, String estado );
    public void pizzaCreada( String idPedido, List<Pizza> pizzaCreadas );
}
