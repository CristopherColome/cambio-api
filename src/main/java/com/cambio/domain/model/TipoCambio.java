package com.cambio.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoCambio {

    private Integer id;

    private Double tipoCambio;

    private Moneda monedaOrigen;

    private Moneda monedaDestino;

}
