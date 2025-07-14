package com.example.msadminstockkafka.listener;

import com.example.msadminstockkafka.dto.VentaDTO;
import com.example.msadminstockkafka.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class VentaListener {

    @Autowired
    private StockService stockService;

    @KafkaListener(topics = "ventas", groupId = "stock-group", containerFactory = "ventaKafkaListenerContainerFactory")
    public void recibirVenta(VentaDTO venta) {
        System.out.println("🛒 Venta recibida: " + venta);
        stockService.procesarStock(venta.getIdProducto(), venta.getCantidad());
    }
}
