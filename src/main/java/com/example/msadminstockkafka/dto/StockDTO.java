package com.example.msadminstockkafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {
    private Long idProducto;
    private Integer stockDisponible;
    private String fecha;
}
