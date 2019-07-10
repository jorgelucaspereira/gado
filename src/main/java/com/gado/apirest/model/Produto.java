package com.gado.apirest.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date criacao;

    private Date alteracao;

    @NotNull
    private String nome;

    @NotNull
    private String descricao;

    @NotNull
    private String marca;

    @NotNull
    private BigDecimal peso;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private BigDecimal duracao_meses;

    @NotNull
    private Date vencimento;

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
