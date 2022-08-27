package com.cambio.application.service;

import com.cambio.APITest;
import com.cambio.application.model.AuthDTO;
import com.cambio.application.model.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationAuthServiceImplTest extends APITest {

    @Autowired
    private ApplicationAuthServiceImpl applicationAuthServiceImpl;

    @Test
    void token() {

        assertNotNull(applicationAuthServiceImpl);

        ResponseEntity<AuthDTO> response = applicationAuthServiceImpl.token(
                UserDTO.builder()
                        .username("root")
                        .password("root")
                        .build()
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertNotNull(response.getBody());

    }
}