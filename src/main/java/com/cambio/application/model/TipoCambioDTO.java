package com.cambio.application.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TipoCambioDTO {

    private Integer id;

    private Double tipoCambio;

    private MonedaDTO monedaOrigen;

    private MonedaDTO monedaDestino;

    //REQUEST
    @Min(1)
    private Double montoCambio;

    private String monedaOrigenNombre;

    private String monedaDestinoNombre;


}
