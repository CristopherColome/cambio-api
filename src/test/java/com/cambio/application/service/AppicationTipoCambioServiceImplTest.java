package com.cambio.application.service;

import com.cambio.APITest;
import com.cambio.application.model.AuthDTO;
import com.cambio.application.model.TipoCambioDTO;
import com.cambio.application.model.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class AppicationTipoCambioServiceImplTest extends APITest {

    @Autowired
    private AppicationTipoCambioServiceImpl appicationTipoCambioServiceImpl;

    @Autowired
    private ApplicationAuthServiceImpl applicationAuthServiceImpl;

    @Test
    void getTipoCambio() {

        assertNotNull(appicationTipoCambioServiceImpl);

        applicationAuthServiceImpl.token(
                UserDTO.builder()
                        .username("root")
                        .password("root")
                        .build()
        );

        ResponseEntity<TipoCambioDTO> response = appicationTipoCambioServiceImpl.getTipoCambio(
                TipoCambioDTO.builder()
                        .montoCambio(Double.valueOf("1000"))
                        .monedaOrigenNombre("PEN")
                        .monedaDestinoNombre("USD")
                        .build()
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertNotNull(response.getBody());
    }

    @Test
    void updateTipoCambio() {

        assertNotNull(appicationTipoCambioServiceImpl);

        applicationAuthServiceImpl.token(
                UserDTO.builder()
                        .username("root")
                        .password("root")
                        .build()
        );

        ResponseEntity<TipoCambioDTO> response = appicationTipoCambioServiceImpl.updateTipoCambio(
                TipoCambioDTO.builder()
                        .id(1)
                        .tipoCambio(Double.valueOf("3.5"))
                        .build()
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertNotNull(response.getBody());

        assertEquals(3.5, response.getBody().getTipoCambio());

    }
}