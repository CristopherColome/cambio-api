package com.cambio.domain.respository;

import com.cambio.domain.model.Usuario;

import org.springframework.stereotype.Repository;

@Repository
public interface DomainUserRepository {

    /**
     * Devuelve usuario por username desde DB
     * @param usuario Data usuario
     * @return Usuario
     * @see Usuario
     */
    Usuario getUserByUsername(Usuario usuario);

}
