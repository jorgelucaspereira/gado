package com.gado.apirest.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_animal")
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date criacao;

    private Date alteracao;

    @NotNull
    private String codigo;

    @NotNull
    private String nome;

    @NotNull
    private String link;

    @NotNull
    private String sexo;

    @NotNull
    private Date nascimento;

    @NotNull
    private BigDecimal valor_compra;

    private BigDecimal valor_venda;

    @ManyToOne
    @JoinColumn(name = "id_lote")
    private Lote lote;

    @ManyToOne
    @JoinColumn(name = "id_animal_tipo")
    private AnimalTipo animalTipo;

    @ManyToOne
    @JoinColumn(name = "id_terreno")
    private Terreno terreno;

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
