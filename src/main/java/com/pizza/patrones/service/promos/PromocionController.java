package com.pizza.patrones.service.promos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.pizza.patrones.modelo.Dias;
import com.pizza.patrones.modelo.Pedido;
import com.pizza.patrones.modelo.Promocion;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Data
public class PromocionController {

    private List<Promocion> promociones;

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String dtoAsString;
        try {
            dtoAsString = objectMapper.writeValueAsString(promociones);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return dtoAsString;
    }

    public void addPromocion(Promocion promocion) {
        if (promociones == null)
            promociones = new ArrayList<>();
        promociones.add(promocion);
    }

    public Promocion obtenerPromo(String fecha) {
        LocalDate date = StringToDate(fecha);
        for (Promocion promocione : promociones) {
            LocalDate dateIni = StringToDate(promocione.getInicio());
            LocalDate dateFin = StringToDate(promocione.getFin());
            if (dateIni.isBefore(date) && dateFin.isAfter(date)) {
                if (promocione.isDia()) {
                    if (promocione.getDias().contains(getDia(date))) {
                        return promocione;
                    }
                } else {
                    return promocione;
                }
            }
        }
        return null;
    }

    private String getDia(LocalDate date) {
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("EEE", Locale.ENGLISH);
        String dia = formatter2.format(date);
        System.out.println("dia : " + dia);
        return dia;
    }

    private LocalDate StringToDate(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        LocalDate dateTime = LocalDate.parse(fecha, formatter);
        return dateTime;
    }


    @PostConstruct
    public void addPromos() {
        Promocion promocion = new Promocion();
        promocion.setNombre("Promo 2x1 Martes y Jueves");
        promocion.setDia(true);
        promocion.setDias(Dias.Tue.name() + "," + Dias.Wed.name());
        promocion.setCreado(Calendar.getInstance().getTime());
        promocion.setInicio("04/11/2024");
        promocion.setFin("17/11/2024");
        promocion.setActivo(true);
        promocion.setIpromo(new Promo2x1Impl());
        addPromocion(promocion);

        promocion = new Promocion();
        promocion.setNombre("Jueves Delivery Gratis");
        promocion.setDia(true);
        promocion.setDias(Dias.Tue.name());
        promocion.setCreado(Calendar.getInstance().getTime());
        promocion.setInicio("18/11/2024");
        promocion.setFin("22/11/2024");
        promocion.setActivo(true);
        promocion.setIpromo(new PromoDeliveryCeroImpl());
        addPromocion(promocion);

    }

}
