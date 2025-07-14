package com.example.msadminstockkafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {
    private Long idProducto;
    private Integer cantidad;
    private BigDecimal total;
    private String fecha;
}
