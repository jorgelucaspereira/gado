package com.gado.apirest.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_saida")
public class Saida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Date criacao;

    @NotNull
    private Date alteracao;

    @ManyToOne
    @JoinColumn(name = "id_gasto")
    private Gasto gasto;

    @NotNull
    private String observacao;

    @NotNull
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

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
