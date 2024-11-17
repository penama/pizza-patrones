package com.pizza.patrones.interfaces;

import com.pizza.patrones.modelo.Pedido;
import com.pizza.patrones.modelo.Promocion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping( "/api/v1/monkeypizza" )
public interface IPedidoPizza {

    @GetMapping( "/pedidos" )
    public ResponseEntity getPedidos();

    @GetMapping( "/catalogo" )
    public ResponseEntity getCatalogo();

    @GetMapping( "/promos" )
    public ResponseEntity getPromos();

    @PostMapping( "/pedido" )
    public ResponseEntity createPedido(@RequestBody List<Pedido> pedidos);


}
