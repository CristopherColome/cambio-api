package com.cambio.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    private Set<Rol> roles;

}
