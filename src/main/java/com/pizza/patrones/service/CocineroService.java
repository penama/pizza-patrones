package com.pizza.patrones.service;

import com.pizza.patrones.interfaces.IPedidosService;
import com.pizza.patrones.modelo.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocineroService {

    private Cocinero cocinero = new Cocinero();
    private PizzaBuilderImpl pizzaBuilder = new PizzaBuilderImpl();
    private IPedidosService pedidosService;

    @Async
    public void procesarPedidos(List<String> idPedidos, IPedidosService pedidosServiceAux){
        pedidosService = pedidosServiceAux;
        List<Pedido> pedidos = pedidosService.getPedidos( idPedidos );
        for (Pedido pedido : pedidos) {
            procesandoPedido( pedido );
        }
    }

    private void procesandoPedido( Pedido pedido ){
        pedidosService.actualizarEstado( pedido.getId(), PedidoStatus.ENPROGRESO.name());
        for (Pizza pizza : pedido.getPizzas()) {
            try {
                System.out.println( "Esperando procesar el pedido..." );
                Thread.sleep( 2000 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Pizza pizzaCreada = procesandoPizza( pizza );
            System.out.println( "Pizza procesada..." );
        }
        pedidosService.actualizarEstado( pedido.getId(), PedidoStatus.COMPLETADO.name());
    }

    private Pizza procesandoPizza( Pizza pizza ){
        Pizza pizzaCreada = null;
        if ( pizza.getNombre().name().equalsIgnoreCase(Sabor.CLASICA.name() ) ){
            cocinero.crearPizzaClasica( pizzaBuilder );
        } else if ( pizza.getNombre().name().equalsIgnoreCase(Sabor.POLLO.name() ) ) {
            cocinero.crearPizzaPollo(pizzaBuilder);
        } else if ( pizza.getNombre().name().equalsIgnoreCase(Sabor.CARNE.name() ) ){
                cocinero.crearPizzaCarne( pizzaBuilder );
        } else if ( pizza.getNombre().name().equalsIgnoreCase(Sabor.CHORIZO.name() ) ){
            cocinero.crearPizzaChorizo( pizzaBuilder );
        }
        if ( pizza.getSize().name().equalsIgnoreCase(Size.PERSONAL.name()) ){
            pizzaBuilder.agregarSizePersonal();
        } else if ( pizza.getSize().name().equalsIgnoreCase(Size.MEDIANA.name()) ){
            pizzaBuilder.agregarSizeMediana();
        } else if ( pizza.getSize().name().equalsIgnoreCase(Size.GRANDE.name()) ){
            pizzaBuilder.agregarSizeGrande();
        }
        if ( pizza.getMixto() ){
            pizzaBuilder.isMixto( true );
            if ( pizza.getNombreMixto().name().equalsIgnoreCase(Sabor.CLASICA.name()) ){
                pizzaBuilder.agregarMixtoChoclo();
                pizzaBuilder.agregarMixtoJamon();
            } else if ( pizza.getNombreMixto().name().equalsIgnoreCase(Sabor.POLLO.name()) ){
                pizzaBuilder.agregarMixtoPollo();
            } else if ( pizza.getNombreMixto().name().equalsIgnoreCase(Sabor.CARNE.name()) ){
                pizzaBuilder.agregarMixtoCarne();
            } else if ( pizza.getNombreMixto().name().equalsIgnoreCase(Sabor.CHORIZO.name()) ){
                pizzaBuilder.agregarMixtoChorizo();
            }
        }
        if ( pizza.getExtrasList() != null && !pizza.getExtrasList().isEmpty() ){
            for (Extras extras : pizza.getExtrasList()) {
                if ( extras.name().equalsIgnoreCase( Extras.CARNE.name() ) )
                    pizzaBuilder.agregarExtraCarne();
                else if ( extras.name().equalsIgnoreCase( Extras.POLLO.name() ) )
                    pizzaBuilder.agregarExtraPollo();
                else if ( extras.name().equalsIgnoreCase( Extras.JAMON.name() ) )
                    pizzaBuilder.agregarExtraJamon();
                else if ( extras.name().equalsIgnoreCase( Extras.CHORIZO.name() ) )
                    pizzaBuilder.agregarChorizo();
                else if ( extras.name().equalsIgnoreCase( Extras.BORDEQUESO.name() ) )
                    pizzaBuilder.agregarExtraBordeQueso();
            }
        }
        return pizzaBuilder.createPizza();
    }

}
