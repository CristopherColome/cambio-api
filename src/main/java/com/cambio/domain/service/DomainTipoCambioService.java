package com.cambio.domain.service;

import com.cambio.domain.model.TipoCambio;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainTipoCambioService {

    /**
     * Devuelve tipo de cambio
     * @param tipoCambio Data para tipo cambio
     * @return TipoCambio
     * @see TipoCambio
     */
    TipoCambio getTipoCambio(TipoCambio tipoCambio);

    /**
     * Actualiza tipo de cambio
     * @param tipoCambio Data para tipo cambio
     * @return TipoCambio
     * @see TipoCambio
     */
    TipoCambio updateTipoCambio(TipoCambio tipoCambio);
}
