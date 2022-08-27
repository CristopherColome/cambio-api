package com.cambio.domain.respository;

import com.cambio.domain.model.TipoCambio;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainTipoCambioRepository {

    /**
     * Devuelve tipo de cambio desde DB
     * @param tipoCambio Data para tipo cambio
     * @return TipoCambio
     * @see TipoCambio
     */
    TipoCambio getTipoCambio(TipoCambio tipoCambio);


    /**
     * Actualiza tipo de cambio en DB
     * @param tipoCambio Data para tipo cambio
     * @return TipoCambio
     * @see TipoCambio
     */
    TipoCambio updateTipoCambio(TipoCambio tipoCambio);
}
