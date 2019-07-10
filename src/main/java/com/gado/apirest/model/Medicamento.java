package com.gado.apirest.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_medicamento")
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date criacao;

    private Date alteracao;

    @NotNull
    private Date aplicacao;

    @NotNull
    private String descricao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_medicamento_tipo")
    private MedicamentoTipo medicamentoTipo;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_animal")
    private Animal animal;

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
