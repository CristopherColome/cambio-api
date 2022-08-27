package com.cambio.domain.service;

import com.cambio.domain.model.Usuario;
import com.cambio.domain.respository.DomainUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class DomainUserServiceImpl implements DomainUserService {

    @Autowired
    private DomainUserRepository domainUserRepository;

    /**
     * Devuelve usuario por username
     * @param usuario Data usuario
     * @return Usuario
     * @see DomainUserService#getUserByUsername(Usuario) 
     */
    @Override
    public Usuario getUserByUsername(Usuario usuario) {
        log.info("INICIO OBTENER USUARIO POR USERNAME");

        var userResult = domainUserRepository.getUserByUsername(usuario);

        log.info("FIN OBTENER USUARIO POR USERNAME");

        return userResult;

    }

}
