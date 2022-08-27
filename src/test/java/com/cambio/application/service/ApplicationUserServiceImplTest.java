package com.cambio.application.service;

import com.cambio.APITest;
import com.cambio.application.model.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ApplicationUserServiceImplTest extends APITest {

    @Autowired
    private ApplicationUserServiceImpl applicationUserServiceImpl;


    @Test
    void loadUserByUsername() {

        assertNotNull(applicationUserServiceImpl);

        UserDetails userDetails = applicationUserServiceImpl.loadUserByUsername("root");

        assertNotNull(userDetails);

        assertEquals("root", userDetails.getUsername());
    }
}