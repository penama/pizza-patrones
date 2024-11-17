package com.pizza.patrones.service;

import com.pizza.patrones.interfaces.Builder;
import com.pizza.patrones.modelo.*;

public class PizzaBuilderImpl implements Builder {

    private Pizza pizza = null;

    public void reset(){
        pizza = new Pizza();
    }

    @Override
    public void agregarSizePersonal() {
        pizza.setSize( Size.PERSONAL );
    }

    @Override
    public void agregarSizeMediana() {
        pizza.setSize( Size.MEDIANA );
    }

    @Override
    public void agregarSizeGrande() {
        pizza.setSize( Size.GRANDE );
    }

    @Override
    public void agregarMasa() {
        pizza.addIngredientes( Ingredientes.MASA );
    }

    public Pizza createPizza(){
        return pizza;
    }

    @Override
    public void asignarNombre(Sabor sabor) {
        pizza.setNombre( sabor );
    }

    @Override
    public void asignarNombreMixto(Sabor sabor) {
        pizza.setNombreMixto( sabor );
    }

    @Override
    public void isMixto(boolean mixto) {
        pizza.setMixto( mixto );
    }

    @Override
    public void agregarSaltaTomate() {
        pizza.addIngredientes( Ingredientes.SALSA_TOMATE );
    }

    @Override
    public void agregarJamon() {
        pizza.addIngredientes(Ingredientes.JAMON);
    }

    @Override
    public void agregarQueso() {
        pizza.addIngredientes(Ingredientes.QUESO);
    }

    @Override
    public void agregarChoclo() {
        pizza.addIngredientes(Ingredientes.CHOCLO);
    }

    @Override
    public void agregarPollo() {
        pizza.addIngredientes(Ingredientes.POLLO);
    }

    @Override
    public void agregarCarne() {
        pizza.addIngredientes(Ingredientes.CARNE);
    }

    @Override
    public void agregarChorizo() {
        pizza.addIngredientes(Ingredientes.CHORIZO);
    }

    @Override
    public void agregarPiña() {
        pizza.addIngredientes(Ingredientes.PIÑA);
    }

    @Override
    public void agregarMixtoChoclo() {
        pizza.addIngredientesMixto( Ingredientes.CHOCLO );
    }

    @Override
    public void agregarMixtoJamon() {
        pizza.addIngredientesMixto( Ingredientes.JAMON );
    }

    @Override
    public void agregarMixtoCarne() {
        pizza.addIngredientesMixto( Ingredientes.CARNE );
    }

    @Override
    public void agregarMixtoChorizo() {
        pizza.addIngredientesMixto( Ingredientes.CHORIZO );
    }

    @Override
    public void agregarMixtoPollo() {
        pizza.addIngredientesMixto( Ingredientes.POLLO );
    }

    @Override
    public void agregarOregano() {
        pizza.addIngredientes(Ingredientes.OREGANO);
    }

    @Override
    public void agregarExtraJamon() {
        pizza.addExtras(Extras.JAMON);
    }

    @Override
    public void agregarExtraQueso() {
        pizza.addExtras(Extras.QUESO);
    }

    @Override
    public void agregarExtraCarne() {
        pizza.addExtras(Extras.CARNE);
    }

    @Override
    public void agregarExtraChorizo() {
        pizza.addExtras(Extras.CHORIZO);
    }

    @Override
    public void agregarExtraPollo() {
        pizza.addExtras(Extras.POLLO);
    }

    @Override
    public void agregarExtraBordeQueso() {
        pizza.addExtras( Extras.BORDEQUESO );
    }


}
