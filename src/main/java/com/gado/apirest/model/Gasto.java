package com.gado.apirest.model;


import lombok.Data;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_gasto")
public class Gasto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date criacao;

    private Date alteracao;

    @NotNull
    private String motivo;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private Boolean pago;

    @NotNull
    private Boolean necessario;

    @Transient
    private List<Saida> saidas = new LinkedList<>();

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
