package com.cambio.infrastructure.repository;

import com.cambio.APITest;
import com.cambio.domain.model.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class InfrastructureUserRepositoryImplTest extends APITest {

    @Autowired
    private InfrastructureUserRepositoryImpl infrastructureUserRepositoryImpl;

    @Test
    void getUserByUsername() {

        assertNotNull(infrastructureUserRepositoryImpl);

        Usuario usuario = infrastructureUserRepositoryImpl.getUserByUsername(
                Usuario.builder()
                        .username("root")
                        .build()
        );

        assertNotNull(usuario);
        assertNotNull(usuario.getId());
    }
}