package com.cambio.infrastructure.repository;

import com.cambio.domain.model.TipoCambio;
import com.cambio.domain.respository.DomainTipoCambioRepository;
import com.cambio.infrastructure.mapper.InfrastructureTipoCambioMapper;
import com.cambio.infrastructure.model.sql.TipoCambioTable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

@Slf4j
@Service
@Transactional
public class InfrastructureTipoCambioRepositoryImpl implements DomainTipoCambioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private InfrastructureTipoCambioMapper infrastructureTipoCambioMapper;

    /**
     * Devuelve tipo de cambio desde DB
     * @param tipoCambio Data para tipo cambio
     * @return TipoCambio
     * @see DomainTipoCambioRepository#getTipoCambio(TipoCambio)
     */
    @Override
    public TipoCambio getTipoCambio(TipoCambio tipoCambio) {

        TipoCambioTable tipoCambioTable;

        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<TipoCambioTable> cr = cb.createQuery(TipoCambioTable.class);

            Root<TipoCambioTable> root = cr.from(TipoCambioTable.class);

            cr.select(root)
                    .where(
                            cb.and(
                                    cb.equal(
                                            root.get("monedaOrigen").get("descripcion"),
                                            tipoCambio.getMonedaOrigen().getDescripcion()
                                    ),
                                    cb.equal(
                                            root.get("monedaDestino").get("descripcion"),
                                            tipoCambio.getMonedaDestino().getDescripcion()
                                    )
                            )
                    );

            Query query = entityManager.createQuery(cr);
            tipoCambioTable = (TipoCambioTable) query.getResultList()
                    .stream()
                    .findFirst()
                    .orElse(TipoCambioTable.builder().build());

            entityManager.flush();

        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }

        return infrastructureTipoCambioMapper.tipoCambioTableToTipoCambio(tipoCambioTable);
    }

    @Override
    public TipoCambio updateTipoCambio(TipoCambio tipoCambio) {
        TipoCambioTable tipoCambioTable;

        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaUpdate<TipoCambioTable> cu = cb.createCriteriaUpdate(TipoCambioTable.class);
            Root<TipoCambioTable> root = cu.from(TipoCambioTable.class);

            tipoCambioTable = infrastructureTipoCambioMapper.tipoCambioToTipoCambioTable(
                    tipoCambio
            );

            cu.set("tipoCambio", tipoCambio.getTipoCambio());
            cu.where(cb.equal(root.get("id"), tipoCambio.getId()));

            int success = entityManager.createQuery(cu).executeUpdate();
            entityManager.flush();

            if (success == 1){
                log.info("SE ACTUALIZO CORRECTAMENTE EL TIPO DE CAMBIO");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }

        return infrastructureTipoCambioMapper.tipoCambioTableToTipoCambio(tipoCambioTable);
    }

}
