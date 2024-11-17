package com.pizza.patrones.service.promos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.pizza.patrones.interfaces.IPromo;
import com.pizza.patrones.modelo.Descuento;
import com.pizza.patrones.modelo.Pizza;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PromoDeliveryCeroImpl implements IPromo {

    private String nombre = "DeveliveryCero";

    @Override
    public List<Descuento> descuentos(List<Pizza> pizzas) {
        List<Descuento> descuentos = new ArrayList<>();
        if (pizzas == null || pizzas.isEmpty()) {
            return descuentos;
        }
        Descuento descuento = new Descuento();
        descuento.setId( UUID.randomUUID().toString() );
        descuento.setMonto( 10 );
        descuento.setConcepto( nombre );
        descuento.setPizza( "todas" );
        descuentos.add( descuento );
        return descuentos;
    }

}
