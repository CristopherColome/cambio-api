package com.cambio.domain.service;

import com.cambio.domain.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainUserService {

    /**
     * Devuelve usuario por username
     * @param usuario Data usuario
     * @return Usuario
     * @see Usuario
     */
    Usuario getUserByUsername(Usuario usuario);
}
