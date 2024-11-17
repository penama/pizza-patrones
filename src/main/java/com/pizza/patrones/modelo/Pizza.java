package com.pizza.patrones.modelo;

import jakarta.annotation.PostConstruct;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Pizza {

    private String id;
    private Sabor nombre;
    private Sabor nombreMixto;
    private Boolean mixto;
    private List<Ingredientes> ingredientesList = new ArrayList<>();
    private List<Ingredientes> ingredientesMixtoList = new ArrayList<>();
    private List<Extras> extrasList = new ArrayList<>();
    private Size size;
    private float precio;


    public Pizza(){
        id = UUID.randomUUID().toString();
    }

    public void addIngredientes( Ingredientes ingredientes ){
        if ( ingredientesList == null )
            ingredientesList = new ArrayList<>();
        ingredientesList.add( ingredientes );
    }

    public void addIngredientesMixto( Ingredientes ingredientes ){
        if ( ingredientesMixtoList == null )
            ingredientesList = new ArrayList<>();
        ingredientesMixtoList.add( ingredientes );
    }

    public void addExtras( Extras extras ){
        if ( extrasList == null )
            extrasList = new ArrayList<>();
        extrasList.add( extras );
    }

    public String toString(){
        return nombre.name() + "," + size.name() + ( mixto ? ", mixto:" + nombreMixto.name() : "" ) + ", id: "+ id;
    }

}
