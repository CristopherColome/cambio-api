package com.cambio.application.service;

import com.cambio.application.mapper.ApplicationUserMapper;
import com.cambio.domain.model.Usuario;
import com.cambio.domain.service.DomainUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class ApplicationUserServiceImpl implements ApplicationUserService {

    @Autowired
    private ApplicationUserMapper applicationUserMapper;

    @Autowired
    private DomainUserService domainUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("INICIO REQUEST OBTENER USUARIO POR USERNAME");
        try {
            var usuario =  domainUserService.getUserByUsername(
                    Usuario.builder()
                    .username(username)
                    .build()
            );

            log.info("FIN REQUEST OBTENER USUARIO POR USERNAME");
            return applicationUserMapper.userToUserDTO(usuario);

        } catch(Exception e){
            log.error("ERROR AL OBTENER USUARIO : {}", e.getMessage());
            throw e;
        }
    }
}
