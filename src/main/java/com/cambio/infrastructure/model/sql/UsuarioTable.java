package com.cambio.infrastructure.model.sql;


import com.cambio.domain.model.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_usuario")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Set<RolTable> roles = new HashSet<>();

}
