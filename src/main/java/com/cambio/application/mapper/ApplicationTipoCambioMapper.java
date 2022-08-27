package com.cambio.application.mapper;


import com.cambio.application.model.MonedaDTO;
import com.cambio.application.model.TipoCambioDTO;
import com.cambio.domain.model.Moneda;
import com.cambio.domain.model.TipoCambio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationTipoCambioMapper {

    TipoCambioDTO  tipoCambioToTipoCambioDTO(TipoCambio tipoCambio);

    TipoCambio  tipoCambioDTOToTipoCambio(TipoCambioDTO tipoCambioDTO);

    Moneda monedaToMonedaDTO(MonedaDTO monedaDTO);

    MonedaDTO monedaDTOToMoneda(Moneda monedaDTO);
}
