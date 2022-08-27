package com.cambio.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rol {

    private Integer id;

    private TipoRol nombre;

    public enum TipoRol {
        ROLE_ADMIN
    }



}



