package com.cambio.infrastructure.model.sql;

import com.cambio.domain.model.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_rol")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RolTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Enumerated(EnumType.STRING)
    private Rol.TipoRol nombre;

}
