package com.cambio.domain.service;

import com.cambio.domain.model.TipoCambio;
import com.cambio.domain.respository.DomainTipoCambioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class DomainTipoCambioServiceImpl implements DomainTipoCambioService {

    @Autowired
    private DomainTipoCambioRepository domainTipoCambioRepository;


    /**
     * Devuelve tipo de cambio
     * @param tipoCambio Data para tipo cambio
     * @return TipoCambio
     * @see DomainTipoCambioService#getTipoCambio(TipoCambio)
     */
    @Override
    public TipoCambio getTipoCambio(TipoCambio tipoCambio) {
        log.info("INICIO OBTENER TIPO CAMBIO");

        var tipoCambioResult = domainTipoCambioRepository.getTipoCambio(tipoCambio);

        if (tipoCambioResult.getId() != null){

            tipoCambioResult.getMonedaOrigen()
                    .setMonto(
                            tipoCambio.getMonedaOrigen().getMonto()
                    );

            tipoCambioResult.getMonedaDestino()
                            .setMonto(
                                    tipoCambio.getMonedaOrigen().getMonto() *
                                    tipoCambioResult.getTipoCambio()
                            );
        }

        log.info("FIN OBTENER TIPO CAMBIO");
        return tipoCambioResult;
    }

    @Override
    public TipoCambio updateTipoCambio(TipoCambio tipoCambio) {
        log.info("INICIO ACTUALIZAR TIPO CAMBIO");

        var tipoCambioResult = domainTipoCambioRepository.updateTipoCambio(tipoCambio);

        log.info("FIN ACTUALIZAR TIPO CAMBIO");
        return tipoCambioResult;
    }
}
