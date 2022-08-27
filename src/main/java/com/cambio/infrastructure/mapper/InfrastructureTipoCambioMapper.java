package com.cambio.infrastructure.mapper;

import com.cambio.domain.model.Moneda;
import com.cambio.domain.model.TipoCambio;
import com.cambio.infrastructure.model.sql.MonedaTable;
import com.cambio.infrastructure.model.sql.TipoCambioTable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InfrastructureTipoCambioMapper {

    TipoCambio tipoCambioTableToTipoCambio(TipoCambioTable tipoCambioTable);

    TipoCambioTable tipoCambioToTipoCambioTable(TipoCambio tipoCambio);

    Moneda monedaTableToMoneda(MonedaTable monedaTable);

    MonedaTable monedaToMonedaTable(Moneda moneda);
}
