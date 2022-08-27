package com.cambio.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonedaDTO {

    private Integer id;

    private String descripcion;

    private Double monto;

}
