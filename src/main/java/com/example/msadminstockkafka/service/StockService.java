package com.example.msadminstockkafka.service;

import com.example.msadminstockkafka.dto.StockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class StockService {

    private static final String TOPIC_STOCK = "stock";

    @Autowired
    private KafkaTemplate<String, StockDTO> kafkaTemplate;

    public void procesarStock(Long idProducto, int cantidadVendida) {
        // Simulación: stock inicial es 1000, luego restamos
        int stockActualizado = 1000 - cantidadVendida;

        StockDTO stock = new StockDTO();
        stock.setIdProducto(idProducto);
        stock.setStockDisponible(stockActualizado);
        stock.setFecha(Instant.now().toString());

        kafkaTemplate.send(TOPIC_STOCK, stock);
        System.out.println("📦 Stock actualizado y enviado a Kafka: " + stock);
    }
}
