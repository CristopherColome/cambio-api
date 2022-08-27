package com.cambio.domain.service;

import com.cambio.APITest;
import com.cambio.domain.model.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class DomainUserServiceImplTest extends APITest {

    @Autowired
    private  DomainUserServiceImpl domainUserServiceImpl;

    @Test
    void getUserByUsername() {
        assertNotNull(domainUserServiceImpl);

        Usuario usuario = domainUserServiceImpl.getUserByUsername(
                Usuario.builder()
                        .username("root")
                        .build()
        );

        assertNotNull(usuario);
        assertNotNull(usuario.getId());
    }
}