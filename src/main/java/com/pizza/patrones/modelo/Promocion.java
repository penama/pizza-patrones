package com.pizza.patrones.modelo;

import com.pizza.patrones.interfaces.IPromo;
import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Getter
@Setter
public class Promocion {

    private String id;
    private String nombre;
    private Date creado;
    private String inicio;
    private String fin;
    private String dias;
    private IPromo ipromo;
    private boolean dia;
    private boolean activo;

    public Promocion(){
        id = UUID.randomUUID().toString();
    }

    private String obtenerDia(Date date, Locale locale) {
//        DateFormat formatter = new SimpleDateFormat("EEEE", locale);
        DateFormat formatter = new SimpleDateFormat("EEEE");
        return formatter.format(date);
    }

    public List<Descuento> descuentos(Pedido pedido){
        return ipromo.descuentos( pedido.getPizzas() );
    }


}
