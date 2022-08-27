package com.cambio.application.service;

import com.cambio.application.model.AuthDTO;
import com.cambio.application.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Repository
@Validated
public interface ApplicationAuthService {

    /**
     * GET /api/auth/token
     * Devuelve token
     * @param userDTORequest Data de usuario
     * @return AuthDTO
     */
    @PostMapping(
            value = "/token",
            produces = "application/json"
    )
    ResponseEntity<AuthDTO> token(@Valid @RequestBody UserDTO userDTORequest);
}
