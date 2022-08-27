package com.cambio.infrastructure.model.sql;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_tipo_cambio")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoCambioTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo_cambio")
    private Double tipoCambio;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_moneda_origen", referencedColumnName = "id")
    private MonedaTable monedaOrigen;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_moneda_destino", referencedColumnName = "id")
    private MonedaTable monedaDestino;

}
