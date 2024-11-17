package com.pizza.patrones.interfaces;

import com.pizza.patrones.modelo.Sabor;

public interface Builder {

    public void reset();
    public void agregarSizePersonal();
    public void agregarSizeMediana();
    public void agregarSizeGrande();
    public void agregarMasa();
//    public void asignarNombre( String nombre );
    public void asignarNombre(Sabor sabor);
    public void asignarNombreMixto(Sabor sabor);
    public void isMixto(boolean mixto);
    public void agregarSaltaTomate();
    public void agregarJamon();
    public void agregarQueso();
    public void agregarChoclo();
    public void agregarPollo();
    public void agregarCarne();
    public void agregarChorizo();
    public void agregarPiña();
    public void agregarMixtoChoclo();
    public void agregarMixtoJamon();
    public void agregarMixtoCarne();
    public void agregarMixtoChorizo();
    public void agregarMixtoPollo();
    public void agregarOregano();
    public void agregarExtraJamon();
    public void agregarExtraQueso();
    public void agregarExtraCarne();
    public void agregarExtraChorizo();
    public void agregarExtraPollo();
    public void agregarExtraBordeQueso();

}
