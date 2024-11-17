package com.pizza.patrones.Controller;

import com.pizza.patrones.interfaces.IPedidoPizza;
import com.pizza.patrones.modelo.Catalogo;
import com.pizza.patrones.modelo.Pedido;
import com.pizza.patrones.service.CatalogoService;
import com.pizza.patrones.service.PedidoService;
import com.pizza.patrones.modelo.Promocion;
import com.pizza.patrones.service.PedidosDto;
import com.pizza.patrones.service.promos.PromocionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PedidoControlerImpl implements IPedidoPizza {

    @Autowired
    private CatalogoService catalogoService;

    @Autowired
    private PromocionController promocionController;

    @Autowired
    private PedidoService pedidoService;

    @Override
    public ResponseEntity getPedidos() {
        return new ResponseEntity<List<PedidosDto>>(pedidoService.getPedidos(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity getCatalogo() {
        return new ResponseEntity<Catalogo>(catalogoService.getCatalogo(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity getPromos() {
        return new ResponseEntity<List<Promocion>>(promocionController.getPromociones(), HttpStatus.OK);
    }


    @Override
    public ResponseEntity createPedido(List<Pedido> pedidos) {
        return new ResponseEntity<List<PedidosDto>>(pedidoService.crearPedido( pedidos ),HttpStatus.CREATED);
    }

}
