package com.cambio.infrastructure.repository;

import com.cambio.domain.model.Usuario;
import com.cambio.domain.respository.DomainUserRepository;
import com.cambio.infrastructure.mapper.InfrastructureUsuarioMapper;
import com.cambio.infrastructure.model.sql.UsuarioTable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Slf4j
@Service
@Transactional
public class InfrastructureUserRepositoryImpl implements DomainUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private InfrastructureUsuarioMapper infrastructureUsuarioMapper;

    /**
     * Devuelve usuario por username desde DB
     * @param usuario Data usuario
     * @return Usuario
     * @see DomainUserRepository#getUserByUsername(Usuario) 
     */
    @Override
    public Usuario getUserByUsername(Usuario usuario) {

        UsuarioTable usuarioTable;

        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<UsuarioTable> cr = cb.createQuery(UsuarioTable.class);
            Root<UsuarioTable> root = cr.from(UsuarioTable.class);

            cr.select(root).where(cb.equal(root.get("username"), usuario.getUsername()));

            Query query = entityManager.createQuery(cr);
            usuarioTable = (UsuarioTable) query.getResultList()
                    .stream()
                    .findFirst()
                    .orElse(UsuarioTable.builder().build());

            entityManager.flush();

        } catch (Exception e){
            log.error(e.getMessage());
            throw e;
        }

        return infrastructureUsuarioMapper.usuarioTableToUsuario(usuarioTable);
    }

}
