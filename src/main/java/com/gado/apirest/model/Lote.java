package com.gado.apirest.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_lote")
public class Lote implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date criacao;

    private Date alteracao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_gasto")
    private Gasto gasto;

    @NotNull
    private String codigo;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private Boolean pago;

    @NotNull
    private BigDecimal quantidade;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_vendedor")
    private Vendedor vendedor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_animal_tipo")
    private AnimalTipo animalTipo;

    @PrePersist
    @PreUpdate
    private void beforeSave() {
        if (criacao == null) {
            this.criacao = new Date();
            this.alteracao = new Date();
        } else {
            this.alteracao = new Date();
        }
    }
}
