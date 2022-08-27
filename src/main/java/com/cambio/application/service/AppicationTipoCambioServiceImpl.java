package com.cambio.application.service;

import com.cambio.application.mapper.ApplicationTipoCambioMapper;
import com.cambio.application.model.MonedaDTO;
import com.cambio.application.model.TipoCambioDTO;
import com.cambio.domain.service.DomainTipoCambioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Service
@Transactional
@RestController
@RequestMapping("/api/tipo-cambio")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AppicationTipoCambioServiceImpl implements AppicationTipoCambioService {

    @Autowired
    private ApplicationTipoCambioMapper applicationTipoCambioMapper;


    @Autowired
    private DomainTipoCambioService domainTipoCambioService;


    @Override
    public ResponseEntity<TipoCambioDTO> getTipoCambio(TipoCambioDTO tipoCambioDTO) {
        log.info("INICIO REQUEST OBTENER TIPO CAMBIO");
        try {

            if(tipoCambioDTO.getMontoCambio() == null){
                return ResponseEntity.badRequest().build();
            }
            if(tipoCambioDTO.getMonedaOrigenNombre() == null){
                return ResponseEntity.badRequest().build();
            }
            if(tipoCambioDTO.getMonedaDestinoNombre() == null){
                return ResponseEntity.badRequest().build();
            }

            tipoCambioDTO.setMonedaOrigen(
                    MonedaDTO.builder()
                            .monto(tipoCambioDTO.getMontoCambio())
                            .descripcion(tipoCambioDTO.getMonedaOrigenNombre()).build()
            );

            tipoCambioDTO.setMonedaDestino(
                    MonedaDTO.builder().descripcion(
                            tipoCambioDTO.getMonedaDestinoNombre()
                    ).build()
            );

            var tipoCambio =  domainTipoCambioService.getTipoCambio(
                    applicationTipoCambioMapper.tipoCambioDTOToTipoCambio(
                            tipoCambioDTO
                    )
            );

            log.debug(tipoCambio.toString());

            log.info("FIN REQUEST OBTENER TIPO CAMBIO");
            return ResponseEntity.ok(
                    applicationTipoCambioMapper.tipoCambioToTipoCambioDTO(tipoCambio)
            );
        } catch(Exception e){
            log.error("ERROR AL OBTENER TIPO CAMBIO : {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public ResponseEntity<TipoCambioDTO> updateTipoCambio(TipoCambioDTO tipoCambioDTO) {
        log.info("INICIO REQUEST UPDATE TIPO CAMBIO");
        try {

            if(tipoCambioDTO.getId() == null){
                return ResponseEntity.badRequest().build();
            }
            if(tipoCambioDTO.getTipoCambio() == null){
                return ResponseEntity.badRequest().build();
            }

            var tipoCambio =  domainTipoCambioService.updateTipoCambio(
                    applicationTipoCambioMapper.tipoCambioDTOToTipoCambio(
                            tipoCambioDTO
                    )
            );

            log.debug(tipoCambio.toString());

            log.info("FIN REQUEST UPDATE TIPO CAMBIO");
            return ResponseEntity.ok(
                    applicationTipoCambioMapper.tipoCambioToTipoCambioDTO(tipoCambio)
            );
        } catch(Exception e){
            log.error("ERROR AL OBTENER TIPO CAMBIO : {}", e.getMessage());
            throw e;
        }    }
}
