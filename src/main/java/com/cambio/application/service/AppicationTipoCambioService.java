package com.cambio.application.service;

import com.cambio.application.model.TipoCambioDTO;
import com.cambio.application.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Repository
@Validated
public interface AppicationTipoCambioService {

    /**
     * GET /api/tipo-cambio
     * Devuelve tipo de cambio
     * @param tipoCambioDTO Data para tipo cambio
     * @return TipoCambioDTO
     * @see TipoCambioDTO
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(
            produces = "application/json"
    )
    ResponseEntity<TipoCambioDTO> getTipoCambio(@Valid @RequestBody TipoCambioDTO tipoCambioDTO);


    /**
     * PUT /api/tipo-cambio
     * Actualiza tipo de cambio
     * @param tipoCambioDTO Data para tipo cambio
     * @return TipoCambioDTO
     * @see TipoCambioDTO
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(
            produces = "application/json"
    )
    ResponseEntity<TipoCambioDTO> updateTipoCambio(@Valid @RequestBody TipoCambioDTO tipoCambioDTO);

}
