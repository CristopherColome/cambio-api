package com.cambio.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthDTO {

    private String token;

    private String type;

    private Long id;

    private String username;

    private List<String> roles;

}
