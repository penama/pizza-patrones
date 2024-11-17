package com.pizza.patrones.service;

import com.pizza.patrones.interfaces.IPedidosService;
import com.pizza.patrones.modelo.*;
import com.pizza.patrones.service.promos.PromocionController;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Service
public class PedidoService implements IPedidosService {

    //    private List<Pedido> pedidos;
    private List<PedidosDto> pedidos;

    @Autowired
    private CatalogoService catalogoService;
    @Autowired
    private PromocionController promocionController;
    @Autowired
    private CocineroService cocineroService;

    private PizzaBuilderImpl pizzaBuilderImpl = new PizzaBuilderImpl();
    private Cocinero cocinero = new Cocinero();

    @PostConstruct
    public void initPedidos() {
        PedidosDto pedidosDto = new PedidosDto();
        Pedido pedido = new Pedido();
        pedido.setId(UUID.randomUUID().toString());
        pedido.addPizza(catalogoService.getCatalogo().getPizzas().getFirst());
        pedido.addPizza(catalogoService.getCatalogo().getPizzas().getLast());
        pedido.setFecha("14/11/2024");
        pedido.setPersonalizable(false);
        pedido.setEstado(PedidoStatus.COMPLETADO.name());
        pedidosDto.setPedido(pedido);
        Promocion promocion = promocionController.obtenerPromo(pedido.getFecha());
        pedidosDto.setPromocion(promocion);
        if (promocion != null)
            pedidosDto.setDescuentos(promocion.descuentos(pedido));
        pedido.setCosto(calcularCosto(pedido));
        pedido.setDescuento(calcularDescuentos(pedidosDto.getDescuentos()));
        pedido.setTotal(pedido.getCosto() - pedido.getDescuento());
        addPedidosDto(pedidosDto);
    }

    public void addPedidosDto(PedidosDto pedidosDto) {
        if (pedidos == null)
            pedidos = new ArrayList<>();
        pedidos.add(pedidosDto);
    }

    public List<PedidosDto> crearPedido(List<Pedido> pedidoss) {
        List<PedidosDto> pedidosCreados = new ArrayList<>();
        List<String> idPedidos = new ArrayList<>();
        PedidosDto pedidosDto = null;
        for (Pedido pedido : pedidoss) {
            pedido.setId(UUID.randomUUID().toString());
            pedido.setEstado(PedidoStatus.RECIBIDO.name());
            List<Pizza> pizzas = pedido.getPizzas();
            for (Pizza pizza : pizzas) {
                pizza.setPrecio(catalogoService.getPrecioMap(pizza));
            }
            pedidosDto = new PedidosDto();
            pedidosDto.setPedido(pedido);
            Promocion promocion = promocionController.obtenerPromo(pedido.getFecha());
            pedidosDto.setPromocion(promocion);
            if (promocion != null)
                pedidosDto.setDescuentos(promocion.descuentos(pedido));
            pedido.setCosto(calcularCosto(pedido));
            pedido.setDescuento(calcularDescuentos(pedidosDto.getDescuentos()));
            pedido.setTotal(pedido.getCosto() - pedido.getDescuento());
            pedidosCreados.add(pedidosDto);
            addPedidosDto(pedidosDto);
            idPedidos.add(pedido.getId());
        }
        cocineroService.procesarPedidos(idPedidos, this);
        return pedidosCreados;
    }

    private float calcularCosto(Pedido pedido) {
        float costo = 0;
        for (Pizza pizza : pedido.getPizzas()) {
            costo += pizza.getPrecio();
        }
        return costo;
    }

    private float calcularDescuentos(List<Descuento> descuentos) {
        float mdescuento = 0;
        for (Descuento descuento : descuentos) {
            mdescuento += descuento.getMonto();
        }
        return mdescuento;
    }

    @Override
    public List<Pedido> getPedidos(List<String> idPedidos) {
        Map<String, Pedido> mapPedidos = pedidos.stream().collect(Collectors.toMap(v -> v.getPedido().getId(), v -> v.getPedido()));
        List<Pedido> pedidos = new ArrayList<>();
        for (String idPedido : idPedidos) {
            Pedido pedido = mapPedidos.get(idPedido);
            if (pedido != null)
                pedidos.add(pedido);
        }
        return pedidos;
    }

    @Override
    public void actualizarEstado(String idPedido, String estado) {
        Map<String, Pedido> mapPedidos = pedidos.stream().collect(Collectors.toMap(v -> v.getPedido().getId(), v -> v.getPedido()));
        Pedido pedido = mapPedidos.get(idPedido);
        pedido.setEstado(estado);
    }

    @Override
    public void pizzaCreada(String idPedido, List<Pizza> pizzaCreadas) {
        Map<String, Pedido> mapPedidos = pedidos.stream().collect(Collectors.toMap(v -> v.getPedido().getId(), v -> v.getPedido()));
        Pedido pedido = mapPedidos.get(idPedido);
        Map<String, Pizza> mapPizza = pedido.getPizzas().stream().collect(Collectors.toMap(v -> v.getNombre().name() + "1" + v.getSize().name(), v -> v));
        for (Pizza pizzaCreada : pizzaCreadas) {
            Pizza pizzaPedido = mapPizza.get(pizzaCreada.getNombre().name() + "|" + pizzaCreada.getSize().name());
            pizzaPedido.setId(pizzaCreada.getId());
            pizzaPedido.setIngredientesList(pizzaCreada.getIngredientesList());
            pizzaPedido.setIngredientesMixtoList(pizzaCreada.getIngredientesMixtoList());
            pizzaPedido.setExtrasList(pizzaCreada.getExtrasList());
        }
    }
}
