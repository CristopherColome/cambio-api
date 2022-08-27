package com.cambio.application.service;

import com.cambio.application.model.AuthDTO;
import com.cambio.application.model.UserDTO;
import com.cambio.application.util.ApplicationJwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ApplicationAuthServiceImpl implements ApplicationAuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApplicationJwtUtils applicationJwtUtils;


    /**
     * Devuelve token
     * @param userDTORequest Data de usuario
     * @return AuthDTO
     * @see ApplicationAuthService#token(UserDTO) 
     */
    @Override
    public ResponseEntity<AuthDTO> token(UserDTO userDTORequest) {


        log.info("INICIO REQUEST AUTH TOKEN");

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDTORequest.getUsername(),
                        userDTORequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = applicationJwtUtils.generateJwtToken(authentication);

        UserDTO userDTO = (UserDTO) authentication.getPrincipal();

        List<String> roles = userDTO.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());


        log.info("FIN REQUEST AUTH TOKEN");

        return ResponseEntity.ok(
                AuthDTO
                        .builder()
                        .token(jwt)
                        .type("Bearer")
                        .id(userDTO.getId())
                        .username(userDTO.getUsername())
                        .roles(roles)
                        .build()
        );
    }
}
