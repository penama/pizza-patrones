package com.pizza.patrones.service;

import com.pizza.patrones.modelo.*;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Service
public class CatalogoService {

    private Catalogo catalogo;
    private Map<String, Float> mapCosto = new HashMap<String, Float>();


    @PostConstruct
    private void cargarCatalogoBase() {

        mapCosto.put("CLASICA|PERSONAL", Float.parseFloat("30"));
        mapCosto.put("CLASICA|MEDIANA", Float.parseFloat("50"));
        mapCosto.put("CLASICA|GRANDE", Float.parseFloat("80"));
        mapCosto.put("POLLO|PERSONAL", Float.parseFloat("30"));
        mapCosto.put("POLLO|MEDIANA", Float.parseFloat("50"));
        mapCosto.put("POLLO|GRANDE", Float.parseFloat("80"));
        mapCosto.put("CARNE|PERSONAL", Float.parseFloat("30"));
        mapCosto.put("CARNE|MEDIANA", Float.parseFloat("50"));
        mapCosto.put("CARNE|GRANDE", Float.parseFloat("80"));
        mapCosto.put("CHORIZO|PERSONAL", Float.parseFloat("30"));
        mapCosto.put("CHORIZO|MEDIANA", Float.parseFloat("50"));
        mapCosto.put("CHORIZO|GRANDE", Float.parseFloat("80"));

        catalogo = new Catalogo();
        catalogo.setId(UUID.randomUUID().toString());
        catalogo.addPizza(armarPizzaClasicaPersonal());
        catalogo.addPizza(armarPizzaClasicaMediana());
        catalogo.addPizza(armarPizzaClasicaGrande());
        catalogo.addPizza(armarPizzaPolloPersonal());
        catalogo.addPizza(armarPizzaPolloMediana());
        catalogo.addPizza(armarPizzaPolloGrande());
        catalogo.addPizza(armarPizzaCarnePersonal());
        catalogo.addPizza(armarPizzaCarneMediana());
        catalogo.addPizza(armarPizzaCarneGrande());
        catalogo.addPizza(armarPizzaChorizoPersonal());
        catalogo.addPizza(armarPizzaChorizoMediana());
        catalogo.addPizza(armarPizzaChorizoGrande());
//        catalogo.addPizza( armarPizzaMixtoClasicaCarnePersonal() );
//        catalogo.addPizza( armarPizzaMixtoClasicaCarnePersonalExtraQuesoyCarne() );
    }

    public Pizza getPizzaId(String id) {
        Map<String, Pizza> mapPizzas = catalogo.getPizzas().stream().collect(Collectors.toMap(v -> v.getId(), v -> v));
        return mapPizzas.get(id);
    }

    public float getPrecioMap(Pizza pizza) {
        return mapCosto.get(pizza.getNombre().name() + "|" + pizza.getSize().name());
    }

    private Pizza armarPizzaClasicaPersonal() {
        Pizza pizza = new Pizza();
        pizza.setNombre(Sabor.CLASICA);
        pizza.setMixto(false);
        pizza.addIngredientes(Ingredientes.MASA);
        pizza.addIngredientes(Ingredientes.QUESO);
        pizza.addIngredientes(Ingredientes.SALSA_TOMATE);
        pizza.addIngredientes(Ingredientes.JAMON);
        pizza.addIngredientes(Ingredientes.CHOCLO);
        pizza.setSize(Size.PERSONAL);
        pizza.setPrecio(getPrecioMap(pizza));
        return pizza;
    }

    private Pizza armarPizzaClasicaMediana() {
        Pizza pizza = new Pizza();
        pizza.setNombre(Sabor.CLASICA);
        pizza.setMixto(false);
        pizza.addIngredientes(Ingredientes.MASA);
        pizza.addIngredientes(Ingredientes.QUESO);
        pizza.addIngredientes(Ingredientes.SALSA_TOMATE);
        pizza.addIngredientes(Ingredientes.JAMON);
        pizza.addIngredientes(Ingredientes.CHOCLO);
        pizza.setSize(Size.MEDIANA);
        pizza.setPrecio(getPrecioMap(pizza));
        return pizza;
    }

    private Pizza armarPizzaClasicaGrande() {
        Pizza pizza = new Pizza();
        pizza.setNombre(Sabor.CLASICA);
        pizza.setMixto(false);
        pizza.addIngredientes(Ingredientes.MASA);
        pizza.addIngredientes(Ingredientes.QUESO);
        pizza.addIngredientes(Ingredientes.SALSA_TOMATE);
        pizza.addIngredientes(Ingredientes.JAMON);
        pizza.addIngredientes(Ingredientes.CHOCLO);
        pizza.setSize(Size.GRANDE);
        pizza.setPrecio(getPrecioMap(pizza));
        return pizza;
    }

    private Pizza armarPizzaCarnePersonal() {
        Pizza pizza = new Pizza();
        pizza.setNombre(Sabor.CARNE);
        pizza.setMixto(false);
        pizza.addIngredientes(Ingredientes.MASA);
        pizza.addIngredientes(Ingredientes.QUESO);
        pizza.addIngredientes(Ingredientes.SALSA_TOMATE);
        pizza.addIngredientes(Ingredientes.CARNE);
        pizza.setSize(Size.PERSONAL);
        pizza.setPrecio(getPrecioMap(pizza));
        return pizza;
    }

    private Pizza armarPizzaCarneMediana() {
        Pizza pizza = new Pizza();
        pizza.setNombre(Sabor.CARNE);
        pizza.setMixto(false);
        pizza.addIngredientes(Ingredientes.MASA);
        pizza.addIngredientes(Ingredientes.QUESO);
        pizza.addIngredientes(Ingredientes.SALSA_TOMATE);
        pizza.addIngredientes(Ingredientes.CARNE);
        pizza.setSize(Size.MEDIANA);
        pizza.setPrecio(getPrecioMap(pizza));
        return pizza;
    }

    private Pizza armarPizzaCarneGrande() {
        Pizza pizza = new Pizza();
        pizza.setNombre(Sabor.CARNE);
        pizza.setMixto(false);
        pizza.addIngredientes(Ingredientes.MASA);
        pizza.addIngredientes(Ingredientes.QUESO);
        pizza.addIngredientes(Ingredientes.SALSA_TOMATE);
        pizza.addIngredientes(Ingredientes.CARNE);
        pizza.setSize(Size.GRANDE);
        pizza.setPrecio(getPrecioMap(pizza));
        return pizza;
    }

    private Pizza armarPizzaPolloPersonal() {
        Pizza pizza = new Pizza();
        pizza.setNombre(Sabor.POLLO);
        pizza.setMixto(false);
        pizza.addIngredientes(Ingredientes.MASA);
        pizza.addIngredientes(Ingredientes.QUESO);
        pizza.addIngredientes(Ingredientes.SALSA_TOMATE);
        pizza.addIngredientes(Ingredientes.POLLO);
        pizza.setSize(Size.PERSONAL);
        pizza.setPrecio(getPrecioMap(pizza));
        return pizza;
    }

    private Pizza armarPizzaPolloMediana() {
        Pizza pizza = new Pizza();
        pizza.setNombre(Sabor.POLLO);
        pizza.setMixto(false);
        pizza.addIngredientes(Ingredientes.MASA);
        pizza.addIngredientes(Ingredientes.QUESO);
        pizza.addIngredientes(Ingredientes.SALSA_TOMATE);
        pizza.addIngredientes(Ingredientes.POLLO);
        pizza.setSize(Size.MEDIANA);
        pizza.setPrecio(getPrecioMap(pizza));
        return pizza;
    }

    private Pizza armarPizzaPolloGrande() {
        Pizza pizza = new Pizza();
        pizza.setNombre(Sabor.POLLO);
        pizza.setMixto(false);
        pizza.addIngredientes(Ingredientes.MASA);
        pizza.addIngredientes(Ingredientes.QUESO);
        pizza.addIngredientes(Ingredientes.SALSA_TOMATE);
        pizza.addIngredientes(Ingredientes.POLLO);
        pizza.setSize(Size.GRANDE);
        pizza.setPrecio(getPrecioMap(pizza));
        return pizza;
    }

    private Pizza armarPizzaChorizoPersonal() {
        Pizza pizza = new Pizza();
        pizza.setNombre(Sabor.CHORIZO);
        pizza.setMixto(false);
        pizza.addIngredientes(Ingredientes.MASA);
        pizza.addIngredientes(Ingredientes.QUESO);
        pizza.addIngredientes(Ingredientes.SALSA_TOMATE);
        pizza.addIngredientes(Ingredientes.CHORIZO);
        pizza.setSize(Size.PERSONAL);
        pizza.setPrecio(getPrecioMap(pizza));
        return pizza;
    }

    private Pizza armarPizzaChorizoMediana() {
        Pizza pizza = new Pizza();
        pizza.setNombre(Sabor.CHORIZO);
        pizza.setMixto(false);
        pizza.addIngredientes(Ingredientes.MASA);
        pizza.addIngredientes(Ingredientes.QUESO);
        pizza.addIngredientes(Ingredientes.SALSA_TOMATE);
        pizza.addIngredientes(Ingredientes.CHORIZO);
        pizza.setSize(Size.MEDIANA);
        pizza.setPrecio(getPrecioMap(pizza));
        return pizza;
    }

    private Pizza armarPizzaChorizoGrande() {
        Pizza pizza = new Pizza();
        pizza.setNombre(Sabor.CHORIZO);
        pizza.setMixto(false);
        pizza.addIngredientes(Ingredientes.MASA);
        pizza.addIngredientes(Ingredientes.QUESO);
        pizza.addIngredientes(Ingredientes.SALSA_TOMATE);
        pizza.addIngredientes(Ingredientes.CHORIZO);
        pizza.setSize(Size.GRANDE);
        pizza.setPrecio(getPrecioMap(pizza));
        return pizza;
    }

    private Pizza armarPizzaMixtoClasicaCarnePersonal() {
        Pizza pizza = new Pizza();
        pizza.setNombre(Sabor.CLASICA);
        pizza.setMixto(true);
        pizza.setNombreMixto(Sabor.CARNE);
        pizza.addIngredientes(Ingredientes.MASA);
        pizza.addIngredientes(Ingredientes.QUESO);
        pizza.addIngredientes(Ingredientes.SALSA_TOMATE);
        pizza.addIngredientes(Ingredientes.JAMON);
        pizza.addIngredientes(Ingredientes.CHOCLO);
        pizza.addIngredientesMixto(Ingredientes.CARNE);
        pizza.setSize(Size.PERSONAL);
        pizza.setPrecio(getPrecioMap(pizza));
        return pizza;
    }

    private Pizza armarPizzaMixtoClasicaCarnePersonalExtraQuesoyCarne() {
        Pizza pizza = new Pizza();
        pizza.setNombre(Sabor.CLASICA);
        pizza.setMixto(true);
        pizza.setNombreMixto(Sabor.CARNE);
        pizza.addIngredientes(Ingredientes.MASA);
        pizza.addIngredientes(Ingredientes.QUESO);
        pizza.addIngredientes(Ingredientes.SALSA_TOMATE);
        pizza.addIngredientes(Ingredientes.JAMON);
        pizza.addIngredientes(Ingredientes.CHOCLO);
        pizza.addIngredientesMixto(Ingredientes.CARNE);
        pizza.addExtras(Extras.BORDEQUESO);
        pizza.addExtras(Extras.CARNE);
        pizza.setSize(Size.PERSONAL);
        pizza.setPrecio(getPrecioMap(pizza));
        return pizza;
    }


}
