package com.cambio.infrastructure.repository;

import com.cambio.APITest;
import com.cambio.domain.model.Moneda;
import com.cambio.domain.model.TipoCambio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class InfrastructureTipoCambioRepositoryImplTest extends APITest {

    @Autowired
    private InfrastructureTipoCambioRepositoryImpl infrastructureTipoCambioRepositoryImpl;

    @Test
    void getTipoCambio() {

        assertNotNull(infrastructureTipoCambioRepositoryImpl);

        TipoCambio tipoCambio = infrastructureTipoCambioRepositoryImpl.getTipoCambio(
                TipoCambio.builder()
                        .monedaOrigen(
                                Moneda.builder()
                                        .monto(Double.valueOf("1000"))
                                        .descripcion("PEN")
                                        .build()
                        )
                        .monedaDestino(
                                Moneda.builder()
                                        .descripcion("USD")
                                        .build()
                        )
                        .build()
        );

        assertNotNull(tipoCambio);
        assertNotNull(tipoCambio.getId());
        assertNotNull(tipoCambio.getTipoCambio());
    }


    @Test
    void updateTipoCambio() {
        assertNotNull(infrastructureTipoCambioRepositoryImpl);

        TipoCambio tipoCambio = infrastructureTipoCambioRepositoryImpl.updateTipoCambio(
                TipoCambio.builder()
                        .id(1)
                        .tipoCambio(Double.valueOf("3.5"))
                        .build()
        );

        assertNotNull(tipoCambio);
        assertEquals(3.5, tipoCambio.getTipoCambio());
    }
}