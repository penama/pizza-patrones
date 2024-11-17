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
public class Promo2x1Impl implements IPromo {

    private String nombre = "Promo2x1";

    @Override
    public List<Descuento> descuentos(List<Pizza> pizzas) {
        List<Descuento> descuentos = new ArrayList<>();
        if (pizzas == null || pizzas.isEmpty()) {
            return descuentos;
        }
        Descuento descuento = null;
        if (pizzas.size() == 1) {
            descuento = new Descuento();
            descuento.setId(UUID.randomUUID().toString());
            descuento.setPizza(pizzas.getFirst().toString());
            descuento.setMonto(0);
            descuento.setConcepto(nombre + " | no aplica la promo al tener solo una pizza");
            descuentos.add(descuento);
        } else if (pizzas.size() == 2) {
            descuento = new Descuento();
            descuento.setId(UUID.randomUUID().toString());
            descuento.setPizza(pizzas.get(1).toString());
            descuento.setMonto(pizzas.get(1).getPrecio());
            descuento.setConcepto(nombre);
            descuentos.add(descuento);
        } else {
            for (int i = (pizzas.size() / 2) + 1; i < pizzas.size(); i++) {
                Pizza pizza = pizzas.get(i);
                descuento = new Descuento();
                descuento.setId(UUID.randomUUID().toString());
                descuento.setPizza(pizza.toString());
                descuento.setMonto(pizza.getPrecio());
                descuento.setConcepto(nombre);
                descuentos.add(descuento);
                System.out.println("Entro mierrrrrr");
            }
        }
        return descuentos;
    }

}
